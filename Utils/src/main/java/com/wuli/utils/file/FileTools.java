package com.wuli.utils.file;

import com.wuli.utils.StringTools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 *     author : wangkang
 *     time   : 2019/05/23
 *     desc   :
 * </pre>
 */
public class FileTools {
    public static String read(String path) {
        if (StringTools.isEmpty(path)) {
            return "";
        }
        return read(new File(path));
    }

    public static String read(File file) {
        return read(file, null, null, 4096);
    }

    public static String read(File file, String encoding, String separator, int bufferLength) {
        if (StringTools.isEmpty(separator)) {
            separator = System.lineSeparator();
        }
        if (!file.exists()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream(file);
            if (StringTools.isEmpty(encoding)) {
                inputStreamReader = new InputStreamReader(fileInputStream);
            } else {
                inputStreamReader = new InputStreamReader(fileInputStream, encoding.trim());
            }
            bufferedReader = new BufferedReader(inputStreamReader);

            String data;
            while ((data = bufferedReader.readLine()) != null) {
                stringBuilder.append(data).append(separator);
            }
            if (stringBuilder.length() > 0) {
                return stringBuilder.substring(0, stringBuilder.lastIndexOf(separator));
            } else {
                return stringBuilder.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return stringBuilder.toString();
    }

    public static String read(String path, String encoding, String separator, int bufferLength) {
        return read(new File(path), encoding, separator, bufferLength);
    }


}
