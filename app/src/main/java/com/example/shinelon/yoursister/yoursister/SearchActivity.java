package com.example.shinelon.yoursister.yoursister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.qf.administrator.yoursister.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里是首页tablayout右边搜索按钮进来之后出现的界面
 *
 */
public class SearchActivity extends AppCompatActivity{
    private EditText search_edittext;
    private Button search_button;
    private RecyclerView search_recyclerView;
    private ListView search_listView;
    private List<String> titleList;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search_edittext= (EditText) findViewById(R.id.search_edittext);
        search_button= (Button) findViewById(R.id.search_button);
        search_recyclerView= (RecyclerView) findViewById(R.id.search_recyclerview);
        search_listView= (ListView) findViewById(R.id.search_listview);
        Log.e("init: ", "1");
        init();
    }


    private void init() {
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
        Log.e("init: ", "123123");
        // 获取搜索记录文件内容
        SharedPreferences sp = getSharedPreferences("search_history", MODE_PRIVATE);
        String history = sp.getString("history", "暂时没有搜索记录");
        Toast.makeText(SearchActivity.this, "1", Toast.LENGTH_SHORT).show();
        // 用逗号分割内容返回数组
        String[] history_arr=history.split(",");
        //新建适配器，适配器数据为搜索历史文件内容
        ArrayAdapter arr_adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, history_arr);
        //保留前20条
        if(history_arr.length>20){
            String[] newArrays=new String[20];
            // 实现数组之间的复制
            System.arraycopy(history_arr,0,newArrays,0,20);
            arr_adapter=new ArrayAdapter<String>(this,
                    android.R.layout.simple_dropdown_item_1line, history_arr);
        }
        search_listView.setAdapter(arr_adapter);

        // 设置监听事件，点击搜索写入搜索词
        search_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                save();
                startActivity(new Intent(SearchActivity.this, com.qf.administrator.yoursister.MainActivity.class));
                Toast.makeText(SearchActivity.this, "123", Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void save() {
        String text=search_edittext.getText().toString();
        SharedPreferences mysp = getSharedPreferences("search_history", MODE_PRIVATE);
        String old_text=mysp.getString("history","暂时没有搜索记录");

        // 利用StringBuilder.append新增内容，逗号便于读取内容时用逗号拆分开
        StringBuffer stringBuffer=new StringBuffer(old_text);
        stringBuffer.append(text+",");
        // 判断搜索内容是否已经存在于历史文件，已存在则不重复添加
       if(!old_text.contains(text+",")){
            SharedPreferences.Editor myeditor=mysp.edit();
            myeditor.putString("history",stringBuffer.toString());
           myeditor.commit();
       }
    }
}
