package com.simpleone;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.simpleone.databinding.ActivityMainBinding;

/**
 * MainActivity 类：
 * - 这是应用程序的主 Activity，负责管理应用的导航和 UI 布局。
 * - 使用 ViewBinding 来访问布局中的视图，避免使用 findViewById。
 * - 使用 Navigation Component 实现导航功能。
 */
public class MainActivity extends AppCompatActivity {

    // ActivityMainBinding 是 ViewBinding 生成的类，用于访问布局中的视图。
    // - 通过 ViewBinding 可以避免使用 findViewById，提高代码的可读性和安全性。
    private ActivityMainBinding binding;

    /**
     * onCreate 方法：
     * - 这是 Activity 的生命周期方法，在 Activity 创建时调用。
     * - 在该方法中，初始化 ViewBinding 和 Navigation Component。
     *
     * @param savedInstanceState Bundle 对象，用于保存 Activity 的状态。
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 初始化 ViewBinding
        // - 使用 ActivityMainBinding.inflate 方法将布局文件解析为视图。
        // - getLayoutInflater() 获取 LayoutInflater 对象。
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // 设置 Activity 的内容视图
        // - binding.getRoot() 返回布局的根视图。
        setContentView(binding.getRoot());

        // 初始化 Navigation Component
        // - 获取 NavController 对象，用于管理 Fragment 导航。
        // - R.id.nav_host_fragment_activity_main 是导航宿主 Fragment 的 ID。
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        // 将底部导航栏与 NavController 绑定
        // - binding.navView 是底部导航栏视图。
        // - NavigationUI.setupWithNavController 将导航栏与 NavController 关联，实现导航功能。
        NavigationUI.setupWithNavController(binding.navView, navController);




    }

    public void setSupportActionBar(Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
    }

}
