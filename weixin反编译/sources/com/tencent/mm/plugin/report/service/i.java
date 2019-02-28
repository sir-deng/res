package com.tencent.mm.plugin.report.service;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.p;
import java.util.HashMap;

public class i implements ap {
    private static HashMap<Integer, d> kNl;
    private a kNn;
    private c pXb = new c<l>() {
        {
            this.xmG = l.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((l) bVar).foa.fob && !g.Do().CF()) {
                x.i("MicroMsg.SubCoreReport", "mOnForegroundListener: account not ready");
            }
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        kNl = hashMap;
        hashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.report.a.b.gLy;
            }
        });
    }

    public final void onAccountRelease() {
        if (boW() != null) {
            i boW = boW();
            if (boW.kNn != null) {
                boW.kNn.iY(boW.hashCode());
                boW.kNn = null;
            }
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.pXb);
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.kNn = com.tencent.mm.platformtools.g.a(hashCode(), g.Dq().cachePath + "CommonOneMicroMsg.db", kNl, false);
        x.i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), bi.chl());
        com.tencent.mm.sdk.b.a.xmy.b(this.pXb);
        g.Dr();
        g.Dt().F(new Runnable() {
            public final void run() {
                if (g.Do().CF()) {
                    bi.g(g.Dq().cachePath + "logcat/", "temp_", 10800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
    }

    public final void bt(boolean z) {
    }

    private static i boW() {
        return (i) p.s(i.class);
    }
}
