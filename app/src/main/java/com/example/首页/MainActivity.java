package com.example.首页;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.控件.R;
import com.example.菜单.FirstMenuActivity;
import com.example.菜单.SecondMenuActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.first);
        btn2=findViewById(R.id.second);
        btn1.setOnClickListener(this::onClick);
        btn2.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.first:
                Intent intent=new Intent(MainActivity.this, FirstMenuActivity.class);
                startActivity(intent);
                break;
            case R.id.second:
                Intent intent1=new Intent(MainActivity.this, SecondMenuActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}