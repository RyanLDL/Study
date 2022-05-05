package com.example.io;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private static final String TAG = "TAG";
    private List<Bean>beans;
    OnItemClickListenner onItemClickListenner;
    OnItemLongClickListenner onItemLongClickListenner;

    public Adapter(List<Bean> beans) {
        this.beans = beans;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.t1.setText(String.valueOf(position));

        holder.t2.setText(String.valueOf(beans.get(position).getStuID()));
        Log.d(TAG, "onBindViewHolder: "+beans.get(position).getStuID());
        holder.t3.setText(String.valueOf(beans.get(position).getStuName()));
        Log.d(TAG, "onBindViewHolder: "+beans.get(position).getStuName());
        holder.t4.setText(String.valueOf(beans.get(position).getStuClass()));
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView t1,t2,t3,t4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.ps);
            t2 = itemView.findViewById(R.id.Id);
            t3 = itemView.findViewById(R.id.Name);
            t4 = itemView.findViewById(R.id.Class);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListenner!=null){
                        onItemClickListenner.click(getAdapterPosition());
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (onItemLongClickListenner != null) {
                        onItemLongClickListenner.longClick(getAdapterPosition());
                    }
                    return true;
                }
            });
        }
    }

    public interface OnItemClickListenner{
        void click(int position);
    }
    public interface OnItemLongClickListenner{
        void longClick(int position);
    }

    public void setOnItemClickListenner(OnItemClickListenner onItemClickListenner) {
        this.onItemClickListenner = onItemClickListenner;
    }

    public void setOnItemLongClickListenner(OnItemLongClickListenner onItemLongClickListenner) {
        this.onItemLongClickListenner = onItemLongClickListenner;
    }
}
