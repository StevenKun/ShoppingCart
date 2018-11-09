package com.example.smc7050u01.shoppingcart.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smc7050u01.shoppingcart.R;
import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart.fragment
 * 文件名:  TimesSquare
 * 创建者： Steven Kun
 * 创建时间：2018/11/9
 * 描述：TODO
 */
public class TimesSquare extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tiemssquare, null);
        initView(view);
        return view;
    }

    private void initView(View view) {

        Calendar nextYear = Calendar.getInstance();
        //nextYear.add(Calendar.YEAR, 1);
        nextYear.add(Calendar.MONTH, 2);

        CalendarPickerView calendar = view.findViewById(R.id.calendar_view);
        Date today = new Date();
        calendar.init(today, nextYear.getTime())
                .withSelectedDate(today);
    }
}
