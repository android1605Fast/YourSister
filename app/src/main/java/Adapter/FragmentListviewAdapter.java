package Adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.qf.administrator.yoursister.R;
import com.qf.administrator.yoursister.bean.MainContext;
import com.se7en.utils.DeviceUtils;

import java.util.List;

import wedget.CustomButton;

/**
 * Created by Shinelon on 2016/7/6.
 */
public class FragmentListviewAdapter extends BaseAdapter {
    private final static int TEXT = 0;
    private final static int IMAGE = 1;
    private final static int VIDEO = 2;
    private Context context;
    private List<MainContext.ListBean> list;
    private LayoutInflater inflater;

    public FragmentListviewAdapter(Context context, List<MainContext.ListBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
        DeviceUtils.setContext(context);
    }
    //返回ListView中一共有多少个不同类型的item
    @Override
    public int getViewTypeCount() {
        return 3;
    }
    //返回item的类型,参数表示当前要加载的item的位置信息
    @Override
    public int getItemViewType(int position) {
        MainContext.ListBean listBean = list.get(position);
        if(listBean.getVideo()!=null){
            return VIDEO;
        }else if(listBean.getImage()!=null){
            return IMAGE;
        }else {
            return TEXT;
        }
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextViewHolder textHolder=null;
        ImgViewHolder imgHolder=null;
        VideoViewHolder videoHolder=null;
        //获取当前要加载的item的类型
        int itemType=getItemViewType(position);
        if(convertView==null) {
            switch (itemType) {
                case TEXT:
                    convertView = inflater.inflate(R.layout.main_listview_item_text, parent, false);
                    textHolder = new TextViewHolder();
                    //用户
                    textHolder.uimg = (SimpleDraweeView) convertView.findViewById(R.id.listview_item_text_uimg);
                    textHolder.uname = (TextView) convertView.findViewById(R.id.listview_item_text_username);
                    textHolder.time = (TextView) convertView.findViewById(R.id.listview_item_text_time);
                    textHolder.uvip = (SimpleDraweeView) convertView.findViewById(R.id.listview_item_text_uservip);
                    //内容
                    textHolder.text = (TextView) convertView.findViewById(R.id.listview_item_text_text);
                    //归类
                    textHolder.tags = (LinearLayout) convertView.findViewById(R.id.listview_item_text_tags);
                    //赞，评论
                    textHolder.up = (CustomButton) convertView.findViewById(R.id.listview_item_text_up);
                    textHolder.down = (CustomButton) convertView.findViewById(R.id.listview_item_text_down);
                    textHolder.forward = (CustomButton) convertView.findViewById(R.id.listview_item_text_forward);
                    textHolder.comment = (CustomButton) convertView.findViewById(R.id.listview_item_text_comment);

                    convertView.setTag(textHolder);
                    break;
                case IMAGE:
                    convertView = inflater.inflate(R.layout.main_listview_item_img, parent, false);
                    imgHolder = new ImgViewHolder();
                    //用户
                    imgHolder.uimg = (SimpleDraweeView) convertView.findViewById(R.id.listview_item_img_uimg);
                    imgHolder.uname = (TextView) convertView.findViewById(R.id.listview_item_img_username);
                    imgHolder.time = (TextView) convertView.findViewById(R.id.listview_item_img_time);
                    imgHolder.uvip = (SimpleDraweeView) convertView.findViewById(R.id.listview_item_img_uservip);
                    //内容
                    imgHolder.text = (TextView) convertView.findViewById(R.id.listview_item_img_text);
                    imgHolder.contextimg= (SimpleDraweeView) convertView.findViewById(R.id.listview_item_img_img_context);
                    //归类
                    imgHolder.tags = (LinearLayout) convertView.findViewById(R.id.listview_item_img_tags);
                    //赞，评论
                    imgHolder.up = (CustomButton) convertView.findViewById(R.id.listview_item_img_up);
                    imgHolder.down = (CustomButton) convertView.findViewById(R.id.listview_item_img_down);
                    imgHolder.forward = (CustomButton) convertView.findViewById(R.id.listview_item_img_forward);
                    imgHolder.comment = (CustomButton) convertView.findViewById(R.id.listview_item_img_comment);


                    convertView.setTag(imgHolder);
                    break;
                case VIDEO:
                    convertView = inflater.inflate(R.layout.main_listview_item_video, parent, false);
                    videoHolder = new VideoViewHolder();
                    //用户
                    videoHolder.uimg = (SimpleDraweeView) convertView.findViewById(R.id.listview_item_video_uimg);
                    videoHolder.uname = (TextView) convertView.findViewById(R.id.listview_item_video_username);
                    videoHolder.time = (TextView) convertView.findViewById(R.id.listview_item_video_time);
                    videoHolder.uvip = (SimpleDraweeView) convertView.findViewById(R.id.listview_item_video_uservip);
                    //内容
                    videoHolder.text = (TextView) convertView.findViewById(R.id.listview_item_video_text);
                    //归类
                    videoHolder.tags = (LinearLayout) convertView.findViewById(R.id.listview_item_video_tags);
                    //赞，评论
                    videoHolder.up = (CustomButton) convertView.findViewById(R.id.listview_item_video_up);
                    videoHolder.down = (CustomButton) convertView.findViewById(R.id.listview_item_video_down);
                    videoHolder.forward = (CustomButton) convertView.findViewById(R.id.listview_item_video_forward);
                    videoHolder.comment = (CustomButton) convertView.findViewById(R.id.listview_item_video_comment);

                    convertView.setTag(videoHolder);
                    break;
            }
        }else {
            switch (itemType) {
                case TEXT:
                    textHolder= (TextViewHolder) convertView.getTag();
                    break;
                case IMAGE:
                    imgHolder= (ImgViewHolder) convertView.getTag();
                    break;
                case VIDEO:
                    videoHolder= (VideoViewHolder) convertView.getTag();
                    break;
            }
        }
        //加载数据
        initData(position, textHolder, imgHolder, videoHolder, itemType);

        return convertView;
    }

    private void initData(int position, TextViewHolder textHolder, ImgViewHolder imgHolder, VideoViewHolder videoHolder, int itemType) {
        MainContext.ListBean listBean = list.get(position);
        RoundingParams params = RoundingParams.fromCornersRadius(60);
        switch (itemType) {
            case TEXT:
                //用户
                textHolder.uimg.setImageURI(Uri.parse(listBean.getU().getHeader()));
                textHolder.uimg.getHierarchy().setRoundingParams(params);
                textHolder.uname.setText(listBean.getU().getName());
                textHolder.time.setText(listBean.getPasstime());
                //内容
                textHolder.text.setText(listBean.getText());
                //归类
                break;
            case IMAGE:
                //用户
                imgHolder.uimg.setImageURI(Uri.parse(listBean.getU().getHeader()));
                imgHolder.uimg.getHierarchy().setRoundingParams(params);
                imgHolder.uimg.getHierarchy().setRoundingParams(params);
                imgHolder.uname.setText(listBean.getU().getName());
                imgHolder.time.setText(listBean.getPasstime());
                //内容
                imgHolder.text.setText(listBean.getText());
                //图片
                Log.e("initData: ",listBean.getGif()+"11" );
                if(listBean.getGif()!=null){
                    Uri animUri = Uri.parse(listBean.getGif().getImages());
                    DraweeController controller = Fresco.newDraweeControllerBuilder().setUri(animUri)
                            //设置动画自动播放
                            .setAutoPlayAnimations(true).build();
                    imgHolder.contextimg.setController(controller);
                }
                if(listBean.getImage()!=null){
                    if(listBean.getImage().getMedium()!=null&&listBean.getImage().getHeight()<1000) {
                        Glide.with(context).load(listBean.getImage().getMedium()).placeholder(R.mipmap.ic_launcher)
                                .override(DeviceUtils.dip2px(listBean.getImage().getWidth()),
                                        listBean.getImage().getHeight()).into(imgHolder.contextimg);
                    }else {
                        Glide.with(context).load(listBean.getImage().getBig()).placeholder(R.mipmap.ic_launcher)
                                .override(DeviceUtils.dip2px(listBean.getImage().getWidth()), DeviceUtils.dip2px(500)).into(imgHolder.contextimg);
                    }
                }

                break;
            case VIDEO:
                //用户
                videoHolder.uimg.setImageURI(Uri.parse(listBean.getU().getHeader()));
                videoHolder.uimg.getHierarchy().setRoundingParams(params);
                videoHolder.uimg.getHierarchy().setRoundingParams(params);
                videoHolder.uname.setText(listBean.getU().getName());
                videoHolder.time.setText(listBean.getPasstime());
                //内容
                videoHolder.text.setText(listBean.getText());
                break;
        }
    }


    //三种布局
    public class TextViewHolder{
        private SimpleDraweeView uimg,uvip;
        private LinearLayout tags;
        private TextView uname,time,text;
        private CustomButton up,down,forward,comment;
    }
    public class ImgViewHolder{
        private SimpleDraweeView uimg,uvip,contextimg;
        private LinearLayout tags;
        private TextView uname,time,text;
        private CustomButton up,down,forward,comment;
    }
    public class VideoViewHolder{
        private SimpleDraweeView uimg,uvip,contextimg;
        private ImageView playericon;
        private ProgressBar progressBar;
        private LinearLayout tags;
        private TextView uname,time,text,playcount;
        private CustomButton up,down,forward,comment;
    }
}
