package com.example.jetpack.MyLifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jetpack.MyViewModel.MyViewModelActivity;
import com.example.jetpack.R;

public class LifecycleServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_service);

    }

    public void start(View view) {
        startService(new Intent(this,MyService.class));
    }

    public void stop(View view) {
        stopService(new Intent(this,MyService.class));

    }

    public void next(View view) {
        startActivity(new Intent(LifecycleServiceActivity.this, MyViewModelActivity.class));
    }
}