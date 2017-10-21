package com.lzq.one.presenter;

import com.lzq.one.App;
import com.lzq.one.BasePresenterImpl;
import com.lzq.one.fragment.MusicFragment;
import com.lzq.one.fragment.ReadFragment;
import com.lzq.one.onesdk.api.bean.MusicListBean;
import com.lzq.one.onesdk.api.bean.OnelistBean;
import com.lzq.one.onesdk.api.bean.ReadingListBean;
import com.lzq.one.onesdk.helper.OneSdkHelper;
import com.lzq.one.onesdk.utils.LogUtils;
import com.lzq.one.presenter.contract.MusicContract;
import com.lzq.one.presenter.contract.ReadContract;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lzq on 2017/10/21.
 */

public class MusicPresenter extends BasePresenterImpl implements MusicContract.Presenter {
    private MusicFragment mMusicFragment;
    public MusicPresenter(MusicFragment readFragment) {
        mMusicFragment = readFragment;
    }

    @Override
    public void loadData() {
        Subscription subscription = OneSdkHelper.getInstance().getMusicList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MusicListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.i(e.toString());
                    }

                    @Override
                    public void onNext(MusicListBean bean) {
                        mMusicFragment.showContent(bean.getData());
                    }
                });
        addSubscribe(subscription);
    }
}
