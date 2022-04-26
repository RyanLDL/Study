package com.example.布局.ViewPager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends PagerAdapter {
    List<View> views=new ArrayList<>();
    Context context;

    public Adapter(List<View> views, Context context) {
        this.views = views;
        this.context = context;
    }

    @Override
    public int getCount() {//获得viewpager中有多少个view
        return views.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {//判断instantiateItem（ViewGroup，int）函数返回来的key与一个页面视图是否代表同一个视图（即判断是否是同一个view），通常return view==object
        return view==object;
    }


    //1、将给定位置的view添加到ViewGroup中，创建并显示出来。
    // 2、返回一个代表新增页面的Object（key），通常直接返回view，也可以自定义key，但要与视图对应
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(views.get(position),0);
        return views.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(views.get(position));
    }
}
