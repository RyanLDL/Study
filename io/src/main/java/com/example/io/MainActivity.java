package com.example.io;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    TextView tv1,tv2;
    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        tv1 = findViewById(R.id.uid);
        tv2 = findViewById(R.id.upwd);
        t1 = findViewById(R.id.id);
        t2 = findViewById(R.id.pwd);
        SharedPreferences preferences = getPreferences(Activity.MODE_PRIVATE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = t1.getText().toString();
                String pwd = t2.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("id",id);//两个参数分别是键和值
                editor.putString("pwd",pwd);
                editor.commit();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = preferences.getString("id","当前用户不存在");
                String pwd = preferences.getString("pwd","当前数据不存在");
                tv1.setText(id);
                tv2.setText(pwd);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences.edit().remove("id").commit();
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });
    }
}