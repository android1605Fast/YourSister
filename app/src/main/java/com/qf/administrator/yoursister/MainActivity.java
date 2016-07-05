package com.qf.administrator.yoursister;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.qf.administrator.yoursister.fragment.PagerFragment;

import java.util.ArrayList;
import java.util.List;

import Adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<PagerFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initView(){
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void initData(){
        fragments = new ArrayList<>();
        fragments.add(new PagerFragment());
        fragments.add(new PagerFragment());
        fragments.add(new PagerFragment());
        fragments.add(new PagerFragment());
        fragments.add(new PagerFragment());
        fragments.add(new PagerFragment());
        fragments.add(new PagerFragment());
        fragments.add(new PagerFragment());
        fragments.add(new PagerFragment());
    }

    public void searchButton(View view){

    }
}
