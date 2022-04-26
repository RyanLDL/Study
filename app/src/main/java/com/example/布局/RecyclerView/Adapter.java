package com.example.布局.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.控件.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private View view;
    private List<Bean>beanList;
    private Context context;
    OnItemClickListener onClickListener;
    public Adapter(List<Bean> beanList, Context context) {
        this.beanList = beanList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view=View.inflate(context,R.layout.recyclerview_item,null);//在listview中使用LayoutInflater.from(context).inflate(R.layout.listview_item, viewGroup, false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;//new MyViewHolder(view)
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(beanList.get(position).getName());
        //第一个设置方法
//        holder.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (onClickListener != null) {
//                    onClickListener.click(position);
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text);
            //第二个设置方法
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onClickListener!=null){
                        onClickListener.click(getAdapterPosition());
                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void click(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        onClickListener=listener;
    }
}
