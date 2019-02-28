package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.bt.a;
import com.tencent.mm.y.c;
import java.util.HashMap;

public final class h implements ap {
    private static HashMap<Integer, d> gyG;
    private a oqA = new a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            String a = n.a(aVar.hoa.vNO);
            x.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:" + a);
            h.aZk().EL(a);
            h.aZk().aZf();
            h.aZk();
            c.dH(bi.Wy());
        }
    };
    private b osC;
    private c osD;
    private i osE = new i();
    private g osF = new g();

    private static h aZi() {
        as.Hg();
        h hVar = (h) bq.ib("plugin.masssend");
        if (hVar != null) {
            return hVar;
        }
        Object hVar2 = new h();
        as.Hg().a("plugin.favorite", hVar2);
        return hVar2;
    }

    public static b aZj() {
        g.Do().CA();
        if (aZi().osC == null) {
            h aZi = aZi();
            as.Hm();
            aZi.osC = new b(c.Fc());
        }
        return aZi().osC;
    }

    public static c aZk() {
        if (aZi().osD == null) {
            aZi().osD = new c();
        }
        return aZi().osD;
    }

    public final void onAccountRelease() {
        as.getSysCmdMsgExtension().b("masssendapp", this.oqA, false);
        com.tencent.mm.sdk.b.a.xmy.c(this.osE);
        com.tencent.mm.sdk.b.a.xmy.c(this.osF);
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("MASSENDINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return b.gLy;
            }
        });
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        as.getSysCmdMsgExtension().a("masssendapp", this.oqA, false);
        com.tencent.mm.sdk.b.a.xmy.b(this.osE);
        com.tencent.mm.sdk.b.a.xmy.b(this.osF);
    }

    public final void bt(boolean z) {
    }
}
