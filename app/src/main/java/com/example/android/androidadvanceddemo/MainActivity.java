package com.example.android.androidadvanceddemo;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.android.androidadvanceddemo.databinding.ActivityMainBinding;
import com.example.android.androidadvanceddemo.drawerlayout.DrawerLayoutActivity;
import com.example.android.androidadvanceddemo.fragment.FragmentActivity;
import com.example.android.androidadvanceddemo.recyclerview.BaseActivity;
import com.example.android.androidadvanceddemo.recyclerview.RecyclerViewActivity;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.button.setOnClickListener(view -> startActivity(new Intent(this, RecyclerViewActivity.class)));
        binding.button2.setOnClickListener(view-> startActivity(new Intent(this, DrawerLayoutActivity.class)));
        binding.fragment.setOnClickListener(view-> startActivity(new Intent(this, FragmentActivity.class)));
        setTitle("MainActivity");
    }
}
