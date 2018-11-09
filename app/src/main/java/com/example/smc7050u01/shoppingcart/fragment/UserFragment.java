package com.example.smc7050u01.shoppingcart.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smc7050u01.shoppingcart.R;
import com.example.smc7050u01.shoppingcart.util.L;
import com.example.smc7050u01.shoppingcart.util.StaticClass;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okio.Source;

/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart.fragment
 * 文件名:  UserFragment
 * 创建者： Steven Kun
 * 创建时间：2018/10/23
 * 描述：TODO 1.版本更新实现下载  2.登录用户信息展示
 */
public class UserFragment extends Fragment {

    private TextView     tv_version;
    private LinearLayout ll_checkupdata;
    private String       versionName;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_userfragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {

        tv_version = view.findViewById(R.id.tv_version);

        ll_checkupdata = view.findViewById(R.id.linearLayout2);




    }











    }

