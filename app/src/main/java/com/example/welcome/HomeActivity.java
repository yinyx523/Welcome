package com.example.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.welcome.bmi.BmiActivity;
import com.example.welcome.bmi.QueryActivity;
import com.example.welcome.food.FoodListActivity;

public class HomeActivity extends AppCompatActivity {

    Button btn1,btn2,btn3;
    TextView tvAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //获取传过来的数据（账号）
        tvAccount = findViewById(R.id.tv_account);
        Intent intent = getIntent();
        String account = intent.getStringExtra("account");
        tvAccount.setText("账号 ： " + account);


        btn1 = findViewById(R.id.home_btn1);
        btn2 = findViewById(R.id.home_btn2);
        btn3 = findViewById(R.id.home_btn3);


        //卡路里查询
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FoodListActivity.class);
                startActivity(intent);
            }
        });

        //BMI计算
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BmiActivity.class);
                startActivity(intent);
            }
        });

        //我的BMI记录
        btn3.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QueryActivity.class);
                startActivity(intent);
            }
        }));

    }

}