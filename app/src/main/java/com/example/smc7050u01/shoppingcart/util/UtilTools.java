package com.example.smc7050u01.shoppingcart.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.example.smc7050u01.shoppingcart.R;

/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart.util
 * 文件名:  UtilTools
 * 创建者： Steven Kun
 * 创建时间：2018/10/23
 * 描述：TODO 工具类
 */
public class UtilTools {

    public static String getVersion(Context mContext){
        PackageManager pm = mContext.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(mContext.getPackageName(),0);
            return info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return mContext.getString(R.string.print);
        }
    }

}
