package com.lzq.one.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lzq.one.BaseFragment;
import com.lzq.one.R;
import com.lzq.one.adapter.ReadAdapter;
import com.lzq.one.onesdk.api.bean.ReadingListBean;
import com.lzq.one.presenter.ReadPresenter;
import com.lzq.one.presenter.contract.ReadContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CTWLPC on 2017/10/20.
 */

public class ReadFragment extends BaseFragment implements ReadContract.View{
    private RecyclerView mReadRecyclerVeiw;
    private ReadAdapter mReadAdapter;
    private List<ReadingListBean.DataBean> mDataList;
    private ReadPresenter mReadPresenter;
    @Override
    public int getLayoutViewId() {
        return R.layout.fragment_music;
    }

    @Override
    public void initData() {
        mReadPresenter.loadData();
    }

    @Override
    public void initView() {
        mDataList = new ArrayList<>();
        mReadAdapter = new ReadAdapter(getActivity(),mDataList);
        mReadRecyclerVeiw = (RecyclerView) mView.findViewById(R.id.music_recyclerview);
        mReadRecyclerVeiw.setLayoutManager(new LinearLayoutManager(getActivity()));
        mReadRecyclerVeiw.setAdapter(mReadAdapter);
    }

    @Override
    public void addPresenter() {
        mReadPresenter = new ReadPresenter(this);
    }

    @Override
    public void removePresenter() {
        mReadPresenter.unSubscribe();
    }


    @Override
    public void showContent(List<ReadingListBean.DataBean> list) {
        mDataList.clear();
        mDataList.addAll(list);
        mReadAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {

    }
}
