package com.bwei.frame.goods;

import com.bwei.frame.MainActivity;

import dagger.Component;

/**
 * 1. 类的用途 桥梁 关联容器跟调用者
 * 2. @author forever
 * 3. @date 2017/12/4 09:32
 */

@Component(modules = GoodsModule.class)
public interface GoodsComponent {
    //注入调用者
    void inject(MainActivity mainActivity);
}
