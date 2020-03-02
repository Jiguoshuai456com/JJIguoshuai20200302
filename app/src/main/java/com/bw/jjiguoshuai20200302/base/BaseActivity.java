package com.bw.jjiguoshuai20200302.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.jjiguoshuai20200302.R;
import com.bw.jjiguoshuai20200302.contract.IHomeContract;

/**
 * 季国帅
 * 20200302
 */
public abstract class  BaseActivity<P extends BasePrenster> extends AppCompatActivity implements IHomeContract.IView {

//    ④　抽取Activity基类，在Activity基类中封装初始化P层的方法
    P mPrenster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mPrenster=initPrenster();
        initView();
        getData();
    }
    public P getPrenster(){
        return mPrenster;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPrenster!=null){
            mPrenster.detachView();
            mPrenster=null;
        }
    }

    protected abstract int getLayout();
    protected abstract P initPrenster();
    protected abstract void initView();
    protected abstract void getData();
}
