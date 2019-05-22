package com.wuli.utils.file;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.util.Set;

/**
 * <pre>
 *     author : wangkang
 *     time   : 2019/05/22
 *     desc   :
 * </pre>
 */
public class FileUtils {

    public static int ModePrivate=Context.MODE_PRIVATE;
    @Deprecated
    public static int ModeReadable=Context.MODE_WORLD_READABLE;
    @Deprecated
    public static int ModeWriteable=Context.MODE_WORLD_WRITEABLE;
    public static int ModeProcess=Context.MODE_MULTI_PROCESS;

    private static SharedPreferences sharedPreferences=null;

    public static void createSharedPreferences(Context context,String str,int mod){
        sharedPreferences=context.getSharedPreferences(str,mod);

    }

    public static void saveDataSharedPreferences(String name,Object object){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        if(object instanceof String){
            editor.putString(name,(String) object);
        }else if(object instanceof Integer){
            editor.putInt(name,(int)object);
        }else if(object instanceof Boolean){
            editor.putBoolean(name,(boolean)object);
        }else if(object instanceof Float){
            editor.putFloat(name,(float)object);
        }else if(object instanceof Long){
            editor.putLong(name,(long)object);
        }else if(object instanceof Set){
            editor.putStringSet(name,(Set<String>) object);
        }
        editor.commit();
    }

    public static Object getDataSharedPreferences(String name,Object object){
        if(object instanceof String){
            return sharedPreferences.getString(name,(String)object);
        }else if(object instanceof Integer){
            return sharedPreferences.getInt(name,(int)object);
        }else if(object instanceof Boolean){
            return sharedPreferences.getBoolean(name,(boolean)object);
        }else if(object instanceof Float){
            return sharedPreferences.getFloat(name,(float)object);
        }else if(object instanceof Long){
            return sharedPreferences.getLong(name,(long)object);
        }else if(object instanceof Set){
            return sharedPreferences.getStringSet(name,(Set<String>) object);
        }else{
            return sharedPreferences.getAll();
        }
    }
}
