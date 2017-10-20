package com.lzq.one.onesdk.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import one.lzq.com.onesdk.R;

/**
 * Created by CTWLPC on 2017/10/20.
 */

public class ImageLoader {
    public static void loadImage(Context context,String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(imageView);
    }
}
