package com.tencent.mm.kernel;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mm.a.g;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.ad.v;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.f.a.bx;
import com.tencent.mm.f.a.by;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ao;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.at;
import com.tencent.mm.y.bz;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    private static boolean gQS = true;
    private static boolean gQT = false;
    static b gQV = new b();
    private static String gQW = "NoResetUinStack";
    private static String gQX = null;
    private static int gRg = -1;
    private c gQQ;
    private v gQR;
    byte[] gQU = new byte[0];
    public com.tencent.mm.y.a gQY;
    public e.c gQZ;
    public int gRa;
    public boolean gRb = false;
    private boolean gRc = false;
    public int gRd = 0;
    public int gRe;
    public List<ao> gRf = new LinkedList();
    long gRh;
    private volatile int gRi = a.gRn;
    public volatile boolean gRj = false;
    private String gRk = "";
    private Map<String, Integer> gRl = new HashMap();

    private enum a {
        ;

        static {
            gRn = 1;
            gRo = 2;
            gRp = new int[]{gRn, gRo};
        }
    }

    static final class b {
        private static boolean gRs = true;
        private boolean gRq = false;
        private s gRr;
        private int uin = 0;

        b() {
        }

        private synchronized int Cn() {
            if (!this.gRq) {
                CK();
                this.gRq = true;
            }
            return this.uin;
        }

        public final synchronized void a(s sVar) {
            this.gRr = sVar;
        }

        private synchronized void eE(int i) {
            x.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", o.getString(this.uin), o.getString(i), Integer.valueOf(h.aJ(i, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bi.chl());
            Assert.assertNotNull(this.gRr);
            a(this.gRr, i);
            this.uin = i;
        }

        private synchronized void CK() {
            int i = 0;
            synchronized (this) {
                Assert.assertNotNull(this.gRr);
                s sVar = this.gRr;
                if (sVar == null) {
                    x.w("MMKernel.CoreAccount", "summer read detault uin exception sysCfg is null!");
                } else {
                    Integer num = (Integer) sVar.get(1);
                    if (num == null) {
                        if (sVar.xuT) {
                            d.pVE.a(148, 40, 1, false);
                        }
                        Integer valueOf = Integer.valueOf(ad.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0));
                        if (valueOf != null) {
                            x.i("MMKernel.CoreAccount", "summer read detault uin[%d], bakUin[%d] sysCfg.isOpenException[%b]", num, valueOf, Boolean.valueOf(sVar.xuT));
                            if (gRs) {
                                x.w("MMKernel.CoreAccount", "summer read detault uin exception backup uin[%d], stack[%s]", valueOf, bi.chl());
                                d.pVE.h(11911, Integer.valueOf(bi.e(valueOf)));
                                gRs = false;
                            }
                            a(sVar, valueOf.intValue());
                            num = valueOf;
                        }
                    }
                    x.i("MMKernel.CoreAccount", "summer getDefaultUin uin[%d]", Integer.valueOf(bi.e(num)));
                    i = bi.e(num);
                }
                this.uin = i;
            }
        }

        private static void a(s sVar, int i) {
            x.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", Integer.valueOf(i), bi.chl());
            ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("default_uin", i).commit();
            sVar.set(1, Integer.valueOf(i));
        }
    }

    public a(c cVar) {
        Assert.assertNotNull(gQV);
        g.Dr();
        gQS = bi.e((Integer) g.Dq().gRO.get(17)) != 0;
        com.tencent.mm.protocal.i.c.a.vHH = new at(702);
        this.gQQ = cVar;
    }

    public static int Cn() {
        return gQV.Cn();
    }

    public static String Co() {
        return new o(gQV.Cn()).toString();
    }

    public static String Cp() {
        return gQX;
    }

    public static String fH(String str) {
        gQX = str;
        return str;
    }

    public static String Cq() {
        return gQW;
    }

    public static void fI(String str) {
        gQW = str;
    }

    static boolean gA(int i) {
        return i != 0;
    }

    protected static void Cr() {
        gQV.eE(0);
    }

    protected static void Cs() {
        gQV.eE(0);
    }

    private void Ct() {
        this.gRi = a.gRn;
        this.gRj = false;
        x.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
        ad.getContext().getSharedPreferences(ad.cgf(), 0).edit().putBoolean("isLogin", false).commit();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        x.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", Integer.valueOf(gQV.Cn()), gQW, simpleDateFormat.format(new Date()));
    }

    final void Cu() {
        x.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", o.getString(gQV.Cn()), Thread.currentThread().getName(), bi.chl());
        if (CF()) {
            this.gQQ.onAccountRelease();
            g.Dr();
            g.Dq().ed(null);
            Ct();
            g.Dr();
            g.Dq().gSc.clear();
            return;
        }
        x.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", bi.chl().toString(), gQW);
    }

    final void bx(boolean z) {
        boolean z2;
        int cgq;
        if (!z) {
            z2 = HardCoderJNI.hcBootEnable;
            int i = HardCoderJNI.hcBootDelay;
            int i2 = HardCoderJNI.hcBootCPU;
            int i3 = HardCoderJNI.hcBootIO;
            if (HardCoderJNI.hcBootThr) {
                cgq = g.Dt().cgq();
            } else {
                cgq = 0;
            }
            this.gRa = HardCoderJNI.startPerformance(z2, i, i2, i3, cgq, HardCoderJNI.hcBootTimeout, 101, HardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
            x.i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", Integer.valueOf(this.gRa), bi.chl());
        }
        x.i("MMKernel.CoreAccount", "UserStatusChange: clear");
        synchronized (this.gRf) {
            this.gRf.clear();
        }
        long currentTimeMillis = System.currentTimeMillis();
        int a = gQV.Cn();
        x.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", o.getString(a), Integer.valueOf(h.aJ(a, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bi.chl());
        if ((a != 0 ? 1 : null) == null) {
            x.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
        } else {
            boolean z3;
            long currentTimeMillis2;
            o.getString(a);
            g.Dr();
            e Dq = g.Dq();
            Runnable anonymousClass1 = new Runnable() {
                public final void run() {
                    a.this.gRi = a.gRo;
                }
            };
            ad.getContext().getSharedPreferences(ad.cgf(), 0).edit().putBoolean("isLogin", true).commit();
            String s = g.s(("mm" + a).getBytes());
            Dq.gRT = Dq.gRS + s + "/";
            Dq.cachePath = w.hbv + s + "/";
            File file = new File(Dq.cachePath);
            x.i("MMKernel.CoreStorage", "dkacc cachePath:" + Dq.cachePath + " accPath:" + Dq.gRT);
            if (file.exists()) {
                z3 = false;
            } else {
                x.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", o.getString(a), Dq.cachePath, Dq.gRT);
                file.mkdirs();
                if (!Dq.cachePath.equalsIgnoreCase(Dq.gRT)) {
                    currentTimeMillis2 = System.currentTimeMillis();
                    new File(Dq.gRT).renameTo(new File(e.bnF + (s + "temp" + System.currentTimeMillis())));
                    x.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - currentTimeMillis2), s);
                }
                z3 = true;
            }
            Dq.gSb = new bz(Dq.cachePath, z3);
            Dq.CW();
            s = Dq.cachePath + "MicroMsg.db";
            String str = Dq.cachePath + "EnMicroMsg.db";
            String str2 = Dq.cachePath + "EnMicroMsg2.db";
            Dq.ed(null);
            Dq.fM(str);
            Dq.gRU = new com.tencent.mm.bx.h(new com.tencent.mm.bx.h.a() {
                public final void Di() {
                    if (e.this.gRW != null) {
                        x.i("MMKernel.CoreStorage", "summer preCloseCallback userConfigStg: " + e.this.gRW);
                        e.this.gRW.lO(true);
                    }
                    e.this.gRQ.Di();
                }

                public final void Dj() {
                    e.this.gRQ.Dj();
                }

                public final void Dk() {
                    e.this.gRQ.Dk();
                }
            });
            if (Dq.gRU.a(s, str, str2, (long) a, q.yL(), e.Bu(), true)) {
                String str3 = Dq.gRU.xJT;
                if (!bi.oN(str3)) {
                    x.e("MMKernel.CoreStorage", "dbinit failed :" + str3);
                    com.tencent.mm.sdk.a.b.z("init db Failed: [ " + str3 + "]", "DBinit");
                }
                com.tencent.mm.bx.h hVar = Dq.gRU;
                if (hVar.xJQ != null ? hVar.xJQ.xJs : false) {
                    Dq.gSa = true;
                }
                Dq.gRW = new t(Dq.gRU);
                Dq.gRY = new com.tencent.mm.storage.bi(Dq.gRU);
                Dq.gRU.xJS = new com.tencent.mm.bx.h.e() {
                    public final void Dl() {
                        if (e.this.gRY != null) {
                            e.this.gRY.hiZ.fD("TablesVersion", "delete * from TablesVersion");
                        } else {
                            x.e("MMKernel.CoreStorage", "tablesVersionStorage is null");
                        }
                    }
                };
                Dq.gRZ = Dq.gRY.ckM();
                Dq.gRV = new com.tencent.mm.bx.h(Dq.gRR);
                if (Dq.gRV.a(s, str, str2, (long) a, q.yL(), new HashMap(), true)) {
                    Dq.gRX = new be(Dq.gRW);
                    Dq.gRX.c(new com.tencent.mm.sdk.e.j.a() {
                        public final void a(String str, l lVar) {
                            q.eK(str);
                        }
                    });
                    Dq.gRX.ckI();
                    anonymousClass1.run();
                    if (z3) {
                        currentTimeMillis2 = ((Long) Dq.gRW.get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0))).longValue();
                        int intValue = ((Integer) Dq.gRW.get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0))).intValue();
                        if (currentTimeMillis2 > 0) {
                            x.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", Long.valueOf(currentTimeMillis2));
                        } else {
                            Dq.gRW.a(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
                        }
                        if (intValue > 0) {
                            x.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", Integer.valueOf(intValue));
                        } else {
                            Dq.gRW.a(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(com.tencent.mm.protocal.d.vHl));
                        }
                        x.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", (Long) Dq.gRW.get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0)), (Integer) Dq.gRW.get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0)), Integer.valueOf(com.tencent.mm.protocal.d.vHl));
                    }
                    if (!z) {
                        Object obj;
                        g.Dr();
                        x.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", bi.oM((String) g.Dq().Db().get(2, null)));
                        if (bi.oM((String) g.Dq().Db().get(2, null)).length() <= 0) {
                            x.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + gQV.Cn());
                            Ct();
                            gQV.eE(0);
                            gQW = bi.chl().toString();
                            ah.y(new Runnable() {
                                public final void run() {
                                    g.Dr().releaseAll();
                                }
                            });
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj == null) {
                            d.pVE.a(598, 21, 1, true);
                            x.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
                        }
                    }
                    com.tencent.mm.sdk.b.a.xmy.m(new by());
                    g.Dr();
                    e Dq2 = g.Dq();
                    e.c cVar = new e.c();
                    cgq = bi.e((Integer) Dq2.gRW.get(14, null));
                    int i4 = com.tencent.mm.protocal.d.vHl;
                    boolean z4 = i4 == cgq ? false : (i4 <= 570425344 || cgq > 570425344) ? i4 > 570556456 && cgq <= 570556456 : true;
                    if (z4) {
                        Dq2.gRW.set(8197, "");
                        Dq2.gRW.set(15, Integer.valueOf(0));
                    }
                    z2 = cgq != i4;
                    if (cgq > 620822536 || cgq == i4) {
                        Dq2.gRW.set(274480, Boolean.valueOf(false));
                        x.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
                    } else {
                        Dq2.gRW.set(274480, Boolean.valueOf(true));
                        x.i("MMKernel.CoreStorage", "[initialize] need init emoji");
                    }
                    if (cgq != 0 && cgq < 637599744) {
                        Dq2.gRW.set(348162, Boolean.valueOf(true));
                    }
                    if ((cgq != i4 ? 1 : null) != null) {
                        x.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(cgq) + " to " + Integer.toHexString(i4) + ", init=" + z4);
                        if (((Integer) Dq2.gRO.get(37, Integer.valueOf(0))).intValue() == 0) {
                            Dq2.gRO.set(37, Integer.valueOf(cgq));
                        }
                        Dq2.gRW.set(30, Boolean.valueOf(false));
                        Dq2.gRW.set(-2046825377, Boolean.valueOf(false));
                        Dq2.gRW.set(-2046825369, Boolean.valueOf(false));
                        Dq2.gRW.set(54, Boolean.valueOf(false));
                        Dq2.gRW.set(-2046825368, Boolean.valueOf(false));
                        Dq2.gRW.set(-2046825366, Boolean.valueOf(true));
                        Dq2.gRW.set(62, Boolean.valueOf(true));
                        ad.getContext().getSharedPreferences("update_config_prefs", 4).edit().clear().commit();
                        if ((cgq & -256) == (i4 & -256)) {
                            af.VI("show_whatsnew");
                        }
                    }
                    cVar.gSl = z2;
                    cVar.gSm = cgq;
                    this.gQZ = cVar;
                    x.i("MMKernel.CoreAccount", "check is update :%b ", Boolean.valueOf(cVar.gSl));
                    this.gRc = true;
                    if (!this.gRb) {
                        Cv();
                        g.Do().CG();
                    }
                    ar.hhz.S("last_login_uin", o.getString(a));
                    d.pVE.eE(a);
                    s = "MMKernel.CoreAccount";
                    str = "SmcLogic.setUin, class loader %s, %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(getClass().getClassLoader() == null ? -1 : getClass().getClassLoader().hashCode());
                    objArr[1] = Integer.valueOf(Thread.currentThread().getContextClassLoader() == null ? -1 : Thread.currentThread().getContextClassLoader().hashCode());
                    x.i(s, str, objArr);
                    this.gQY = new com.tencent.mm.y.a();
                    x.i("MMKernel.CoreAccount", "setAccUin done :%s", o.getString(a));
                    g.Dr();
                    if (g.Dp().gRu != null) {
                        g.Dr();
                        if (g.Dp().gRu.hoF != null) {
                            g.Dr();
                            g.Dp().gRu.hoF.bH(true);
                            g.Dr();
                            com.tencent.mm.network.c KD = g.Dp().gRu.hoF.KD();
                            if (!(a == 0 || KD == null || a == KD.Cn())) {
                                x.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", Integer.valueOf(KD.Cn()), Integer.valueOf(a));
                                d.pVE.a(148, 46, 1, false);
                                KD.eE(a);
                            }
                        }
                    }
                } else {
                    throw new com.tencent.mm.y.b((byte) 0);
                }
            }
            throw new SQLiteException("main db init failed");
        }
        x.i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        x.i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
    }

    public final void Cv() {
        if (this.gRc) {
            this.gRc = false;
            x.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", Long.valueOf(Thread.currentThread().getId()), bi.chl());
            long currentTimeMillis = System.currentTimeMillis();
            this.gQQ.onAccountInitialized(this.gQZ);
            x.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            Cw();
            return;
        }
        x.i("MMKernel.CoreAccount", "no need do account initialized notify.");
    }

    public final void Cw() {
        if (CF() && com.tencent.mm.kernel.a.c.DA().gTe) {
            x.i("MMKernel.CoreAccount", "Flush client version.");
            g.Dq().gRW.set(14, Integer.valueOf(com.tencent.mm.protocal.d.vHl));
        }
    }

    public final synchronized v Cx() {
        if (this.gQR == null) {
            this.gQR = new v();
        }
        return this.gQR;
    }

    public static boolean Cy() {
        return gQT;
    }

    public static void by(boolean z) {
        gQT = z;
    }

    public static boolean Cz() {
        if (gQS) {
            String string;
            String str = "MMKernel.CoreAccount";
            String str2 = "account holded :%s init:%b";
            Object[] objArr = new Object[2];
            g.Dr();
            if (g.Do() != null) {
                g.Dr();
                g.Do();
                string = o.getString(gQV.Cn());
            } else {
                string = "-1";
            }
            objArr[0] = string;
            objArr[1] = Boolean.valueOf(g.Do().CF());
            x.w(str, str2, objArr);
        }
        return gQS;
    }

    public static void hold() {
        String string;
        String str = "MMKernel.CoreAccount";
        String str2 = " HOLD ACCOUNT! uin:%s stack:%s init:%b";
        Object[] objArr = new Object[3];
        g.Dr();
        if (g.Do() != null) {
            g.Dr();
            g.Do();
            string = o.getString(gQV.Cn());
        } else {
            string = "-1";
        }
        objArr[0] = string;
        objArr[1] = bi.chl();
        objArr[2] = Boolean.valueOf(g.Do().CF());
        x.w(str, str2, objArr);
        gQS = true;
        g.Dr();
        g.Dq().gRO.set(17, Integer.valueOf(1));
    }

    public static void unhold() {
        String string;
        String str = "MMKernel.CoreAccount";
        String str2 = " UN HOLD ACCOUNT! uin:%s init:%b";
        Object[] objArr = new Object[2];
        g.Dr();
        if (g.Do() != null) {
            g.Dr();
            g.Do();
            string = o.getString(gQV.Cn());
        } else {
            string = "-1";
        }
        objArr[0] = string;
        objArr[1] = Boolean.valueOf(g.Do().CF());
        x.w(str, str2, objArr);
        gQS = false;
        g.Dr();
        g.Dq().gRO.set(17, Integer.valueOf(0));
    }

    public final void CA() {
        if (!CF()) {
            throw new com.tencent.mm.y.b();
        }
    }

    public final void CB() {
        new ag(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                ao[] aoVarArr = new ao[a.this.gRf.size()];
                a.this.gRf.toArray(aoVarArr);
                for (ao Hd : aoVarArr) {
                    Hd.Hd();
                }
            }
        });
    }

    public final void aT(int i, int i2) {
        int i3 = (this.gRd == i && this.gRe == i2) ? 0 : 1;
        x.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.gRe), Integer.valueOf(this.gRd));
        if (i3 != 0) {
            this.gRd = i;
            this.gRe = i2;
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    a.this.CB();
                }
            });
        }
    }

    public static void gB(int i) {
        if (gRg == -1 || gRg != i) {
            gRg = i;
            CD().edit().putInt("notification.user.state", i).commit();
            x.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", Integer.valueOf(i));
        }
    }

    public static int CC() {
        return CD().getInt("notification.user.state", 0);
    }

    public static SharedPreferences CD() {
        return ad.getContext().getSharedPreferences("notify_key_pref_settings", 4);
    }

    public static boolean gC(int i) {
        return (i & 1) != 0;
    }

    public final void release() {
        synchronized (this.gQU) {
            Cu();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize() {
        /*
        r6 = this;
        r0 = r6.CF();
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r1 = r6.gQU;
        monitor-enter(r1);
        r0 = r6.CF();	 Catch:{ all -> 0x0012 }
        if (r0 == 0) goto L_0x0015;
    L_0x0010:
        monitor-exit(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x0006;
    L_0x0012:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0012 }
        throw r0;
    L_0x0015:
        r0 = gQV;	 Catch:{ all -> 0x0012 }
        r0 = r0.Cn();	 Catch:{ all -> 0x0012 }
        if (r0 == 0) goto L_0x0041;
    L_0x001d:
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0012 }
        r6.gRh = r2;	 Catch:{ all -> 0x0012 }
        r2 = "MMKernel.CoreAccount";
        r3 = "auto set up account storage uin: %d, stack: %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0012 }
        r5 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x0012 }
        r4[r5] = r0;	 Catch:{ all -> 0x0012 }
        r0 = 1;
        r5 = com.tencent.mm.sdk.platformtools.bi.chl();	 Catch:{ all -> 0x0012 }
        r4[r0] = r5;	 Catch:{ all -> 0x0012 }
        com.tencent.mm.sdk.platformtools.x.w(r2, r3, r4);	 Catch:{ all -> 0x0012 }
        r0 = 0;
        r6.bx(r0);	 Catch:{ all -> 0x0012 }
    L_0x0041:
        monitor-exit(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kernel.a.initialize():void");
    }

    public static boolean CE() {
        return gQV.Cn() != 0;
    }

    public final boolean CF() {
        return this.gRi == a.gRo;
    }

    public final void CG() {
        x.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", Boolean.valueOf(this.gRj), bi.chl());
        this.gRj = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        x.i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", Long.valueOf(this.gRh), Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime - this.gRh), bi.chl());
        com.tencent.mm.sdk.b.a.xmy.m(new bx());
    }

    public static int CH() {
        return Integer.valueOf(ad.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0)).intValue();
    }

    public static String CI() {
        g.Dr();
        if (bi.oN(g.Do().gRk)) {
            CJ();
        }
        g.Dr();
        return g.Do().gRk;
    }

    public static void CJ() {
        g.Dr();
        g.Do().gRk = q.yM() + "_" + System.currentTimeMillis();
        g.Dr();
        g.Do().gRl.clear();
    }

    public static int fJ(String str) {
        int i;
        g.Dr();
        if (g.Do().gRl.get(str) == null) {
            i = 0;
        } else {
            g.Dr();
            i = ((Integer) g.Do().gRl.get(str)).intValue();
        }
        int Wx = (int) bi.Wx();
        if (i == 0) {
            g.Dr();
            g.Do().gRl.put(str, Integer.valueOf(Wx));
            return i;
        }
        i = Wx - i;
        g.Dr();
        g.Do().gRl.put(str, Integer.valueOf(Wx));
        return i < 0 ? 0 : i;
    }
}
