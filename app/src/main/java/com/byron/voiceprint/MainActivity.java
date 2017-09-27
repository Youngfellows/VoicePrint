package com.byron.voiceprint;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.byron.voiceprint.adapter.DetailtPagerAdapter;
import com.byron.voiceprint.fragment.CareFragment;
import com.byron.voiceprint.fragment.HomeFragment;
import com.byron.voiceprint.fragment.MyFragment;
import com.byron.voiceprint.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initListener();
    }

    private void initData() {

    }

    private void initView() {
        getSupportActionBar().hide();//隐藏ActionBar
        mTabLayout = findView(R.id.tablayout_top); //顶部导航
        mViewPager = findView(R.id.viewpager_detail); //详情viewPager

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new VideoFragment());
        fragments.add(new CareFragment());
        fragments.add(new MyFragment());
        String[] titles = getResources().getStringArray(R.array.tab_titles);

        //使用适配器将ViewPager与Fragment绑定在一起
        DetailtPagerAdapter pagerAdapter = new DetailtPagerAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(pagerAdapter);
        //mViewPager.setOnPageChangeListener(onPageChangeListener);//ViewPager事件

        //将TabLayout与ViewPager绑定在一起
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(onTabSelectedListener);//TabLayout的事件

        //设置tab选中未选中背景
        Drawable drawable = null;
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            switch (i) {
                case 0:
                    drawable = getResources().getDrawable(R.drawable.selector_tab_home);
                    break;
                case 1:
                    drawable = getResources().getDrawable(R.drawable.selector_tab_video);
                    break;
                case 2:
                    drawable = getResources().getDrawable(R.drawable.selector_tab_care);
                    break;
                case 3:
                    drawable = getResources().getDrawable(R.drawable.selector_tab_my);
                    break;

            }
            tab.setIcon(drawable);//设置tab选中未选中背景
        }
    }

    private void initListener() {

    }

    /**
     * 找控件
     *
     * @param id
     * @param <T>
     * @return
     */
    private <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    /**
     * ViewPager事件
     */
    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    /**
     * TabLayout的事件
     */
    private TabLayout.OnTabSelectedListener onTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            //选中了tab的逻辑
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            //未选中tab的逻辑
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
            //再次选中tab的逻辑
        }
    };
}
