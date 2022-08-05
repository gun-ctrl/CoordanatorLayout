package com.example.coordanatorlayout.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.coordanatorlayout.R;
import com.example.coordanatorlayout.databinding.FragmentBlankBinding;


public class BlankFragment extends Fragment {
    FragmentBlankBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentBlankBinding.inflate(inflater);
        return binding.getRoot();
    }
}