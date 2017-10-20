package com.lzq.one.presenter.contract;

import com.lzq.one.BasePresenter;
import com.lzq.one.BaseView;
import com.lzq.one.onesdk.api.bean.OnelistBean;

import java.util.List;

/**
 * Created by CTWLPC on 2017/10/20.
 */

public interface HomePageContract {
    interface View extends BaseView{
        void showContent(List<OnelistBean.DataBean.ContentListBean> list);
        void showError(String error);
    }
    interface Presenter extends BasePresenter{
        void loadData();
    }
}
