package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.walletlock.a.d;
import com.tencent.mm.plugin.walletlock.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class a {
    View mView = null;
    TextView tmV = null;
    FrameLayout tmW = null;
    PatternLockView tmX = null;
    TextView tmY = null;

    public a(Activity activity) {
        this.mView = View.inflate(activity, e.tkQ, null);
        this.tmV = (TextView) this.mView.findViewById(d.dtu);
        this.tmW = (FrameLayout) this.mView.findViewById(d.tkM);
        this.tmX = (PatternLockView) this.mView.findViewById(d.tkL);
        this.tmY = (TextView) this.mView.findViewById(d.tkO);
    }
}
