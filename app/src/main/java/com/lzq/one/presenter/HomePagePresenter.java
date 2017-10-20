package com.lzq.one.presenter;

import android.util.Log;

import com.lzq.one.BasePresenter;
import com.lzq.one.BasePresenterImpl;
import com.lzq.one.BaseView;
import com.lzq.one.fragment.HomePageFragment;
import com.lzq.one.onesdk.OneSdk;
import com.lzq.one.onesdk.OneSdkBuilder;
import com.lzq.one.onesdk.api.bean.IdListBean;
import com.lzq.one.onesdk.api.bean.OnelistBean;
import com.lzq.one.onesdk.helper.OneSdkHelper;
import com.lzq.one.onesdk.helper.RetrofitHelper;
import com.lzq.one.onesdk.utils.LogUtils;
import com.lzq.one.presenter.contract.HomePageContract;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by CTWLPC on 2017/10/20.
 */

public class HomePagePresenter extends BasePresenterImpl implements HomePageContract.Presenter{
    HomePageFragment mHomePageFragment;
    public HomePagePresenter(HomePageFragment homePageFragment) {
        mHomePageFragment = homePageFragment;
    }

    @Override
    public void loadData() {
//        Subscription subscription = OneSdkHelper.getInstance().getIdList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<IdListBean>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onNext(IdListBean idListBean) {
//                        mHomePageFragment.showContent(idListBean.getData());
//                    }
//                });
//        addSubscribe(subscription);


        Subscription subscription = OneSdkHelper.getInstance().getOneList("4548")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OnelistBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.i(e.toString());
                    }

                    @Override
                    public void onNext(OnelistBean idListBean) {
                        LogUtils.i(idListBean.toString());
                        mHomePageFragment.showContent(idListBean.getData().getContent_list());
                    }
                });
        addSubscribe(subscription);
    }

}
