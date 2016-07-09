package com.qf.administrator.yoursister;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapter.SearchRecyclerView;

/**
 * 这里是首页tablayout右边搜索按钮进来之后出现的界面
 */
public class SearchActivity extends AppCompatActivity{
    private EditText search_edittext;
    private Button search_button;
    private RecyclerView search_recyclerView;
    private ListView search_listView;
    private List<String> titleList;
    private ArrayAdapter arr_adapter;
    private ImageView history_clean_img;
    private ImageView search_back_img;
    private Button search_recyclerview_button;
    //记录RecyclerView是否显示
    private boolean flag = false;
    private SearchRecyclerView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search_edittext = (EditText) findViewById(R.id.search_edittext);
        search_button = (Button) findViewById(R.id.search_button);
        search_recyclerView = (RecyclerView) findViewById(R.id.search_recyclerview);
        search_listView = (ListView) findViewById(R.id.search_listview);
        history_clean_img = (ImageView) findViewById(R.id.search_history_clean_img);
        search_back_img = (ImageView) findViewById(R.id.search_back_img);
        search_recyclerview_button = (Button) findViewById(R.id.search_recyclerview_button);
        init();
        initRecyclerView();
    }

    private void initRecyclerView(){
        //设置监听
        search_recyclerview_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(flag){
                    search_recyclerView.setVisibility(View.GONE);
                }else{
                    search_recyclerView.setVisibility(View.VISIBLE);
                }
                flag = !flag;
            }
        });
        //给RecyclerViews设置数据
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        search_recyclerView.setLayoutManager(staggeredGridLayoutManager);
        adapter = new SearchRecyclerView(this, titleList, search_recyclerview_button.getText().toString());
        search_recyclerView.setAdapter(adapter);
        //获取recyclerview点击的text
        adapter.setOnClickRecyclerViewListener(new SearchRecyclerView.OnClickRecyclerViewListener(){
            @Override
            public void onClick(String text){
                search_recyclerview_button.setText(text);
                if(flag){
                    search_recyclerView.setVisibility(View.GONE);
                    flag = false;
                }
            }
        });
    }

    private void init(){
        titleList = new ArrayList<>();
        String[] titleStr = new String[]{"综合", "车评", "视频", "长测", "策划", "观点", "图片", "资讯", "经典"};
        for(int i = 0; i < 8; i++){
            titleList.add(titleStr[i]);
        }
        // 获取搜索记录文件内容
        SharedPreferences sp = getSharedPreferences("search_history", MODE_PRIVATE);
        String history = sp.getString("history", "暂时没有搜索记录");
        // 用逗号分割内容返回数组
        String[] history_arr = history.split(",");
        //新建适配器，适配器数据为搜索历史文件内容
        arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, history_arr);
        //保留前20条
        if(history_arr.length > 20){
            String[] newArrays = new String[20];
            // 实现数组之间的复制
            System.arraycopy(history_arr, 0, newArrays, 0, 20);
            arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, history_arr);
        }
        search_listView.setAdapter(arr_adapter);
        // 设置监听事件，点击搜索写入搜索词
        search_button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                // TODO Auto-generated method stub
                save();
                startActivity(new Intent(SearchActivity.this, MainActivity.class));
                arr_adapter.notifyDataSetChanged();
            }
        });
        //清空历史记录
        history_clean_img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);
                builder.setTitle("是否清空历史记录").setNegativeButton("确定", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        cleanHistory();
                    }
                }).setPositiveButton("取消", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                    }
                });
                builder.create().show();
            }
        });
        //返回
        search_back_img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }

    private void save(){
        String text = search_edittext.getText().toString();
        SharedPreferences mysp = getSharedPreferences("search_history", MODE_PRIVATE);
        String old_text = mysp.getString("history", "");
        // 利用StringBuilder.append新增内容，逗号便于读取内容时用逗号拆分开
        StringBuffer stringBuffer = new StringBuffer(old_text);
        stringBuffer.append(text + ",");
        // 判断搜索内容是否已经存在于历史文件，已存在则不重复添加
        if(!old_text.contains(text + ",")){
            SharedPreferences.Editor myeditor = mysp.edit();
            myeditor.putString("history", stringBuffer.toString());
            myeditor.commit();
        }
    }

    //清除搜索记录
    public void cleanHistory(){
        SharedPreferences sp = getSharedPreferences("search_history", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(this, "清除成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
