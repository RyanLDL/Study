package com.example.servise;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * 在使用时余姚在清单文件中注册<service android:name=".MyService"/>
 *
 *
 * 生命周期
 *  调用startService（）启动时-->oncreat（）-->onStartCommond()-->运行状态-->Service结束或调用stopService（）结束服务-->onDestroy（） ----此方法便于保活
 *  or
 *  调用bindService()启动时--> oncreat()-->onbind()-->运行状态-->onUnbindService()-->onDestroy()       ---此方法可以便与通信  兼顾连着优点时，可以两者同时调用
 *
 * Service具体执行的任务写在onatarcommond（）或onbind（）中；
 *  Service可以start多次但只会oncreat（）和onDestroy（）一次
 *
 *  当使用startService方式时，如果没有stop，服务就不会停止，而使用bindService时，调用者消亡服务也会消亡。当两者同时调用时，必须调用stopService和unbindService才能终止服务
 *
 */
import androidx.annotation.Nullable;


/**
 * 前台服务级通知推送
 * startForeground（）和stopForeground（）
 */
public class MyService extends Service {
    private static final String TAG = "SERvice";

    //实现IBinder接口
    class Mybinder extends Binder{
        public MyService getMyBinder(){
            return MyService.this;//返回当前Service类
        }
    }

    //实例化一个MyBinder对象，用于实现客户端（调用者/acyivity）与service通信
    private Mybinder mybinder=new Mybinder();
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }


//执行的具体任务
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) { //flags:1、START_FLAG_REDELIVERY(当该方法返回值为START_REDELIVERY_INTENT时，且在上一次被杀死前调用stopSelf)、2、START_FLAG_RETYR、（当该方法调用后没有返回值时，重新调用该方法）
        //该方法返回值：
//        START_REDELIVERY_INTENT：因内存不足被kill后，重建service
//        START_STICKY：因内存不足被kill后，当系统空闲时重建此service
//        START_NO_STICKY：因内存不足被kill后，即便系统空闲也不重建
        Log.d(TAG, "onStartCommand: ");
        new Thread(new Runnable() {
            @Override
            public void run() {
                int b = intent.getIntExtra("key",0);
                for (int i = 0; i < 500; i++) {
                    b+=i;
                }
                Log.d(TAG, "run: "+b);
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        new Thread(new Runnable() {
            int a = intent.getIntExtra("num",0);
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    a=a+i;
                }
                Log.d(TAG, "run: "+a);
            }
        }).start();
        return mybinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }
}
