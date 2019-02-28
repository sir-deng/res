package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.b.c;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyMoneyInputView extends LinearLayout implements b {
    private TextWatcher XD = new TextWatcher() {
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (LuckyMoneyMoneyInputView.this.onE != null) {
                f a = LuckyMoneyMoneyInputView.this.onE;
                LuckyMoneyMoneyInputView.this.getId();
                a.aXW();
            }
        }
    };
    private TextView jOY;
    public int mType;
    private c ohp;
    TenpaySecureEditText onB;
    private TextView onC;
    private TextView onD;
    public f onE;
    public double onF;
    public double onG;

    public LuckyMoneyMoneyInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a.aXv();
        this.ohp = a.aXw().aXH();
        View inflate = LayoutInflater.from(context).inflate(g.uIX, this, true);
        this.onB = (TenpaySecureEditText) inflate.findViewById(f.uua);
        this.onB.addTextChangedListener(this.XD);
        this.jOY = (TextView) inflate.findViewById(f.uux);
        this.onD = (TextView) inflate.findViewById(f.uuw);
        this.onC = (TextView) inflate.findViewById(f.utd);
    }

    public final double aYn() {
        return bi.getDouble(this.onB.getText().toString(), 0.0d);
    }

    public final void setTitle(String str) {
        this.jOY.setText(str);
    }

    public final void gy(boolean z) {
        if (z) {
            this.onD.setVisibility(0);
        } else {
            this.onD.setVisibility(8);
        }
    }

    public final void aYo() {
        this.onB.setFilters(new InputFilter[]{new LengthFilter(12)});
    }

    public final void EF(String str) {
        this.onB.setText(str);
    }

    public final int aYm() {
        if (bi.oN(this.onB.getText().toString())) {
            return 0;
        }
        double d = bi.getDouble(this.onB.getText().toString(), -1.0d);
        if (d < 0.0d) {
            return 3;
        }
        if (d > this.onF && this.onF > 0.0d) {
            return 1;
        }
        if (d >= this.onG || d <= 0.0d) {
            return 0;
        }
        return 2;
    }

    public final void restore() {
        this.jOY.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.onB.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.onC.setTextColor(WebView.NIGHT_MODE_COLOR);
    }

    public final void onError() {
        this.jOY.setTextColor(n.da(getContext()));
        this.onB.setTextColor(n.da(getContext()));
        this.onC.setTextColor(n.da(getContext()));
    }

    public final String sy(int i) {
        a.aXv();
        this.ohp = a.aXw().aXH();
        if (i == 1) {
            if (this.mType == 1) {
                return getContext().getString(i.uRA, new Object[]{Math.round(this.onF), bi.aD(this.ohp.oho, "")});
            }
            return getContext().getString(i.uQl, new Object[]{Math.round(this.onF), bi.aD(this.ohp.oho, "")});
        } else if (i != 2) {
            return null;
        } else {
            return getContext().getString(i.uQm, new Object[]{e.t(this.onG), bi.aD(this.ohp.oho, "")});
        }
    }
}
