package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.a.hn;
import com.tencent.mm.f.a.in;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.q.d;
import com.tencent.mm.pluginsdk.q.k;
import com.tencent.mm.pluginsdk.q.z;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

public class c implements k, ap {
    private com.tencent.mm.sdk.b.c gAp = new com.tencent.mm.sdk.b.c<hn>() {
        {
            this.xmG = hn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            hn hnVar = (hn) bVar;
            if (hnVar != null && (hnVar instanceof hn)) {
                hnVar.fyK.url = c.this.bEH();
            }
            return false;
        }
    };
    private a sca = null;
    private b scb = null;
    Map<String, Integer> scc = new HashMap();

    public final /* synthetic */ d bEI() {
        return bED();
    }

    public c() {
        x.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + bi.chl());
    }

    public static c bEy() {
        c cVar = (c) z.vjl;
        if (cVar != null) {
            return cVar;
        }
        Object cVar2 = new c();
        z.vjl = cVar2;
        return cVar2;
    }

    public final HashMap<Integer, h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        x.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
        if (this.sca == null) {
            this.sca = new a();
        }
        as.getSysCmdMsgExtension().a("jd", this.sca, true);
        a.xmy.b(this.gAp);
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
        if (this.sca != null) {
            a.xmy.c(this.sca.sbJ);
            as.getSysCmdMsgExtension().b("jd", this.sca, true);
        }
        this.scc.clear();
        this.sca = null;
        a.xmy.c(this.gAp);
    }

    public final boolean bEz() {
        as.Hm();
        return "1".equals((String) com.tencent.mm.y.c.Db().get(327939, (Object) ""));
    }

    public final boolean bEA() {
        as.Hm();
        return "1".equals((String) com.tencent.mm.y.c.Db().get(327938, (Object) ""));
    }

    public final void bEB() {
        as.Hm();
        com.tencent.mm.y.c.Db().set(327938, "");
    }

    public final void bEC() {
        as.Hm();
        com.tencent.mm.y.c.Db().set(327939, "");
    }

    public final b bED() {
        if (this.scb == null) {
            this.scb = b.bEq();
        }
        return this.scb;
    }

    public static void b(b bVar) {
        g.Do().CA();
        c bEy = bEy();
        if (bEy.scb == null) {
            bEy.scb = b.bEq();
        }
        x.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", bEy.scb.bEs(), bVar.bEs());
        if (bVar.a(bEy.scb)) {
            if (!bi.oN(bVar.sbQ) || bVar.sbP) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(327939, "1");
            }
            if (bVar.sbO) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(327938, "1");
            } else {
                as.Hm();
                com.tencent.mm.y.c.Db().set(327938, "");
            }
            bEy.scb = bVar;
            as.Hm();
            com.tencent.mm.y.c.Db().set(327942, bVar.fEK);
            bEy.bEE();
            return;
        }
        x.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
    }

    private void bEE() {
        new ag(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                a.xmy.m(new in());
            }
        });
    }

    public final void bEF() {
        if (!as.Hp()) {
            return;
        }
        if (bEy().bEz() || bEy().bEA()) {
            b bED = bEy().bED();
            if ((!bi.oN(bED.sbQ) || bED.sbP) && bED.bEr()) {
                x.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
                bEy().bEB();
                bEy().bEC();
                bEy().bEE();
            }
        }
    }

    public static String cn(String str, int i) {
        if (-1 != str.indexOf(35)) {
            return str;
        }
        if (-1 == str.indexOf(63)) {
            return str + "?wc_scene=" + i;
        }
        return str + "&wc_scene=" + i;
    }

    public static boolean bEG() {
        return (bi.oN(com.tencent.mm.j.g.Af().getValue("JDEntranceConfigName")) || bi.oN(com.tencent.mm.j.g.Af().getValue("JDEntranceConfigIconUrl")) || bi.oN(com.tencent.mm.j.g.Af().getValue("JDEntranceConfigJumpUrl"))) ? false : true;
    }

    public final String bEH() {
        int i = 1;
        String value = com.tencent.mm.j.g.Af().getValue("JDEntranceConfigJumpUrl");
        if (bi.oN(value)) {
            return null;
        }
        int i2;
        int i3;
        b bED = bED();
        if (bEz()) {
            if (!bED.bEr() && TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(bED.sbM) && !bi.oN(bED.jumpUrl)) {
                x.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", bED.jumpUrl);
                value = bED.jumpUrl;
                i2 = 6;
                if (bED.sbS < System.currentTimeMillis() / 1000) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                if (i3 != 0) {
                    i = 0;
                    if (i == 0) {
                        value = bED.jumpUrl;
                        i2 = 3;
                    }
                }
                return cn(value, i2);
            } else if (bED.sbP) {
                i2 = 2;
                if ("2".equals(bED.sbM) && !bi.oN(bED.jumpUrl)) {
                    if (bED.sbS < System.currentTimeMillis() / 1000) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        if (bED.sbT == 0 || bED.sbT >= System.currentTimeMillis() / 1000) {
                            i = 0;
                        }
                        if (i == 0) {
                            value = bED.jumpUrl;
                            i2 = 3;
                        }
                    }
                }
                return cn(value, i2);
            }
        }
        i2 = 1;
        if (bED.sbS < System.currentTimeMillis() / 1000) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            i = 0;
            if (i == 0) {
                value = bED.jumpUrl;
                i2 = 3;
            }
        }
        return cn(value, i2);
    }
}
