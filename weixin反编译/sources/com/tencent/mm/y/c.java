package com.tencent.mm.y;

import android.content.SharedPreferences;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.h;
import com.tencent.mm.storage.j;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.n;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.w;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c {
    public static HashMap<Integer, d> gyG;
    public bl hgk;
    public bk hgl;
    h hgm;
    com.tencent.mm.y.b.c hgn;
    com.tencent.mm.y.b.d hgo;
    j hgp;
    n hgq;
    l hgr;
    com.tencent.mm.y.b.b hgs;

    public interface a {
        void a(c cVar, boolean z);
    }

    static class b implements Runnable {
        String fFG;
        String hgu;

        public b(String str, String str2) {
            this.fFG = str;
            this.hgu = str2;
        }

        public final void run() {
            if (!bi.oN(this.fFG) && !bi.oN(this.hgu)) {
                x.d("MicroMsg.AccountStorage", "MoveDataFiles :" + this.fFG + " to :" + this.hgu);
                if (f.zl() && this.hgu.substring(0, e.bnF.length()).equals(e.bnF)) {
                    k.r(this.fFG + "image/", this.hgu + "image/", true);
                    k.r(this.fFG + "image2/", this.hgu + "image2/", true);
                    k.r(this.fFG + "video/", this.hgu + "video/", true);
                    k.r(this.fFG + "voice/", this.hgu + "voice/", true);
                    k.r(this.fFG + "voice2/", this.hgu + "voice2/", true);
                    k.r(this.fFG + "package/", this.hgu + "package/", true);
                    k.r(this.fFG + "emoji/", this.hgu + "emoji/", true);
                    k.r(this.fFG + "mailapp/", this.hgu + "mailapp/", true);
                    k.r(this.fFG + "brandicon/", this.hgu + "brandicon/", true);
                }
            }
        }
    }

    public c() {
        g.Dr();
        com.tencent.mm.kernel.e Dq = g.Dq();
        Dq.gRQ.aE(new com.tencent.mm.bx.h.a() {
            public final void Di() {
                g.Dr();
                if (g.Do().CF()) {
                    m Tn = q.Tn();
                    if (Tn != null) {
                        x.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: " + Tn);
                        long currentTimeMillis = System.currentTimeMillis();
                        Tn.hUe.lL(true);
                        x.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    }
                }
            }

            public final void Dj() {
            }

            public final void Dk() {
            }
        });
        com.tencent.mm.kernel.a.c.DA().add(new com.tencent.mm.kernel.api.b() {
            public final List<String> collectStoragePaths() {
                Object linkedList = new LinkedList();
                Collections.addAll(linkedList, new String[]{"image/shakeTranImg/", "emoji/", "locallog", "mailapp/", "mailapp/", "voice2/", "video/", "attachment/"});
                return linkedList;
            }
        });
        com.tencent.mm.kernel.a.c.DA().add(new com.tencent.mm.kernel.api.f() {
            public final void Dw() {
                as.Hl();
            }

            public final void fP(String str) {
                if (f.zl()) {
                    g.Dr();
                    if (g.Dq().gRS.equals(e.bnF)) {
                        g.Dr();
                        com.tencent.mm.sdk.f.e.post(new b(g.Dq().cachePath, str), "AccountStorage_moveDataFiles");
                    }
                }
            }
        });
    }

    public static int Cn() {
        g.Dr();
        g.Do();
        return com.tencent.mm.kernel.a.Cn();
    }

    public static String EY() {
        g.Dr();
        return g.Dq().gRS;
    }

    public static void Dd() {
        g.Dr();
        g.Dq().Dd();
    }

    public static boolean isSDCardAvailable() {
        g.Dr();
        return g.Dq().isSDCardAvailable();
    }

    public static String CX() {
        g.Dr();
        return g.Dq().CX();
    }

    public static void EZ() {
        g.Dr();
        g.Dq().ed(null);
    }

    public static void a(ao aoVar) {
        g.Dr();
        com.tencent.mm.kernel.a Do = g.Do();
        x.i("MMKernel.CoreAccount", "UserStatusChange: add %s", aoVar);
        synchronized (Do.gRf) {
            if (!Do.gRf.contains(aoVar)) {
                Do.gRf.add(aoVar);
            }
        }
    }

    public static void b(ao aoVar) {
        g.Dr();
        com.tencent.mm.kernel.a Do = g.Do();
        x.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", aoVar);
        synchronized (Do.gRf) {
            Do.gRf.remove(aoVar);
        }
    }

    public static void CB() {
        g.Dr();
        g.Do().CB();
    }

    public static boolean Fa() {
        g.Dr();
        return com.tencent.mm.kernel.a.gC(g.Do().gRd);
    }

    public static boolean gC(int i) {
        return com.tencent.mm.kernel.a.gC(i);
    }

    public static int Fb() {
        g.Dr();
        return g.Do().gRe;
    }

    public static com.tencent.mm.bx.h Fc() {
        g.Dr();
        return g.Dq().gRU;
    }

    public static com.tencent.mm.bx.h Fd() {
        g.Dr();
        return g.Dq().gRV;
    }

    public static SharedPreferences fN(String str) {
        g.Dr();
        return g.Dq().fN(str);
    }

    public static t Db() {
        g.Dr();
        return g.Dq().Db();
    }

    public static be Dc() {
        g.Dr();
        return g.Dq().Dc();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.d Fe() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fe();
    }

    public static ar Ff() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.g Fg() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fg();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.c Fh() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO();
    }

    public static o Fi() {
        return ((com.tencent.mm.af.o) g.h(com.tencent.mm.af.o.class)).Fi();
    }

    public static p Fj() {
        return ((com.tencent.mm.af.o) g.h(com.tencent.mm.af.o.class)).Fj();
    }

    public static as Fk() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fk();
    }

    public static com.tencent.mm.plugin.downloader.e.b Fl() {
        return ((com.tencent.mm.plugin.downloader.b.a) g.h(com.tencent.mm.plugin.downloader.b.a.class)).Fl();
    }

    public static at Fm() {
        return ((com.tencent.mm.plugin.r.a.a) g.h(com.tencent.mm.plugin.r.a.a.class)).Fm();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.f Fn() {
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fn();
    }

    public static ae Fo() {
        g.Dr();
        g.Do().CA();
        return ((com.tencent.mm.plugin.chatroom.b.b) g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fo();
    }

    public static String Fp() {
        return com.tencent.mm.plugin.n.c.Fp();
    }

    public static String Fq() {
        return com.tencent.mm.plugin.n.c.Fq();
    }

    public static String Fr() {
        return com.tencent.mm.plugin.ad.a.Fr();
    }

    public static String Fs() {
        return com.tencent.mm.modelvoice.q.Fs();
    }

    public static String Ft() {
        return com.tencent.mm.modelvoice.q.Ft();
    }

    public static String Fu() {
        return com.tencent.mm.plugin.record.b.Fu();
    }

    public static String Fv() {
        return u.Fv();
    }

    public static String Fw() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("emoji/").toString();
    }

    public static String Fx() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("mailapp/").toString();
    }

    public static String getAccVideoPath() {
        com.tencent.mm.modelvideo.o.Ua();
        return com.tencent.mm.modelvideo.o.getAccVideoPath();
    }

    public static String Fy() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("image/shakeTranImg/").toString();
    }

    public static String Fz() {
        return com.tencent.mm.plugin.l.a.Fz();
    }

    public static String FA() {
        return com.tencent.mm.plugin.y.a.FA();
    }

    public static String FB() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("attachment/").toString();
    }

    public static String FC() {
        return ((com.tencent.mm.af.o) g.h(com.tencent.mm.af.o.class)).FC();
    }

    public static String FD() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("record/").toString();
    }

    public static String FE() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("draft/").toString();
    }

    public static String getAccSnsPath() {
        return ((com.tencent.mm.plugin.sns.b.b) g.k(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
    }

    public static String getAccSnsTmpPath() {
        return ((com.tencent.mm.plugin.sns.b.b) g.k(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
    }

    public static String FF() {
        return com.tencent.mm.plugin.n.c.FF();
    }

    public static String FG() {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(FJ()).append("voiceremind/").toString();
    }

    public static String FH() {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(FJ()).append("wenote/").toString();
    }

    public static String CY() {
        g.Dr();
        return g.Dq().CY();
    }

    public static String CZ() {
        g.Dr();
        return g.Dq().CZ();
    }

    public static String FI() {
        g.Dr();
        return g.Dq().cachePath;
    }

    public static String FJ() {
        g.Dr();
        return g.Dq().gRT;
    }

    public final void FK() {
        StringBuilder stringBuilder = new StringBuilder("mm");
        g.Dr();
        g.Do();
        String s = com.tencent.mm.a.g.s(stringBuilder.append(com.tencent.mm.kernel.a.Cn()).toString().getBytes());
        String str = w.hbv + s + "/";
        String str2 = e.bnF + s + "/";
        String[] list = new File(str).list(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                return str.equals("EnMicroMsg.db") || str.startsWith("EnMicroMsg.dberr") || str.equals("FTS5IndexMicroMsg.db");
            }
        });
        if (list != null) {
            for (String str3 : list) {
                String str4 = str2 + str3 + ".dump";
                FileOp.deleteFile(str4);
                FileOp.x(str + str3, str4);
                x.i("MicroMsg.AccountStorage", "Exported: " + str4);
            }
        }
    }

    public static void FL() {
    }

    public static void ge(int i) {
        p.gL(i);
        if ((i & 16) != 0) {
            bb.a("medianote", null);
            as.Hm();
            Fk().XE("medianote");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return am.gLy;
            }
        });
        gyG.put(Integer.valueOf("APPBRAND_MESSAGE_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return h.gLy;
            }
        });
        gyG.put(Integer.valueOf("BackupMoveTime".hashCode()), new d() {
            public final String[] wn() {
                return j.gLy;
            }
        });
        gyG.put(Integer.valueOf("BackupTempMoveTime".hashCode()), new d() {
            public final String[] wn() {
                return n.gLy;
            }
        });
        gyG.put(Integer.valueOf("BackupRecoverMsgListDataId".hashCode()), new d() {
            public final String[] wn() {
                return l.gLy;
            }
        });
    }

    public final com.tencent.mm.y.b.c FM() {
        g.Dr();
        g.Do().CA();
        return this.hgn;
    }

    public final com.tencent.mm.y.b.d FN() {
        g.Dr();
        g.Do().CA();
        return this.hgo;
    }

    public final com.tencent.mm.y.b.b FO() {
        g.Dr();
        g.Do().CA();
        return this.hgs;
    }

    public static com.tencent.mm.storage.g FP() {
        g.Dr();
        g.Do().CA();
        return com.tencent.mm.plugin.d.a.Yf().FP();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.b FQ() {
        g.Dr();
        g.Do().CA();
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).FQ();
    }

    public final j FR() {
        g.Dr();
        g.Do().CA();
        return this.hgp;
    }

    public final n FS() {
        g.Dr();
        g.Do().CA();
        return this.hgq;
    }

    public final l FT() {
        g.Dr();
        g.Do().CA();
        return this.hgr;
    }
}
