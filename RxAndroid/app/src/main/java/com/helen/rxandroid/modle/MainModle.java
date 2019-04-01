package com.helen.rxandroid.modle;

public class MainModle implements IMainModle {

    @Override
    public void requestData(OnCompleteListener completeListener) {
        if (completeListener!=null){
            completeListener.onComplete("终于完成了");
        }
    }
}
