package com.example.welcome.bean;

import java.io.Serializable;

public class FoodBean implements Serializable {
    private String title,calorie,desc;
    private int picId;

    public FoodBean(String title, String calorie, String desc, int picId) {
        this.title = title;
        this.calorie = calorie;
        this.desc = desc;
        this.picId = picId;
    }


    public String getTitle() {
        return title;
    }

    public String getCalorie() {
        return calorie;
    }

    public String getDesc() {
        return desc;
    }

    public int getPicId() {
        return picId;
    }

}
