package com.wuli.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.logging.Logger;

/**
 * <pre>
 *     author : wangkang
 *     time   : 2019/04/03
 *     desc   :
 * </pre>
 */
public class WLog {
    private static String TAG="[Custom]";
    private static final int CHUNK_SIZE = 4000;
    private static final int MIN_STACK_OFFSET = 5;

    private static final int VERBOSE = 2;
    private static final int DEBUG = 3;
    private static final int INFO = 4;
    private static final int WARN = 5;
    private static final int ERROR = 6;
    private static final int ASSERT = 7;

    public static void v(String args){
        a(VERBOSE,TAG,args);
    }
    public static void v(String tag,String args){
        a(VERBOSE,tag,args);
    }
    public static void d(String args){
        a(DEBUG,TAG,args);
    }
    public static void d(String tag,String args){
        a(DEBUG,tag,args);
    }
    public static void i(String args){
        a(INFO,TAG,args);
    }
    public static void i(String tag,String args){
        a(INFO,tag,args);
    }
    public static void w(String args){
        a(WARN,TAG,args);
    }
    public static void w(String tag,String args){
        a(WARN,tag,args);
    }
    public static void e(String args){
        a(ERROR,TAG,args);
    }
    public static void e(String tag,String args){
        a(ERROR,tag,args);
    }

    private static void a(int priority,String tag,String message){

        logHeader(priority,tag,1);

        byte[] bytes=message.getBytes();
        int length=bytes.length;
        if(length<=CHUNK_SIZE){
            Log.println(priority,tag,message);
            return;
        }
        for(int i=0;i<length;i+=CHUNK_SIZE){
            int count=Math.min(length-i,CHUNK_SIZE);
            Log.println(priority,tag,new String(bytes,i,count));
        }
    }

    /**
     *
     * @param priority
     * @param tag
     * @param methodCount   表示需要打印的方法的个数；（打印出 打印log的前调用的前methodCount个方法）
     */
    private static void logHeader(int priority,String tag,int methodCount){
        StackTraceElement[] stackTraceElement=Thread.currentThread().getStackTrace();
        int stackOffset = getStackOffset(stackTraceElement);
        if (methodCount + stackOffset > stackTraceElement.length) {
            methodCount = stackTraceElement.length - stackOffset - 1;
        }

        for (int i = methodCount; i > 0; i--) {
            int stackIndex = i + stackOffset;
            if (stackIndex >= stackTraceElement.length) {
                continue;
            }
            StringBuilder builder = new StringBuilder();
            builder.append("------")
                    .append(' ')
                    .append("Thread(")
                    .append(Thread.currentThread().getName())
                    .append(")")
                    .append(' ')
                    .append(getSimpleClassName(stackTraceElement[stackIndex].getClassName()))
                    .append(".")
                    .append(stackTraceElement[stackIndex].getMethodName())
                    .append(" ")
                    .append(" (")
                    .append(stackTraceElement[stackIndex].getFileName())
                    .append(":")
                    .append(stackTraceElement[stackIndex].getLineNumber())
                    .append(")");
            Log.println(priority, tag, builder.toString());
        }
    }
    private static int getStackOffset(@NonNull StackTraceElement[] trace) {

        for (int i = MIN_STACK_OFFSET; i < trace.length; i++) {
            StackTraceElement e = trace[i];
            String name = e.getClassName();
            if (!name.equals(WLog.class.getName()) && !name.equals(Logger.class.getName())) {
                return --i;
            }
        }
        return -1;
    }

    private static String getSimpleClassName(@NonNull String name) {
        int lastIndex = name.lastIndexOf(".");
        return name.substring(lastIndex + 1);
    }
}
