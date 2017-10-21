package com.lzq.one.presenter.contract;

import com.lzq.one.onesdk.api.bean.MovieListBean;
import com.lzq.one.onesdk.api.bean.ReadingListBean;

import java.util.List;

/**
 * Created by lzq on 2017/10/21.
 */

public interface MovieContract {
    interface View{
        void showContent(List<MovieListBean.DataBean> list);
        void showError();
    }
    interface Presenter{
        void loadData();
    }
}
