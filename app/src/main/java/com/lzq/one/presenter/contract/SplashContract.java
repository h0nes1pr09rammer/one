package com.lzq.one.presenter.contract;

import com.lzq.one.BasePresenter;
import com.lzq.one.BaseView;

/**
 * Created by lzq on 2017/10/21.
 */

public interface SplashContract {
    interface View extends BaseView{
        void toMainActivity();
    }
    interface Presentet extends BasePresenter{
        void getDate();
    }
}
