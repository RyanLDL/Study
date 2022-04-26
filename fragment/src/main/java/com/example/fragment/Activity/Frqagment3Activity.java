package com.example.fragment.Activity;

/*
    Activity与fragment通讯
        原生方案 Bundle：发送：1、创建实例（Bundle和fragment）2、调用put方法3、调用setArguments（）接收：调用getArguments（）和get方法
        接口方案：



*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fragment.FragmentCallBack;
import com.example.fragment.R;
import com.example.fragment.fragment.BlankFragment1;
import com.example.fragment.fragment.InfoFragment;
import com.example.fragment.fragment.InfoFragment2;

public class Frqagment3Activity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frqagment3);
        tv=findViewById(R.id.tv);


    }

    public void sendFirstinfo(View view) {
        Bundle bundle=new Bundle();
        InfoFragment bf=new InfoFragment();
        bundle.putString("first","这是第一种通信方式");
        bf.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fc,bf).commit();
    }

    public void sendSecondinfo(View view) {
        InfoFragment2 infoFragment=new InfoFragment2();
        getSupportFragmentManager().beginTransaction().replace(R.id.fc,infoFragment).commit();
        infoFragment.setFragmentCallBack(new FragmentCallBack() {
            @Override
            public void setMsgToActivity(String str) {
                tv.setText(str);
            }

            @Override
            public String getMsgFromActivity() {
                return "这是来自Avtivity的信息";
            }
        });
    }

    public void sendThirdinfo(View view) {
    }

    public void next(View view) {
        Intent intent=new Intent(this,Fragment4Activity.class);
        startActivity(intent);
    }
}