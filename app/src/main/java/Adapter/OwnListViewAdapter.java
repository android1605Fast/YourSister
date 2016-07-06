package Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.administrator.yoursister.R;

import java.util.ArrayList;
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

        itemlist = new ArrayList<>();
        itemlist.add("我的车库");
        itemlist.add("我的导购");
        itemlist.add("我的评论");
        itemlist.add("我的收藏");
        itemlist.add("我的好友");
        itemlist.add("系统");

        Resources resources = context.getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(resources,R.mipmap.ic_launcher);
        bitmapList = new ArrayList<>();
        bitmapList.add(bitmap);
        bitmapList.add(bitmap);
        bitmapList.add(bitmap);
        bitmapList.add(bitmap);
        bitmapList.add(bitmap);
        bitmapList.add(bitmap);
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
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_ownlisti, parent, false);
            viewHolder = new viewHolder();
            viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (OwnListViewAdapter.viewHolder) convertView.getTag();
        }
        viewHolder.iv.setImageBitmap(bitmapList.get(position));
        viewHolder.tv.setText(itemlist.get(position));
        return convertView;
    }

    class viewHolder{
        ImageView iv;
        TextView tv;
    }
}
