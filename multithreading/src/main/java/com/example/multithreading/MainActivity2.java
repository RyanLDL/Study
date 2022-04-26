package com.example.multithreading;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

/**
 * 线程通信：1、Handler （线程安全，不关系具体接收者）  2、AsyncTask
 *
 *
 * 1、handler：消息处理类Handler在Android系统里负责发送和处理消息，通过它可以实现其他 线程与UI线程之间的消息通信。Handler主要有两个用途：首先是可以定时处理或者 分发消息，
 *      其次是可以添加一个执行的行为在其他线程中执行。 Handler允许发送和处理Message或Runnable对象到其所在线程的MessageQueue 中，在发送的时候可以指定不同的延迟时间、
 *      发送时间和要携带的数据。当 MessageQueue循环到该Message时调用相应的Handler对象的handleMessage(）方法 对其进行处理。一个线程对应着一个Looper对象，
 *      一个Looper对象对应着一个 MessageQueue(消息队列）对象，但是一个线程可以有多个Handler对象，这些Handler 对象可以共享同一个Looper和MessageQueue
 *
 *                handleMessage(Message msg)  ：处理消息的方法，在发送消息之后，该方法 会自动调用
 *                post(Runnable r)：立即发送Runnable对象，该Runnable对象最后被封装成Message对象
 *                postAtTime(Runnable r, long uptimeMills)：定时发送Runnable对象
 *                 postDelayed(Runnable r,long delayMills)： 延迟发送Runnable对象
 *                  sendEmptyMessage(int what) ：发送空消息
 *                  sendMessage(Messagemsg)Messagemsg 立即发送消息
 *                  sendMessageAtTime(Messagemsg,long uptimeMils) 定时发送消息
 *                  sendMessageDelay（Message msg,long delaymills）延迟发送消息
 *
 * Looper:用于实现消息队列和消息循环机制。一个线程对应一个L哦哦烹饪对象，一个L哦哦烹饪对象对应一个MessageQueue对象。MessageQueue用于存放消息
 *              myLooper（）：获取当前线程的looper对象
 *              getThread（）获取looper对象所属的线程。
 *              quit（）结束Looper循环
 *
 * Message：线程通信的消息载体。 调用Message。obtain（）或Handler。obtainMessage（）获取对象。  message存与MessageQueue中，一个MessageQueue包含多个Message对象
 *          属性：
 *                  arg1: int 用于存放整形数据
 *                  arg2: int 用于存放整形数据
 *                  abj: Object 存放任意类型数据
 *                  replayTo: Message 用来指定此Message发往何处
 *                  what: int 消息标识-->自定义
 *
 *
 *  步骤：（1）在主线程实例化Handler,重写handleMessage()方法，处理收到的消息。
 *       （2）在子线程中实例化Message对象。调用已经实例化好的Handler对象的 obtainMessage()方法,把数据传给obtainMessage(）方法,obtainMessage()方法就会实 例化一个Message对象。
 *       （3）调用Handler的sendMessage(）方法把已经实例化的Message对象发送出去，添加到UI线程的MessageQueue中
 *       （4）UI线程通过MainLooper从消息队列中取出Handler发过来的消息时，回调Handler的handMessage方法
 */
public class MainActivity2 extends AppCompatActivity {
    int a=0;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.time);
        Handler handler = new Handler(Looper.myLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1){
                    tv.setText(msg.arg1+"");
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.currentThread().sleep(1000);
                        a++;
                        Message msg = Message.obtain();
                        msg.arg1=a;
                        msg.what = 1;
                        handler.sendMessage(msg);
                    }catch (Exception e){
                    }
                }
            }
        }).start();
    }
}