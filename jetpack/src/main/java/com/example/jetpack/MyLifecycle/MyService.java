package com.example.jetpack.MyLifecycle;

import android.util.Log;

import androidx.lifecycle.LifecycleService;

public class MyService extends LifecycleService {
    String TAG = "TAG";
    public MyService() {
        Log.d(TAG, "MyService: ");
        MyObserver myObserver = new MyObserver(this);
        getLifecycle().addObserver(myObserver);
    }
}
