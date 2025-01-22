package com.simpleone.ui.section01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.simpleone.R;

public class Section01_dictation_Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // 通过布局填充器将fragment_section01_dictation.xml布局文件加载为视图
        View view = inflater.inflate(R.layout.fragment_section01_dictation, container, false);

        // 获取 ViewModelProvider 实例，并获取 Section02ViewModel 实例，确保在配置更改时数据的持久性。
        Section01_dictation_ViewModel section01_dictation_ViewModel =
                new ViewModelProvider(this).get(Section01_dictation_ViewModel.class);


        // 设置 TextView 的文本内容
        TextView textView = view.findViewById(R.id.text_dictation_section01);
        textView.setText(section01_dictation_ViewModel.getText().getValue());

        // 获取 NavController 实例
        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);

        // 获取 Toolbar 实例
        Toolbar toolbar = view.findViewById(R.id.toolbar_custom);
        // 确保当前活动是一个 AppCompatActivity 并设置 Toolbar
        if (getActivity() instanceof AppCompatActivity) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        //隐藏底部导航模块
        //在调用getActivity()之前，检查其是否为null
        if (getActivity() != null) {
            // 获取底部导航栏实例
            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.nav_view);
            // 检查底部导航栏是否存在，如果存在则将其隐藏
            if (bottomNavigationView != null) {
                bottomNavigationView.setVisibility(View.GONE); // 隐藏底部导航栏
            }
        }


        // 获取返回按钮
        AppCompatImageButton btnBack = view.findViewById(R.id.btn_back); // 直接使用 view.findViewById
        // 设置返回按钮的点击事件
        btnBack.setOnClickListener(v -> {
            navController.navigateUp(); // 返回上一个 Fragment
        });

        // 返回填充后的视图
        return view;
    }

    // 当 Fragment 被销毁时调用：离开当前界面后显示底部导航模块
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 重新显示底部导航栏，当离开这个 Fragment 时
        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.nav_view);
        if (bottomNavigationView != null) {
            bottomNavigationView.setVisibility(View.VISIBLE); // 显示底部导航栏
        }
    }
}
