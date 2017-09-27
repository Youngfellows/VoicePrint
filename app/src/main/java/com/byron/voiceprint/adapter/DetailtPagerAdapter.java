package com.byron.voiceprint.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/**
 * Created by Jie.Chen on 2017/9/27.
 */

public class DetailtPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles;
    private List<Fragment> mFragments;

    public DetailtPagerAdapter(FragmentManager fm,List<Fragment> fragments,String [] titles) {
        super(fm);
        this.mFragments = fragments;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    /**
     * ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
     *
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
