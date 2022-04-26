package com.example.菜单;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.控件.R;


public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.myhodler>{
    OnItemClickListener listener;
    public interface OnItemClickListener{
        public void OnItemClick(View v,int position) throws ClassNotFoundException;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public myhodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.firsrmenu_item,parent,false);
        myhodler hodler=new myhodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(@NonNull myhodler holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(Data.getData().firstnameList.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    listener.OnItemClick(view,position);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return Data.getData().firstnameList.size();
    }

    class myhodler extends RecyclerView.ViewHolder {
        private TextView textView;
        public myhodler(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
        }
    }
}
