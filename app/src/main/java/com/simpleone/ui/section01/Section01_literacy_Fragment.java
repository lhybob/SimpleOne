package com.simpleone.ui.section01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.simpleone.R;

public class Section01_literacy_Fragment extends Fragment {

    private Section01_literacy_ViewModel viewModel; // 声明 ViewModel

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(Section01_literacy_ViewModel.class); // 初始化 ViewModel
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_section01_literacy, container, false);

        // 其他视图初始化和逻辑处理...

        return view;
    }
}
