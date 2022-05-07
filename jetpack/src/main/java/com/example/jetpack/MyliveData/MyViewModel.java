package com.example.jetpack.MyliveData;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> currentSecond;//LiveData的子类

    public MutableLiveData<Integer> getCurrentSecond() {
        if (currentSecond == null) {
            currentSecond = new MutableLiveData<>();
            currentSecond.setValue(0);
        }
        return currentSecond;
    }
}
