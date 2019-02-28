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
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView extends LinearLayout implements b {
    private TextWatcher XD = new TextWatcher() {
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (LuckyMoneyNumInputView.this.onE != null) {
                f a = LuckyMoneyNumInputView.this.onE;
                LuckyMoneyNumInputView.this.getId();
                a.aXW();
            }
        }
    };
    private TextView jOY;
    public f onE;
    TenpaySecureEditText ooL;
    private TextView ooM;
    private int ooN = 1;
    private int ooO = Integer.MAX_VALUE;
    public int ooP = 1;

    public LuckyMoneyNumInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(g.uJe, this, true);
        this.jOY = (TextView) inflate.findViewById(f.uvu);
        this.ooL = (TenpaySecureEditText) inflate.findViewById(f.uua);
        this.ooM = (TextView) inflate.findViewById(f.uvv);
        this.ooL.setText(this.ooN);
        this.ooL.addTextChangedListener(this.XD);
    }

    public final void sA(int i) {
        int i2 = 3;
        this.ooO = i;
        int i3 = 0;
        while (i > 0) {
            i3++;
            i /= 10;
        }
        if (i3 > 3) {
            i2 = i3;
        }
        this.ooL.setFilters(new InputFilter[]{new LengthFilter(i2)});
    }

    public final int aYu() {
        return bi.getInt(this.ooL.getText().toString(), 0);
    }

    public final void EG(String str) {
        this.ooL.setText(str);
        this.ooL.setSelection(this.ooL.getText().length());
        this.ooN = bi.getInt(str, 0);
    }

    public final int aYm() {
        if (bi.oN(this.ooL.getText().toString())) {
            return 0;
        }
        int i = bi.getInt(this.ooL.getText().toString(), -1);
        if (i < 0) {
            return 3;
        }
        if (i > this.ooO && this.ooO > 0) {
            return 1;
        }
        if (i >= this.ooP || this.ooP <= 0) {
            return 0;
        }
        return 2;
    }

    public final void restore() {
        this.jOY.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.ooL.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.ooM.setTextColor(WebView.NIGHT_MODE_COLOR);
    }

    public final void onError() {
        this.jOY.setTextColor(n.da(getContext()));
        this.ooL.setTextColor(n.da(getContext()));
        this.ooM.setTextColor(n.da(getContext()));
    }

    public final String sy(int i) {
        if (i == 1) {
            return getContext().getString(i.uRb, new Object[]{Integer.valueOf(this.ooO)});
        } else if (i != 2) {
            return null;
        } else {
            return getContext().getString(i.uRa, new Object[]{Integer.valueOf(this.ooP)});
        }
    }
}
