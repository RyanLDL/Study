package com.example.jetpack.MyLifecycle;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyChronometer extends Chronometer implements LifecycleObserver {
    long elapseTime;
    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)//使用注解完成对生命周期的绑定
    private void startMeter(){
        setBase(SystemClock.elapsedRealtime()-elapseTime);
        start();
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void stopMeter(){
        elapseTime = SystemClock.elapsedRealtime()-getBase();
        stop();
    }
}
