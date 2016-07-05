package com.qf.administrator.yoursister;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qf.administrator.yoursister.fragment.PagerFragment;

import java.util.ArrayList;
import java.util.List;

import Adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<PagerFragment> fragments;
    private RadioButton daogouBTN;
    private RadioButton garageBTN;
    private RadioButton hudongBTN;
    private RadioButton ownBTN;
    private RadioButton centerBTN;
    private RadioGroup radioGroup;

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

    /**
     * 点击RadioGroup里面内容的监听器
     */
    public void clickRadioGroup(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId){
                    case R.id.daogou:

                        break;
                }
            }
        });

    }

    private void initView(){
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        daogouBTN = (RadioButton) findViewById(R.id.daogou);
        garageBTN = (RadioButton) findViewById(R.id.garage);
        hudongBTN = (RadioButton) findViewById(R.id.hudong);
        ownBTN = (RadioButton) findViewById(R.id.own);
        centerBTN = (RadioButton) findViewById(R.id.center);
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

    /**
     * 跳转到搜索activity
     * @param view
     */
    public void searchButton(View view){
        startActivity(new Intent(this,SearchActivity.class));
    }
}
