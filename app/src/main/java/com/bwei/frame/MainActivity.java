package com.bwei.frame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bwei.frame.goods.DaggerGoodsComponent;
import com.bwei.frame.goods.GoodsInfo;
import com.bwei.frame.goods.GoodsModule;
import com.bwei.frame.goods.GoodsPresenter;
import com.bwei.frame.goods.GoodsView;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements GoodsView {
    @Inject //注入对象
            GoodsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //得到桥梁对象
        DaggerGoodsComponent.builder().goodsModule(new GoodsModule(this)).build().inject(this);
        presenter.relevanceData();

    }

    @Override
    public void showView(List<GoodsInfo> goodsInfos) {
        Log.i("xxx", goodsInfos.get(0).getName());
    }
}
