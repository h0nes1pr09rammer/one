package com.lzq.one.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lzq.one.R;
import com.lzq.one.presenter.SplashPresenter;
import com.lzq.one.presenter.contract.SplashContract;


/**
 * Created by CTWLPC on 2017/3/6.
 */

public class SplashActivity extends AppCompatActivity implements SplashContract.View{
    private SplashPresenter mSplashPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSplashPresenter = new SplashPresenter(this);
        mSplashPresenter.getDate();
    }

    @Override
    public void toMainActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },2000);
    }
}
