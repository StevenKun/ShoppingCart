package com.example.smc7050u01.shoppingcart.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smc7050u01.shoppingcart.R;
import com.example.smc7050u01.shoppingcart.ui.OrderDetail;
import com.example.smc7050u01.shoppingcart.util.DBUtil;



/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart.fragment
 * 文件名:  ShoppingCartFragment
 * 创建者： Steven Kun
 * 创建时间：2018/10/23
 * 描述：TODO
 */
public class ShoppingCartFragment extends Fragment implements View.OnClickListener, View.OnTouchListener {
    private ConstraintLayout con_layout;
    private EditText edit_requestno;
    private EditText edit_itemno;
    private Button btn_submit;
    private Bundle mydata;
    private Message msg;

    Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){

                case 1001:
                    String qr_byid =msg.getData().getString("result");
                    Intent intent=new Intent(getActivity(), OrderDetail.class);
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

        View view =inflater.inflate(R.layout.activity_orderfragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        con_layout=view.findViewById(R.id.con_layout);
        con_layout.setOnTouchListener(this);
        btn_submit=view.findViewById(R.id.button3);
        edit_requestno=view.findViewById(R.id.editText4);
        edit_itemno=view.findViewById(R.id.editText5);
        btn_submit.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button3:
                query_id();
                break;
        }


    }

    private void query_id() {
        Runnable run =new Runnable() {
            @Override
            public void run() {
                String requestno =edit_requestno.getText().toString().trim();
                String itemno =edit_itemno.getText().toString().trim();
                if (!TextUtils.isEmpty(requestno)
                        &!TextUtils.isEmpty(itemno)){
                    String ret =DBUtil.querybyid(requestno,itemno);
                    msg=new Message();
                    msg.what=1001;
                    mydata =new Bundle();
                    mydata.putString("result", ret);
                    msg.setData(mydata);
                    handler.sendMessage(msg);
                }else{
                    Looper.prepare();
                    Toast.makeText(getActivity(),"订单号或者订单项号不能为空",Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            }
        };
        new Thread(run).start();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()){
            case R.id.con_layout:
                
        }
        return false;
    }


}
