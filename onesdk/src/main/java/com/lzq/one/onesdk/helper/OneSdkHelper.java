package com.lzq.one.onesdk.helper;

import android.util.Log;

import com.lzq.one.onesdk.OneSdk;
import com.lzq.one.onesdk.api.bean.IdListBean;
import com.lzq.one.onesdk.api.bean.OnelistBean;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by CTWLPC on 2017/10/19.
 */

public class OneSdkHelper {

    public static OneSdkHelper getInstance() {
        return OneSdkHelperHolder.sInstance;
    }

    private static class OneSdkHelperHolder {
        private static final OneSdkHelper sInstance = new OneSdkHelper();
    }
    public Observable<IdListBean> getIdList(){
        return RetrofitHelper.getInstence().getOneService().getIdList(OneSdk.channel,OneSdk.vertion,OneSdk.uuid,OneSdk.platform);
    }
    public Observable<OnelistBean> getOneList(String data){
        return RetrofitHelper.getInstence().getOneService().getOneList(data,OneSdk.channel,OneSdk.vertion,OneSdk.uuid,OneSdk.platform);
    }
}
