package com.tencent.mm.y.c;

import android.annotation.SuppressLint;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.e;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.b;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.bt.a;
import com.tencent.mm.y.p;
import java.util.HashMap;
import java.util.Map;

public class c implements ap {
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, d> gyG;
    private com.tencent.mm.storage.d hkh;
    private b hki;
    private a hkj = new a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            String a = n.a(aVar.hoa.vNO);
            x.d("MicroMsg.SubCoreNewABTest", "Message content(abtest): %s" + a);
            a.a ip = a.ip(a);
            if (ip != null) {
                c.IL().i(ip.hkf, 1);
                c.IM().i(ip.hkg, 2);
            }
        }
    };
    private com.tencent.mm.sdk.b.c hkk = new com.tencent.mm.sdk.b.c<e>() {
        {
            this.xmG = e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((e) bVar).fnJ.fnK) {
                b.IF();
            }
            return true;
        }
    };
    private j.a hkl = new j.a() {
        public final void a(String str, l lVar) {
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                com.tencent.mm.storage.c fp = c.IL().fp("100205");
                if (fp.isValid()) {
                    Map civ = fp.civ();
                    int i = bi.getInt((String) civ.get("main_thread_watch_enable"), 65535);
                    int i2 = bi.getInt((String) civ.get("main_thread_watch_timeout"), 5000);
                    int i3 = bi.getInt((String) civ.get("main_thread_watch_log_loop"), 0);
                    ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("main_thread_watch_enable", i).putInt("main_thread_watch_timeout", i2).putInt("main_thread_watch_log_loop", i3).putInt("main_thread_watch_report", bi.getInt((String) civ.get("main_thread_watch_report"), 0)).commit();
                    x.i("MicroMsg.SubCoreNewABTest", "summeranr MM_MAIN_THREAD_WATCH enable[%d] timeout[%d], loop[%d] report[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(r0));
                }
                c.IN();
            }
        }
    };
    private com.tencent.mm.vending.b.b hkm = null;
    private final com.tencent.mm.plugin.auth.a.a hkn = new com.tencent.mm.plugin.auth.a.a() {
        public final void a(f fVar, g gVar, boolean z) {
            if (z) {
                if (fVar != null && (fVar instanceof i.a) && fVar.vHV == 12) {
                    b.IG();
                }
            } else if (fVar != null && fVar.vHV == 16) {
                b.IG();
            }
        }

        public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
        }
    };

    static /* synthetic */ void IN() {
        com.tencent.mm.storage.c fp = IL().fp("100229");
        if (fp.isValid()) {
            Map civ = fp.civ();
            int i = bi.getInt((String) civ.get("UseSvrTime"), 0);
            ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("client_server_diff_time_enable", i).putInt("client_server_diff_time_interval", bi.getInt((String) civ.get("MinDiffTime"), 0)).commit();
            x.i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time enable[%d] diffTime[%d]", Integer.valueOf(i), Integer.valueOf(r0));
            return;
        }
        ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().remove("client_server_diff_time_enable").remove("client_server_diff_time_interval").commit();
        x.i("MicroMsg.SubCoreNewABTest", "[oneliang] client server diff time abtest is not valid, then delete data");
    }

    private static synchronized c IK() {
        c cVar;
        synchronized (c.class) {
            cVar = (c) p.s(c.class);
        }
        return cVar;
    }

    public static com.tencent.mm.storage.d IL() {
        com.tencent.mm.kernel.g.Do().CA();
        if (IK().hkh == null) {
            IK().hkh = new com.tencent.mm.storage.d(com.tencent.mm.kernel.g.Dq().gRU);
        }
        return IK().hkh;
    }

    public static b IM() {
        com.tencent.mm.kernel.g.Do().CA();
        if (IK().hki == null) {
            IK().hki = new b(com.tencent.mm.kernel.g.Dq().gRU);
        }
        return IK().hki;
    }

    public final void bs(boolean z) {
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("newabtest", this.hkj, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("newabtestinfo", this.hkj, true);
        com.tencent.mm.sdk.b.a.xmy.b(this.hkk);
        IL().c(this.hkl);
        this.hkm = ((com.tencent.mm.plugin.auth.a.b) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.hkn);
    }

    public final void onAccountRelease() {
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("newabtest", this.hkj, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("newabtestinfo", this.hkj, true);
        com.tencent.mm.sdk.b.a.xmy.c(this.hkk);
        IL().j(this.hkl);
        if (this.hkm != null) {
            this.hkm.dead();
            this.hkm = null;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("NEW_ABTEST_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.storage.d.gLy;
            }
        });
        gyG.put(Integer.valueOf("NEW_ABTEST_INFO_TABLE".hashCode()), new d() {
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

    public final void bt(boolean z) {
    }
}
