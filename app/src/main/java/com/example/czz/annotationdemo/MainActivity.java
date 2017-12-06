package com.example.czz.annotationdemo;

import android.os.Bundle;
import android.widget.TextView;

@AnnotationCollect.BindLayout(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @AnnotationCollect.BindView(R.id.tv_1)
    private TextView tv_1;
    @AnnotationCollect.BindView(R.id.tv_2)
    private TextView tv_2;
    @AnnotationCollect.BindView(R.id.tv_3)
    private TextView tv_3;
    @AnnotationCollect.BindView(R.id.tv_4)
    private TextView tv_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        People people = new People();
        startSetValue(people);
        people.printInfo();

        tv_1.setText("1");
        tv_2.setText("2");
        tv_3.setText("3");
        tv_4.setText("4");
    }

}
