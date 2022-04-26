package com.example.fragment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.fragment.R;
import com.example.fragment.fragment.BlankFragment1;
import com.example.fragment.fragment.BlankFragment2;


public class FragmentActivity extends AppCompatActivity {

    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

    }









    public void next(View view) {
        Intent intent=new Intent(FragmentActivity.this, Fragment2Activity.class);
        startActivity(intent);
    }
}