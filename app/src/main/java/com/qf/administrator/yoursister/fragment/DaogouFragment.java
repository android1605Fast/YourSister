package com.qf.administrator.yoursister.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.administrator.yoursister.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaogouFragment extends Fragment{

    public DaogouFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_daogou, container, false);
    }
}
