package com.example.android.androidadvanceddemo.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android.androidadvanceddemo.R;
import com.example.android.androidadvanceddemo.databinding.ActivityRecyclerViewBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends BaseActivity {

    ActivityRecyclerViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        init();
    }

    private void init() {
        setTitle("RecyclerView");
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("测试数据");
        }
        SimpleAdapter adapter = new SimpleAdapter(datas);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        binding.recyclerView.addItemDecoration(new SimpleItemDecoration(this, RecyclerView.VERTICAL));
    }
}
