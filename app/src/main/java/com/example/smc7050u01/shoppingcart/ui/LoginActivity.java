package com.example.smc7050u01.shoppingcart.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smc7050u01.shoppingcart.MainActivity;
import com.example.smc7050u01.shoppingcart.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_login;
    private EditText edit_name;
    private EditText edit_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {

        btn_login=findViewById(R.id.button);
        edit_name=findViewById(R.id.editText);
        edit_password=findViewById(R.id.editText2);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Login();
                break;
        }
    }

    private void Login() {

        String name =edit_name.getText().toString().trim();
        String password =edit_password.getText().toString().trim();
        if (!TextUtils.isEmpty(name)&
                !TextUtils.isEmpty(password)){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }else {
            Toast.makeText(this, "姓名和密码不能为空", Toast.LENGTH_SHORT).show();
        }

    }



}
