package com.lzq.one.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lzq.one.BaseFragment;
import com.lzq.one.R;
import com.lzq.one.adapter.MusicAdapter;
import com.lzq.one.onesdk.api.bean.MusicListBean;
import com.lzq.one.presenter.MusicPresenter;
import com.lzq.one.presenter.contract.MusicContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CTWLPC on 2017/10/20.
 */

public class MusicFragment extends BaseFragment implements MusicContract.View{
    private RecyclerView mMUsicRecyclerVeiw;
    private MusicAdapter mMusicAdapter;
    private List<MusicListBean.DataBean> mDataList;
    private MusicPresenter mMusicPresenter;
    @Override
    public int getLayoutViewId() {
        return R.layout.fragment_music;
    }

    @Override
    public void initData() {
        mMusicPresenter.loadData();
    }

    @Override
    public void initView() {
        mDataList = new ArrayList<>();
        mMusicAdapter = new MusicAdapter(getActivity(),mDataList);
        mMUsicRecyclerVeiw = (RecyclerView) mView.findViewById(R.id.music_recyclerview);
        mMUsicRecyclerVeiw.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMUsicRecyclerVeiw.setAdapter(mMusicAdapter);
    }

    @Override
    public void addPresenter() {
        mMusicPresenter = new MusicPresenter(this);
    }

    @Override
    public void removePresenter() {
        mMusicPresenter.unSubscribe();
    }


    @Override
    public void showContent(List<MusicListBean.DataBean> list) {
        mDataList.clear();
        mDataList.addAll(list);
        mMusicAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {

    }
}
