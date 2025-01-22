package com.simpleone.ui.section01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.simpleone.R; // 确保使用的是应用包名的 R 类



public class Section01_dictation_selection_Fragment extends Fragment {

    private Section01_dictation_selection_ViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 加载布局文件
        View view = inflater.inflate(R.layout.fragment_section01_dictation_selection, container, false);

        // 获取 ViewModel
        viewModel = new ViewModelProvider(this).get(Section01_dictation_selection_ViewModel.class);



        return view;
    }
}
