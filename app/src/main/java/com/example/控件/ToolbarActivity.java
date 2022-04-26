package com.example.控件;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*
* Toolbar用于
*
*
*
* */
public class ToolbarActivity extends AppCompatActivity {
    Toolbar toolbar1,toolbar2;
    Button button;
    String TAG="toolbar";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        toolbar1=findViewById(R.id.tb);
        toolbar2=findViewById(R.id.tb2);
        button=findViewById(R.id.btn);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: 点击了第一个");
            }
        });
        toolbar2.setNavigationIcon(R.drawable.ic_2);
        toolbar2.setTitle("标题");
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: 点击了第二个");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ToolbarActivity.this,AlertDialogActivity.class);
                startActivity(intent);
            }
        });
    }
}