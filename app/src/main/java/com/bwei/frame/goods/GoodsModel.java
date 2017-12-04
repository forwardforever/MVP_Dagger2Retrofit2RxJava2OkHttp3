package com.bwei.frame.goods;

import android.util.Log;

import com.bwei.frame.Api;
import com.bwei.frame.ApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/12/4 09:29
 */


public class GoodsModel {
    @Inject
    public GoodsModel() {
    }


    public Flowable<List<GoodsInfo>> getData(final OnGoodsFinishListener listener) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("xxx", message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(okHttpClient)
                .build();
        //动态代理获取网络接口对象
        ApiService apiService = retrofit.create(ApiService.class);
        Flowable<List<GoodsInfo>> flowable = apiService.getGoods("26868b32e808498db32fd51fb422d00175e179df", 83);
      /*  flowable.subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<List<GoodsInfo>>() {
                    @Override
                    public void onNext(List<GoodsInfo> goodsInfos) {
                        Log.i("xxx", goodsInfos.get(0).getName());
                        if (listener != null) {
                            listener.onSuccess(goodsInfos);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        if (listener != null) {
                            listener.onError(t);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/
        return flowable;
    }
}
