package com.example.布局.ViewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.控件.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {
    ViewPager viewPager;
    Adapter adapter;
    List<View>views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager=findViewById(R.id.vp);
        LayoutInflater lf=getLayoutInflater().from(this);//渲染每个布局
        View view1 = lf.inflate(R.layout.viewpager_1, null);
        View view2=lf.inflate(R.layout.viewpager_2,null);
        View view3=lf.inflate(R.layout.viewpager_3,null);
        views=new ArrayList<>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        adapter=new Adapter(views,this);
        viewPager.setAdapter(adapter);
    }
}