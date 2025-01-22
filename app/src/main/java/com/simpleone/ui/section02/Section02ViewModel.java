package com.simpleone.ui.section02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Section02ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Section02ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("数学内容");
    }

    public LiveData<String> getText() {
        return mText;
    }
}