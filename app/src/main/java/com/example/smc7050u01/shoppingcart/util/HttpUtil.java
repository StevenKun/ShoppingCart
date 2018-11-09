package com.example.smc7050u01.shoppingcart.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart.util
 * 文件名:  HttpUtil
 * 创建者： Steven Kun
 * 创建时间：2018/10/30
 * 描述：TODO okhttp3的工具类
 */
public class HttpUtil {

    public static  void sendOkHttpRequest(String address , okhttp3.Callback callback ){
        OkHttpClient client =new OkHttpClient();
        Request request =new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
