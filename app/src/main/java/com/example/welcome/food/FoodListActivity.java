package com.example.welcome.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.welcome.R;
import com.example.welcome.bean.FoodBean;
import com.example.welcome.bean.FoodUtils;

import java.util.ArrayList;
import java.util.List;

public class FoodListActivity extends AppCompatActivity implements View.OnClickListener{
    EditText searchEt;
    ImageView searchIv,flushIv;
    ListView showLv;

    //ListView内部数据源
    List<FoodBean> mDatas;
    List<FoodBean> allFoodList;
    private FoodListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);

        //查找控件
        initView();

        //找到ListView对应的数据源
        mDatas = new ArrayList<>();
        allFoodList = FoodUtils.getAllFoodList();
        mDatas.addAll(allFoodList);

        //创建适配器
        adapter = new FoodListAdapter(this, mDatas);
        showLv.setAdapter(adapter); //设置适配器

        //设置单击监听
        setListener();

    }

    private void setListener() {
        showLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               FoodBean foodBean = mDatas.get(position);
                Intent intent = new Intent(FoodListActivity.this, FoodDescActivity.class);
                intent.putExtra("food",foodBean);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        searchEt = findViewById(R.id.info_et_search);
        searchIv = findViewById(R.id.info_iv_search);
        flushIv = findViewById(R.id.info_iv_flush);
        showLv = findViewById(R.id.infolist_lv);

        //添加点击事件
        searchIv.setOnClickListener(this);
        flushIv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            //刷新点击
            case R.id.info_iv_flush:
                searchEt.setText("");
                mDatas.clear();
                mDatas.addAll(allFoodList);
                adapter.notifyDataSetChanged();
                break;

            //搜索点击
            case R.id.info_iv_search:
                //获取输入内容，判断是否为空
                String msg = searchEt.getText().toString();//获取输入信息
                if(TextUtils.isEmpty(msg)){
                    Toast.makeText(this,"输入内容为空！",Toast.LENGTH_SHORT).show();
                    return;
                }

                //判断所有列表的标题是否包含输入内容
                List<FoodBean> list = new ArrayList<>();
                for(int i = 0; i < allFoodList.size(); i ++){
                    String title = allFoodList.get(i).getTitle();
                    if(title.contains(msg)){
                        list.add(allFoodList.get(i));
                    }
                }
                mDatas.clear();//清空原来的数据源
                mDatas.addAll(list);//添加新获取的数据
                adapter.notifyDataSetChanged();//适配器更新
                break;
        }

    }
}