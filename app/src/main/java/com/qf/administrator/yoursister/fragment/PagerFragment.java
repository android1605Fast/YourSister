package com.qf.administrator.yoursister.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.qf.administrator.yoursister.Jsonparser.HttpRequest;
import com.qf.administrator.yoursister.Jsonparser.JsonParser;
import com.qf.administrator.yoursister.R;
import com.qf.administrator.yoursister.bean.MainContext;

import java.util.List;

import Adapter.FragmentListviewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerFragment extends Fragment{
    private String urlstring="http://d.api.budejie.com/topic/tag-topic/1/hot/budejie-android-6.4.5/0-20.json?market=tencentyingyongbao&udid=864394104816923" +
            "&appname=baisibudejie&os=4.4.2&client=android&visiting=&mac=5A%3AA9%3AD2%3A52%3A71%3A20&ver=6.4.5";
    private ListView listView;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            List<MainContext> list= (List<MainContext>) msg.obj;
            if(list!=null){
                FragmentListviewAdapter adapter=new FragmentListviewAdapter(getContext(),list);
                listView.setAdapter(adapter);
            }
        }
    };
    public PagerFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_pager, container, false);
        listView= (ListView) view.findViewById(R.id.mian_fragment_listview);
        initData();
        return view;
    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String jsonString= HttpRequest.downJsonString(urlstring);
                List<MainContext> list= JsonParser.parserContext(jsonString);
                Message msg = handler.obtainMessage();
                msg.obj=list;
                handler.sendMessage(msg);
            }
        }).start();
    }
}
