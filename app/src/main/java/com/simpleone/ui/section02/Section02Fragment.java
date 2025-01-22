package com.simpleone.ui.section02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.simpleone.R;
import com.simpleone.databinding.FragmentSection02Binding;
//Section02Fragment 继承自 Fragment，表示应用中的一个片段。
public class Section02Fragment extends Fragment {

    // 声明 ViewBinding 实例，用于访问布局中的视图
    private FragmentSection02Binding binding;

    //@Override 是一个注解（annotation），用于告诉编译器该方法是重写（override）了父类中的方法。
    @Override
    //onCreateView 方法：该方法在 Fragment 创建其视图时被调用。
    //@NonNull LayoutInflater inflater：用于膨胀布局文件。
    //ViewGroup container：Fragment 视图的父容器。
    //Bundle savedInstanceState：用于保存 Fragment 的状态。
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // 获取 ViewModelProvider 实例，并获取 Section02ViewModel 实例，确保在配置更改时数据的持久性。
        Section02ViewModel section02ViewModel =
                new ViewModelProvider(this).get(Section02ViewModel.class);

        // 使用 ViewBinding 来膨胀 fragment_section02.xml 布局文件并获取根视图，简化视图的引用。
        binding = FragmentSection02Binding.inflate(inflater, container, false);
        //返回布局的根视图。
        View root = binding.getRoot();

        // 获取 TextView 并设置观察器
        final TextView textView = binding.textSection02;
        // 观察 ViewModel 中的文本数据，并在数据变化时更新 TextView 的显示内容
        //getViewLifecycleOwner() 返回当前 Fragment 的 LifecycleOwner，确保在 Fragment 销毁时停止观察。
        section02ViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // 使用 ViewBinding 直接访问 btn_cs01 按钮
        Button but_cs01 = binding.btnCs01;

        // 设置 btn_cs01 的点击事件监听器
        but_cs01.setOnClickListener(v -> {
            // 当按钮被点击时获取 NavController 实例
            NavController navController = Navigation.findNavController(root);
            // 使用 navController.navigate 方法导航到 Section01_literacy Fragment。
            //R.id.action_section02_to_section01_literacy 是导航图中定义的动作 ID。
            navController.navigate(R.id.action_section02_to_section01_literacy);
        });

        // 返回根视图
        return root;
    }

    @Override
    //该方法在 Fragment 视图被销毁时被调用。
    public void onDestroyView() {
        super.onDestroyView();
        // 释放 ViewBinding 的引用，避免内存泄漏
        binding = null;
    }
}
