package com.tencent.mm.plugin.multitalk.a;

import android.util.Base64;
import com.tencent.mm.ad.e;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.multitalk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.b;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.q;
import java.util.HashMap;
import java.util.Map;

public final class o implements ap {
    private static HashMap<Integer, d> gyG;
    private com.tencent.mm.y.bw.a mPo = new com.tencent.mm.y.bw.a() {
        public final boolean Il() {
            x.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
            if (o.this.oNa != null) {
                o.this.oNa.aTG();
                if (o.this.oNa.oLN != null) {
                    x.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", i.h(o.this.oNa.oLN));
                }
            }
            return true;
        }
    };
    private c oMZ;
    private e oNa;
    private l oNb;
    private h oNc;
    private a oNd;
    private g oNe;
    private com.tencent.mm.plugin.multitalk.b.a oNf;
    private c oNg;
    private f oNh;

    class a implements com.tencent.mm.y.bt.a {
        a() {
        }

        public final void a(com.tencent.mm.ad.d.a aVar) {
            f bdE = o.bdE();
            String a = n.a(aVar.hoa.vNO);
            Map y = bj.y(a, "sysmsg");
            if (((String) y.get(".sysmsg.multivoip.notfriendnotifydata")) != null) {
                x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive notfriendnotifydata msg:" + a);
                return;
            }
            String str = (String) y.get(".sysmsg.multivoip.notifydata");
            if (str != null) {
                byte[] decode = Base64.decode(bi.aD(str, "").getBytes(), 0);
                x.i("MicroMsg.SubCoreMultiTalk.MultiTalkMsgRecevie", "receive " + n.a(aVar.hoa.vNO) + " buffer len " + decode.length);
                o.bdA().oLv.bg(bi.e((Integer) as.Hk().get(1)), q.FY());
                o.bdA().oLv.bH(decode);
                return;
            }
            str = (String) y.get(".sysmsg.multivoip.banner");
            if (str != null) {
                bdE.a(str, aVar);
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("MULTITALKINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.multitalk.b.a.gLy;
            }
        });
        gyG.put(Integer.valueOf("MULTITALKMEMBER_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return c.gLy;
            }
        });
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    private static o bdw() {
        as.Hg();
        o oVar = (o) bq.ib("plugin.multitalk");
        if (oVar != null) {
            return oVar;
        }
        Object oVar2 = new o();
        as.Hg().a("plugin.multitalk", oVar2);
        return oVar2;
    }

    public static com.tencent.mm.plugin.multitalk.b.a bdx() {
        as.Hm();
        if (com.tencent.mm.y.c.Cn() == 0) {
            throw new b();
        }
        if (bdw().oNf == null) {
            o bdw = bdw();
            as.Hm();
            bdw.oNf = new com.tencent.mm.plugin.multitalk.b.a(com.tencent.mm.y.c.Fc());
        }
        return bdw().oNf;
    }

    public static c bdy() {
        as.Hm();
        if (com.tencent.mm.y.c.Cn() == 0) {
            throw new b();
        }
        if (bdw().oNg == null) {
            o bdw = bdw();
            as.Hm();
            bdw.oNg = new c(com.tencent.mm.y.c.Fc());
        }
        return bdw().oNg;
    }

    public static h bdz() {
        g.Do().CA();
        if (bdw().oNc == null) {
            bdw().oNc = new h();
        }
        return bdw().oNc;
    }

    public static c bdA() {
        g.Do().CA();
        if (bdw().oMZ == null) {
            bdw().oMZ = new c();
        }
        return bdw().oMZ;
    }

    public static e bdB() {
        g.Do().CA();
        if (bdw().oNa == null) {
            bdw().oNa = new e();
        }
        return bdw().oNa;
    }

    public static l bdC() {
        g.Do().CA();
        if (bdw().oNb == null) {
            bdw().oNb = new l();
        }
        return bdw().oNb;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        this.oMZ = new c();
        this.oNd = new a();
        as.getSysCmdMsgExtension().a("multivoip", this.oNd, true);
        as.Ds().a(this.mPo);
        com.tencent.mm.pluginsdk.q.a.vjf = bdD();
        bdD().bdp();
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        if (this.oMZ != null) {
            e eVar = this.oMZ;
            as.CN().b(1918, eVar);
            as.CN().b(1919, eVar);
            as.CN().b(1927, eVar);
            as.CN().b(1928, eVar);
            as.CN().b(1929, eVar);
            as.CN().b(1931, eVar);
            as.CN().b(1932, eVar);
            as.CN().b(1933, eVar);
            as.CN().b(1935, eVar);
            as.CN().b(1937, eVar);
            as.CN().b(1938, eVar);
            as.CN().b(1939, eVar);
            this.oMZ = null;
        }
        if (this.oNa != null) {
            e eVar2 = this.oNa;
            ad.getContext().unregisterReceiver(eVar2.oMc);
            com.tencent.mm.sdk.b.a.xmy.c(eVar2.oMd);
            eVar2.c(false, false, false);
            this.oNa = null;
        }
        if (this.oNb != null) {
            this.oNb.bdv();
            this.oNb = null;
        }
        if (this.oNc != null) {
            this.oNc.reset();
            this.oNc = null;
        }
        as.getSysCmdMsgExtension().b("multivoip", this.oNd, true);
        as.Ds().b(this.mPo);
    }

    public static g bdD() {
        if (bdw().oNe == null) {
            bdw().oNe = new g();
        }
        return bdw().oNe;
    }

    public static f bdE() {
        if (bdw().oNh == null) {
            bdw().oNh = new f();
        }
        return bdw().oNh;
    }
}
