package com.helen.rxandroid;

import java.lang.ref.WeakReference;

public class BasePresenter<T extends IBaseView, K extends IBaseModel> implements IBasePresenter {
    private WeakReference<T> view;

    public void onDetached() {
        if (view != null)
            view.clear();
    }

    public void onAttached(T view) {
        this.view = new WeakReference<>(view);
    }



}
