package com.example.布局.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.控件.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseAdapter {
    private List<JavaBean>beans;
    private Context context;

    public Adapter(List<JavaBean> beans, Context context) {
        this.beans = beans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {//返回item布局
//        if (view==null) {
//            view = LayoutInflater.from(context).inflate(R.layout.listview_item, viewGroup, false);
//        }
//        TextView text = view.findViewById(R.id.text);
//        text.setText(beans.get(i).getName());
//        return view;
//    }
    @Override//性能更好，不用重复使用findviewbyid（）
    public View getView(int i, View view, ViewGroup viewGroup) {//返回item布局
        viewHolder viewHolder;
        if (view==null) {
            viewHolder=new viewHolder();
            view = View.inflate(context,R.layout.listview_item,null);//LayoutInflater.from(context).inflate(R.layout.listview_item, viewGroup, false);
            viewHolder.textView=view.findViewById(R.id.text);
            view.setTag(viewHolder);
        }else {
            viewHolder=(viewHolder) view.getTag();
        }
        viewHolder.textView.setText(beans.get(i).getName());
        return view;
    }
    private final class viewHolder{
        TextView textView;
    }
}
