package com.wuli.custom.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;

import com.wuli.custom.R;
import com.wuli.utils.DisplayTools;
import com.wuli.utils.log.WLog;

import java.util.Calendar;
import java.util.Date;

/**
 * <pre>
 *     author : wangkang
 *     time   : 2019/10/10
 *     desc   :
 * </pre>
 */
public class TimeTestView extends View {

    public Paint mPaint;
    public Paint onePaint;
    public int year,month,day,hours,minutes,seconds;
    public int[] data;
    public String[] hoursData;
    public String[] minutesData;
    public String[] secondsData;

    public TimeTestView(Context context) {
        super(context);
        init(context);
    }

    public TimeTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TimeTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public TimeTestView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }
    public void init(Context context){
        mPaint=new Paint();
        mPaint.setColor(context.getResources().getColor(R.color.color_959595));
        mPaint.setTextSize(20);
        mPaint.setStrokeWidth(2);

        onePaint=new Paint();
        onePaint.setColor(context.getResources().getColor(R.color.color_959595));
        onePaint.setTextSize(24);
        onePaint.setStrokeWidth(2);

        data= DisplayTools.getDisplay(context);

        hoursData=context.getResources().getStringArray(R.array.hours);
        minutesData=context.getResources().getStringArray(R.array.minutes);
        secondsData=context.getResources().getStringArray(R.array.seconds);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        WLog.d(widthMeasureSpec+" , "+heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawColor(Color.BLACK);
//        canvas.save();

        Calendar calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        hours=calendar.get(Calendar.HOUR_OF_DAY);
        minutes=calendar.get(Calendar.MINUTE);
        seconds=calendar.get(Calendar.SECOND);
        String str1=year+"年"+month+"月"+day+"日";
        canvas.drawText(str1,(data[0]-mPaint.measureText(str1))/2,(data[1]-10)/2-15,mPaint);
        String str2=hours+"时"+minutes+"分"+seconds+"秒";
        canvas.drawText(str2,(data[0]-mPaint.measureText(str2))/2,(data[1]-10)/2+15,mPaint);

        drawHours(canvas,-360/12*hours);
        drawMinute(canvas,-360/59*minutes);
        drawSecond(canvas,-360/59*seconds);
        invalidate();
    }

    public void drawHours(Canvas canvas,float degrees){
        canvas.save();
        canvas.rotate(degrees,data[0]/2,data[1]/2);
        for(int i=0;i<12;i++){
            canvas.save();
            canvas.rotate(360/12*i,data[0]/2,data[1]/2);
            canvas.drawText(hoursData[i],data[0]/2+80,data[1]/2,onePaint);
            canvas.restore();
        }
        canvas.restore();
    }

    public void drawMinute(Canvas canvas,float degrees){
        canvas.save();
        canvas.rotate(degrees,data[0]/2,data[1]/2);
        for(int i=0;i<59;i++){
            canvas.save();
            canvas.rotate(360/59*i,data[0]/2,data[1]/2);
            canvas.drawText(minutesData[i],data[0]/2+170,data[1]/2,onePaint);
            canvas.restore();
        }
        canvas.restore();
    }

    public void drawSecond(Canvas canvas,float degrees){
        canvas.save();
        canvas.rotate(degrees,data[0]/2,data[1]/2);
        for(int i=0;i<59;i++){
            canvas.save();
            canvas.rotate(360/59*i,data[0]/2,data[1]/2);
            canvas.drawText(secondsData[i],data[0]/2+250,data[1]/2,onePaint);
            canvas.restore();
        }
        canvas.restore();
    }
}
