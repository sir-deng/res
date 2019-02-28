package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.q.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bg;
import com.tencent.mm.y.bh;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.c;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public final class g implements ap {
    private static HashMap<Integer, d> gyG;
    private bh pGk;
    private c pGl = new c();
    private a pGm = new a();
    private d pGn = new d();
    private f pGo = new f();

    public interface a {
        void bmS();
    }

    private static g bmU() {
        as.Hg();
        g gVar = (g) bq.ib("plugin.readerapp");
        if (gVar != null) {
            return gVar;
        }
        Object gVar2 = new g();
        as.Hg().a("plugin.readerapp", gVar2);
        return gVar2;
    }

    public static bh bmV() {
        com.tencent.mm.kernel.g.Do().CA();
        if (bmU().pGk == null) {
            g bmU = bmU();
            as.Hm();
            bmU.pGk = new bh(c.Fc());
        }
        return bmU().pGk;
    }

    public final void onAccountRelease() {
        com.tencent.mm.ad.d.c.b(Integer.valueOf(12399999), this.pGl);
        com.tencent.mm.sdk.b.a.xmy.c(this.pGm);
        com.tencent.mm.sdk.b.a.xmy.c(this.pGn);
        com.tencent.mm.sdk.b.a.xmy.c(this.pGo);
        i.a(e.pGj);
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("READERAPPINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return bh.gLy;
            }
        });
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
        if ((SQLiteGlobal.journalSizeLimit & i) != 0) {
            a(null);
        }
        if ((262144 & i) != 0) {
            b(null);
        }
    }

    public static void a(a aVar) {
        bmV().gZ(20);
        as.Hm();
        c.Fk().XE("newsapp");
        a(20, aVar);
    }

    public static void b(a aVar) {
        bmV().gZ(11);
        as.Hm();
        c.Fk().XE("blogapp");
        a(11, aVar);
    }

    public static void ea(long j) {
        g(bmV().a(j, 20), 20);
    }

    public static void v(long j, int i) {
        g(bmV().b(j, i), i);
    }

    private static void g(List<bg> list, int i) {
        if (list != null && !list.isEmpty()) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    if (i3 == 0) {
                        bi.deleteFile(t.x(((bg) list.get(i3)).HR(), i, "@T"));
                    } else {
                        bi.deleteFile(t.x(((bg) list.get(i3)).HR(), i, "@S"));
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private static void c(final a aVar) {
        ah.y(new Runnable() {
            public final void run() {
                if (aVar != null) {
                    aVar.bmS();
                }
            }
        });
    }

    private static void a(final int i, final a aVar) {
        if (as.Hp()) {
            as.Dt().F(new Runnable() {
                public final void run() {
                    int i = 0;
                    as.Hm();
                    File file = new File(c.Fp());
                    if (file.exists() && file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length <= 0) {
                            g.c(aVar);
                            return;
                        }
                        String format = String.format("reader_%d_", new Object[]{Integer.valueOf(i)});
                        String format2 = String.format("ReaderApp_%d", new Object[]{Integer.valueOf(i)});
                        while (i < listFiles.length) {
                            if (listFiles[i].getName().startsWith(format)) {
                                listFiles[i].delete();
                            }
                            if (listFiles[i].getName().startsWith(format2)) {
                                listFiles[i].delete();
                            }
                            i++;
                        }
                        g.c(aVar);
                        return;
                    }
                    g.c(aVar);
                }

                public final String toString() {
                    return super.toString() + "|deleteAllPic";
                }
            });
        } else {
            c(aVar);
        }
    }

    public final void bs(boolean z) {
        com.tencent.mm.ad.d.c.a(Integer.valueOf(12399999), this.pGl);
        as.Dt().F(new Runnable() {
            public final void run() {
                if (as.Hp()) {
                    as.Hm();
                    bi.g(c.Fp(), "ReaderApp_", 604800000);
                }
            }

            public final String toString() {
                return super.toString() + "|onAccountPostReset";
            }
        });
        com.tencent.mm.sdk.b.a.xmy.b(this.pGm);
        com.tencent.mm.sdk.b.a.xmy.b(this.pGn);
        com.tencent.mm.sdk.b.a.xmy.b(this.pGo);
        i.b(e.pGj);
    }

    public final void bt(boolean z) {
    }
}
