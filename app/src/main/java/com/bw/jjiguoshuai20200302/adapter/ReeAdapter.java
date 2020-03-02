package com.bw.jjiguoshuai20200302.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.jjiguoshuai20200302.R;
import com.bw.jjiguoshuai20200302.bean.Bean;

import java.util.List;

/**
 * 季国帅
 * 20200302
 */
public class ReeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Bean.DataBean.HorizontalListDataBean> listData;
    public ReeAdapter(Context context, List<Bean.DataBean.HorizontalListDataBean> listData) {
        this.context=context;
        this.listData=listData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.iv1);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item, null);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Bean.DataBean.HorizontalListDataBean bean = listData.get(i);
        String imageurl = bean.getImageurl();
//        ⑥　使用Glide完成网络图片加载，并配置占位图、错误图
        Glide.with(context).load(imageurl).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(((ViewHolder)viewHolder).iv1);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
