package com.example.菜单;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.控件.R;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.myholder>{
    OnItemClickListener listener;
    public interface OnItemClickListener{
        public void OnItemClick(View v,int position) throws ClassNotFoundException;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    @NonNull
    @Override
    public myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.secondmenu_item,parent,false);
        myholder holder=new myholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull myholder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(Data.getData().secondnameList.get(position));
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
        return Data.getData().secondnameList.size();
    }

    class myholder extends RecyclerView.ViewHolder{
        TextView textView;
        public myholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
        }
    }
}
