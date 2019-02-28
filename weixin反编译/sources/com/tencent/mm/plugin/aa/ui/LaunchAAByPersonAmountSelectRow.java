package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class LaunchAAByPersonAmountSelectRow extends LinearLayout {
    private ImageView ikl;
    private TextView ill;
    private WalletFormView ilm;
    private View iln;
    private TextWatcher ilo = null;

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LaunchAAByPersonAmountSelectRow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        v.fw(context).inflate(g.uID, this, true);
        this.ikl = (ImageView) findViewById(f.bLD);
        this.ill = (TextView) findViewById(f.cUw);
        this.ilm = (WalletFormView) findViewById(f.uyc);
        this.iln = findViewById(f.divider);
    }
}
