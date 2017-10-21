package com.lzq.one.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;
import android.widget.Toast;

import com.lzq.one.BaseFragment;
import com.lzq.one.R;
import com.lzq.one.adapter.HomePageAdapter;
import com.lzq.one.onesdk.api.bean.OnelistBean;
import com.lzq.one.presenter.HomePagePresenter;
import com.lzq.one.presenter.contract.HomePageContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CTWLPC on 2017/10/20.
 */

public class HomePageFragment extends BaseFragment implements HomePageContract.View,SwipeRefreshLayout.OnRefreshListener,HomePageAdapter.HomePageRecycleOnClickListener {

    private HomePagePresenter mHomePagePresenter;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private HomePageAdapter mHomePageAdapter;
    private List<OnelistBean.DataBean.ContentListBean> list;
    @Override
    public int getLayoutViewId() {
        return R.layout.fragment_homepage;
    }

    @Override
    public void initData() {
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.id_recyclerview);
        mHomePageAdapter = new HomePageAdapter(getActivity(),list);
        mHomePageAdapter.setHomeItemOnClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mHomePageAdapter);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.id_swiperefreshlayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        onRefresh();
    }

    @Override
    public void addPresenter() {
        mHomePagePresenter = new HomePagePresenter(this);
    }

    @Override
    public void removePresenter() {
        mHomePagePresenter.unSubscribe();
    }

    @Override
    public void showContent(List<OnelistBean.DataBean.ContentListBean> list) {
        mSwipeRefreshLayout.setRefreshing(false);
        this.list.clear();
        this.list.addAll(list);
        mHomePageAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        if (!mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(true);
            mHomePagePresenter.loadData();
        }else{
            Toast.makeText(getActivity(),"is refresh",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(int category, String itemId) {
        mHomePagePresenter.loadItemData(category,itemId);
    }
}
