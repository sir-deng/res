package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.ui.tools.CustomFitTextView;
import com.tencent.mm.v.a.d;

public class WalletPayUSecurityQuestionView extends LinearLayout {
    private Context mContext;
    private TextView tkv;
    private CustomFitTextView tkw;
    String tkx;

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        CharSequence charSequence;
        super(context, attributeSet);
        this.mContext = context;
        String str = "";
        String str2 = "";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, k.vfk, -1, 0);
            int resourceId = obtainStyledAttributes.getResourceId(k.vfs, 0);
            if (resourceId != 0) {
                str = this.mContext.getString(resourceId);
            }
            resourceId = obtainStyledAttributes.getResourceId(k.vfr, 0);
            if (resourceId != 0) {
                str2 = this.mContext.getString(resourceId);
            }
            boolean z2 = obtainStyledAttributes.getBoolean(k.vfn, false);
            obtainStyledAttributes.recycle();
            z = z2;
            charSequence = str;
        } else {
            z = false;
            Object charSequence2 = str;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(g.uJV, this, true);
        this.tkv = (TextView) inflate.findViewById(f.cSc);
        this.tkw = (CustomFitTextView) inflate.findViewById(f.uAc);
        this.tkv.setText(charSequence2);
        CustomFitTextView customFitTextView = this.tkw;
        customFitTextView.a(str2, customFitTextView.maxLines, customFitTextView.zrd, customFitTextView.zrb, customFitTextView.getResources().getColor(d.bsO));
        if (z) {
            this.tkw.setEnabled(false);
            this.tkw.setTextColor(getResources().getColor(c.uhU));
            this.tkw.setFocusable(false);
            this.tkw.setClickable(false);
            this.tkw.setBackgroundResource(e.bHc);
            setBackgroundResource(e.bBy);
            return;
        }
        this.tkw.setEnabled(false);
        this.tkw.setFocusable(false);
        this.tkw.setClickable(false);
        this.tkw.setBackgroundResource(e.bHc);
        setBackgroundResource(e.bDq);
    }

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void Og(String str) {
        this.tkx = str;
        KeyListener keyListener = this.tkw.getKeyListener();
        this.tkw.setInputType(1);
        this.tkw.setKeyListener(null);
        this.tkw.b(str, 3, false, -1);
        this.tkw.setKeyListener(keyListener);
    }
}
