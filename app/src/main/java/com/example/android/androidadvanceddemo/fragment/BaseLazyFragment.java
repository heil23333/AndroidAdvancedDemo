package com.example.android.androidadvanceddemo.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseLazyFragment extends Fragment {
    private boolean isVisibleToUser = false;
    private boolean isViewCreate = false;
    private boolean isFirstLoad = true;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        onLazyLoad();
    }

    private void onLazyLoad() {
        if (isVisibleToUser && isViewCreate && isFirstLoad) {
            isFirstLoad = false;
            lazyLoad();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreate = true;
        onLazyLoad();
    }

    protected abstract void lazyLoad();
}
