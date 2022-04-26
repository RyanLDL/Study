package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//广播：用于下程序间传递消息----系统广播和自定义广播----静态注册和动态注册
//发送广播的方法：1、sendBroadcast（）2、sendOrderedBroadcast();,两者在发送广播时，所有满足田间的对象都能接受，但后者会根据设置的优先级顺序来执行，如果动态和静态优先级相同，动态优先
//优先级的设置：在清单文件中的<intent-filter>标签中设置：android:prioity值，值越大优先级越高，高优先级有权阻止同样的广播发送到低优先级（getAbrotBroadcast()方法）。
public class MainActivity extends AppCompatActivity {
    private Button b1,b2,b3;
    String TAG = "TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //静态 ----1、清单文件注册 2、创建类继承BroadcastReceiver重写onreceive方法 3、发送广播
        b1=findViewById(R.id.send);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BroadCastTag.First);
                intent.putExtra("key","静态注册");
                sendBroadcast(intent);

                Log.d(TAG, "onClick: 发送广播");
            }
        });
//        动态  ---1、创建IntentFilter对象，并设置过滤条件 2、在注册的地方调用registReceiver注册监听 3、程序退出时调用unregistReceiver注销广播----缺点：宿主消亡时，广播也消亡。
        b2 = findViewById(R.id.send1);

        MyBroadCast myBroadCast = new MyBroadCast();//初始化广播对象

        IntentFilter intentFilter = new IntentFilter();//初始化过滤器对象

        intentFilter.addAction(BroadCastTag.Second);//设置过滤规则
//        intentFilter.setPriority(5);设置优先级

        registerReceiver(myBroadCast,intentFilter);//注册监听

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent =new Intent(BroadCastTag.Second);
            intent.putExtra("key1","动态注册");
            sendBroadcast(intent);
                Log.d(TAG, "onClick: 发送广播");
            }
        });
        b3 = findViewById(R.id.cancel);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unregisterReceiver(myBroadCast);
                Log.d(TAG, "onClick: 注销广播");
            }
        });
    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        unregisterReceiver(myBroadCast);
//    }
}