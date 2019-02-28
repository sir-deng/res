package com.tencent.mm.plugin.record.b;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.me;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class n implements ap {
    private static HashMap<Integer, d> gyG;
    private k pLj = null;
    private d pLk = null;
    private l pLl = new l();
    private c pLm = new c<me>() {
        {
            this.xmG = me.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            me meVar = (me) bVar;
            String str = meVar.fEF.fDn;
            long j = meVar.fEF.fqB;
            com.tencent.mm.protocal.b.a.c IP = h.IP(str);
            str = "";
            Iterator it = IP.hfI.iterator();
            while (true) {
                String str2 = str;
                if (it.hasNext()) {
                    str = str2 + h.c((uz) it.next(), j) + ":";
                } else {
                    meVar.fEG.fEH = str2;
                    return true;
                }
            }
        }
    };

    private static n bnx() {
        as.Hg();
        n nVar = (n) bq.ib("plugin.record");
        if (nVar != null) {
            return nVar;
        }
        Object nVar2 = new n();
        as.Hg().a("plugin.record", nVar2);
        return nVar2;
    }

    public static e bny() {
        return ((a) g.k(a.class)).getRecordMsgInfoStorage();
    }

    public static com.tencent.mm.plugin.record.a.d getRecordMsgCDNStorage() {
        return ((a) g.k(a.class)).getRecordMsgCDNStorage();
    }

    public static k bnz() {
        g.Do().CA();
        if (bnx().pLj == null) {
            bnx().pLj = new k();
        }
        return bnx().pLj;
    }

    public static d bnA() {
        g.Do().CA();
        if (bnx().pLk == null) {
            bnx().pLk = new d();
        }
        return bnx().pLk;
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("RECORD_MSG_INFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return e.gLy;
            }
        });
        gyG.put(Integer.valueOf("RECORD_MSG_CDN_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.record.a.d.gLy;
            }
        });
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        x.d("MicroMsg.SubCoreRecordMsg", "on account post reset");
        com.tencent.mm.sdk.b.a.xmy.b(this.pLl);
        com.tencent.mm.sdk.b.a.xmy.b(this.pLm);
        as.Hm();
        File file = new File(com.tencent.mm.y.c.FD());
        if (!file.exists() || !file.isDirectory()) {
            x.d("MicroMsg.SubCoreRecordMsg", "record stg dir[%s] not exsit, create it");
            file.mkdirs();
        }
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        x.d("MicroMsg.SubCoreRecordMsg", "on account post release");
        com.tencent.mm.sdk.b.a.xmy.c(this.pLl);
        com.tencent.mm.sdk.b.a.xmy.c(this.pLm);
        com.tencent.mm.ad.e eVar = bnx().pLj;
        if (eVar != null) {
            eVar.finish();
            as.CN().b(632, eVar);
            getRecordMsgCDNStorage().b(eVar);
        }
        c cVar = bnx().pLk;
        if (cVar != null) {
            cVar.finish();
        }
    }
}
