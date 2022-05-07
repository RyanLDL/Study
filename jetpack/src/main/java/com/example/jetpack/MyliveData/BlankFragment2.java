package com.example.jetpack.MyliveData;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.jetpack.R;

public class BlankFragment2 extends Fragment {
    private View view;
    private MyViewModel2 myViewModel2;
    private SeekBar seekBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_blank2, container, false);
            seekBar = view.findViewById(R.id.seekBar2);
            myViewModel2 = new ViewModelProvider(getActivity(),new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(MyViewModel2.class);
            myViewModel2.getProgress().observe(getActivity(), new Observer<Integer>() {//当ViewModel中的值变化时，通过ViewModel中的变量调用Observer（）方法（观察者模式）改变界面的值
                @Override
                public void onChanged(Integer integer) {
                    seekBar.setProgress(integer);
                }
            });
        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                myViewModel2.getProgress().setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return view;
    }
}