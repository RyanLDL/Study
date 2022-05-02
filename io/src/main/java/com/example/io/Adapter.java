package com.example.io;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private List<Bean> beans;
    private Context context;
    public Adapter(List<Bean> beans,Context context){
        this.beans = beans;
        this.context = context;
    }
    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        myViewHolder myViewHolder ;
        if (convertView == null) {
            myViewHolder = new myViewHolder();
            convertView = View.inflate(context,R.layout.item,null);
            myViewHolder.t1 = convertView.findViewById(R.id.t1);
            myViewHolder.t2 = convertView.findViewById(R.id.t2);
            myViewHolder.t3 = convertView.findViewById(R.id.t3);
            myViewHolder.t4 = convertView.findViewById(R.id.t4);
            convertView.setTag(myViewHolder);
        }else {
            myViewHolder = (myViewHolder) convertView.getTag();
        }
        myViewHolder.t1.setText(position);
        myViewHolder.t2.setText(beans.get(position).stuId);
        myViewHolder.t3.setText(beans.get(position).stuName);
        myViewHolder.t4.setText(beans.get(position).stuClass);
        return convertView;
    }
    private final class myViewHolder{
        TextView t1,t2,t3,t4;


    }
}
