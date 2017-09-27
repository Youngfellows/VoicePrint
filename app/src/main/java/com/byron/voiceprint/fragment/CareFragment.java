package com.byron.voiceprint.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byron.voiceprint.R;
import com.byron.voiceprint.base.BaseFragment;

public class CareFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_care, container, false);
    }

    @Override
    protected void loadData() {
        Log.i(TAG, "loadData: 在这里加载关注页数据");
    }
}
