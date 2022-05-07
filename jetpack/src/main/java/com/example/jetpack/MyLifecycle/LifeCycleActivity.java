package com.example.jetpack.MyLifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jetpack.R;

public class LifeCycleActivity extends AppCompatActivity {
    MyChronometer chronometer;
    Button button;
    long l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.time);
        getLifecycle().addObserver(chronometer);//添加生命周期的监听
        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LifeCycleActivity.this,LifecycleServiceActivity.class));
            }
        });

    }


    //这是未使用LifeCycle之前，过分依赖Activity的生命周期
//    @Override
//    protected void onResume() {
//        super.onResume();
//        chronometer.setBase(SystemClock.elapsedRealtime()-l);//设置基准时间
//        chronometer.start();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        l = SystemClock.elapsedRealtime() - chronometer.getBase();//在后台的时间
//        chronometer.stop();
//    }


}