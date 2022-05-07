package com.example.jetpack.MyLifecycle;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;

public class ProcessLifecycleOwnerApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle()
                .addObserver(new ApplicationOberserver());
    }
}
