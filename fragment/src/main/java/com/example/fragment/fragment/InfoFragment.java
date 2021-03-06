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


public class InfoFragment extends Fragment {
    private View view;
    private TextView tv;
    private Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_info, container, false);
        }
        tv = view.findViewById(R.id.tv);
        String str = getArguments().getString("first");
        tv.setText(str);
        return view;
    }
}