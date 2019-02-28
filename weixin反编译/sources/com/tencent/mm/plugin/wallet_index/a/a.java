package com.tencent.mm.plugin.wallet_index.a;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.plugin.wallet_index.c.h;
import com.tencent.mm.y.ap;
import java.util.HashMap;

public class a implements ap {
    private h tgD = new h();

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }

    public final void bs(boolean z) {
        com.tencent.mm.sdk.b.a.xmy.b(this.tgD.tgX);
        com.tencent.mm.sdk.b.a.xmy.b(this.tgD.tgY);
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xmy.c(this.tgD.tgX);
        com.tencent.mm.sdk.b.a.xmy.c(this.tgD.tgY);
    }
}
