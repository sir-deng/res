package com.tencent.mm.plugin.product.a;

import com.tencent.mm.bx.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.p;
import java.util.HashMap;

public class a implements ap {
    private c pjo = null;
    private d pjp = null;
    private com.tencent.mm.plugin.product.b.a pjq = new com.tencent.mm.plugin.product.b.a();

    public static a bjs() {
        return (a) p.s(a.class);
    }

    public final HashMap<Integer, h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        this.pjo = null;
        com.tencent.mm.sdk.b.a.xmy.b(this.pjq);
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xmy.c(this.pjq);
    }

    public static c bjt() {
        g.Do().CA();
        if (bjs().pjo == null) {
            bjs().pjo = new c();
        }
        return bjs().pjo;
    }

    public final d bju() {
        g.Do().CA();
        if (this.pjp == null) {
            this.pjp = new d();
        }
        return this.pjp;
    }
}
