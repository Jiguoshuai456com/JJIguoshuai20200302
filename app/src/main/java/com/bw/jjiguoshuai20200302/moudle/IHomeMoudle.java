package com.bw.jjiguoshuai20200302.moudle;

import com.bumptech.glide.Glide;
import com.bw.jjiguoshuai20200302.R;
import com.bw.jjiguoshuai20200302.base.App;
import com.bw.jjiguoshuai20200302.contract.IHomeContract;
import com.bw.jjiguoshuai20200302.utiuls.VolleyUtiuls;

/**
 * 季国帅
 * 20200302
 */
public class IHomeMoudle implements IHomeContract.IMoudle {
    @Override
    public void getBanner(String url, final IBack iBack) {
        boolean net = VolleyUtiuls.getInstance().getNet(App.getApplicon());
        if (net){
            VolleyUtiuls.getInstance().doGet(url, new VolleyUtiuls.ICallBack() {
                @Override
                public void onSuccess(String json) {
                    iBack.Succcess(json);
                }

                @Override
                public void onError(String msg) {

                }
            });
        }


    }
}
