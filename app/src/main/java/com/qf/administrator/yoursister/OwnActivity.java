package com.qf.administrator.yoursister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class OwnActivity extends AppCompatActivity{

    private ListView ownlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own);
        ownlistView = (ListView) findViewById(R.id.ownListView);
    }
}
