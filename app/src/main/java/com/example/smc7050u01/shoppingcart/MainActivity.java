package com.example.smc7050u01.shoppingcart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.example.smc7050u01.shoppingcart.fragment.Returnletter;
import com.example.smc7050u01.shoppingcart.fragment.ShoppingCartFragment;
import com.example.smc7050u01.shoppingcart.fragment.TimesSquare;
import com.example.smc7050u01.shoppingcart.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart
 * 文件名:  MainActivity
 * 创建者： Steven Kun
 * 创建时间：2018/10/23
 * 描述：TODO 整体布局  主页面
 */
public class MainActivity extends AppCompatActivity {

    private TabLayout      tabLayout;
    private ViewPager      viewPager;
    private List<Fragment> fragment;
    private List<String>   mtitile;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

    }


    private void initView() {

        tabLayout = findViewById(R.id.mtabLayout);
        viewPager = findViewById(R.id.mviewpager);

        //预编译
        viewPager.setOffscreenPageLimit(fragment.size());
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int i) {
                return fragment.get(i);
            }

            @Override
            public int getCount() {
                return fragment.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mtitile.get(position);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initData() {

        mtitile = new ArrayList<>();
        mtitile.add("订单查询");
        mtitile.add("返信中心");
        mtitile.add("个人中心");
        mtitile.add("日历查看");
        fragment = new ArrayList<>();
        fragment.add(new ShoppingCartFragment());
        fragment.add(new Returnletter());
        fragment.add(new UserFragment());
        fragment.add(new TimesSquare());
    }
}
