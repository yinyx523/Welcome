package com.example.welcome.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.welcome.R;
import com.example.welcome.bean.User;

import java.text.DecimalFormat;

public class BmiActivity extends AppCompatActivity {

    Button button1,button2;
    EditText heightText,weightText;
    TextView bmiText,bodyText;

    private MySQLiteOpenHelper mMySQLiteOpenHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);


        initView();
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);


    }


    private void initView() {

        button1 = findViewById(R.id.bt_bmi);
        button2 = findViewById(R.id.bt_delete);
        heightText = findViewById(R.id.height);
        weightText = findViewById(R.id.weight);
        bmiText = findViewById(R.id.tv_bim2);
        bodyText = findViewById(R.id.tv_body2);

        //【计算BMI】 按钮
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat nf = new DecimalFormat("0.00");//保留两位小数
                double weight,height,BMI;
                weight = Double.parseDouble(weightText.getText().toString());
                height = Double.parseDouble(heightText.getText().toString());
                BMI = weight/(height*height);
                bmiText.setText(nf.format(BMI));
                if (BMI < 20){
                    bodyText.setText("偏瘦，多吃点东西！");
                }else if(BMI > 25){
                    bodyText.setText("超重，少吃点东西～");
                }else {
                    bodyText.setText("正常，继续保持！！");
                }
            }
        });

        //【清空】 按钮
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heightText.setText("");
                weightText.setText("");
                bmiText.setText("");
                bodyText.setText("");

            }
        });
    }


    //保存数据
    public void insert(View view) {

        String height = heightText.getText().toString();
        String weight = weightText.getText().toString();
        String BMI = bmiText.getText().toString();

        //构建数据实体
        User user = new User();
        user.setHeight(height);
        user.setWeight(weight);
        user.setBMI(BMI);

        //插入数据库
        long rowId = mMySQLiteOpenHelper.insertData(user);
        if(rowId != -1){
            Toast.makeText(this,"保存成功！",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"保存失败！",Toast.LENGTH_LONG).show();
        }

    }


}