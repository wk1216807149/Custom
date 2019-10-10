package com.wuli.utils;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

/**
 * <pre>
 *     author : wangkang
 *     time   : 2019/10/10
 *     desc   :
 * </pre>
 */
public class DisplayTools {

    public static int[] getDisplay(Context context){
        int[] data=new int[2];
        WindowManager windowManager= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display=windowManager.getDefaultDisplay();
        data[0]=display.getWidth();
        data[1]=display.getHeight();
        return data;
    }
}
