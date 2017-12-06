package com.example.czz.annotationdemo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by cuizhize on 2017/12/4.
 */

public class People {
    @AnnotationCollect.BindName("sam")
    private String name;
    @AnnotationCollect.BindSex
    private String sex;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void printInfo(){
        Log.d("print","this people name is "+name+" and sex is "+sex+" and age is "+age+"");
    }

}
