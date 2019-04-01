package com.helen.rxandroid.modle;

public interface IMainModle {
    void requestData(OnCompleteListener completeListener);
    interface OnCompleteListener{
        void onComplete(String response);
    }
}
