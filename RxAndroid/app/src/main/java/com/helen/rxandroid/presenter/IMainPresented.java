package com.helen.rxandroid.presenter;

import com.helen.rxandroid.modle.IMainModle;
import com.helen.rxandroid.view.IMainView;

public interface IMainPresented<T extends IMainView,K extends IMainModle> {
    void getData();
}
