package com.example.fragment.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragment.FragmentCallBack;
import com.example.fragment.R;

public class InfoFragment2 extends Fragment {
    private View view;
    private Button button;
    private TextView textView;
    private FragmentCallBack fragmentCallBack;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view=inflater.inflate(R.layout.fragment_info2, container, false);
        }
        button=view.findViewById(R.id.btn);
        textView=view.findViewById(R.id.tv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentCallBack.setMsgToActivity("这是来自fragment的消息");
            }
        });
        String str=fragmentCallBack.getMsgFromActivity();
        textView.setText(str);
        return view;
    }

    public void setFragmentCallBack(FragmentCallBack fragmentCallBack) {
        this.fragmentCallBack = fragmentCallBack;
    }
}