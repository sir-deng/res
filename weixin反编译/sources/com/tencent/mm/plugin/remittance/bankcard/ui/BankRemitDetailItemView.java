package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.d.i;

public class BankRemitDetailItemView extends LinearLayout {
    private TextView jOY;
    private TextView lpZ;
    private boolean pOi;

    public BankRemitDetailItemView(Context context) {
        this(context, false);
    }

    public BankRemitDetailItemView(Context context, boolean z) {
        super(context);
        this.pOi = false;
        this.pOi = z;
        init();
    }

    public BankRemitDetailItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pOi = false;
        init();
    }

    public BankRemitDetailItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pOi = false;
        init();
    }

    private void init() {
        if (this.pOi) {
            inflate(getContext(), g.uHA, this);
        } else {
            inflate(getContext(), g.uHz, this);
        }
        this.jOY = (TextView) findViewById(f.umy);
        this.lpZ = (TextView) findViewById(f.umx);
    }

    public final void a(String str, CharSequence charSequence, boolean z) {
        this.jOY.setText(str);
        if (z) {
            this.lpZ.setText(i.b(getContext(), charSequence, this.lpZ.getTextSize()));
        } else {
            this.lpZ.setText(charSequence);
        }
    }

    public final void c(int i, CharSequence charSequence) {
        a(getContext().getString(i), charSequence, false);
    }
}
