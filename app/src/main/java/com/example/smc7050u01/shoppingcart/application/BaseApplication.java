package com.example.smc7050u01.shoppingcart.application;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart.application
 * 文件名:  BaseApplication
 * 创建者： Steven Kun
 * 创建时间：2019/1/9
 * 描述：TODO
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);

    }
}
