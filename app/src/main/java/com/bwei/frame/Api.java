package com.bwei.frame;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/12/4 09:07
 */


public class Api {
    //true 测试 false线上
    private static boolean isDebug = true;
    //http://baobab.kaiyanapp.com/api/v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    public static final String onTestUrl = "http://baobab.kaiyanapp.com/";
    public static final String onLineUrl = "http://baobab.kaiyanapp.com/";


    public static final String url = baseUrl() + "api/v2/";

    //三目运算
    private static String baseUrl() {

        return isDebug ? onTestUrl : onLineUrl;
    }


}
