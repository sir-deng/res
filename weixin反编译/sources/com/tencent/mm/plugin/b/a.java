package com.tencent.mm.plugin.b;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.y.a.d;
import com.tencent.mm.y.a.g;
import com.tencent.mm.y.p;

public final class a extends p implements c {
    private static a imT;
    private d imU = new d();
    private com.tencent.mm.y.a.a imV = new com.tencent.mm.y.a.a();

    private a() {
        super(g.class);
    }

    public static synchronized a Xu() {
        a aVar;
        synchronized (a.class) {
            if (imT == null) {
                imT = new a();
            }
            aVar = imT;
        }
        return aVar;
    }

    public final void onAccountInitialized(e.c cVar) {
        super.onAccountInitialized(cVar);
        com.tencent.mm.ad.d.c.a(Integer.valueOf(-1879048184), this.imU);
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("abtest", this.imV);
    }

    public final void onAccountRelease() {
        super.onAccountRelease();
        com.tencent.mm.ad.d.c.a(Integer.valueOf(-1879048184), this.imU);
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("abtest", this.imV);
    }
}
