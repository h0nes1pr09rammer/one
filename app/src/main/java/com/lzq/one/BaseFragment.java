package com.lzq.one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by CTWLPC on 2017/10/20.
 */

public abstract class BaseFragment extends Fragment implements BaseView{
    protected View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        addPresenter();
        Log.i("lzq","onCreateView(BaseFragment.java:20)");
        mView = inflater.inflate(getLayoutViewId(),container,false);
        initView();
        return mView;
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        initData();
//    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("lzq","onActivityCreated(BaseFragment.java:37)");
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        removePresenter();
    }

    public abstract int getLayoutViewId();
    public abstract void initData();
    public abstract void initView();
    public abstract void addPresenter();
    public abstract void removePresenter();
}
