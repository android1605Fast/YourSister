package com.qf.administrator.yoursister.utils;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;

/**
 * Created by Administrator on 2016/7/8.
 */
public class CommonUse{
    /**
     * /当viewpager滑动的时候，refresh取消加载事件,防止冲突
     *
     * @param vp 正在滑动的viewpager
     * @param rl 取消事件的swipe
     */
    public static void patchChongtu(ViewPager vp, final SwipeRefreshLayout rl){
        vp.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                switch(event.getAction()){
                    case MotionEvent.ACTION_MOVE:
                        rl.setEnabled(false);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        rl.setEnabled(true);
                }
                return false;
            }
        });
    }

    /**
     * 隐藏viewpager并显示另外一个viewpager
     *
     * @param vViewpager 要显示的viewpager
     * @param iViewpager 要隐藏的viewpager
     * @param sfl        取消swipe的加载
     */
    public static void hideViewpager(ViewPager vViewpager, ViewPager iViewpager, SwipeRefreshLayout sfl){
        vViewpager.setVisibility(View.VISIBLE);
        iViewpager.setVisibility(View.INVISIBLE);
        sfl.setRefreshing(false);
    }

    public static void hideViewpager(ViewPager vViewpager, ViewPager iViewpager){
        vViewpager.setVisibility(View.VISIBLE);
        iViewpager.setVisibility(View.INVISIBLE);
    }

    /**
     * 被选择的button改变LOGO颜色，没被现实的保持灰色
     *
     * @param trueBtn   被改变的button
     * @param falseBTN  没被改变的button
     * @param false2BTN 没被改变的button
     * @param false3BTN 没被改变的button
     */
    public static void changeBtnLogo(RadioButton trueBtn, RadioButton falseBTN, RadioButton false2BTN, RadioButton false3BTN){
        trueBtn.setChecked(true);
        falseBTN.setChecked(false);
        false2BTN.setChecked(false);
        false3BTN.setChecked(false);
    }

    /**
     * 给view设置监听器
     *
     * @param activity
     * @param view     需要设置监听器的view
     * @param view1    需要设置监听器的view
     * @param view2    需要设置监听器的view
     * @param view3    需要设置监听器的view
     */
    public static void setOnclickListenerCustom(Activity activity, View view, View view1, View view2, View view3){
        view.setOnClickListener((View.OnClickListener) activity);
        view1.setOnClickListener((View.OnClickListener) activity);
        view2.setOnClickListener((View.OnClickListener) activity);
        view3.setOnClickListener((View.OnClickListener) activity);
    }
}
