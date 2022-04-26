package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

//接收者
public class MyBroadCast extends BroadcastReceiver {
    private static final String TAG = "TAG";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: 接收到了广播");
        String action = intent.getAction();
        Log.d(TAG, "onReceive: 接收到的广播的action"+action);
        String data;
        if (action.equals(BroadCastTag.First)){
           data = intent.getStringExtra("key");
        }else {
            data = intent.getStringExtra("key1");
        }

        Log.d(TAG, "onReceive: 接收到的广播信息是"+data);
    }
}
