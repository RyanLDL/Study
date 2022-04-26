package com.example.布局;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.控件.R;

public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
    }

    public void next(View view) {
        Intent intent=new Intent(LinearLayoutActivity.this,RelativeLayoutActivity.class);
        startActivity(intent);
    }
}