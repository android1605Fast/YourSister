package com.qf.administrator.yoursister;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private List<String> titleList;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView(){
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        
    }

    private void initData(){
        titleList = new ArrayList<>();
        titleList.add("首页");
        titleList.add("车评");
        titleList.add("视频");
        titleList.add("长策");
        titleList.add("策划");
        titleList.add("观点");
        titleList.add("图片");
        titleList.add("资讯");
        titleList.add("经典");
    }
}
