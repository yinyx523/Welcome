package com.example.welcome.login_register;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.welcome.HomeActivity;
import com.example.welcome.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLogin;
    private EditText etAccount,etPassword;

    private String userName = "abc";
    private String pass = "123";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String account = etAccount.getText().toString();
        String password = etPassword.getText().toString();

        if(TextUtils.isEmpty(userName)){
            Toast.makeText(LoginActivity.this,"还未注册账号！",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.equals(account,userName)){
            if(TextUtils.equals(password,pass)){
                Toast.makeText(LoginActivity.this,"登录成功！",Toast.LENGTH_LONG).show();

                //登录成功后，跳转到HomeActivity页面,并且把账号数据传过去
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.putExtra("account",account);
                startActivity(intent);

            }else {
                Toast.makeText(LoginActivity.this,"密码错误！",Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(LoginActivity.this,"用户名错误！",Toast.LENGTH_LONG).show();
        }
    }


    //注册账号
    public void toRegister(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent,1);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 0 && data != null){
            Bundle extras = data.getExtras();

            //获取用户名和密码
            String account = extras.getString("account","");
            String password = extras.getString("password","");

            //输入框自动填充内容
            etAccount.setText(account);
            etPassword.setText(password);

            userName = account;
            pass = password;
        }
    }
}