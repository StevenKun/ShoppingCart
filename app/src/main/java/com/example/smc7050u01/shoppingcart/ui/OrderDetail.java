package com.example.smc7050u01.shoppingcart.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icu.text.UnicodeSet;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smc7050u01.shoppingcart.R;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart.ui
 * 文件名:  OrderDetail
 * 创建者： Steven Kun
 * 创建时间：2018/10/24
 * 描述：TODO
 */
public class OrderDetail extends AppCompatActivity {
    private LinearLayout order_top;
    private LinearLayout order_layout;
    private LinearLayout order_status;
    private TextView tv_1;
    private TextView tv_2;
    private TextView tv_3;


    private TextView textresult;
    private TextView tv_requestid;
    private TextView tv_itemid;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdetail);

        initView();

        Intent intent=getIntent();

        String data =intent.getStringExtra("result");
        String requestno=intent.getStringExtra("edit_requestno");
        String edit_itemno=intent.getStringExtra("edit_itemno");


        if (TextUtils.isEmpty(data)){
            data="查无此数据";
            order_top.setVisibility(View.GONE);
            order_status.setVisibility(View.GONE);
            textresult.setText(data);
        }else {
            tv_requestid.setText(requestno);
            tv_itemid.setText(edit_itemno);

            if (data.contains(" 接单日期 :null")){
                tv_1.setBackgroundResource(R.drawable.shape_round_textview_null);
                tv_1.setText("未接单");
            }
            if (data.contains(" 打印日期 :null")){
                tv_2.setBackgroundResource(R.drawable.shape_round_textview_null);
                tv_2.setText("未打印");
            }
            if (data.contains("实际入物流日 :null")){
                tv_3.setBackgroundResource(R.drawable.shape_round_textview_null);
                tv_3.setText("未入库");
            }
            textresult.setText(data);
        }
    }

    private void initView() {

        textresult=findViewById(R.id.textView5);
        tv_1=findViewById(R.id.tv_1);
        tv_2=findViewById(R.id.tv_2);
        tv_3=findViewById(R.id.tv_3);
        tv_requestid=findViewById(R.id.tv_requestid);
        tv_itemid=findViewById(R.id.tv_itemid);
        order_layout=findViewById(R.id.order_layout);
        order_status=findViewById(R.id.order_status);
        order_top=findViewById(R.id.order_top);

    }
}
