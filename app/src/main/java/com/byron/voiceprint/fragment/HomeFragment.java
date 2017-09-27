package com.byron.voiceprint.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.byron.voiceprint.R;
import com.byron.voiceprint.base.BaseFragment;

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private View mRootView;
    private EditText mEdt_user_name;
    private TextView mTv_prompt_result;
    private Button mBtn_recordiong;
    private String TAG = getClass().getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Log.i(TAG, "------HomeFragment -------onCreateView()");
        mRootView = inflater.inflate(R.layout.fragment_home, container, false);
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
        Log.i(TAG, "loadData: 在这里加载首页数据");
    }

    private void initView() {
        mEdt_user_name = findView(mRootView, R.id.edt_user_name);//用户名
        mTv_prompt_result = findView(mRootView, R.id.tv_prompt_result);//注册结果
        mBtn_recordiong = findView(mRootView, R.id.btn_recording);//开始录音

    }

    private void initData() {

    }

    private void initListener() {
        mBtn_recordiong.setOnClickListener(this);
    }

    private <T extends View> T findView(View view, int id) {
        return view.findViewById(id);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recording:
                Toast.makeText(mContext, "点你妹呀", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
