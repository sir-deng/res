package com.tencent.mm.plugin.label;

import com.tencent.mm.ar.a;
import com.tencent.mm.ar.b;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.c;
import java.util.HashMap;

public class e implements ap {
    private static HashMap<Integer, d> gyG;
    private ac nUh;
    private d nUi = new d();

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return ac.gLy;
            }
        });
        gyG.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return ab.gLy;
            }
        });
    }

    private static e aVB() {
        as.Hg();
        e eVar = (e) bq.ib("plugin.label");
        if (eVar == null) {
            synchronized (e.class) {
                if (eVar == null) {
                    eVar = new e();
                    as.Hg().a("plugin.label", eVar);
                }
            }
        }
        return eVar;
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        a bVar = new b();
        com.tencent.mm.plugin.label.a.a.nUj = bVar;
        b.hGj = bVar;
        com.tencent.mm.sdk.b.a.xmy.b(this.nUi);
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.plugin.label.a.a.nUj = null;
        com.tencent.mm.sdk.b.a.xmy.c(this.nUi);
    }

    public static ac aVC() {
        g.Do().CA();
        if (aVB().nUh == null) {
            e aVB = aVB();
            as.Hm();
            aVB.nUh = new ac(c.Fc());
        }
        return aVB().nUh;
    }
}
