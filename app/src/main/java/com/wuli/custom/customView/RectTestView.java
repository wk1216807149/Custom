package com.wuli.custom.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.wuli.utils.WLog;


/**
 * <pre>
 *     author : wangkang
 *     time   : 2019/03/30
 *     desc   :
 * </pre>
 */
public class RectTestView extends View {
    public Paint mPaint;
    public RectTestView(Context context) {
        super(context);
        WLog.i("RectTestView()1");
        init();

    }

    public RectTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        WLog.i("RectTestView()2");
        init();
    }

    public RectTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        WLog.i("RectTestView()3");
        init();
    }

    public RectTestView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        WLog.i("RectTestView()4");
        init();
    }
    RectF rectF;
    public void init(){
        WLog.i("init()");
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#000000"));
        rectF=new RectF();
        rectF.set(1,1,99,300);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        WLog.i("onDraw()");
        int layerId = canvas.saveLayer(0, 0, canvas.getWidth(), canvas.getHeight(), null, Canvas.ALL_SAVE_FLAG);
        drawTest(canvas);

        mPaint.setColor(Color.BLACK);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        canvas.drawRect(rectF,mPaint);
        canvas.restoreToCount(layerId);
        rectF.top=100;
//        invalidate();
    }
    public void drawTest(Canvas canvas) {
        WLog.i("drawTest()");
        Paint mPaint=new Paint();
        mPaint.setColor(Color.RED);
        RectF rectF1=new RectF();
        rectF1.set(1,1,99,300);

        canvas.drawRoundRect(rectF1,49,49,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        WLog.i("event()"+event.getAction());
        return true;
//        return super.onTouchEvent(event);
    }
}
