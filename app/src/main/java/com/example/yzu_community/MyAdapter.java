package com.example.yzu_community;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments;           //fragment集合
    private List<String> titles;                //tab标题集合
    public MyAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override

    public Fragment getItem(int position) {
        return fragments.get(position);
    }
    @Override

    public int getCount() {
        int ret = 0;
        if (fragments!=null && fragments.size()!=0){
            ret = fragments.size();
        }
        return ret;

    }
    @Override

    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

}

