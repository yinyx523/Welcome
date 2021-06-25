package com.example.welcome.bean;

public class User {
    private String height;
    private String weight;
    private String BMI;

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBMI() {
        return BMI;
    }

    public void setBMI(String BMI) {
        this.BMI = BMI;
    }


    @Override
    public String toString() {
        return "User{" +
                ",height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", BMI='" + BMI + '\'' +
                '}';
    }



}
