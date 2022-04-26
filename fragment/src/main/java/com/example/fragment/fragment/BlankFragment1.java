package com.example.fragment.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragment.Activity.Fragment2Activity;
import com.example.fragment.R;


public class BlankFragment1 extends Fragment {
    View view;
    Button btn;
    TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view =inflater.inflate(R.layout.fragment_blank1,container,false);
        }
        btn = view.findViewById(R.id.btn);
        tv=view.findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                tv.setText("I'm fine,thank you！");
                String key=getArguments().getString("key");
                tv.setText(key);
            }
        });
        return view;
    }
}