package com.example.smc7050u01.shoppingcart.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smc7050u01.shoppingcart.R;
import com.example.smc7050u01.shoppingcart.ui.OrderDetail;
import com.example.smc7050u01.shoppingcart.util.AllCapTransformationMethod;
import com.example.smc7050u01.shoppingcart.util.DBUtil;
import com.example.smc7050u01.shoppingcart.util.L;


/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart.fragment
 * 文件名:  ShoppingCartFragment
 * 创建者： Steven Kun
 * 创建时间：2018/10/23
 * 描述：TODO
 */
public class ShoppingCartFragment extends Fragment implements View.OnClickListener {
    private TextView method_first;
    private TextView method_second;
    private TextView tv_requestno;
    private TextView tv_itemno;
    private TextView tv_requestno_method_1;
    private EditText edit_requestno_method_first;



    private EditText         edit_requestno;
    private EditText         edit_itemno;
    private Button           btn_submit;
    private Bundle           mydata;
    private Message          msg;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

                case 1001:
                    String qr_byid = msg.getData().getString("result");
                    Intent intent = new Intent(getActivity(), OrderDetail.class);
                    intent.putExtra("result", qr_byid);
                    intent.putExtra("edit_requestno", edit_requestno.getText().toString().trim());
                    intent.putExtra("edit_itemno", edit_itemno.getText().toString().trim());
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_orderfragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tv_itemno = view.findViewById(R.id.textView2);
        tv_requestno = view.findViewById(R.id.textView3);
        tv_requestno_method_1 =view.findViewById(R.id.textView7);
        method_first = view.findViewById(R.id.textView4);

        method_first.setOnClickListener(this);
        method_second = view.findViewById(R.id.textView6);
        method_second.setOnClickListener(this);
        TextPaint tp1 =method_first.getPaint();
        TextPaint tp2=method_second.getPaint();
        tp1.setFakeBoldText(true);
        tp2.setFakeBoldText(true);


        btn_submit = view.findViewById(R.id.button3);
        edit_requestno = view.findViewById(R.id.editText4);
        edit_requestno.setTransformationMethod(new AllCapTransformationMethod(true));
        edit_itemno = view.findViewById(R.id.editText5);
        edit_itemno.setTransformationMethod(new AllCapTransformationMethod(true));
        edit_requestno_method_first = view.findViewById(R.id.editText3);
        edit_requestno_method_first.setTransformationMethod(new AllCapTransformationMethod(true));
        btn_submit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:
                query_id();
                break;
            case R.id.textView4:
                method_first.setBackgroundColor(Color.parseColor("#ffffd1"));
                method_second.setBackgroundColor(Color.WHITE);
                setVisibility(true);
                break;
            case R.id.textView6:
                setVisibility(false);
                method_first.setBackgroundColor(Color.WHITE);
                method_second.setBackgroundColor(Color.parseColor("#ffffd1"));
                break;
        }


    }

    private void setVisibility(Boolean visibility) {
        if (visibility) {
            edit_requestno.setVisibility(View.GONE);
            edit_itemno.setVisibility(View.GONE);
            tv_requestno.setVisibility(View.GONE);
            tv_itemno.setVisibility(View.GONE);
            edit_requestno_method_first.setVisibility(View.VISIBLE);
            tv_requestno_method_1.setVisibility(View.VISIBLE);
        } else {
            edit_requestno.setVisibility(View.VISIBLE);
            edit_itemno.setVisibility(View.VISIBLE);
            tv_requestno.setVisibility(View.VISIBLE);
            tv_itemno.setVisibility(View.VISIBLE);
            edit_requestno_method_first.setVisibility(View.GONE);
            tv_requestno_method_1.setVisibility(View.GONE);
        }

    }

    private void query_id() {
        ColorDrawable colorDrawable = (ColorDrawable) method_first.getBackground();
        int color = colorDrawable.getColor();
        if (color == Color.parseColor("#ffffd1")) {
            Runnable run =new Runnable() {
                @Override
                public void run() {
                    String requestno =edit_requestno_method_first.getText().toString().trim();
                    if (!TextUtils.isEmpty(requestno)){
                        L.d("按照方式一运行");
                        String ret =DBUtil.QueryALL();
                        msg.what=1002;
                        mydata =new Bundle();
                        mydata.putString("result", ret);
                        msg.setData(mydata);
                        handler.sendMessage(msg);
                    }else {
                        Looper.prepare();
                        Toast.makeText(getActivity(), "订单号不能为空", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }
                }
            };
            new Thread(run).start();
        } else {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    String requestno = edit_requestno.getText().toString().trim();
                    String itemno = edit_itemno.getText().toString().trim();
                    if (!TextUtils.isEmpty(requestno)
                            & !TextUtils.isEmpty(itemno)) {
                        String ret = DBUtil.querybyid(requestno, itemno);
                        msg = new Message();
                        msg.what = 1001;
                        mydata = new Bundle();
                        mydata.putString("result", ret);
                        msg.setData(mydata);
                        handler.sendMessage(msg);
                    } else {
                        Looper.prepare();
                        Toast.makeText(getActivity(), "订单号或者订单项号不能为空", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }
                }
            };
            new Thread(run).start();
        }
    }
}
