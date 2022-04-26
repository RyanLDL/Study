package com.example.fragment.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import com.example.fragment.R;
import com.example.fragment.fragment.FragmentTest;

/*        1、具有生命周期
        * 2、必须委托在activity中才能运行
        *       Activity State          Fragment Callbacks
        *
        *                               1—>OnAttach(绑定Activity)
        *       Created                 2—>onCreate
        *                               3—>onCreatView
        *                               4—>onActivityCreated()
        * **********************************************
        *       Started                 5—>onstart
        *       Resumed                 6—>onResumed
        *       Paused                  7—>onPause
        *       Stoped                  8—>onStop
        * **********************************************
        *                               9—>onDestroyView
        *       Destroyed               10—>onDestoy
        *                               11—>onDetach
        *
        *
        * 打开界面：2->3->4->5->6
        * 按下主屏幕：7->8
        * 重新打开：5->6
        * 按下返回键：7->8->9->10->11
        * */
public class Fragment4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment4);

    }

    public void add(View view) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fc,new FragmentTest()).commit();
    }
}