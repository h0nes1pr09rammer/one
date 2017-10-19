package com.lzq.one.onesdk;

import android.content.Context;

import com.lzq.one.onesdk.utils.CommonUtils;

import java.io.File;

/**
 * Created by CTWLPC on 2017/10/19.
 */

public class OneSdk {
    public static String PATH_DATA;
    public static String PATH_CACHE;
    public static String vertion;
    public static String channel;
    public static String platform;
    public static String uuid;

    public static void init(Context context,OneSdkBuilder builder){
        if (builder == null || context == null){
            throw new NullPointerException("初始化参数为空");
        }
        CommonUtils.init(context);
        PATH_DATA = context.getCacheDir().getAbsolutePath() + File.separator + "data";
        PATH_CACHE = PATH_DATA + "/NetCache";
        vertion = builder.vertion;
        channel = builder.channel;
        platform = builder.platform;
        uuid = builder.uuid;
    }
//    public static Context getContext(){
//        if (mContext == null){
//            throw new NullPointerException("OneSdk is not init");
//        }
//        return mContext;
//    }
}
