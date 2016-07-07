package com.qf.administrator.yoursister;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qf.administrator.yoursister.fragment.PagerFragment;

import java.util.ArrayList;
import java.util.List;

import Adapter.ViewPagerAdapter;
import cn.bmob.v3.Bmob;

public class MainActivity extends BaseActivity implements View.OnClickListener{

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
        //初始化Bmob
        Bmob.initialize(this, "8023c69a2752f39ecdf1a21c73bc4087");
    }

    /**
     * 首页最下方四个radiobutton的监听事件
     */
    public void radioButton(View view){
        switch(view.getId()){
            case R.id.daogou:
                Toast.makeText(this, "daoggou", Toast.LENGTH_SHORT).show();
                break;
            case R.id.hudong:
                Toast.makeText(this, "hudong", Toast.LENGTH_SHORT).show();
                break;
            case R.id.garage:
                Toast.makeText(this, "garage", Toast.LENGTH_SHORT).show();
                break;
            case R.id.own:
                startActivity(new Intent(this,OwnActivity.class));
                break;
        }
    }

    /**
     * 首页最下方RadioButton中间的红十字的监听器
     */
    public void clickRadioGroup(){
        centerBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                popupWindow.setAnimationStyle(R.style.anim_popup_dir);
                //                popupWindow.showAsDropDown(radioGroup,0,-radioGroup.getLayoutParams().height);
                popupWindow.showAtLocation(radioGroup, Gravity.BOTTOM, 0, radioGroup.getLayoutParams().height);
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
     *
     * @param view
     */
    public void searchButton(View view){
        startActivity(new Intent(this, SearchActivity.class));
    }

    /**
     * 这里写popwinow控件的相关设置方法
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
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
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

    /**
     * popwindow里面最下面那个箭头的点击事件
     * 点击了就关掉popwindow
     *
     * @param view
     */
    public void popwindowLastIamge(View view){
        popupWindow.dismiss();
    }
}
