package com.simpleone.ui.section01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.simpleone.R;
import com.simpleone.databinding.FragmentSection01Binding;

public class Section01Fragment extends Fragment {

    private FragmentSection01Binding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSection01Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // 使用 ViewBinding 直接访问按钮
        binding.button02Section01.setOnClickListener(v -> {
            // 导航到 Literacy
            NavController navController = Navigation.findNavController(root);
            navController.navigate(R.id.action_section01_to_section01_literacy);
        });

        binding.button03Section01.setOnClickListener(v -> {
            // 导航到 Dictation Selection
            NavController navController = Navigation.findNavController(root);
            navController.navigate(R.id.action_section01_to_section01_dictation);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // 释放 ViewBinding 的引用
    }
}
