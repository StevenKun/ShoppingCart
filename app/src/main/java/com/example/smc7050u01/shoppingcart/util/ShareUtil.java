package com.example.smc7050u01.shoppingcart.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 项目名： ButerApp
 * 包名：   com.example.smc7050u01.buterapp.util
 * 文件名:  ShareUtil
 * 创建者： Steven Kun
 * 创建时间：2018/10/10
 * 描述：TODO
 */
public class ShareUtil {

    private static final String NAME ="config";
    //sharedPreferences String类型数据的封装
    public static void putString(Context context,String key,String values){
        SharedPreferences sharedPreferences=context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key,values).commit();

    }
    public static String getString(Context context,String key,String defvalues){
        SharedPreferences sharedPreferences=context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defvalues);
    }


    //sharedPreferences Int类型数据的封装
    public static void putInt(Context context,String key,int values){
        SharedPreferences sharedPreferences=context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt(key,values).commit();

    }
    public static int getInt(Context context,String key,int defvalues){
        SharedPreferences sharedPreferences=context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defvalues);
    }
    //sharedPreferences boolean类型数据的封装
    public static void putBoolean(Context context,String key,boolean values){
        SharedPreferences sharedPreferences=context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key,values).commit();

    }
    public static boolean getBoolean(Context context,String key,boolean defvalues){
        SharedPreferences sharedPreferences=context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defvalues);
    }
    //删除
    public static void remove(Context context,String key){
        SharedPreferences sharedPreferences=context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove(key).commit();
    }
    //删除全部
    public static void removeAll(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
    }
}
