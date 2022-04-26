package com.example.multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**  多线程
 * 进程：正在运行的程序的实例
 * 线程：线程时进程的一个实体
 * 进程分类（重要级别由大到小）
 *      前台进程：用户当前正在使用的进程。activity（onresume状态），service（宿主处于onresume），broadcast（宿主处于onresume）
 *      可见进程：不包含前台组件，但会在屏幕上显示。1、还进程中含有一个不为于前台的Activity但仍对用户可见。2、该进程绑定在了一个可见Activity的service上。
 *      服务进程：包含一个已经以startService（）方式启动的service的进程，但不属于前面两种
 *      后台进程：不对用户可见的activity（处于onstop状态）
 *      空进程：不包含任何活动的应用组件的进程
 *
 *
 *  Thread类或Runnable接口创建线程
 *
 *UI线程与非UI线程
 * 非UI线程访问UI线程：1、Activity.runOnUiThread(Runnable)  2、View.post(Runnable)  3、View.postDelayed(Runnable,long)
 *
 *
 *
 *
 *
 */
public class MainActivity extends AppCompatActivity {
    TextView tv;
    private int time=0;
    boolean isrunning = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.LDL);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        Thread.currentThread().sleep(1000);
                        time+=1;
                        tv.post(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText(time+"");
                            }
                        });
                    }catch (Exception e){

                    }
                }
            }
        });
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public void next(View view) {
        startActivity(new Intent(MainActivity.this,MainActivity2.class));
    }
}
////       1、thread类
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        thread.start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).run();
////    2、runnable 接口
//    class A implements Runnable{
//
//        @Override
//        public void run() {
//
//        }
//
//    }