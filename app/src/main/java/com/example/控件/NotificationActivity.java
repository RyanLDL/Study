package com.example.控件;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
* Noticefication与NoticeficationManager
*   创建一个NoticeficationManager
*       NotificationManager类是一个通知管理器类，这个对象是由系统维护的服务，是以单例模式的方式获得，所以一般并不直接实例化这个对象
*       在Activity中，可以使用Acticity.getSystemService（String）方法获取NotificationManager对象，Acticity.getSystemService（String）通过Adroid系统级
*       服务的句柄，返回对象。在这块i需要返回NotificationManager，所以直接传递Context.NOTICEFICATION_SERVICE即可
*   使用Builder构造器来创建Notification对象
*       使用NotificationCompat类的Builder构造器来chuangjianNotification对象，可以保证程序在所有版本都正常工作，Android8.0增加了通知渠道，没有设置无法正常显示
*
*
* */
public class NotificationActivity extends AppCompatActivity {
    NotificationManager systemService;
    Notification notification;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        button=findViewById(R.id.btn);
        systemService = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel Channel = new NotificationChannel("LDL", "测试", NotificationManager.IMPORTANCE_HIGH);
                systemService.createNotificationChannel(Channel);
            }
            Intent intent=new Intent(NotificationActivity.this,ceshiActivity.class);
        PendingIntent activity = PendingIntent.getActivity(NotificationActivity.this, 0, intent, 0);//第二、四参数随意
        //channleid:通知渠道，可自定义
        /*：通知重要程度：
        IMPORTANCE_NONE:关闭通知
        IMPORTACE_MIN：开启，不会弹出，没有提示音，状态栏中无显示
        IMPORTANCE_LOW：开启，不弹出，无声音，显示
        IMPORTANCE_DEFAULT：开启，不弹出，有声音，显示
        IMPORTANCE_HIGH：开启，弹出，有声音，显示*/
       notification= new NotificationCompat.Builder(this,"LDL")
                .setContentTitle("通知")
                .setContentText("测试")
                .setSmallIcon(R.drawable.ic_1)//前三个必须要
               .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.img2))
               .setColor(Color.parseColor("#ff0000"))
               .setContentIntent(activity)
               .setAutoCancel(true)
                .build();

        /*
        * setContentTitle(String string):标题
        * setContentText(String string):内容
        * setSmallicon(Int icon):设置小图标
        * setLargrIcon(Bitmap icon):设置大图标
        * setColor(int argb):小图标颜色
        * setContentinten(PendingIntent intent):设置点击后的跳转意图
        * setAutiCancel(boolean boolean):点击后自动清除通知
        * setWhen(long when):被创建的时间
        * */
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1=new Intent(NotificationActivity.this,ToolbarActivity.class);
            startActivity(intent1);

        }
    });

    }

    public void send(View view) {
        systemService.notify(1,notification);//id随意
    }

    public void cacel(View view) {
        systemService.cancel(1);
    }

}