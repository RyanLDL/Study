package com.example.io;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.MergeCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MySQLiteDatabase extends AppCompatActivity {
    private static final String TAG = "TAG";
    private Adapter adapter;
    private RecyclerView rv;
    private List<Bean> beans;
    private TextView t1,t2,t3;
    private Button b1,b2,b3;
    MySQL mySQL;
    SQLiteDatabase dbReader,dbWriter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sqlite_database);
        t1 = findViewById(R.id.ID);
        t2 = findViewById(R.id.NAME);
        t3 = findViewById(R.id.CLASS);
        b1 = findViewById(R.id.ADD);
        b2 = findViewById(R.id.UPDATE);
        b3 = findViewById(R.id.DELETE);
        rv = findViewById(R.id.rv);
        beans = new ArrayList<>();
        mySQL = new MySQL(getApplicationContext(),"student.db",null,1);
        dbReader = mySQL.getReadableDatabase();
        dbWriter = mySQL.getWritableDatabase();
        findAll();
        initRv(beans);
        adapter.setOnItemClickListenner(new Adapter.OnItemClickListenner() {
            @Override
            public void click(int position) {
                Log.d(TAG, "click: 点击");
                int a = beans.get(position).getStuID();
                String b = beans.get(position).getStuName();
                String c = beans.get(position).getStuClass();
                t1.setText(String.valueOf(a));
                t2.setText(b);
                t3.setText(c);
            }
        });
        adapter.setOnItemLongClickListenner(new Adapter.OnItemLongClickListenner() {
            @Override
            public void longClick(int position) {
                Log.d(TAG, "longClick: 长按");
                initAlertDialog(position);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stuId = Integer.parseInt(t1.getText().toString());
                String stuName = t2.getText().toString();
                String stuClass = t3.getText().toString();
                insert(stuId,stuName,stuClass);
                findAll();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int stuId = Integer.parseInt(t1.getText().toString());
                String stuName = t2.getText().toString();
                String stuClass = t3.getText().toString();
                update(stuId,stuName,stuClass);
                findAll();
                initRv(beans);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
                findAll();
                initRv(beans);
            }
        });
        
    }
    private void initRv(List<Bean> beans){
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new Adapter(beans);
        rv.setAdapter(adapter);
    }
    private void initAlertDialog(int position ) {
        View view = getLayoutInflater().inflate(R.layout.dialog,null);
        AlertDialog.Builder  builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_baseline_delete_forever_24)
                .setMessage("确认删除？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int stuId = beans.get(position).getStuID();
                        boolean isDelete = deleteById(stuId);
                        if(isDelete){
                            Log.d(TAG, "onClick: 删除成功");
                            findAll();
                            initRv(beans);
                        }else {
                            Log.d(TAG, "onClick: 删除失败");
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setView(view)
                .create()
                .show();
    }

    /**
     * 遍历
     */
    private void findAll() {
        Cursor cursor = null;
        cursor = dbReader.rawQuery("SELECT * from student",null);
        beans.clear();
        while (cursor.moveToNext()){
            Bean bean = new Bean();
            int stuId = cursor.getInt(1);
            String stuName = cursor.getString(2);
            String stuClass = cursor.getString(3);
            bean.setStuID(stuId);
            bean.setStuName(stuName);
            bean.setStuClass(stuClass);
            beans.add(bean);

        }
        cursor.close();

    }

    /**
     * 添加
     * @return
     */
    public boolean insert(int stuId,String stuName,String stuClass ){
        Cursor cursor = dbReader.query("student",null,"stuId=?",new String[]{String.valueOf(stuId)},null,null,null);
        if (cursor == null) {
            ContentValues cv = new ContentValues();
            cv.put("stuName",stuName);
            cv.put("stuId",stuId);
            cv.put("stuClass",stuClass);
            dbWriter.insert("student","stuId",cv);
            return true;
        }else {
            Log.d(TAG, "insert: 添加失败");
            return false;
        }
    }

    /**
     * 删除
     * @return
     */
    public boolean delete(){
        dbWriter.delete("student",null,null);
        Cursor cursor = dbReader.rawQuery("SELECT * from student",null);
        if (cursor == null) {
            Log.d(TAG, "delete: 成功");
            return true;

        }else {
            Log.d(TAG, "delete: 失败");
            return false;
        }
    }

    /**
     * 更新
     * @param stuId
     * @param stuName
     * @param stuClass
     * @return
     */
    public boolean update(int stuId,String stuName,String stuClass){
        Cursor cursor = dbReader.query("student",null,"stuId=?",new String[]{String.valueOf(stuId)},null,null,null);
        if (cursor == null) {
            Log.d(TAG, "update: 未找到");
            return false;
        }else {
            ContentValues cv =new ContentValues();
            cv.put("stuName",stuName);
            cv.put("stuClass",stuClass);
            dbWriter.update("student",cv,"stuId=?",new String[]{String.valueOf(stuId)});
            return true;
        }
    }
    public boolean deleteById(int stuId){
        dbWriter.delete("student","stuId=?",new String[]{String.valueOf(stuId)});
        Cursor cursor = dbReader.query("student",null,"stuId=?",new String[]{String.valueOf(stuId)},null,null,null);
        if (cursor == null) {
            return true;
        }else {
            return false;
        }

    }

}