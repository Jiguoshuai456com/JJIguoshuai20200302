package com.bw.jjiguoshuai20200302.activity;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.jjiguoshuai20200302.R;
import com.bw.jjiguoshuai20200302.adapter.ReeAdapter;
import com.bw.jjiguoshuai20200302.adapter.ReeAdapter2;
import com.bw.jjiguoshuai20200302.adapter.ReeAdapter3;

import com.bw.jjiguoshuai20200302.base.BaseActivity;
import com.bw.jjiguoshuai20200302.base.BasePrenster;
import com.bw.jjiguoshuai20200302.bean.Bean;
import com.bw.jjiguoshuai20200302.prenster.IHomePrenster;
import com.bw.jjiguoshuai20200302.utiuls.VolleyUtiuls;
import com.google.gson.Gson;

import java.util.List;

/**
 * 季国帅
 * 20200302
 */
public class MainActivity extends BaseActivity {


    private ImageView iv;
    private RecyclerView rv;
    private RecyclerView rv1;
    private RecyclerView rv2;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePrenster initPrenster() {
        return new IHomePrenster(this);
    }

    @Override
    protected void initView() {
        iv = findViewById(R.id.iv);
        rv = findViewById(R.id.rv);
        rv1 = findViewById(R.id.rv1);
        rv2 = findViewById(R.id.rv2);
    }

    @Override
    protected void getData() {
        BasePrenster prenster = getPrenster();
        if (prenster!=null && prenster instanceof IHomePrenster){
            IHomePrenster prenster1= (IHomePrenster) prenster;
            prenster1.getBanner("http://blog.zhaoliang5156.cn/api/shop/jingdong.json");
        }

    }

    @Override
    public void Succcess(String url) {
        boolean net = VolleyUtiuls.getInstance().getNet(this);
        if (net){
//            ⑦　配置Glide的图片加载优先级，最高优先级是横向列表，其次是中间列表，最低的是底部网格/
            Gson gson = new Gson();
            Bean bean = gson.fromJson(url, Bean.class);
            Bean.DataBean data = bean.getData();
//            ②　完成RecycleView条目1横向RecycleView。对应图1京东狗图片下面横向列表
            List<Bean.DataBean.HorizontalListDataBean> listData = data.getHorizontalListData();
            RecyclerView.LayoutManager layoutManager=  new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
            rv.setLayoutManager(layoutManager);
            ReeAdapter adapter = new ReeAdapter(this, listData);
            rv.setAdapter(adapter);
            List<Bean.DataBean.GridDataBean> gridData = data.getGridData();
            final List<Bean.DataBean.VerticalListDataBean> verticalListData = data.getVerticalListData();

//③　完成RecycleView条目2列表RecycleView。对应图1中间列表

            RecyclerView.LayoutManager layoutManager1=  new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
            rv1.setLayoutManager(layoutManager1);
            ReeAdapter2 adapter2 = new ReeAdapter2(this, verticalListData);
            rv1.setAdapter(adapter2);
//            ⑤　给中间列表RecycleView设置条目点击事件，点击吐司商品价格。/
            adapter2.steOnitemClickListener(new ReeAdapter2.OnItemClickListener() {
                @Override
                public void onClick(int postion) {
                    Toast.makeText(MainActivity.this, ""+verticalListData.get(postion).getPrice(), Toast.LENGTH_SHORT).show();

                }
            });
//            ④　完成RecycleView条目3网格RecycleView。对应图1底部网格
            RecyclerView.LayoutManager manager=new GridLayoutManager(this,2);
            rv2.setLayoutManager(manager);
            ReeAdapter3 adapter3 = new ReeAdapter3(this, gridData);
            rv2.setAdapter(adapter3);
        }else {
//            ⑦　有网展示图片1，无网展示图片2
            Glide.with(this).load(R.mipmap.jing).into(iv);
        }

        Log.i("xxx",url);

    }

    @Override
    public void Error(String url) {

    }
}
