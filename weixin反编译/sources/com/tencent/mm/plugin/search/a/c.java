package com.tencent.mm.plugin.search.a;

import com.tencent.mm.a.e;
import com.tencent.mm.ay.r;
import com.tencent.mm.bb.k;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.az;
import com.tencent.mm.f.a.bc;
import com.tencent.mm.f.a.ix;
import com.tencent.mm.f.a.mu;
import com.tencent.mm.f.a.oq;
import com.tencent.mm.f.a.sa;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.search.ui.b.f;
import com.tencent.mm.plugin.search.ui.b.i;
import com.tencent.mm.plugin.search.ui.b.j;
import com.tencent.mm.plugin.search.ui.b.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import junit.framework.Assert;

public class c implements ap {
    private com.tencent.mm.sdk.b.c inf = new com.tencent.mm.sdk.b.c<bc>() {
        {
            this.xmG = bc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return c((bc) bVar);
        }

        private boolean c(bc bcVar) {
            Throwable e;
            int intValue;
            if (bcVar != null && bcVar.fqf.fqg == 27) {
                if (bcVar.fqf.fqh == 2 && !c.bqC()) {
                    c.du(bcVar.fqf.fqh, 12);
                }
                String Ak = g.Ak(bcVar.fqf.fqh);
                String Al = g.Al(bcVar.fqf.fqh);
                int Am = g.Am(bcVar.fqf.fqh);
                if (!(bi.oN(Ak) || bi.oN(Al))) {
                    File file = new File(bcVar.fqf.filePath);
                    if (file.exists()) {
                        x.i("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener callback to update %s", file.getAbsoluteFile());
                        File file2 = new File(Ak, "temp");
                        File file3 = new File(file2, Al);
                        file2.mkdirs();
                        e.x(file.getAbsolutePath(), file3.getAbsolutePath());
                        int fz = bi.fz(file3.getAbsolutePath(), file2.getAbsolutePath());
                        if (fz >= 0) {
                            Properties properties = new Properties();
                            InputStream fileInputStream;
                            try {
                                fileInputStream = new FileInputStream(new File(file2, "config.conf"));
                                try {
                                    properties.load(fileInputStream);
                                    e.c(fileInputStream);
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        x.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, e.getMessage(), new Object[0]);
                                        e.c(fileInputStream);
                                        intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                        e.g(file2);
                                        if (Am < intValue) {
                                            if (fz >= 0) {
                                                c.du(bcVar.fqf.fqh, 11);
                                            } else {
                                                c.du(bcVar.fqf.fqh, 13);
                                            }
                                            x.i("MicroMsg.FTS.SubCoreSearch", "res no need update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bcVar.fqf.fqh), Integer.valueOf(Am), Integer.valueOf(intValue));
                                        } else {
                                            c.du(bcVar.fqf.fqh, 9);
                                            x.i("MicroMsg.FTS.SubCoreSearch", "res update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bcVar.fqf.fqh), Integer.valueOf(Am), Integer.valueOf(intValue));
                                            c.f(file, bcVar.fqf.fqh);
                                        }
                                        return false;
                                    } catch (Throwable th) {
                                        e = th;
                                        e.c(fileInputStream);
                                        throw e;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                fileInputStream = null;
                                x.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, e.getMessage(), new Object[0]);
                                e.c(fileInputStream);
                                intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                e.g(file2);
                                if (Am < intValue) {
                                    c.du(bcVar.fqf.fqh, 9);
                                    x.i("MicroMsg.FTS.SubCoreSearch", "res update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bcVar.fqf.fqh), Integer.valueOf(Am), Integer.valueOf(intValue));
                                    c.f(file, bcVar.fqf.fqh);
                                } else {
                                    if (fz >= 0) {
                                        c.du(bcVar.fqf.fqh, 13);
                                    } else {
                                        c.du(bcVar.fqf.fqh, 11);
                                    }
                                    x.i("MicroMsg.FTS.SubCoreSearch", "res no need update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bcVar.fqf.fqh), Integer.valueOf(Am), Integer.valueOf(intValue));
                                }
                                return false;
                            } catch (Throwable th2) {
                                e = th2;
                                fileInputStream = null;
                                e.c(fileInputStream);
                                throw e;
                            }
                            intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                        } else {
                            intValue = 1;
                        }
                        e.g(file2);
                        if (Am < intValue) {
                            c.du(bcVar.fqf.fqh, 9);
                            x.i("MicroMsg.FTS.SubCoreSearch", "res update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bcVar.fqf.fqh), Integer.valueOf(Am), Integer.valueOf(intValue));
                            c.f(file, bcVar.fqf.fqh);
                        } else {
                            if (fz >= 0) {
                                c.du(bcVar.fqf.fqh, 13);
                            } else {
                                c.du(bcVar.fqf.fqh, 11);
                            }
                            x.i("MicroMsg.FTS.SubCoreSearch", "res no need update template subtype:%d currentVersion:%d resVersion:%d", Integer.valueOf(bcVar.fqf.fqh), Integer.valueOf(Am), Integer.valueOf(intValue));
                        }
                    } else {
                        x.e("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener file not exist");
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c jON = new com.tencent.mm.sdk.b.c<ix>() {
        {
            this.xmG = ix.class.getName().hashCode();
        }

        private boolean a(ix ixVar) {
            Throwable e;
            int intValue;
            if (ixVar != null && ixVar.fAr.fqg == 27) {
                File file;
                if (ixVar.fAr.fqh == 1) {
                    File file2 = new File(ixVar.fAr.filePath);
                    if (file2.exists()) {
                        x.i("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener callback to update %s", file2.getAbsoluteFile());
                        File file3 = new File(g.Ak(ixVar.fAr.fqh), "temp");
                        file = new File(file3, g.Al(ixVar.fAr.fqh));
                        file3.mkdirs();
                        e.x(file2.getAbsolutePath(), file.getAbsolutePath());
                        if (bi.fz(file.getAbsolutePath(), file3.getAbsolutePath()) >= 0) {
                            Properties properties = new Properties();
                            InputStream fileInputStream;
                            try {
                                fileInputStream = new FileInputStream(new File(file3, "config.conf"));
                                try {
                                    properties.load(fileInputStream);
                                    e.c(fileInputStream);
                                } catch (Exception e2) {
                                    e = e2;
                                    try {
                                        x.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, e.getMessage(), new Object[0]);
                                        e.c(fileInputStream);
                                        intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                        e.g(file3);
                                        x.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(g.Af(0)), Integer.valueOf(intValue));
                                        c.f(file2, ixVar.fAr.fqh);
                                        return false;
                                    } catch (Throwable th) {
                                        e = th;
                                        e.c(fileInputStream);
                                        throw e;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                fileInputStream = null;
                                x.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, e.getMessage(), new Object[0]);
                                e.c(fileInputStream);
                                intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                e.g(file3);
                                x.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(g.Af(0)), Integer.valueOf(intValue));
                                c.f(file2, ixVar.fAr.fqh);
                                return false;
                            } catch (Throwable th2) {
                                e = th2;
                                fileInputStream = null;
                                e.c(fileInputStream);
                                throw e;
                            }
                            intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                        } else {
                            intValue = 1;
                        }
                        e.g(file3);
                        x.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(g.Af(0)), Integer.valueOf(intValue));
                        c.f(file2, ixVar.fAr.fqh);
                    } else {
                        x.e("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener file not exist");
                    }
                } else if (ixVar.fAr.fqh == 2) {
                    file = new File(ixVar.fAr.filePath);
                    if (file.exists()) {
                        int Af = g.Af(1);
                        c.f(file, ixVar.fAr.fqh);
                        x.i("MicroMsg.FTS.SubCoreSearch", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(Af), Integer.valueOf(g.Af(1)));
                    } else {
                        x.e("MicroMsg.FTS.SubCoreSearch", "checkResUpdateListener file not exist");
                    }
                }
            }
            return false;
        }
    };
    private long qhl;
    private m qhm = new m() {
        public final void b(String str, Map<String, String> map, com.tencent.mm.ad.d.a aVar) {
            if (map != null && str != null) {
                if (str.equals("mmsearch_reddot_new")) {
                    x.i("MicroMsg.FTS.SubCoreSearch", "recv %s, %s", "mmsearch_reddot_new", map.toString());
                    int Wo = bi.Wo((String) map.get(".sysmsg.mmsearch_reddot_new.clear"));
                    int Wo2 = bi.Wo((String) map.get(".sysmsg.mmsearch_reddot_new.msgid"));
                    int Wo3 = bi.Wo((String) map.get(".sysmsg.mmsearch_reddot_new.discovery"));
                    int Wo4 = bi.Wo((String) map.get(".sysmsg.mmsearch_reddot_new.entry"));
                    int Wo5 = bi.Wo((String) map.get(".sysmsg.mmsearch_reddot_new.android_cli_version"));
                    long Wp = bi.Wp((String) map.get(".sysmsg.mmsearch_reddot_new.expire_time"));
                    int Wo6 = bi.Wo((String) map.get(".sysmsg.mmsearch_reddot_new.h5_version"));
                    int Wo7 = bi.Wo((String) map.get(".sysmsg.mmsearch_reddot_new.reddot_type"));
                    String str2 = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_text");
                    String str3 = (String) map.get(".sysmsg.mmsearch_reddot_new.reddot_icon");
                    long Wp2 = bi.Wp((String) map.get(".sysmsg.mmsearch_reddot_new.timestamp"));
                    k Rl = k.Rl();
                    com.tencent.mm.bb.k.a aVar2 = null;
                    switch (Wo4) {
                        case 1:
                            aVar2 = Rl.hMR;
                            break;
                        case 2:
                            aVar2 = Rl.hMS;
                            break;
                    }
                    if (aVar2 == null) {
                        aVar2 = new com.tencent.mm.bb.k.a();
                    }
                    if (aVar2.timestamp < Wp2) {
                        aVar2.id = Wo2;
                        aVar2.hMX = Wo3;
                        aVar2.hMU = Wo4;
                        aVar2.hMV = Wo5;
                        aVar2.hMW = Wp;
                        aVar2.hMG = Wo6;
                        aVar2.type = Wo7;
                        aVar2.text = str2;
                        aVar2.fED = str3;
                        aVar2.timestamp = Wp2;
                        aVar2.clear = Wo;
                        aVar2.hJs = System.currentTimeMillis();
                    } else {
                        x.i("SearchRedPointMgr", "timestamp %d not big than last msg %d", Long.valueOf(Wp2), Long.valueOf(aVar2.timestamp));
                    }
                    Rl.save();
                    com.tencent.mm.sdk.b.a.xmy.m(new oq());
                }
            }
        }
    };
    private com.tencent.mm.sdk.b.c qhn = new com.tencent.mm.sdk.b.c<az>() {
        {
            this.xmG = az.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            c.this.bqB();
            return false;
        }
    };

    private class a implements Runnable {
        boolean qhr;

        a(boolean z) {
            this.qhr = z;
        }

        public final void run() {
            c.a(c.this, this.qhr);
        }
    }

    static /* synthetic */ void a(c cVar, boolean z) {
        int i;
        int[] iArr = new int[]{0, 1};
        String[] strArr = new String[2];
        for (i = 0; i < 2; i++) {
            strArr[i] = g.Aj(iArr[i]);
        }
        Assert.assertEquals(2, 2);
        for (i = 0; i < 2; i++) {
            File file = new File(strArr[i]);
            x.i("MicroMsg.FTS.SubCoreSearch", "copy to path %s, type %d", file.getAbsolutePath(), Integer.valueOf(iArr[i]));
            int Ai = g.Ai(iArr[i]);
            if (z) {
                x.i("MicroMsg.FTS.SubCoreSearch", "need update assetVersion=%d currentVersion=%d type=%d", Integer.valueOf(g.Ad(iArr[i])), Integer.valueOf(Ai), Integer.valueOf(iArr[i]));
                if (Ai < g.Ad(iArr[i])) {
                    e.g(file);
                    e(file, iArr[i]);
                }
            } else if (Ai == 1) {
                x.i("MicroMsg.FTS.SubCoreSearch", "need init template");
                e.g(file);
                e(file, iArr[i]);
            } else {
                x.i("MicroMsg.FTS.SubCoreSearch", "currentVersion=%d", Integer.valueOf(Ai));
            }
        }
        e.g(new File(com.tencent.mm.compatible.util.e.bnF, "fts"));
    }

    static /* synthetic */ void du(int i, int i2) {
        if (i == 2) {
            com.tencent.mm.bb.g.it(i2);
        }
    }

    static /* synthetic */ void f(File file, int i) {
        String str = "";
        String str2 = "";
        switch (i) {
            case 1:
                str = g.Aj(0);
                str2 = g.Ah(0);
                break;
            case 2:
                str = g.Aj(1);
                str2 = g.Ah(1);
                break;
        }
        if (bi.oN(str) || bi.oN(str2)) {
            x.w("MicroMsg.FTS.SubCoreSearch", "initTemplateFoldByResUpdate templatePath nil! subtype:%d, resFile:%s", Integer.valueOf(i), file.getAbsolutePath());
            return;
        }
        File file2 = new File(str);
        e.g(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, "create nomedia file error", new Object[0]);
            }
        }
        file3 = new File(str2);
        e.x(file.getAbsolutePath(), file3.getAbsolutePath());
        int fz = bi.fz(file3.getAbsolutePath(), file3.getParent());
        if (fz < 0) {
            x.e("MicroMsg.FTS.SubCoreSearch", "unzip fail, ret = " + fz + ", zipFilePath = " + file3.getAbsolutePath() + ", unzipPath = " + file3.getParent());
            return;
        }
        switch (i) {
            case 1:
                fz = g.Ai(0);
                break;
            case 2:
                fz = g.Ai(1);
                break;
            default:
                fz = 1;
                break;
        }
        com.tencent.mm.sdk.b.a.xmy.m(new mu());
        x.i("MicroMsg.FTS.SubCoreSearch", "Unzip Path%s version=%d", file3.getParent(), Integer.valueOf(fz));
    }

    private static c bqy() {
        as.Hg();
        c cVar = (c) bq.ib("plugin.search");
        if (cVar != null) {
            return cVar;
        }
        Object cVar2 = new c();
        as.Hg().a(c.class.getName(), cVar2);
        return cVar2;
    }

    public static com.tencent.mm.plugin.fts.d.g bqz() {
        return h.aOe();
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }

    public final void bs(boolean z) {
        h.a(new com.tencent.mm.plugin.search.ui.k());
        this.qhn.cfB();
        this.inf.cfB();
        this.jON.cfB();
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.qhm);
        bqB();
        com.tencent.mm.sdk.f.e.post(new a(z), "CopySearchTemplateTask");
        h.a(new l());
        h.a(new com.tencent.mm.plugin.search.ui.b.e());
        h.a(new com.tencent.mm.plugin.search.ui.b.c());
        h.a(new com.tencent.mm.plugin.search.ui.b.g());
        h.a(new i());
        h.a(new com.tencent.mm.plugin.search.ui.b.k());
        h.a(new com.tencent.mm.plugin.search.ui.b.d());
        h.a(new com.tencent.mm.plugin.search.ui.b.b());
        h.a(new com.tencent.mm.plugin.search.ui.b.h());
        h.a(new j());
        h.a(new com.tencent.mm.plugin.search.ui.b.a());
        h.a(new f());
    }

    public final void onAccountRelease() {
        this.qhn.dead();
        this.inf.dead();
        this.jON.dead();
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.qhm);
        h.aOd();
        com.tencent.mm.bb.d.hMs = null;
    }

    private static void e(File file, int i) {
        String Ah = g.Ah(i);
        if (bi.oN(Ah)) {
            x.w("MicroMsg.FTS.SubCoreSearch", "initTemplateFolder outputZipFilePath nil! type:%d, ftsTemplateFolder:%s", Integer.valueOf(i), file.getAbsolutePath());
            return;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.SubCoreSearch", e, "create nomedia file error", new Object[0]);
            }
        }
        file2 = new File(Ah);
        if (g.Ag(i)) {
            int fz = bi.fz(file2.getAbsolutePath(), file2.getParent());
            if (fz < 0) {
                x.e("MicroMsg.FTS.SubCoreSearch", "unzip fail, ret = " + fz + ", zipFilePath = " + file2.getAbsolutePath() + ", unzipPath = " + file2.getParent());
                return;
            }
            fz = g.Ai(i);
            x.i("MicroMsg.FTS.SubCoreSearch", "Unzip Path%s version=%d", file2.getParent(), Integer.valueOf(fz));
            return;
        }
        x.i("MicroMsg.FTS.SubCoreSearch", "copy template file from asset fail %s", file2.getAbsolutePath());
    }

    public static void bqA() {
        if (r.QO().be(0, 18) != null) {
            if (new File(r.QO().bh(0, 18)).exists()) {
                x.i("MicroMsg.FTS.SubCoreSearch", "Exist Uzip Folder path=%s", r.QO().bh(0, 18));
            } else {
                x.i("MicroMsg.FTS.SubCoreSearch", "Not Exist Uzip Folder， path=%s", r.QO().bh(0, 18));
                as.CN().a(new com.tencent.mm.ay.j(0, 18), 0);
                return;
            }
        }
        if (System.currentTimeMillis() - bqy().qhl > 7200000) {
            bqy().qhl = System.currentTimeMillis();
            as.CN().a(new com.tencent.mm.ay.k(18), 0);
        }
    }

    private void bqB() {
        ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).getFTSTaskDaemon().a(65536, new com.tencent.mm.plugin.fts.a.a.a() {
            String qhp = w.eM(ad.getContext());
            boolean qhq = false;

            public final boolean execute() {
                this.qhq = ((int) ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).getFTSIndexDB().u(-3, 0)) != this.qhp.hashCode();
                if (this.qhq) {
                    com.tencent.mm.sdk.b.a.xmy.m(new sa());
                }
                return true;
            }

            public final String adF() {
                return String.format("{changed: %b}", new Object[]{Boolean.valueOf(this.qhq)});
            }

            public final String getName() {
                return "CheckLanguageUpdate";
            }
        });
    }

    public static boolean bqC() {
        File file = new File(g.Aj(1));
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File file2 = new File(file, g.bPF());
        File file3 = new File(file, g.bPG());
        if (file2.exists() && file3.exists()) {
            return true;
        }
        return false;
    }
}
