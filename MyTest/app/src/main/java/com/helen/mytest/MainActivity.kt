package com.helen.mytest

import android.widget.TextView
import com.helen.baselib.base.BaseActivity
import com.helen.baselib.commonwidget.LoadingDialog
import com.helen.mytest.test.TestContract
import com.helen.mytest.test.TestModel
import com.helen.mytest.test.TestPresenter

class MainActivity : BaseActivity<TestPresenter,TestModel>(), TestContract.View {
    var text:TextView? = null;
    override fun showView(test: String) {
        if (text!=null) text!!.setText(test)
    }

    override fun showLoading(title: String?) {
        LoadingDialog.showDialogForLoading(this@MainActivity,title,true)
    }

    override fun stopLoading() {
        LoadingDialog.cancelDialogForLoading();
    }

    override fun showErrorTip(msg: String?) {
        showErrorTip(msg)
    }

    override fun getLayoutResId(): Int {
      return  R.layout.activity_main
    }

    override fun initPresenter() {
        mPresenter.setVM(mModel,this@MainActivity)
    }

    override fun initView() {
        text = findViewById<TextView>(R.id.text);
        mPresenter.setdata()
    }


}
