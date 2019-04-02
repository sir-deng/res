package com.helen.baselib.base;

import android.content.Context;

import com.helen.baselib.RxManager.RxManager;

public abstract class BasePresenter<T, K> {
    public Context mContext;
    public T mModel;
    public K mView;
    public RxManager mRxManage = new RxManager();

    public void setVM(T mModel, K mView) {
        this.mModel = mModel;
        this.mView = mView;
        this.onStart();
    }

    public void onStart() {

    }

    public void OnDestroy() {
    }

}
