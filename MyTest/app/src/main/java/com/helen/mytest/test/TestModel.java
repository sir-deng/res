package com.helen.mytest.test;

import com.helen.baselib.RxManager.RxSchedulers;
import com.helen.mytest.api.Api;

import org.jetbrains.annotations.NotNull;

import rx.Observable;
import rx.functions.Func1;

public class TestModel implements TestContract.Model {

    @NotNull
    @Override
    public Observable<String> getData() {
        return  Api.getDefault().getTest("60").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s;
            }
        }).compose(RxSchedulers.<String>io_main());
//        Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
////                subscriber.onNext();
//                subscriber.onCompleted();
//            }
//        }).compose(RxSchedulers.io_main());
//        Observable.create(new Observable.OnSubscribe<String>(){
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//
//            }
//        }).compose(R);


    }
}
