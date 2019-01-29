package com.example.smc7050u01.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart
 * 文件名:  HomeActivity
 * 创建者： Steven Kun
 * 创建时间：2019/1/7
 * 描述：TODO
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_btn_1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView() {
        img_btn_1= findViewById(R.id.img_btn_1);
        img_btn_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_btn_1:
                Intent intent =new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
