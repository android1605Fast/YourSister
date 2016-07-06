package Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.administrator.yoursister.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class OwnListViewAdapter extends BaseAdapter{
    private List<String> itemlist;
    private List<Bitmap> bitmapList;
    private Context context;
    private LayoutInflater inflater;

    public OwnListViewAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount(){
        return itemlist.size();
    }

    @Override
    public Object getItem(int position){
        return itemlist.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        viewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.item_ownlisti,parent,false);
            viewHolder = new viewHolder();
            viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (OwnListViewAdapter.viewHolder) convertView.getTag();
        }

        return null;
    }
    class  viewHolder{
        ImageView iv;
        TextView tv;
    }
}
