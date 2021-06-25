package com.example.welcome.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.welcome.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnRegister;
    private EditText etAccount,etPass,etPassConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        etAccount = findViewById(R.id.et_account);
        etPass = findViewById(R.id.et_password);
        etPassConfirm =findViewById(R.id.et_password_confirm);
        btnRegister = findViewById(R.id.btn_register);

        //点击监听事件
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String name = etAccount.getText().toString();
        String pass = etPass.getText().toString();
        String passConfirm = etPassConfirm.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(RegisterActivity.this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(RegisterActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!TextUtils.equals(pass, passConfirm)) {
            Toast.makeText(RegisterActivity.this, "密码不一致！", Toast.LENGTH_SHORT).show();
            return;
        }


        //储存注册的用户名和密码
        SharedPreferences spf = getSharedPreferences("spfRecord", MODE_PRIVATE);
        SharedPreferences.Editor edit = spf.edit();

        //数据回传
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("account", name);
        bundle.putString("password", pass);
        intent.putExtras(bundle);
        setResult(0, intent);

        Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_LONG).show();

        //结束页面,返回到登录页面
        this.finish();
    }
}