package com.lzq.one.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lzq.one.R;
import com.lzq.one.onesdk.OneSdk;
import com.lzq.one.onesdk.OneSdkBuilder;
import com.lzq.one.onesdk.api.bean.OnelistBean;
import com.lzq.one.onesdk.helper.RetrofitHelper;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by CTWLPC on 2017/10/19.
 */

public class TestActivity extends AppCompatActivity{
    private CompositeSubscription mCompositeSubscription;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        OneSdkBuilder mBuilder = new OneSdkBuilder();
        mBuilder.vertion = "4.0.2";
        mBuilder.platform = "android";
        mBuilder.uuid = "ffffffff-a90e-706a-63f7-ccf973aae5ee";
        mBuilder.channel = "wdj";
        OneSdk.init(getApplication(),mBuilder);
        mCompositeSubscription = new CompositeSubscription();
        Subscription subscription = RetrofitHelper.getInstence().getOneService().getOneList("4534","wdj","4.0.2","ffffffff-a90e-706a-63f7-ccf973aae5ee&platform","android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OnelistBean>() {
                    @Override
                    public void onCompleted() {
                        Log.i("lzq","onCompleted(TestActivity.java:33) onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("lzq","onError(TestActivity.java:38)"+e.toString());
                    }

                    @Override
                    public void onNext(OnelistBean idListBean) {
                        Log.i("lzq","onNext(TestActivity.java:43)"+idListBean.toString());
                    }
                });
        mCompositeSubscription.add(subscription);
    }
}
