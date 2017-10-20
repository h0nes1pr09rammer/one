package com.lzq.one.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lzq.one.R;
import com.lzq.one.onesdk.api.bean.OnelistBean;
import com.lzq.one.onesdk.utils.ImageLoader;
import com.lzq.one.onesdk.utils.LogUtils;

import java.util.List;

/**
 * Created by CTWLPC on 2017/3/22.
 */

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.MyViewHolder>
{
    private Context context;
    private List<OnelistBean.DataBean.ContentListBean> list;
    private HomePageRecycleOnClickListener mOnClickListener;

    public HomePageAdapter(Context context,List<OnelistBean.DataBean.ContentListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public HomePageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        HomePageAdapter.MyViewHolder holder = new HomePageAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_homepage, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        LogUtils.i(list.get(position).getItem_id());
        LogUtils.i(list.get(position).getCategory());
        LogUtils.i(list.get(position).getShare_info().getTitle());
        holder.title.setText(list.get(position).getTitle());
        holder.forword.setText(list.get(position).getForward());
        ImageLoader.loadImage(context,list.get(position).getImg_url(),holder.imageView);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnClickListener != null){
                    mOnClickListener.onClick(Integer.valueOf(list.get(position).getCategory()),list.get(position).getItem_id());
                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView title;
        ImageView imageView;
        TextView forword;
        LinearLayout linearLayout;

        public MyViewHolder(View view)
        {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            forword = (TextView) view.findViewById(R.id.forword);
            imageView = (ImageView) view.findViewById(R.id.image);
            linearLayout = (LinearLayout) view.findViewById(R.id.content_layout);
        }
    }
    public interface HomePageRecycleOnClickListener{
        void onClick(int category,String itemId);
    }
    public void setHomeItemOnClickListener(HomePageRecycleOnClickListener mOnClickListener){
        this.mOnClickListener = mOnClickListener;
    }
}
