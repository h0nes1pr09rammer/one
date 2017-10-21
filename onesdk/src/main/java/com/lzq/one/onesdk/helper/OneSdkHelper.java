package com.lzq.one.onesdk.helper;

import com.lzq.one.onesdk.OneSdk;
import com.lzq.one.onesdk.api.bean.EssayBean;
import com.lzq.one.onesdk.api.bean.IdListBean;
import com.lzq.one.onesdk.api.bean.MovieBean;
import com.lzq.one.onesdk.api.bean.MovieListBean;
import com.lzq.one.onesdk.api.bean.MusicBean;
import com.lzq.one.onesdk.api.bean.MusicListBean;
import com.lzq.one.onesdk.api.bean.OnelistBean;
import com.lzq.one.onesdk.api.bean.ReadingListBean;

import rx.Observable;

/**
 * Created by CTWLPC on 2017/10/19.
 */

public class OneSdkHelper {
    private String source = "summary";

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
    public Observable<EssayBean> getEssay(String itemId){
        return RetrofitHelper.getInstence().getOneService().getEssay(itemId,OneSdk.channel,source,"9264",OneSdk.vertion,OneSdk.uuid,OneSdk.platform);
    }
    public Observable<MusicBean> getMusic(String itemId){
        return RetrofitHelper.getInstence().getOneService().getMusic(itemId,OneSdk.channel,OneSdk.vertion,OneSdk.uuid,OneSdk.platform);
    }
    public Observable<MovieBean> getMovieContent(String itemId){
        return RetrofitHelper.getInstence().getOneService().getMovieContent(itemId,OneSdk.channel,OneSdk.vertion,OneSdk.uuid,OneSdk.platform);
    }
    public Observable<ReadingListBean> getReadingList(){
        return RetrofitHelper.getInstence().getOneService().getReadingList(OneSdk.channel,OneSdk.vertion,OneSdk.uuid,OneSdk.platform);
    }
    public Observable<MusicListBean> getMusicList(){
        return RetrofitHelper.getInstence().getOneService().getMusicList(OneSdk.channel,OneSdk.vertion,OneSdk.uuid,OneSdk.platform);
    }
    public Observable<MovieListBean> getMovieList(){
        return RetrofitHelper.getInstence().getOneService().getMovieList(OneSdk.channel,OneSdk.vertion,OneSdk.uuid,OneSdk.platform);
    }
}
