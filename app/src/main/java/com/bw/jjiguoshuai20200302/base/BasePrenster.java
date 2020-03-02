package com.bw.jjiguoshuai20200302.base;

import java.lang.ref.WeakReference;

/**
 * 季国帅
 * 20200302
 */
public abstract class BasePrenster<V extends IBaseView> {

    WeakReference<V> vWeakReference;

    public BasePrenster(V v) {
        vWeakReference = new WeakReference<>(v);
        initMoudle();
    }
    public abstract void initMoudle();
    public V getView(){
        if (vWeakReference!=null){
            return vWeakReference.get();
        }
        return null;
    }
    public void detachView(){
        if (vWeakReference!=null){
            vWeakReference.clear();
            vWeakReference=null;
        }
    }
}
