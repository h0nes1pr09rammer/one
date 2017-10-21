package com.lzq.one.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzq.one.R;
import com.lzq.one.onesdk.api.bean.MovieListBean;
import com.lzq.one.onesdk.api.bean.ReadingListBean;
import com.lzq.one.onesdk.utils.ImageLoader;

import java.util.List;

/**
 * Created by lzq on 2017/10/21.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{
    private Context context;
    private List<MovieListBean.DataBean> list;

    public MovieAdapter(Context context, List<MovieListBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_read,parent,false));
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MyViewHolder holder, int position) {
        ImageLoader.loadImage(context,list.get(position).getImg_url(),holder.headView);
        holder.title.setText(list.get(position).getTitle());
        holder.content.setText(list.get(position).getForward());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView headView;
        TextView title;
        TextView content;

        public MyViewHolder(View itemView) {
            super(itemView);
            headView = (ImageView) itemView.findViewById(R.id.head_img);
            title = (TextView) itemView.findViewById(R.id.title);
            content = (TextView) itemView.findViewById(R.id.content);
        }
    }
}
