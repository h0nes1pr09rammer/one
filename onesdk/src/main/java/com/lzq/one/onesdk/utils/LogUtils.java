package com.lzq.one.onesdk.utils;

import android.util.Log;

import one.lzq.com.onesdk.BuildConfig;

/**
 * Created by CTWLPC on 2017/10/20.
 */

public class LogUtils {

    private static final String TAG = "lzq";

    public static void e(String str) {
        if(BuildConfig.DEBUG) {
            Log.e(TAG, str);
        }
    }


    public static void w(String msg) {
        if(BuildConfig.DEBUG) {
            Log.w(TAG,msg);
        }
    }


    public static void d(String msg) {
        if(BuildConfig.DEBUG) {
            Log.d(TAG,msg);
        }
    }

    public static void i(String msg) {
//        if(BuildConfig.DEBUG) {
//            Log.i(TAG,msg);
//        }
        Log.i(TAG,msg);
    }
}
