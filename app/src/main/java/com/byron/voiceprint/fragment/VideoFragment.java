package com.byron.voiceprint.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.byron.voiceprint.R;
import com.byron.voiceprint.base.BaseFragment;

public class VideoFragment extends BaseFragment implements View.OnClickListener {
    private String TAG = getClass().getSimpleName();

    private View mRootView;
    private Button mBtn_recording;//开始录音
    private TextView mTv_login_result;//验证结果

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Log.i(TAG, "------HomeFragment -------onCreateView()");
        mRootView = inflater.inflate(R.layout.fragment_video, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "------HomeFragment -------onViewCreated()");
        initData();
        initView();
        initListener();
    }

    /**
     * 加载数据
     */
    @Override
    protected void loadData() {
        Log.i(TAG, "loadData: 在这里加载视频页数据");
    }

    private void initData() {

    }

    private void initView() {
        mBtn_recording = findView(mRootView, R.id.btn_recording);
        mTv_login_result = findView(mRootView, R.id.tv_login_result);
    }

    private void initListener() {
        mBtn_recording.setOnClickListener(this);
    }

    private <T extends View> T findView(View view, int id) {
        return view.findViewById(id);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recording:
                Toast.makeText(mContext, "哥哥，晚上约不约", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
