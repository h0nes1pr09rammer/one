package com.lzq.one.presenter;

import com.lzq.one.App;
import com.lzq.one.BasePresenterImpl;
import com.lzq.one.activity.SplashActivity;
import com.lzq.one.onesdk.api.bean.IdListBean;
import com.lzq.one.onesdk.helper.OneSdkHelper;
import com.lzq.one.presenter.contract.SplashContract;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lzq on 2017/10/21.
 */

public class SplashPresenter extends BasePresenterImpl implements SplashContract.Presentet{
    private SplashActivity mSplashActivity;
    public SplashPresenter(SplashActivity splashActivity) {
        this.mSplashActivity = splashActivity;
    }

    @Override
    public void getDate() {
        Subscription subscription = OneSdkHelper.getInstance().getIdList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<IdListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(IdListBean idListBean) {
                        App.getInstance().setIdList(idListBean.getData());
                        mSplashActivity.toMainActivity();
                    }
                });
        addSubscribe(subscription);
    }
}
