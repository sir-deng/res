package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

public class d implements OnClickListener {
    private long jNZ = 0;
    private OnClickListener pMx;

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.jNZ >= 500) {
            this.pMx.onClick(view);
            this.jNZ = currentTimeMillis;
        }
    }
}
