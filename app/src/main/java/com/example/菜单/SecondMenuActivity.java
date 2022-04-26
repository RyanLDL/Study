package com.example.菜单;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.控件.R;

public class SecondMenuActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SecondAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_menu);
        recyclerView=findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(SecondMenuActivity.this));
        adapter=new SecondAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setListener(new SecondAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View v, int position) throws ClassNotFoundException {
                Class clazz=Class.forName(Data.getData().secondactivityList.get(position));
                Intent intent=new Intent(SecondMenuActivity.this,clazz);
                startActivity(intent);
            }
        });
    }
}