package com.lzq.one.onesdk.helper;

import android.util.Log;

import com.lzq.one.onesdk.Constants;
import com.lzq.one.onesdk.OneSdk;
import com.lzq.one.onesdk.api.OneService;
import com.lzq.one.onesdk.utils.CommonUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import one.lzq.com.onesdk.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CTWLPC on 2017/10/19.
 */

public class RetrofitHelper {
    private okhttp3.OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;
    private static volatile RetrofitHelper mRetrofitHelper;


    public static RetrofitHelper getInstence() {
        if (mRetrofitHelper == null) {
            synchronized (RetrofitHelper.class) {
                if (mRetrofitHelper == null) {
                    mRetrofitHelper = new RetrofitHelper();
                }
            }
        }
        return mRetrofitHelper;
    }

    private RetrofitHelper() {
        if (mOkHttpClient == null){
            okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                builder.addInterceptor(loggingInterceptor);
            }
            Log.i("lzq","RetrofitHelper(RetrofitHelper.java:40)"+OneSdk.PATH_CACHE);
            File cacheFile = new File(OneSdk.PATH_CACHE);
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
            Interceptor cacheInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    if (!CommonUtils.isNetWorkAvailable()) {
                        request = request.newBuilder()
                                .cacheControl(CacheControl.FORCE_CACHE)
                                .build();
                    }
                    Response response = chain.proceed(request);
                    if (CommonUtils.isNetWorkAvailable()) {
                        int maxAge = 0;
                        // 有网络时, 不缓存, 最大保存时长为0
                        response.newBuilder()
                                .header("Cache-Control", "public, max-age=" + maxAge)
                                .removeHeader("Pragma")
                                .build();
                    } else {
                        // 无网络时，设置超时为4周
                        int maxStale = 60 * 60 * 24 * 28;
                        response.newBuilder()
                                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                .removeHeader("Pragma")
                                .build();
                    }
                    return response;
                }
            };
            //设置缓存
            builder.addNetworkInterceptor(cacheInterceptor);
            builder.addInterceptor(cacheInterceptor);
            builder.cache(cache);
            //设置超时
            builder.connectTimeout(10, TimeUnit.SECONDS);
            builder.readTimeout(20, TimeUnit.SECONDS);
            builder.writeTimeout(20, TimeUnit.SECONDS);
            //错误重连
            builder.retryOnConnectionFailure(true);
            mOkHttpClient = builder.build();
        }
        if (mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://v3.wufazhuce.com:8000/")
                    .client(mOkHttpClient)
                    .build();
        }
    }

    public OneService getOneService(){
        return mRetrofit.create(OneService.class);
    }
}
