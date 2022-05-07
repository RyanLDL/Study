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

import java.util.PrimitiveIterator;

public class BlankFragment extends Fragment {
    SeekBar seekBar;
    private MyViewModel2 viewModel2;
    View root;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_blank,container,false);
            seekBar = root.findViewById(R.id.seekBar);
            viewModel2 = new ViewModelProvider(getActivity(),new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(MyViewModel2.class);
            viewModel2.getProgress().observe(getActivity(), new Observer<Integer>() {
                @Override
                public void onChanged(Integer integer) {
                    seekBar.setProgress(integer);
                }
            });
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    viewModel2.getProgress().setValue(progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }

        return root;
    }
}