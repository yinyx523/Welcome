package com.example.welcome.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.welcome.R;
import com.example.welcome.bean.User;

import java.util.List;

public class QueryActivity extends AppCompatActivity {

    private MySQLiteOpenHelper mMySQLiteOpenHelper;
    TextView tvQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        tvQuery = findViewById(R.id.tv_query);
        mMySQLiteOpenHelper = new MySQLiteOpenHelper(this);

    }


    public void query(View view) {
            //查询数所有数据
            List<User> user = mMySQLiteOpenHelper.queryAll();
            showData(user);
            return;
    }

    //查询后，展示查询数据
    private void showData(List<User> user){
        //遍历
        String result = "";
        for(User us : user){
            result += "身高： " + us.getHeight() + ", 体重： " + us.getWeight() + ", BMI: " + us.getBMI() + "\n";
        }

        tvQuery.setText(result);

    }

}