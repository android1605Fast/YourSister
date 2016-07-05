package com.qf.administrator.yoursister;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import fragment.MyFragment;

/**
 * Created by Administrator on 2016/7/5.
 */
public class PagerAdapter extends FragmentPagerAdapter{
    private List<String> titleList;
    private List<MyFragment> fragmentList;
    public PagerAdapter(FragmentManager fm, List<String> titleList, List<MyFragment> fragmentList){
        super(fm);
        this.titleList = titleList;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position){
        return fragmentList.get(position);
    }

    @Override
    public int getCount(){
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return titleList.get(position);
    }
}
