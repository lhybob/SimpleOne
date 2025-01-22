package com.simpleone.ui.section03;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Section03ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Section03ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("个人中心内容");
    }

    public LiveData<String> getText() {
        return mText;
    }
}