package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.d.g;
import com.tencent.mm.y.as;

public final class b {
    private static b nMd;
    private g nMe;

    public static b aUJ() {
        if (nMd == null) {
            nMd = new b();
        }
        return nMd;
    }

    public final void gf(boolean z) {
        as.CN().c(this.nMe);
        this.nMe = null;
        if (z) {
            this.nMe = new g(1);
        } else {
            this.nMe = new g(0);
        }
        as.CN().a(this.nMe, 0);
    }
}
