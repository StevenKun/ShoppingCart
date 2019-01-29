package com.example.smc7050u01.shoppingcart.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
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

import com.example.smc7050u01.shoppingcart.MainActivity;
import com.example.smc7050u01.shoppingcart.R;
import com.example.smc7050u01.shoppingcart.ui.OrderDetail;
import com.example.smc7050u01.shoppingcart.util.AllCapTransformationMethod;
import com.example.smc7050u01.shoppingcart.util.DBUtil;
import com.example.smc7050u01.shoppingcart.util.L;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;


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
    private TextView method_three;
    private TextView tv_requestno;
    private TextView tv_itemno;
    private TextView tv_requestno_method_1;
    private EditText edit_requestno_method_first;

    private final int REQUEST_CODE=10001;
    private EditText edit_requestno;
    private EditText edit_itemno;
    private Button   btn_submit;
    private Button btn_Zxing;
    private Bundle   mydata;
    private Message  msg;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

                case 1001:
                    String qr_byid = msg.getData().getString("result");
                    L.d(qr_byid);
                    Intent intent1 = new Intent(getActivity(), OrderDetail.class);
                    intent1.putExtra("result", qr_byid);
                    intent1.putExtra("edit_requestno", edit_requestno.getText().toString().trim());
                    intent1.putExtra("edit_itemno", edit_itemno.getText().toString().trim());
                    startActivity(intent1);
                    break;
                case 1002:
                    String qr_all = msg.getData().getString("result");
                    L.d(qr_all);
                    Intent intent2 = new Intent(getActivity(), OrderDetail.class);
                    intent2.putExtra("result", qr_all);
                    intent2.putExtra("edit_requestno", edit_requestno_method_first.getText().toString().trim());
                    startActivity(intent2);
                    break;
                case 1003:
                    String ApprovedID = msg.getData().getString("result");
                    L.d(ApprovedID);
                    Intent intent3 = new Intent(getActivity(), OrderDetail.class);
                    intent3.putExtra("result", ApprovedID);
                    intent3.putExtra("approvedID", edit_requestno_method_first.getText().toString().trim());
                    startActivity(intent3);
                    break;
                default:
                    break;
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (getActivity().checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[] {Manifest.permission.CAMERA}, 1);
            }
        }

        View view = inflater.inflate(R.layout.activity_orderfragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tv_itemno = view.findViewById(R.id.textView2);
        tv_requestno = view.findViewById(R.id.textView3);
        tv_requestno_method_1 = view.findViewById(R.id.textView7);
        method_first = view.findViewById(R.id.textView4);
        method_first.setOnClickListener(this);
        method_second = view.findViewById(R.id.textView6);
        method_second.setOnClickListener(this);
        method_three = view.findViewById(R.id.tv_method3);
        method_three.setOnClickListener(this);
        TextPaint tp1 = method_first.getPaint();
        TextPaint tp2 = method_second.getPaint();
        TextPaint tp3 =method_three.getPaint();
        tp1.setFakeBoldText(true);
        tp2.setFakeBoldText(true);
        tp3.setFakeBoldText(true);

        btn_Zxing=view.findViewById(R.id.btn_Zxing);
        btn_Zxing.setOnClickListener(this);

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
            case R.id.btn_Zxing:
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.textView4:
                tv_requestno_method_1.setText("订单编号");
                edit_requestno_method_first.setHint("订单编号");
                method_first.setBackgroundColor(Color.parseColor("#f53505"));
                method_three.setBackgroundColor(Color.WHITE);
                method_second.setBackgroundColor(Color.WHITE);
                edit_requestno.setText("");
                edit_itemno.setText("");
                setVisibility(true);
                break;
            case R.id.textView6:
                setVisibility(false);
                method_first.setBackgroundColor(Color.WHITE);
                method_three.setBackgroundColor(Color.WHITE);
                method_second.setBackgroundColor(Color.parseColor("#f53505"));
                break;
            case R.id.tv_method3:
                method_first.setBackgroundColor(Color.WHITE);
                method_second.setBackgroundColor(Color.WHITE);
                tv_requestno_method_1.setText("出荷指示号");
                edit_requestno_method_first.setText("");
                edit_itemno.setText("");
                edit_requestno_method_first.setHint("出荷指示号");
                method_three.setBackgroundColor(Color.parseColor("#f53505"));
                setVisibility(true);


        }


    }

    private void setVisibility(Boolean visibility) {
        if (visibility) {
            edit_requestno.setVisibility(View.GONE);
            edit_itemno.setVisibility(View.GONE);
            tv_requestno.setVisibility(View.GONE);
            tv_itemno.setVisibility(View.GONE);
            btn_Zxing.setVisibility(View.VISIBLE);
            edit_requestno_method_first.setVisibility(View.VISIBLE);
            tv_requestno_method_1.setVisibility(View.VISIBLE);
        } else {
            edit_requestno.setVisibility(View.VISIBLE);
            edit_itemno.setVisibility(View.VISIBLE);
            tv_requestno.setVisibility(View.VISIBLE);
            tv_itemno.setVisibility(View.VISIBLE);
            btn_Zxing.setVisibility(View.GONE);
            edit_requestno_method_first.setVisibility(View.GONE);
            tv_requestno_method_1.setVisibility(View.GONE);
        }
    }

    private void query_id() {
        ColorDrawable colorDrawable1 = (ColorDrawable) method_first.getBackground();
        ColorDrawable colorDrawable2 = (ColorDrawable) method_second.getBackground();

        final int color1 = colorDrawable1.getColor();

        if (color1 == Color.parseColor("#f53505")) {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    String requestno = edit_requestno_method_first.getText().toString().trim();
                    if (!TextUtils.isEmpty(requestno)) {
                        L.d("按照方式一运行");
                        String ret = DBUtil.QueryALL(requestno);
                        msg = new Message();
                        msg.what = 1002;
                        mydata = new Bundle();
                        mydata.putString("result", ret);
                        L.d(ret);
                        msg.setData(mydata);
                        handler.sendMessage(msg);
                    } else {
                        Looper.prepare();

                        Toast.makeText(getActivity(), "订单号不能为空", Toast.LENGTH_SHORT).show();

                        Looper.loop();
                    }
                }
            };
            new Thread(run).start();
        } else if (colorDrawable2.getColor() == Color.parseColor("#f53505")) {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    String requestno = edit_requestno.getText().toString().trim();
                    String itemno = edit_itemno.getText().toString().trim();
                    if (!TextUtils.isEmpty(requestno)
                            & !TextUtils.isEmpty(itemno)) {
                        String ret = DBUtil.querybyid(requestno,itemno);
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
        else {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    String ApprovedID = edit_requestno_method_first.getText().toString().trim();
                    if (!TextUtils.isEmpty(ApprovedID)) {
                        L.d("按照方式三运行");
                        String ret = DBUtil.Query_ApprovedID(ApprovedID);
                        msg = new Message();
                        msg.what = 1003;
                        mydata = new Bundle();
                        mydata.putString("result", ret);
                        L.d(ret);
                        msg.setData(mydata);
                        handler.sendMessage(msg);
                    } else {
                        Looper.prepare();
                        Toast.makeText(getActivity(), "出荷指示号不能为空", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }
                }
            };
            new Thread(run).start();

        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        L.d(data+"");
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                L.d(data+"");
                if (bundle == null) {
                    L.d(data+"");
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    edit_requestno_method_first.setText(result);
                    L.d(result);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
