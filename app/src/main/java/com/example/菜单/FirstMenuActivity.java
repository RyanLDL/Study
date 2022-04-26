package com.example.菜单;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.控件.R;

public class FirstMenuActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FirstAdapter firstAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmenu);
        recyclerView=findViewById(R.id.recyclerview);
        firstAdapter =new FirstAdapter();
        firstAdapter.setListener(new FirstAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View v, int position) throws ClassNotFoundException {
                Class clazz=Class.forName(Data.getData().firstactivityList.get(position));
                Intent intent=new Intent(FirstMenuActivity.this,clazz);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(firstAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(FirstMenuActivity.this));
    }

}