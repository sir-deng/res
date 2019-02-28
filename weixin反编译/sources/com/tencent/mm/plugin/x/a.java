package com.tencent.mm.plugin.x;

import com.tencent.mm.ad.k;
import com.tencent.mm.av.b;
import com.tencent.mm.av.e;
import com.tencent.mm.av.f;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.az;
import com.tencent.mm.y.p;
import java.util.HashMap;

public final class a extends p implements com.tencent.mm.kernel.api.bucket.a, c {
    private static HashMap<Integer, d> gyG;
    private static a oWT;
    private com.tencent.mm.av.d oWU = null;
    private az oWV = null;
    private com.tencent.mm.av.c oWW = null;
    private e oWX = new e();
    private final com.tencent.mm.ad.e oWY = new com.tencent.mm.ad.e() {
        public final void a(int i, int i2, String str, k kVar) {
        }
    };

    private a() {
        super(f.class);
    }

    public static synchronized a bfR() {
        a aVar;
        synchronized (a.class) {
            if (oWT == null) {
                oWT = new a();
            }
            aVar = oWT;
        }
        return aVar;
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("NEWTIPS_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return az.gLy;
            }
        });
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        super.onAccountInitialized(cVar);
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("newtips", this.oWX);
        g.CN().a(597, this.oWY);
        bfS();
        com.tencent.mm.av.d.a(b.hJR, 1, b.hJQ, "", b.hJY);
        x.i("MicroMsg.NewTipsManager", "dancy register dynamic newtips, tipsId:%s, path:%s", Integer.valueOf(r0), r1);
    }

    public final void onAccountRelease() {
        super.onAccountRelease();
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("newtips", this.oWX);
        g.CN().b(597, this.oWY);
    }

    public static com.tencent.mm.av.d bfS() {
        g.Do().CA();
        if (bfR().oWU == null) {
            bfR().oWU = new com.tencent.mm.av.d();
        }
        return bfR().oWU;
    }

    public static az bfT() {
        g.Do().CA();
        if (bfR().oWV == null) {
            a bfR = bfR();
            g.Dr();
            bfR.oWV = new az(g.Dq().gRU);
        }
        return bfR().oWV;
    }

    public static com.tencent.mm.av.c bfU() {
        g.Do().CA();
        if (bfR().oWW == null) {
            bfR().oWW = new com.tencent.mm.av.c();
        }
        return bfR().oWW;
    }

    public final HashMap<Integer, d> collectDatabaseFactory() {
        return gyG;
    }
}
