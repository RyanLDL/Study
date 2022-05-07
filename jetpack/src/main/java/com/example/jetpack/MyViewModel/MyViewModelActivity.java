package com.example.jetpack.MyViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jetpack.MyliveData.MyLivaDataActivity;
import com.example.jetpack.R;

public class MyViewModelActivity extends AppCompatActivity {
    private TextView textView;
    MyViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_model);
        textView = findViewById(R.id.num);
        viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(MyViewModel.class);
        textView.setText(String.valueOf(viewModel.number));
    }

    public void plus(View view) {
        textView.setText(String.valueOf(++ viewModel.number));
    }

    public void nextone(View view) {
        startActivity(new Intent(MyViewModelActivity.this, MyLivaDataActivity.class));
    }
}