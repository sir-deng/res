package com.tencent.mm.plugin.auto.a;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import java.util.HashMap;

public final class b implements ap {
    private a koa = new a();

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        x.i("MicroMsg.auto.SubCoreAuto", "onAccountPostReset");
        a.xmy.b(this.koa.knY);
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.auto.SubCoreAuto", "onAccountRelease");
        a.xmy.c(this.koa.knY);
    }
}
