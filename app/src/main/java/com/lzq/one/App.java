package com.lzq.one;

import android.app.Application;

import com.lzq.one.onesdk.OneSdk;
import com.lzq.one.onesdk.OneSdkBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzq on 2017/10/21.
 */

public class App extends Application{
    private static App instance;

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    private List<String> idList;
    public static App getInstance(){
        if (instance == null){
            instance = new App();
        }
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        OneSdkBuilder mBuilder = new OneSdkBuilder();
        mBuilder.vertion = "4.0.2";
        mBuilder.platform = "android";
        mBuilder.uuid = "ffffffff-a90e-706a-63f7-ccf973aae5ee";
        mBuilder.channel = "wdj";
        OneSdk.init(this,mBuilder);
        idList = new ArrayList<>();
    }
}
