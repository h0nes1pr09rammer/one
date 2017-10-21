package com.lzq.one.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lzq.one.BaseFragment;
import com.lzq.one.R;
import com.lzq.one.adapter.MovieAdapter;
import com.lzq.one.adapter.MusicAdapter;
import com.lzq.one.onesdk.api.bean.MovieListBean;
import com.lzq.one.onesdk.api.bean.MusicListBean;
import com.lzq.one.presenter.MoviePresenter;
import com.lzq.one.presenter.MusicPresenter;
import com.lzq.one.presenter.contract.MovieContract;
import com.lzq.one.presenter.contract.MusicContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CTWLPC on 2017/10/20.
 */

public class MovieFragment extends BaseFragment implements MovieContract.View{
    private RecyclerView mMovieRecyclerVeiw;
    private MovieAdapter mMovieAdapter;
    private List<MovieListBean.DataBean> mDataList;
    private MoviePresenter mMoviePresenter;
    @Override
    public int getLayoutViewId() {
        return R.layout.fragment_movie;
    }

    @Override
    public void initData() {
        mMoviePresenter.loadData();
    }

    @Override
    public void initView() {
        mDataList = new ArrayList<>();
        mMovieAdapter = new MovieAdapter(getActivity(),mDataList);
        mMovieRecyclerVeiw = (RecyclerView) mView.findViewById(R.id.movie_recyclerview);
        mMovieRecyclerVeiw.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMovieRecyclerVeiw.setAdapter(mMovieAdapter);
    }

    @Override
    public void addPresenter() {
        mMoviePresenter = new MoviePresenter(this);
    }

    @Override
    public void removePresenter() {
        mMoviePresenter.unSubscribe();
    }


    @Override
    public void showContent(List<MovieListBean.DataBean> list) {
        mDataList.clear();
        mDataList.addAll(list);
        mMovieAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {

    }
}
