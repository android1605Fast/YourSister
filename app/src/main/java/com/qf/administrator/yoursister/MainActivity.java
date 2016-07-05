package com.qf.administrator.yoursister;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fragment.MyFragment;

public class MainActivity extends AppCompatActivity{

    private List<String> titleList;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<MyFragment> myFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),titleList,myFragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initView(){
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void initData(){
        titleList = new ArrayList<>();
        titleList.add("推荐");
        titleList.add("视频");
        titleList.add("图片");
        titleList.add("段子");
        titleList.add("网红");
        titleList.add("排行");
        titleList.add("社会");
        titleList.add("美女");
        titleList.add("冷知识");
        titleList.add("游戏");
        myFragments = new ArrayList<>();
        myFragments.add(new MyFragment());
        myFragments.add(new MyFragment());
        myFragments.add(new MyFragment());
        myFragments.add(new MyFragment());
        myFragments.add(new MyFragment());
        myFragments.add(new MyFragment());
        myFragments.add(new MyFragment());
        myFragments.add(new MyFragment());
        myFragments.add(new MyFragment());
        myFragments.add(new MyFragment());
    }
}
