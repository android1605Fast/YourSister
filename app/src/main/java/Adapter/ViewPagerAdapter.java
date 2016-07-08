package Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.qf.administrator.yoursister.fragment.PagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/5.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter{
    private List<String> titleList;
    private List<PagerFragment> fragments;

    public ViewPagerAdapter(FragmentManager fm, List<PagerFragment> fragments){
        super(fm);
        this.fragments = fragments;
        //因为标题栏是固定的，所以直接在这里设置,不用从网上获取
        titleList = new ArrayList<>();
        titleList.add("首页");
        titleList.add("车评");
        titleList.add("视频");
        titleList.add("长测");
        titleList.add("策划");
        titleList.add("观点");
        titleList.add("图片");
        titleList.add("资讯");
        titleList.add("经典");
    }

    @Override
    public Fragment getItem(int position){
        return fragments.get(position);
    }

    @Override
    public int getCount(){
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return titleList.get(position);
    }
}
