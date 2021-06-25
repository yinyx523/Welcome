package com.example.welcome.bmi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.welcome.bean.User;

import java.util.ArrayList;
import java.util.List;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME ="mySQLite.db";
    private static final String TABLE_NAME = "User";
    private static final String CREATE_TABLE_SQL = "create table "+ TABLE_NAME +"  (id integer primary key autoincrement,height text, weight text,BMI text)";



    public MySQLiteOpenHelper(Context context){
        super(context,DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //保存数据
    public long insertData(User user){

        //获取数据库
        SQLiteDatabase db = getWritableDatabase();

        //准备好数据
        ContentValues values = new ContentValues();
        values.put("height",user.getHeight());
        values.put("weight",user.getWeight());
        values.put("BMI",user.getBMI());

        //把数据插入数据库
        return db.insert(TABLE_NAME,null,values);
    }

    public List<User> queryAll(){

        //获取数据库
        SQLiteDatabase db = getWritableDatabase();

        List<User> userList = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);

        if(cursor != null){
            while (cursor.moveToNext()){

                //获取数据
                String height1 = cursor.getString(cursor.getColumnIndex("height"));
                String weight = cursor.getString(cursor.getColumnIndex("weight"));
                String BMI = cursor.getString(cursor.getColumnIndex("BMI"));


                //构建数据实体
                User user = new User();
                user.setHeight(height1);
                user.setWeight(weight);
                user.setBMI(BMI);

                //把数据添加到列表中
                userList.add(user);
            }
            cursor.close();


        }
        return userList;
    }
}
