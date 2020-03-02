package com.bw.jjiguoshuai20200302.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.jjiguoshuai20200302.R;
import com.bw.jjiguoshuai20200302.bean.Bean;

import java.util.List;

/**
 * 季国帅
 * 20200302
 */
public class ReeAdapter3 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Bean.DataBean.GridDataBean> gridData;
    public ReeAdapter3(Context context, List<Bean.DataBean.GridDataBean> gridData) {
        this.context=context;
        this.gridData=gridData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv1;
        TextView t2;
        TextView t1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.iv1);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Bean.DataBean.GridDataBean bean = gridData.get(i);
        String imageurl = bean.getImageurl();
        String title = bean.getTitle();
        String price = bean.getPrice();
        ((ReeAdapter3.ViewHolder)viewHolder).t1.setText(title);
        ((ReeAdapter3.ViewHolder)viewHolder).t2.setText(price);
        Glide.with(context).load(imageurl).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(((ViewHolder)viewHolder).iv1);

    }

    @Override
    public int getItemCount() {
        return gridData.size();
    }
}
