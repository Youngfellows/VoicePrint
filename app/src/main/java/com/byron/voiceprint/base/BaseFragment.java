package com.byron.voiceprint.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Jie.Chen on 2017/9/27.
 */

public abstract class BaseFragment extends Fragment {
    protected String TAG = getClass().getSimpleName();

    private boolean isViewCreated; //Fragment的View加载完毕的标记
    private boolean isUIVisible; //Fragment对用户可见的标记
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        lazyLoad();
    }

    /**
     *
     */
    protected void lazyLoad() {
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
//        if (isUIVisible && isViewCreated) {
        if (isUIVisible) {
            loadData();
            //Log.i(TAG, "lazyLoad: 可见加载数据");
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;
        }
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }

    protected abstract void loadData();//加载数据

}
