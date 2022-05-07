package com.example.jetpack.MyliveData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jetpack.R;

import java.util.Timer;
import java.util.TimerTask;

public class MyLivaDataActivity extends AppCompatActivity {
    private TextView textView;
    private MyViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_liva_data);
        textView = findViewById(R.id.textView);
        viewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        textView.setText(String.valueOf(viewModel.getCurrentSecond().getValue()));
        viewModel.getCurrentSecond().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(String.valueOf(integer));
            }
        });
        startTime();
    }

    private void startTime() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //异步线程（非UI线程）用postValue（），UI线程用setValue（）
                viewModel.getCurrentSecond().postValue(viewModel.getCurrentSecond().getValue()+1);
            }
        },1000,1000);
    }

    public void Next(View view) {
        startActivity(new Intent(MyLivaDataActivity.this,MyViewModelActivity2.class));
    }
}