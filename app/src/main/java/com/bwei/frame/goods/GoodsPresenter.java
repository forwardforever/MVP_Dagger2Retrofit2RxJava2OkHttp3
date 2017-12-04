package com.bwei.frame.goods;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/12/4 09:29
 */


public class GoodsPresenter implements OnGoodsFinishListener {
    @Inject
    GoodsModel goodsModel;

    private GoodsView goodsView;


    @Inject
    public GoodsPresenter() {
    }

    public GoodsPresenter(GoodsView goodsView) {
        this.goodsView = goodsView;

    }

    public void relevanceData() {
        Flowable<List<GoodsInfo>> flowable = goodsModel.getData(this);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<List<GoodsInfo>>() {
                    @Override
                    public void onNext(List<GoodsInfo> goodsInfos) {
                        Log.i("xxx", goodsInfos.get(0).getName());
                        goodsView.showView(goodsInfos);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onSuccess(List<GoodsInfo> goodsInfos) {
        goodsView.showView(goodsInfos);
    }

    @Override
    public void onError(Throwable t) {


    }
}
