package com.example.布局.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.控件.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private List<Bean>beans=new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter adapter;
    String TAG="TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        for (int i = 0; i < 100; i++) {
            Bean bean=new Bean();
            bean.setName("LDL"+i);
            beans.add(bean);

        }
        recyclerView=findViewById(R.id.rv);
        adapter=new Adapter(beans,this);
        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this,3));网格布局
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));//瀑布流布局
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void click(int position) {
                Log.d(TAG, "click: "+position);
            }
        });
    }
}