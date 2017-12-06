package com.example.czz.annotationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;

public class BaseActivity extends AppCompatActivity {
    private int layoutId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        displayLayout();
        displayView();
    }

    public <C extends Object> void startSetValue(C c){
        try {
            Class p = Class.forName("com.example.czz.annotationdemo.People");
            People people = (People) c;
            Field[] fields = p.getDeclaredFields();
            for (Field field : fields){
                if (field.isAnnotationPresent(AnnotationCollect.BindName.class)){
                    field.setAccessible(true);
                    AnnotationCollect.BindName bindName = field.getAnnotation(AnnotationCollect.BindName.class);
                    field.set(people,bindName.value());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //解析注解的view
    private void displayView(){
        //判断如果没有给avtivity通过注释赋值就return
        if (layoutId<=0){return;}
        //通过反射获取这个类以及实现他的子类
        Class<?> c = this.getClass();
        //获取反射到的类的属性
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields){
            try {
                //判断这条属性有没有被注解修饰
                if (field.getAnnotations() != null) {
                    //如果有获取这个属性的注解类
                    if (field.isAnnotationPresent(AnnotationCollect.BindView.class)) {//如果属于这个注解
                        field.setAccessible(true);//设置为true允许访问私有属性
                        //获取到修饰这个属性的注解
                        AnnotationCollect.BindView inject = field.getAnnotation(AnnotationCollect.BindView.class);
                        //获取到这个注解的value并对属性进行操作
                        field.set(this, this.findViewById(inject.value()));
                    }
                }
            } catch (Exception e) {
                Log.e("wusy", "not found view id!");
            }
        }

    }

    //解析注解的layout
    private void displayLayout(){
        Class<?> c = this.getClass();
        if (c.getAnnotations() != null){
            if (c.isAnnotationPresent(AnnotationCollect.BindLayout.class)){
                AnnotationCollect.BindLayout bindLayout = c.getAnnotation(AnnotationCollect.BindLayout.class);
                layoutId = bindLayout.value();
                setContentView(layoutId);
            }
        }
    }


}
