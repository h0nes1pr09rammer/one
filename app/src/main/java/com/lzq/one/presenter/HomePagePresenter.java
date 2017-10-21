package com.lzq.one.presenter;

import com.lzq.one.App;
import com.lzq.one.BasePresenterImpl;
import com.lzq.one.fragment.HomePageFragment;
import com.lzq.one.onesdk.Constants;
import com.lzq.one.onesdk.api.bean.EssayBean;
import com.lzq.one.onesdk.api.bean.MovieBean;
import com.lzq.one.onesdk.api.bean.MusicBean;
import com.lzq.one.onesdk.api.bean.OnelistBean;
import com.lzq.one.onesdk.helper.OneSdkHelper;
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

        Subscription subscription = OneSdkHelper.getInstance().getOneList(App.getInstance().getIdList().get(0))
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
                        LogUtils.i("size: "+idListBean.getData().getContent_list().size());
                        mHomePageFragment.showContent(idListBean.getData().getContent_list());
                    }
                });
        addSubscribe(subscription);
    }

    @Override
    public void loadItemData(int category, String itemId) {
        Subscription subscription;
        if (category == Constants.ONE_API_CATEGORY_MUSIC){
            subscription = OneSdkHelper.getInstance().getMusic(itemId).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<MusicBean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            LogUtils.i(e.toString());
                        }

                        @Override
                        public void onNext(MusicBean bean) {
                        }
                    });
        }else if (category == Constants.ONE_API_CATEGORY_MOVIE){
            subscription = OneSdkHelper.getInstance().getMovieContent(itemId).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<MovieBean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            LogUtils.i(e.toString());
                        }

                        @Override
                        public void onNext(MovieBean bean) {
                        }
                    });
        }else{
            subscription = OneSdkHelper.getInstance().getEssay(itemId).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<EssayBean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            LogUtils.i(e.toString());
                        }

                        @Override
                        public void onNext(EssayBean bean) {
                        }
                    });
        }


        addSubscribe(subscription);
    }

}
