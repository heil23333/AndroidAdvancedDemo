package com.example.android.androidadvanceddemo.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.android.androidadvanceddemo.R;
import com.example.android.androidadvanceddemo.databinding.ActivityFragmentBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class FragmentActivity extends androidx.fragment.app.FragmentActivity {

    ActivityFragmentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fragment);
        binding.viewpager.setAdapter(new FragmentAdapter(this));
        binding.viewpager.setOffscreenPageLimit(1);
        TabLayoutMediator mediator = new TabLayoutMediator(binding.tabLayout, binding.viewpager, (tab, position) -> {
            tab.setText("第" + position + "个页面");
        });
        mediator.attach();
    }
}
