package com.bw.jjiguoshuai20200302.contract;

import com.bw.jjiguoshuai20200302.base.IBaseView;

/**
 * 季国帅
 * 20200302
 */
public interface IHomeContract {
    interface IView extends IBaseView{
        void Succcess(String url);
        void Error(String url);
    }
    interface IPrenster{
        void getBanner(String url);
    }
    interface IMoudle{
        void getBanner(String url,IBack iBack);
        interface IBack{
            void Succcess(String url);
            void Error(String url);
        }
    }
}
