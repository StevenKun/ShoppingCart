package com.example.smc7050u01.shoppingcart.util;


import android.util.Log;

/**
 * 项目名： ButerApp
 * 包名：   com.example.smc7050u01.buterapp.util
 * 文件名:  L
 * 创建者： Steven Kun
 * 创建时间：2018/10/10
 * 描述：log日志的封装
 */
public class L {


    //开关
    public static final boolean DEBUG=true;
    public static final String TAG="THIS";

    public  static void d(String text){
        if (DEBUG){
            Log.d(TAG, text);
        }
    }
    public  static void w(String text){
        if (DEBUG){
            Log.w(TAG, text);
        }
    }
    public  static void e(String text){
        if (DEBUG){
            Log.e(TAG, text);
        }
    }
    public  static void i(String text){
        if (DEBUG){
            Log.i(TAG, text);
        }
    }

}
