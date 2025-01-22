package com.simpleone.ui.section03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.simpleone.databinding.FragmentSection03Binding;

public class Section03Fragment extends Fragment {

    private FragmentSection03Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Section03ViewModel section03ViewModel =
                new ViewModelProvider(this).get(Section03ViewModel.class);

        binding = FragmentSection03Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSection03;
        section03ViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}