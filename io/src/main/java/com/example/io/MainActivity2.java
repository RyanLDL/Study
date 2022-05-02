package com.example.io;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class MainActivity2 extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView tv1,tv2,tv3;
    String TAG=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1= findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        tv2 = findViewById(R.id.TV2);
        b4 = findViewById(R.id.button4);
        tv1 = findViewById(R.id.TV1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
//                    1.获取InpoutStream（字节流）对象
                    InputStream in = getResources().getAssets().open("test.txt");
//                    2.使用InputStrreamReader（转换流）将字节流转换为字符流
                    InputStreamReader reader = new InputStreamReader(in,"UTF-8");
//                    3.使用缓冲流
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    char[]chars = new char[5];
                    int len;
                    while ((len=bufferedReader.read(chars)) != -1){
                        bufferedReader.read(chars,0,len);
                    }
                    bufferedReader.close();
                    String s = new String(chars);
                    tv1.setText(s);
                    Log.d(TAG, "onClick: "+s);
                }catch (IOException e){

                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fileOutputStream = openFileOutput("test.txt",MODE_APPEND);
//                    将字符转换为字节
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.write(tv2.getText().toString());
                    outputStreamWriter.close();
                }catch (IOException e){

                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //获取输入流
                    FileInputStream fileInputStream= openFileInput("test.txt");
                    //转换为字符流
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//                    构造字符数组，长度为输入流实际长度
                    char[]chars = new char[fileInputStream.available()];
                    int len;
                    while ((len = inputStreamReader.read(chars))!=-1){
                        inputStreamReader.read(chars,0,len);
                    }
                    String str = new String(chars);
                    tv2.setText(str);
                }catch (IOException e){

                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this,MainActivity3.class));
            }
        });
    }
}