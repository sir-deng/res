package com.helen.mytest.test

import com.helen.baselib.base.BaseModel
import com.helen.baselib.base.BasePresenter
import com.helen.baselib.base.BaseView
import rx.Observable

interface TestContract {
    interface Model :BaseModel{
        fun getData(): Observable<String>;
    }
    interface View :BaseView{
        fun showView(test:String);
    }
    abstract class Presenter : BasePresenter<Model, View>() {
        abstract fun setdata();
    }
}