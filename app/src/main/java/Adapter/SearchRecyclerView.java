package Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.qf.administrator.yoursister.R;
import com.qf.administrator.yoursister.SearchActivity;

import java.util.List;

/**
 * Created by Shinelon on 2016/7/6.
 */
public class SearchRecyclerView extends RecyclerView.Adapter {
    private Context context;
    private List<String> title;
    private LayoutInflater inflater;
    private String text;
    private ViewHolder holder;
    private int pos=0;
    public SearchRecyclerView(Context context, List<String> title,String text) {
        this.context = context;
        this.title= title;
        this.text=text;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=inflater.inflate(R.layout.search_recycylerview_item,parent,false);
        holder = new ViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       /* if(text.equals(title.get(position))){
            ((ViewHolder)holder).btn.setTextColor(Color.WHITE);
            ((ViewHolder)holder).btn.setBackgroundColor(Color.RED);
            pos=position;
        }*/
        ((ViewHolder)holder).btn.setText(title.get(position));
    }

    @Override
    public int getItemCount() {
        return title==null?0:title.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button btn;
        public ViewHolder(View itemView) {
            super(itemView);
            btn= (Button) itemView.findViewById(R.id.search_recyclerview_item_button);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(title.get(getLayoutPosition()));
                  /*  text=title.get(getLayoutPosition());
                    holder.btn.setTextColor(Color.WHITE);
                    holder.btn.setBackgroundColor(Color.RED);
                    pos=getLayoutPosition();*/
//                    Toast.makeText(context, "position:" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    //给recyrlerview里面的数据设置接口
    private OnClickRecyclerViewListener listener;
    public interface OnClickRecyclerViewListener{
        void onClick(String text);
    }
    public void setOnClickRecyclerViewListener(OnClickRecyclerViewListener listener){
        this.listener=listener;
    }
}
