package com.example.布局.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.控件.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    ListView lv;
    String TAG="TAG";
    private List<JavaBean> bean=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        for(int i=0;i<100;i++){
            JavaBean javaBean=new JavaBean();
            javaBean.setName("LDL"+i);
            bean.add(javaBean);
        }
        lv=findViewById(R.id.listview);
        lv.setAdapter(new Adapter(bean,this));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {//点击事件
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: "+i);
            }
        });
    }
}