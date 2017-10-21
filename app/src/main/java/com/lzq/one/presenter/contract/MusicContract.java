package com.lzq.one.presenter.contract;

import com.lzq.one.onesdk.api.bean.MusicListBean;
import com.lzq.one.onesdk.api.bean.ReadingListBean;

import java.util.List;

/**
 * Created by lzq on 2017/10/21.
 */

public interface MusicContract {
    interface View{
        void showContent(List<MusicListBean.DataBean> list);
        void showError();
    }
    interface Presenter{
        void loadData();
    }
}
