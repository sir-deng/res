package com.helen.mytest.test;

import com.helen.baselib.RxManager.RxSubscriber;
import com.helen.baselib.commountutils.ToastUitl;

import rx.Observable;

public class TestPresenter extends TestContract.Presenter {
    @Override
    public void setdata() {
        Observable<String> data = mModel.getData();
        mRxManage.add(mModel.getData().subscribe(new RxSubscriber<String>(mContext) {
            @Override
            protected void _onNext(String s) {
                mView.showView(s);
            }

            @Override
            protected void _onError(String message) {
                ToastUitl.showToastWithImg(message, com.helen.baselib.R.drawable.ic_wrong);
            }
        }));
    }
}
