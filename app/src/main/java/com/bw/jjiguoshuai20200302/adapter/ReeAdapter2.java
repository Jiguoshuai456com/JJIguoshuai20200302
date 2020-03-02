package com.bw.jjiguoshuai20200302.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.jjiguoshuai20200302.R;
import com.bw.jjiguoshuai20200302.bean.Bean;

import java.util.List;

/**
 * 季国帅
 * 20200302
 */
public class ReeAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Bean.DataBean.VerticalListDataBean> verticalListData;
    public ReeAdapter2(Context context,  List<Bean.DataBean.VerticalListDataBean> verticalListData) {
        this.context=context;
        this.verticalListData=verticalListData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv1;
        TextView t2;
        TextView t1;
        LinearLayout l;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.iv1);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
            l = itemView.findViewById(R.id.l);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item2, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        Bean.DataBean.VerticalListDataBean bean = verticalListData.get(i);
        String imageurl = bean.getImageurl();
        String title = bean.getTitle();
        String price = bean.getPrice();
//        ⑥　使用Glide完成网络图片加载，并配置占位图、错误图
        Glide.with(context).load(imageurl).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(((ViewHolder)viewHolder).iv1);
        ((ViewHolder)viewHolder).t1.setText(title);
        ((ViewHolder)viewHolder).t2.setText(price);
        ((ViewHolder)viewHolder).l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(i);
            }
        });
    }
    private OnItemClickListener onItemClickListener;
    public void steOnitemClickListener(OnItemClickListener onItemClickListener1){
        onItemClickListener=onItemClickListener1;

    }
   public interface OnItemClickListener{
        void onClick(int postion);
    }

    @Override
    public int getItemCount() {
        return verticalListData.size();
    }
}
