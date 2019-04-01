package com.helen.rxandroid.presenter;

import com.helen.rxandroid.modle.IMainModle;
import com.helen.rxandroid.modle.MainModle;
import com.helen.rxandroid.view.IMainView;

import java.lang.ref.WeakReference;

public class MainPresenter implements IMainPresented<IMainView,IMainModle> {
    private WeakReference<IMainView>  iMainView;


    @Override
    public void getData() {
        IMainModle mainModle = new MainModle();
        mainModle.requestData(response -> iMainView.get().getData(response));
    }
}
