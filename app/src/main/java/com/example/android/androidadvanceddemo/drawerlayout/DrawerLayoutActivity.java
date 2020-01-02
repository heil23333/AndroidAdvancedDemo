package com.example.android.androidadvanceddemo.drawerlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.androidadvanceddemo.R;
import com.example.android.androidadvanceddemo.databinding.ActivityDrawerLayoutBinding;
import com.example.android.androidadvanceddemo.recyclerview.BaseActivity;

public class DrawerLayoutActivity extends BaseActivity {

    ActivityDrawerLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_drawer_layout);
        setTitle("DrawerLayout");

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.collect) {
            Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        System.out.println("hl----" + item.getTitle());
        return super.onContextItemSelected(item);
    }
}
