package com.example.io;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private MySQL mySQL;
    private ListView listView;
    private Button b1,b2,b3;
    private EditText et1,et2,et3;
    private SQLiteDatabase dbRedader,dbWrite;
    private Adapter adapter;
    private List<Bean>beans;
    private Bean bean = new Bean();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        b1 = findViewById(R.id.add);
        b2 = findViewById(R.id.update);
        b3 = findViewById(R.id.delete);
        listView = findViewById(R.id.lv);
        beans = new ArrayList<>();
        //实例化
        mySQL = new MySQL(getApplicationContext(),"FIRST.db",null,1);
        dbRedader = mySQL.getReadableDatabase();

        adapter = new Adapter(beans,getApplicationContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                et1.setText(beans.get(position).stuId);
                et2.setText(beans.get(position).stuName);
                et3.setText(beans.get(position).stuClass);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dbWrite = mySQL.getWritableDatabase();
                dbWrite.delete("FIRST.db","_id=?",new String[]{String.valueOf(position)});
                show();
                return true;
            }
        });

    }

    private void show() {
        //遍历
        Cursor cursor = dbRedader.query("FIRST.db",null,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            bean.stuId = cursor.getInt(1);
            bean.stuName = cursor.getString(2);
            bean.stuClass = cursor.getString(3);
            beans.add(bean);
            cursor.moveToNext();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbRedader.close();
        dbWrite.close();
    }
}