package com.example.android.androidadvanceddemo.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.androidadvanceddemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends BaseLazyFragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("hl----" + this + "onCreateView");
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("hl----" + this + "onResume");
    }

    @Override
    protected void lazyLoad() {
        Toast.makeText(getContext(), "lazyLoad", Toast.LENGTH_SHORT).show();
    }
}
