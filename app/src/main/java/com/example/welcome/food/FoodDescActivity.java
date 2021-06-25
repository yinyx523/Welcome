package com.example.welcome.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.welcome.R;
import com.example.welcome.bean.FoodBean;

public class FoodDescActivity extends AppCompatActivity {
    TextView tvTitle1,tvTitle2,tvDesc, tvCalorie;
    ImageView ivBack, ivPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_desc);

        ivBack = findViewById(R.id.iv_back);
        tvTitle1 = findViewById(R.id.tv_title1);
        tvTitle2 = findViewById(R.id.tv_title2);
        tvDesc = findViewById(R.id.tv_desc);
        tvCalorie = findViewById(R.id.tv_calorie);
        ivPic = findViewById(R.id.iv_pic);


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //接收上一个页面传来的数据
        Intent intent = getIntent();
        FoodBean foodBean = (FoodBean) intent.getSerializableExtra("food");
        //设置显示控件
        tvTitle1.setText(foodBean.getTitle());
        tvTitle2.setText(foodBean.getTitle());
        tvDesc.setText(foodBean.getDesc());
        tvCalorie.setText("每100克 ： " + foodBean.getCalorie() + " 大卡");
        ivPic.setImageResource(foodBean.getPicId());

    }

}