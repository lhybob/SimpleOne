package com.simpleone.ui.section01;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Section01_dictation_ViewModel extends ViewModel {
    // 定义 LiveData 及其他数据源
    private final MutableLiveData<String> mText;

    public Section01_dictation_ViewModel() {
        Section01_PinyinUtils section01_PinyinUtils = new Section01_PinyinUtils();
        String pinyin = section01_PinyinUtils.convertToPinyin("唱歌");
        mText = new MutableLiveData<>();
        mText.setValue(pinyin);
    }

    public LiveData<String> getText() {
        return mText;
    }
    // 处理数据的方法
}
