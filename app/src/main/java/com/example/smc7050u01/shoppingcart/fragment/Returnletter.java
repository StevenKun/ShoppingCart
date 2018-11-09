package com.example.smc7050u01.shoppingcart.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smc7050u01.shoppingcart.R;

/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart.fragment
 * 文件名:  Returnletter
 * 创建者： Steven Kun
 * 创建时间：2018/10/23
 * 描述：TODO 返信碎片
 */
public class Returnletter extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.activity_returnletter, null);
        
        return view;

    }
}
