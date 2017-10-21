package com.lzq.one.presenter.contract;

import com.lzq.one.onesdk.api.bean.MusicListBean;
import com.lzq.one.onesdk.api.bean.ReadingListBean;

import java.util.List;

/**
 * Created by lzq on 2017/10/21.
 */

public interface ReadContract {
    interface View{
        void showContent(List<ReadingListBean.DataBean> list);
        void showError();
    }
    interface Presenter{
        void loadData();
    }
}
