package com.bw.jjiguoshuai20200302.prenster;

import com.bw.jjiguoshuai20200302.base.BasePrenster;
import com.bw.jjiguoshuai20200302.base.IBaseView;
import com.bw.jjiguoshuai20200302.contract.IHomeContract;
import com.bw.jjiguoshuai20200302.moudle.IHomeMoudle;

/**
 * 季国帅
 * 20200302
 */
public class IHomePrenster extends BasePrenster implements IHomeContract.IPrenster {

    IHomeMoudle moudle;

    public IHomePrenster(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    public void getBanner(String url) {
        moudle.getBanner(url, new IHomeContract.IMoudle.IBack() {
            @Override
            public void Succcess(String url) {
                IBaseView view = getView();
                if (view instanceof IHomeContract.IView){
                    IHomeContract.IView view1= (IHomeContract.IView) view;
                    view1.Succcess(url);
                }
            }

            @Override
            public void Error(String url) {
                IBaseView view = getView();
                if (view instanceof IHomeContract.IView){
                    IHomeContract.IView view1= (IHomeContract.IView) view;
                    view1.Error(url);
                }
            }
        });

    }

    @Override
    public void initMoudle() {
        moudle = new IHomeMoudle();

    }
}
