package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public class CheckBoxWithTipIconPreference extends CheckBoxPreference {
    private TextView sOj;
    private int sOk;
    private String sOl;
    private int sOm;

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sOk = -1;
        this.sOl = "";
        this.sOm = 8;
        setLayoutResource(g.uJI);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.sOj = (TextView) view.findViewById(f.gYl);
        ct(this.sOl, this.sOk);
        zx(this.sOm);
    }

    public final void ct(String str, int i) {
        this.sOk = i;
        this.sOl = str;
        if (this.sOj != null) {
            if (this.sOk > 0) {
                this.sOj.setBackgroundResource(this.sOk);
            }
            if (!TextUtils.isEmpty(this.sOl)) {
                this.sOj.setText(this.sOl);
            }
        }
    }

    public final void zx(int i) {
        this.sOm = i;
        if (this.sOj != null) {
            this.sOj.setVisibility(i);
        }
    }
}
