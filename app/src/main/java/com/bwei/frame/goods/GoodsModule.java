package com.bwei.frame.goods;

import dagger.Module;

/**
 * 1. 类的用途 容器
 * 2. @author forever
 * 3. @date 2017/12/4 09:30
 */

@Module
public class GoodsModule {
    //实例化
    private GoodsView view;

    public GoodsModule(GoodsView view) {
        this.view = view;
    }

}
