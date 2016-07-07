package com.qf.administrator.yoursister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import Adapter.OwnListViewAdapter;

public class OwnActivity extends AppCompatActivity{
    public final int STARTACTIVITYCODE = 1;
    private ListView ownlistView;
    private TextView register_login;
    private RelativeLayout cancleClick;
    private ImageView headerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own);
        initView();
        ownlistView = (ListView) findViewById(R.id.ownListView);
        OwnListViewAdapter adapter = new OwnListViewAdapter(this);
        //给onlistview设置头布局
        addHeadView(adapter);
    }

    private void initView(){
        headerImage = (ImageView) findViewById(R.id.userHeadInfo);
        cancleClick = (RelativeLayout) findViewById(R.id.cancelClick);
        register_login = (TextView) findViewById(R.id.regist_login);
    }

    private void addHeadView(OwnListViewAdapter adapter){
        View headview = getLayoutInflater().inflate(R.layout.head_layout, null);
        ownlistView.addHeaderView(headview);
        ownlistView.setAdapter(adapter);
    }

    //点击跳转到登录界面,返回登录成功的数据
    public void loginlistener(View view){
        startActivityForResult(new Intent(this, LoginActivity.class), STARTACTIVITYCODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
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
