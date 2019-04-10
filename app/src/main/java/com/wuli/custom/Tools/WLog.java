package com.wuli.custom.Tools;

import android.util.Log;

/**
 * <pre>
 *     author : wangkang
 *     time   : 2019/04/03
 *     desc   :
 * </pre>
 */
public class WLog {
    private static String TAG="[Custom]";
    public static void v(String args){
        Log.v(TAG,args);
    }
    public static void v(String tag,String args){
        Log.v(tag,args);
    }
    public static void d(String args){
        Log.d(TAG,args);
    }
    public static void d(String tag,String args){
        Log.d(tag,args);
    }
    public static void i(String args){
        Log.i(TAG,args);
    }
    public static void i(String tag,String args){
        Log.i(tag,args);
    }
    public static void w(String args){
        Log.w(TAG,args);
    }
    public static void w(String tag,String args){
        Log.w(tag,args);
    }
    public static void e(String args){
        Log.e(TAG,args);
    }
    public static void e(String tag,String args){
        Log.e(tag,args);
    }

}
