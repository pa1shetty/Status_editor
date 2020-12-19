package com.shetty.statuseditor;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<String> mNumber;

    public MutableLiveData<String> getNumber() {
        if (mNumber == null) {
            mNumber = new MutableLiveData<>();
            mNumber.setValue(String.valueOf(generateRandomNumber()));
        }
        return mNumber;
    }

    public void updateRandomNumber() {
        mNumber.setValue(String.valueOf(generateRandomNumber()));
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100);
    }
}
