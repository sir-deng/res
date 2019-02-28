package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.b.e;
import com.tencent.mm.plugin.appbrand.f;

final class i extends e {
    private f jSu;

    i(Activity activity, f fVar) {
        super(activity);
        this.jSu = fVar;
    }

    protected final void aaN() {
        com.tencent.mm.plugin.appbrand.e YR = this.jSu.YR();
        if (YR != null) {
            YR.itj.iKb.jC(10);
        }
    }
}
