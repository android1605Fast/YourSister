package com.qf.administrator.yoursister;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qf.administrator.yoursister.fragment.DaogouFragment;
import com.qf.administrator.yoursister.fragment.GarageFragment;
import com.qf.administrator.yoursister.fragment.HudongFragment;
import com.qf.administrator.yoursister.fragment.OwnFragment;
import com.qf.administrator.yoursister.fragment.PagerFragment;
import com.qf.administrator.yoursister.utils.CommonUse;

import java.util.ArrayList;
import java.util.List;

import Adapter.AdapterDown;
import Adapter.ViewPagerAdapter;
import cn.bmob.v3.Bmob;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private TabLayout tabLayout;
    private ViewPager viewPagerUp;
    private List<PagerFragment> fragments_up;
    private RadioButton centerBTN;
    private RadioGroup radioGroup;
    private PopupWindow popupWindow;
    private ViewPager viewPagerDown;
    private List<Fragment> fragments_down;
    private SwipeRefreshLayout refreshLayout;
    private RadioButton daogouBTN;
    private RadioButton hudongBTN;
    private RadioButton garageBTN;
    private RadioButton ownBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        addAdapterForTab();
        initPopWindow();
        clickRadioGroup();
        viewpager2ChangeListener();
        //初始化Bmob
        Bmob.initialize(this, "8023c69a2752f39ecdf1a21c73bc4087");
    }

    /**
     * viewpager2的页面改变监听
     * //当页面被选择的时候，下方radiobutton图标改变
     */
    private void viewpager2ChangeListener(){
        viewPagerDown.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
            }

            //改变radiobutton的checked属性
            @Override
            public void onPageSelected(int position){
                if(position == 0){
                    CommonUse.changeBtnLogo(daogouBTN, hudongBTN, garageBTN, ownBTN);
                }
                if(position == 1){
                    CommonUse.changeBtnLogo(hudongBTN, daogouBTN, garageBTN, ownBTN);
                }
                if(position == 2){
                    CommonUse.changeBtnLogo(garageBTN, daogouBTN, hudongBTN, ownBTN);
                }
                if(position == 3){
                    CommonUse.changeBtnLogo(ownBTN, daogouBTN, hudongBTN, garageBTN);
                }
            }

            //防止viewpager和refresh冲突
            @Override
            public void onPageScrollStateChanged(int state){
                CommonUse.patchChongtu(viewPagerDown, refreshLayout);
            }
        });
    }

    /**
     * tablayout的适配器设置
     * 并且当tablayout的title被点击的时候设置两个viewpager的显示与隐藏
     */
    private void addAdapterForTab(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments_up);
        viewPagerUp.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPagerUp);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                CommonUse.hideViewpager(viewPagerUp, viewPagerDown, refreshLayout);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab){
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab){
                CommonUse.hideViewpager(viewPagerUp, viewPagerDown);
                CommonUse.patchChongtu(viewPagerUp, refreshLayout);
            }
        });
    }

    /**
     * 首页最下方四个radiobutton的监听事件
     */
    public void radioButton(View view){
        CommonUse.hideViewpager(viewPagerDown, viewPagerUp, refreshLayout);
        AdapterDown adapter_down = new AdapterDown(getSupportFragmentManager(), fragments_down);
        viewPagerDown.setAdapter(adapter_down);
        switch(view.getId()){
            case R.id.daogou:
                viewPagerDown.setCurrentItem(0);
                break;
            case R.id.hudong:
                viewPagerDown.setCurrentItem(1);
                break;
            case R.id.garage:
                viewPagerDown.setCurrentItem(2);
                break;
            case R.id.own:
                viewPagerDown.setCurrentItem(3);
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
    //初始化视图
    private void initView(){
        daogouBTN = (RadioButton) findViewById(R.id.daogou);
        hudongBTN = (RadioButton) findViewById(R.id.hudong);
        garageBTN = (RadioButton) findViewById(R.id.garage);
        ownBTN = (RadioButton) findViewById(R.id.own);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        viewPagerDown = (ViewPager) findViewById(R.id.viewPager_down);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPagerUp = (ViewPager) findViewById(R.id.viewPager_up);
        centerBTN = (RadioButton) findViewById(R.id.center);
    }
    //初始化数据
    private void initData(){
        //tablout子选项的viewpager
        fragments_up = new ArrayList<>();
        for(int i = 0; i <8 ; i++){
            fragments_up.add(new PagerFragment());
        }
        //下方radiogroup的viewpager
        fragments_down = new ArrayList<>();
        fragments_down.add(new DaogouFragment());
        fragments_down.add(new HudongFragment());
        fragments_down.add(new GarageFragment());
        fragments_down.add(new OwnFragment(this));
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
        CommonUse.setOnclickListenerCustom(this,postImage,shaiImage,askImage,findImage);
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
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivity(intent);
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
     * popwindow里面最下面那个箭头的点击事件点击了就关掉popwindow
     *
     * @param view
     */
    public void popwindowLastIamge(View view){
        popupWindow.dismiss();
    }
}
