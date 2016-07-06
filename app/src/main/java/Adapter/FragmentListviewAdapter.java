package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.qf.administrator.yoursister.bean.MainContext;

import java.util.List;

/**
 * Created by Shinelon on 2016/7/6.
 */
public class FragmentListviewAdapter extends BaseAdapter {
    private Context context;
    private List<MainContext> list;
    private LayoutInflater inflater;

    public FragmentListviewAdapter(Context context, List<MainContext> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
