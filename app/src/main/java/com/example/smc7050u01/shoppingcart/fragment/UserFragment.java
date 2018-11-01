package com.example.smc7050u01.shoppingcart.fragment;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.smc7050u01.shoppingcart.R;
import com.example.smc7050u01.shoppingcart.util.DownloadManagerUtil;
import com.example.smc7050u01.shoppingcart.util.StaticClass;

/**
 * 项目名： ShoppingCart
 * 包名：   com.example.smc7050u01.shoppingcart.fragment
 * 文件名:  UserFragment
 * 创建者： Steven Kun
 * 创建时间：2018/10/23
 * 描述：TODO 1.版本更新实现下载  2.登录用户信息展示  3
 */
public class UserFragment extends Fragment implements View.OnClickListener {


    private Button btn_updata;

    private TextView tv_version;
    private LinearLayout ll_checkupdata;
    private String versionName;
    private int versionCode;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.activity_userfragment, null);

        initView(view);

        return view;
    }

    private void initView(View view) {


        tv_version=view.findViewById(R.id.tv_version);

        ll_checkupdata=view.findViewById(R.id.ll_checkupdata);

        ll_checkupdata.setOnClickListener(this);

        try {
            getVersionNameCode();
            tv_version.setText(versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            tv_version.setText("");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_checkupdata:


                /**步骤：
                 * 1.请求服务器的配置文件，拿到code
                 * 2.比较
                 * 3.dialog提示
                 * 4.跳转更新界面，并把url传递过去
                 */

                // 使用DownloadManager进行下载，需要卸载原程序
                /*downloadManagerUtil =new DownloadManagerUtil(getActivity());
                if (downloadId !=0){
                    downloadManagerUtil.clearCurrentTask(downloadId);
                }
                downloadId =downloadManagerUtil.download(StaticClass.CHECK_UPDATE_URL, title, desc);
                break;*/


        }
    }

    private void getVersionNameCode() throws PackageManager.NameNotFoundException {
        PackageManager pm =getActivity().getPackageManager();
        PackageInfo info =pm.getPackageInfo(getActivity().getPackageName(), 0);

        versionName =info.versionName;
        versionCode =info.versionCode;

    }
}
