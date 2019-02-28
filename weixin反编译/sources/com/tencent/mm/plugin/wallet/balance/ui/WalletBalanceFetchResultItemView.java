package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public class WalletBalanceFetchResultItemView extends LinearLayout {
    private TextView jOY;
    private TextView lpZ;
    private boolean pOi;

    public WalletBalanceFetchResultItemView(Context context) {
        this(context, false);
    }

    public WalletBalanceFetchResultItemView(Context context, boolean z) {
        super(context);
        this.pOi = false;
        this.pOi = z;
        init();
    }

    public WalletBalanceFetchResultItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pOi = false;
        init();
    }

    public WalletBalanceFetchResultItemView(Context context, AttributeSet attributeSet, int i) {
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

    public final void c(int i, CharSequence charSequence) {
        this.jOY.setText(getContext().getString(i));
        this.lpZ.setText(charSequence);
    }
}
