package com.tencent.mm.am;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.subapp.a;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.c;
import java.util.HashMap;

public class d implements ap {
    private static HashMap<Integer, com.tencent.mm.bx.h.d> gyG;
    private b hAy;
    private c hAz;

    private static d Pd() {
        as.Hg();
        a aVar = (a) bq.ib("plugin.subapp");
        d dVar = aVar == null ? null : (d) aVar.MN(d.class.getName());
        if (dVar != null) {
            return dVar;
        }
        ap dVar2 = new d();
        aVar.b(d.class.getName(), dVar2);
        return dVar2;
    }

    public static b Pe() {
        g.Do().CA();
        if (Pd().hAy == null) {
            d Pd = Pd();
            as.Hm();
            Pd.hAy = new b(c.Fc());
        }
        return Pd().hAy;
    }

    public final void onAccountRelease() {
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("GETCONTACTINFO_TABLE".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return b.gLy;
            }
        });
    }

    public final HashMap<Integer, com.tencent.mm.bx.h.d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        if (this.hAz == null) {
            this.hAz = new c();
        }
        ak.a.hhv = this.hAz;
        x.i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", this.hAz);
        g.a(com.tencent.mm.pluginsdk.g.class, new com.tencent.mm.pluginsdk.ui.applet.c());
        g.a(i.class, new f());
    }

    public final void bt(boolean z) {
    }
}
