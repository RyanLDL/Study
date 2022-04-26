package com.example.布局;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.控件.R;

public class RelativeLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
    }

    public void next(View view) {
        Intent intent=new Intent(RelativeLayoutActivity.this,FrameLayoutActivity.class);
        startActivity(intent);
    }
}