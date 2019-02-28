package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.d.m;

public final class a extends m {
    private a sGs;

    public interface a {
        void WX();
    }

    public a(a aVar) {
        super(2, null);
        this.sGs = aVar;
    }

    public final void onClick(View view) {
        if (this.sGs != null) {
            this.sGs.WX();
        }
    }
}
