package com.example.shinelon.yoursister.yoursister;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.qf.administrator.yoursister.R;
import com.qf.administrator.yoursister.SearchActivity;
import com.qf.administrator.yoursister.fragment.PagerFragment;

import java.util.ArrayList;
import java.util.List;

import Adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<PagerFragment> fragments;
    private RadioButton daogouBTN;
    private RadioButton garageBTN;
    private RadioButton hudongBTN;
    private RadioButton ownBTN;
    private RadioButton centerBTN;
    private RadioGroup radioGroup;
    private PopupWindow popupWindow;
    private RelativeLayout relativelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        initPopWindow();
        clickRadioGroup();
    }

    /**
     * 点击RadioGroup里面内容的监听器
     */
    public void clickRadioGroup(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId){
                    case R.id.center:
                        popupWindow.showAtLocation(relativelayout, Gravity.BOTTOM, 200, 160);
                        break;
                }
            }
        });
    }

    private void initView(){
        relativelayout = (RelativeLayout) findViewById(R.id.mainRelative);
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
     *
     * @param view
     */
    public void searchButton(View view){
        startActivity(new Intent(this, SearchActivity.class));
    }

    /**
     * 这里写popwinow的相关控件设置方法
     */
    private void initPopWindow(){
        View layout = getLayoutInflater().inflate(R.layout.popwindow_layout, null);
        ImageView postImage = (ImageView) layout.findViewById(R.id.postmsg);
        ImageView shaiImage = (ImageView) layout.findViewById(R.id.shaiimage);
        ImageView askImage = (ImageView) layout.findViewById(R.id.askques);
        ImageView findImage = (ImageView) layout.findViewById(R.id.findcar);
        postImage.setOnClickListener(this);
        shaiImage.setOnClickListener(this);
        askImage.setOnClickListener(this);
        findImage.setOnClickListener(this);
        popupWindow = new PopupWindow(layout, LinearLayout.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);
        //要想在点击popwindow之外的时候能关闭pop,必须设置下面三个参数
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x000000));
        popupWindow.setFocusable(true);
    }

    /**
     * popwindow里面的事件响应
     *
     * @param v
     */
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.postmsg:
                Toast.makeText(this, "发帖", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shaiimage:
                Toast.makeText(this, "晒图", Toast.LENGTH_SHORT).show();
                break;
            case R.id.askques:
                Toast.makeText(this, "求问", Toast.LENGTH_SHORT).show();
                break;
            case R.id.findcar:
                Toast.makeText(this, "找车", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
