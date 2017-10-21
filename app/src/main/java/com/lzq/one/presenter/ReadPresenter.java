package com.lzq.one.presenter;

import com.lzq.one.App;
import com.lzq.one.BasePresenterImpl;
import com.lzq.one.fragment.ReadFragment;
import com.lzq.one.onesdk.api.bean.OnelistBean;
import com.lzq.one.onesdk.api.bean.ReadingListBean;
import com.lzq.one.onesdk.helper.OneSdkHelper;
import com.lzq.one.onesdk.utils.LogUtils;
import com.lzq.one.presenter.contract.ReadContract;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lzq on 2017/10/21.
 */

public class ReadPresenter extends BasePresenterImpl implements ReadContract.Presenter {
    private ReadFragment mReadFragment;
    public ReadPresenter(ReadFragment readFragment) {
        mReadFragment = readFragment;
    }

    @Override
    public void loadData() {
        Subscription subscription = OneSdkHelper.getInstance().getReadingList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReadingListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.i(e.toString());
                    }

                    @Override
                    public void onNext(ReadingListBean bean) {
                        mReadFragment.showContent(bean.getData());
                    }
                });
        addSubscribe(subscription);
    }
}
