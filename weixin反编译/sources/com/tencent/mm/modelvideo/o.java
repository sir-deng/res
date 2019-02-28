package com.tencent.mm.modelvideo;

import com.tencent.mm.ad.d.c;
import com.tencent.mm.ad.e;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.b;
import com.tencent.mm.y.p;
import java.io.File;
import java.util.HashMap;

public class o implements ap {
    private static HashMap<Integer, d> gyG;
    private static ah hXi = null;
    private static ag hXj = null;
    private volatile u hXb = new u();
    private volatile s hXc;
    private volatile w hXd;
    private volatile a hXe = null;
    private volatile l hXf = null;
    private volatile k hXg = null;
    private volatile m hXh = null;
    private f hXk = null;
    private i hXl = null;

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("VIDEOINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return s.gLy;
            }
        });
        gyG.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return w.gLy;
            }
        });
        gyG.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return l.gLy;
            }
        });
    }

    public static o Ua() {
        return (o) p.s(o.class);
    }

    public static s Ub() {
        if (g.Do().CF()) {
            if (Ua().hXc == null) {
                Ua().hXc = new s(g.Dq().gRU);
            }
            return Ua().hXc;
        }
        throw new b();
    }

    public static f Uc() {
        g.Do().CA();
        if (Ua().hXk == null) {
            Ua().hXk = new f();
        }
        if ((com.tencent.mm.modelcdntran.g.MQ().htY == null ? 1 : null) != null) {
            com.tencent.mm.modelcdntran.g.MQ().htY = Ua().hXk;
        }
        return Ua().hXk;
    }

    public static i Ud() {
        g.Do().CA();
        if (Ua().hXl == null) {
            Ua().hXl = new i();
        }
        return Ua().hXl;
    }

    public static w Ue() {
        if (g.Do().CF()) {
            if (Ua().hXd == null) {
                Ua().hXd = new w(g.Dq().gRU);
            }
            return Ua().hXd;
        }
        throw new b();
    }

    public static synchronized l Uf() {
        l lVar;
        synchronized (o.class) {
            if (g.Do().CF()) {
                if (Ua().hXf == null) {
                    Ua().hXf = new l(g.Dq().gRU);
                }
                lVar = Ua().hXf;
            } else {
                throw new b();
            }
        }
        return lVar;
    }

    public static a Ug() {
        if (g.Do().CF()) {
            if (Ua().hXe == null) {
                Ua().hXe = new a();
            }
            return Ua().hXe;
        }
        throw new b();
    }

    public static m Uh() {
        if (g.Do().CF()) {
            if (Ua().hXh == null) {
                Ua().hXh = new m();
            }
            return Ua().hXh;
        }
        throw new b();
    }

    private static void Ui() {
        boolean z = false;
        if (hXj == null || hXi == null) {
            String str = "MicroMsg.SubCoreVideo";
            String str2 = "check decoder thread available fail, handler[%B] thread[%B] stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(hXj != null);
            if (hXi != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = bi.chl();
            x.w(str, str2, objArr);
            if (hXj != null) {
                hXj.removeCallbacksAndMessages(null);
            }
            if (hXi != null) {
                hXi.a(null);
            } else {
                hXi = new ah("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
            }
            hXj = new ag(hXi.oFY.getLooper());
        }
    }

    public static boolean c(Runnable runnable, long j) {
        if (runnable == null) {
            return false;
        }
        Ui();
        if (j > 0) {
            hXj.postDelayed(runnable, j);
        } else {
            hXj.post(runnable);
        }
        return true;
    }

    public static boolean k(Runnable runnable) {
        if (runnable == null) {
            return true;
        }
        Ui();
        if (hXj == null) {
            x.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
            return false;
        }
        hXj.removeCallbacks(runnable);
        return true;
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreVideo", "%d onAccountRelease ", Integer.valueOf(hashCode()));
        try {
            if (Ua().hXe != null) {
                e eVar = Ua().hXe;
                eVar.fmn = 0;
                if (eVar.hYf != null) {
                    g.CN().c(eVar.hYf);
                }
                if (eVar.hYg != null) {
                    g.CN().c(eVar.hYg);
                }
                g.CN().b((int) com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX, eVar);
                g.CN().b(150, eVar);
            }
            if (Ua().hXh != null) {
                m mVar = Ua().hXh;
                mVar.fmn = 0;
                x.i("MicroMsg.SightMassSendService", "stop, cur cdn client id %s", mVar.hWF);
                if (!bi.oN(mVar.hWF)) {
                    com.tencent.mm.modelcdntran.g.MP().kK(mVar.hWF);
                }
            }
            if (Ua().hXl != null) {
                i iVar = Ua().hXl;
                iVar.stopDownload();
                iVar.hWp.clear();
            }
            if (Ua().hXk != null) {
                g.CN().b(379, Ua().hXk);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreVideo", e, "", new Object[0]);
        }
        c.b(Integer.valueOf(43), this.hXb);
        c.b(Integer.valueOf(44), this.hXb);
        c.b(Integer.valueOf(62), this.hXb);
        if (hXj != null) {
            hXj.removeCallbacksAndMessages(null);
        }
        try {
            a Ug = Ug();
            x.i("MicroMsg.VideoService", "quitVideoSendThread: %s", Ug.hXZ);
            if (Ug.hXZ != null) {
                try {
                    Ug.hXZ.quit();
                    Ug.hYb = false;
                    Ug.hYa = null;
                    Ug.hXZ = null;
                } catch (Exception e2) {
                    x.e("MicroMsg.VideoService", "quitVideoSendThread error: %s", e2.getMessage());
                }
            }
        } catch (Exception e22) {
            x.e("MicroMsg.SubCoreVideo", "onAccountRelease, quitVideoSendThread error: %s", e22.getMessage());
        }
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        x.i("MicroMsg.SubCoreVideo", "%d onAccountPostReset ", Integer.valueOf(hashCode()));
        c.a(Integer.valueOf(43), this.hXb);
        c.a(Integer.valueOf(44), this.hXb);
        c.a(Integer.valueOf(62), this.hXb);
        if (hXj != null) {
            hXj.removeCallbacksAndMessages(null);
        }
        g.Dt().F(new Runnable() {
            public final void run() {
                if (g.Do().CF()) {
                    s Ub = o.Ub();
                    x.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", "UPDATE videoinfo2 SET status = 198, lastmodifytime = " + (System.currentTimeMillis() / 1000) + " WHERE masssendid > 0  AND status" + " = 200");
                    Ub.hiZ.fD("videoinfo2", r1);
                    o.Uf().gLA.fD("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
                    l Uf = o.Uf();
                    if (1209600000 <= 0) {
                        x.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
                        Uf.gLA.fD("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
                    } else {
                        x.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", Long.valueOf(bi.Wy() - 1209600000));
                        Uf.gLA.fD("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < " + r2);
                    }
                    for (j jVar : o.Uf().TW()) {
                        x.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", jVar.field_fileName);
                        com.tencent.mm.loader.stub.b.deleteFile(k.no(jVar.field_fileName));
                        com.tencent.mm.loader.stub.b.deleteFile(k.np(jVar.field_fileName));
                    }
                }
            }
        });
        File file = new File(k.TV());
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
    }

    public static String getAccVideoPath() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("video/").toString();
    }

    public final void bt(boolean z) {
    }
}
