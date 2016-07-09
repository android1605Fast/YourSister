package com.qf.administrator.yoursister.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qf.administrator.yoursister.LoginActivity;
import com.qf.administrator.yoursister.R;
import com.qf.administrator.yoursister.javabean.MyApp;

import Adapter.OwnListViewAdapter;

/**
 * Created by Administrator on 2016/7/7.
 */
public class OwnFragment extends BaseFragment{
    public final int STARTACTIVITYCODE = 1;
    private ListView ownlistView;
    private TextView register_login;
    private RelativeLayout cancleClick;
    private ImageView headerImage;
    private Context context;
    private RelativeLayout relativeLayout;

    public OwnFragment(){
    }

    public OwnFragment(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_own, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        initView(view);
        addHeadView();
        ownlistView.setAdapter(new OwnListViewAdapter(context));
        //点击跳转到登录界面,返回登录成功的数据
        relativeLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context, LoginActivity.class);
                startActivityForResult(intent, STARTACTIVITYCODE);
            }
        });

    }
    //添加头布局
    private void addHeadView(){
        LayoutInflater layoutInflater = getLayoutInflater(null);
        View view = layoutInflater.inflate(R.layout.head_layout, null);
        ownlistView.addHeaderView(view);
    }

    private void initView(View view){
        relativeLayout = (RelativeLayout) view.findViewById(R.id.cancelClick);
        ownlistView = (ListView) view.findViewById(R.id.ownListView);
        headerImage = (ImageView) view.findViewById(R.id.userHeadInfo);
        cancleClick = (RelativeLayout) view.findViewById(R.id.cancelClick);
        register_login = (TextView) view.findViewById(R.id.regist_login);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        //如果登录界面返回的数据,并设置在相应界面上
        if(resultCode == 2){
            String userName = data.getStringExtra("userName");
            register_login.setText(userName);
            headerImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
            headerImage.setImageResource(R.mipmap.headinfo);
            cancleClick.setClickable(false);
        }
    }
}
