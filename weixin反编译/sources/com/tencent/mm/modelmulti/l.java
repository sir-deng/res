package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.i;
import com.tencent.mm.ad.k;
import com.tencent.mm.booter.f;
import com.tencent.mm.f.a.li;
import com.tencent.mm.f.a.qi;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.atv;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.c.ou;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import junit.framework.Assert;

public final class l extends k implements com.tencent.mm.network.k {
    protected static int cLs = 7;
    private static int hHC = 0;
    private static boolean hHz = false;
    public String TAG;
    private int errCode;
    private int errType;
    private String foE;
    private e gLE;
    private boolean hGJ;
    private int hGL;
    private com.tencent.mm.compatible.util.g.a hGM;
    private long hGO;
    private boolean hGP;
    private boolean hHA;
    private al hHB;
    private int hHD;
    private boolean hHE;
    private String hHF;
    public b hHG;
    private long hHH;
    public s hHy;
    private al hmy;

    public static class a extends i {
        private final com.tencent.mm.protocal.w.a hGS;
        private final b hGT;
        private final boolean hGU;

        public a() {
            this.hGS = new com.tencent.mm.protocal.w.a();
            this.hGT = new b();
            this.hGU = false;
        }

        public a(b bVar) {
            this.hGS = new com.tencent.mm.protocal.w.a();
            this.hGT = bVar;
            this.hGU = true;
        }

        public final d Hu() {
            return this.hGS;
        }

        public final com.tencent.mm.protocal.k.e Hv() {
            return this.hGT;
        }

        public final int getType() {
            return 138;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newsync";
        }
    }

    public l(int i) {
        this.TAG = "MicroMsg.NetSceneSync";
        this.errType = 0;
        this.errCode = 0;
        this.foE = "";
        this.hHy = null;
        this.hHA = false;
        this.hGL = 0;
        this.hmy = null;
        this.hHB = null;
        this.hGO = -1;
        this.hGP = false;
        this.hHE = false;
        this.hGJ = false;
        this.hHF = "";
        this.hHG = null;
        this.hHH = 0;
        this.TAG += "[" + hashCode() + "]";
        x.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", Integer.valueOf(i), bi.chl());
        this.hHF = aj.cgu();
        this.hGM = new com.tencent.mm.compatible.util.g.a();
        if (this.hHy == null) {
            this.hHy = new s();
        }
        this.hHy.hJv = i;
        g.Dr();
        if (g.Dq() != null && g.Do().CF()) {
            g.Dr();
            if (!(g.Dq().Db() == null || com.tencent.mm.kernel.a.Cz())) {
                g.Dr();
                long a = bi.a((Long) g.Dq().Db().get(8196, null), 0);
                if (a != 0) {
                    g.Dr();
                    g.Dq().Db().set(8196, Long.valueOf(0));
                    int i2 = (int) (a | ((long) cLs));
                    cLs = i2;
                    cLs = i2 & 95;
                }
            }
        }
        if (i == 1) {
            hHz = true;
        }
        if (i == HardCoderJNI.FUNC_REG_ANR_CALLBACK) {
            cLs |= 16;
            hHz = true;
            this.hHD = 7;
        } else if (i == HardCoderJNI.FUNC_REG_PRELOAD_BOOT_RESOURCE) {
            cLs |= 64;
            hHz = true;
            this.hHD = 7;
        } else if (i == 3) {
            cLs |= 262144;
            hHz = true;
            this.hHD = 3;
            x.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", Integer.valueOf(i), Integer.valueOf(cLs), Integer.valueOf(this.hHD));
        } else {
            this.hHD = i;
        }
        if (hHC == 0) {
            Qd();
        }
    }

    public l(final b bVar, int i, long j) {
        this(8);
        this.hHF = aj.cgu();
        x.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", Long.valueOf(bVar.vIa), Integer.valueOf(i), Long.valueOf(j));
        this.hGL = i;
        this.hGO = j;
        this.hmy = new al(g.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                l.this.hGP = true;
                q aVar = new a(bVar);
                com.tencent.mm.plugin.report.d.pVE.a(99, 230, 1, false);
                l.this.a(-1, 0, 0, "", aVar, null);
                return false;
            }
        }, false);
        if (hHC == 0) {
            Qd();
        }
    }

    protected final boolean a(k kVar) {
        boolean z = true;
        if (!(kVar instanceof l)) {
            return false;
        }
        l lVar = (l) kVar;
        if (lVar.hHA || !hHz) {
            return false;
        }
        x.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", Long.valueOf(lVar.hol));
        if (bi.bB(lVar.hol) <= 360000) {
            z = false;
        }
        if (z) {
            x.i(this.TAG, "summerworker NetSceneSync timeout");
            Runnable findTaskByRunTime = g.Dt().cgs().findTaskByRunTime(0);
            if (findTaskByRunTime != null) {
                x.e(this.TAG, "summerworker worker is just blocked by task: " + ag.dump(findTaskByRunTime, false));
                return false;
            }
        }
        return z;
    }

    public final boolean Kj() {
        return true;
    }

    protected final int Bo() {
        return 100;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    public final boolean Kk() {
        int i = 1;
        boolean Kk = super.Kk();
        if (Kk) {
            com.tencent.mm.plugin.report.d.pVE.a(99, 228, 1, false);
            com.tencent.mm.plugin.report.d dVar = com.tencent.mm.plugin.report.d.pVE;
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(0);
            objArr[6] = Integer.valueOf(0);
            if (!com.tencent.mm.sdk.a.b.foreground) {
                i = 2;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "9999";
            dVar.h(12063, objArr);
        }
        return Kk;
    }

    public final int getType() {
        return 138;
    }

    protected final void cancel() {
        super.cancel();
        com.tencent.mm.plugin.report.d.pVE.a(99, 229, 1, false);
        this.hGJ = true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (m.Qf()) {
            hHC = 0;
            x.e(this.TAG, "dkinit never do sync before init done");
            return -1;
        }
        this.gLE = eVar2;
        if (this.hHy == null) {
            this.hHy = new s();
        }
        this.hHy.hJu = com.tencent.mm.sdk.a.b.foreground;
        if (this.hHB != null) {
            x.i(this.TAG, "pushSyncRespHandler not null");
            c(eVar);
            this.hHB.K(0, 0);
            return 0;
        } else if (hHC > 0) {
            x.w(this.TAG, "other sync is dealing with resp data :%d", Integer.valueOf(hHC));
            return -1;
        } else if (this.hmy != null) {
            x.i(this.TAG, "pusher not null");
            c(eVar);
            this.hmy.K(0, 0);
            return 0;
        } else {
            q aVar = new a();
            atv atv = ((com.tencent.mm.protocal.w.a) aVar.Kh()).vIC;
            if (this.hHD == 3) {
                atv.wIG = 1;
            } else {
                atv.wIG = 0;
            }
            this.hHD = this.hHE ? 6 : this.hHD;
            atv.vYD = cLs;
            g.Dr();
            atv.vYE = n.N(bi.Wj(bi.oM((String) g.Dq().Db().get(8195, new byte[0]))));
            atv.sfa = this.hHD;
            atv.wIF = new ou();
            atv.vQr = com.tencent.mm.protocal.d.DEVICE_TYPE;
            x.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", Integer.valueOf(atv.vYD), Integer.valueOf(atv.sfa), ad.bk(r0));
            hHz = false;
            return a(eVar, aVar, this);
        }
    }

    private boolean Qd() {
        PInt pInt = new PInt();
        g.Dr();
        g.Do();
        byte[] a = f.a(pInt, com.tencent.mm.kernel.a.Cn());
        String str = this.TAG;
        String str2 = "dealWithRespData index:%d, hashcode:%d, buf.len:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(pInt.value);
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = Integer.valueOf(a != null ? a.length : 0);
        x.i(str, str2, objArr);
        hHC = pInt.value;
        if (pInt.value == 0 || bi.by(a)) {
            hHC = 0;
            return false;
        }
        b bVar = new b();
        try {
            bVar.E(a);
            final a aVar = new a(bVar);
            this.hHB = new al(g.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    l.this.hGP = true;
                    com.tencent.mm.plugin.report.d.pVE.a(99, 231, 1, false);
                    l.this.a(-1, 0, 0, "", aVar, null);
                    return false;
                }
            }, false);
            return true;
        } catch (Exception e) {
            com.tencent.mm.plugin.report.d.pVE.a(99, 226, 1, false);
            x.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
            int i = hHC;
            g.Dr();
            g.Do();
            f.aL(i, com.tencent.mm.kernel.a.Cn());
            hHC = 0;
            return false;
        } catch (Error e2) {
            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
            long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
            x.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory));
            Assert.assertTrue("dealWithRespData error", false);
            return false;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        String str2;
        if (qVar == null || qVar.getType() != 138) {
            int i4;
            String str3 = this.TAG;
            str2 = "onGYNetEnd error type:%d";
            Object[] objArr = new Object[1];
            if (qVar == null) {
                i4 = -2;
            } else {
                i4 = qVar.getType();
            }
            objArr[0] = Integer.valueOf(i4);
            x.e(str3, str2, objArr);
            return;
        }
        boolean z;
        b bVar = (b) qVar.Hv();
        str2 = this.TAG;
        String str4 = "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ";
        Object[] objArr2 = new Object[8];
        objArr2[0] = Integer.valueOf(i2);
        objArr2[1] = Integer.valueOf(i3);
        objArr2[2] = str;
        objArr2[3] = Long.valueOf(this.hGM.zp());
        objArr2[4] = Boolean.valueOf(this.hGP);
        objArr2[5] = Integer.valueOf(bVar.vID.vYH == null ? -1 : bVar.vID.vYH.kyA);
        objArr2[6] = this.hmy;
        objArr2[7] = this.hHB;
        x.i(str2, str4, objArr2);
        Object obj = (bVar.vID.vYH == null ? -1 : bVar.vID.vYH.kyA) > 0 ? 1 : null;
        if (!Qe()) {
            com.tencent.mm.plugin.report.d.pVE.a(99, obj != null ? 221 : 218, 1, false);
        } else if (com.tencent.mm.sdk.a.b.foreground) {
            com.tencent.mm.plugin.report.d.pVE.a(99, obj != null ? 219 : 216, 1, false);
        } else {
            com.tencent.mm.plugin.report.d.pVE.a(99, obj != null ? 220 : 217, 1, false);
        }
        this.hmy = null;
        this.hHA = true;
        if (i2 == 4 && i3 == -2006) {
            z = true;
            i2 = 0;
            i3 = 0;
            com.tencent.mm.plugin.report.d.pVE.a(99, 227, 1, false);
        } else {
            z = false;
        }
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.report.d.pVE.a(99, 233, 1, false);
            byte[] a = n.a(((com.tencent.mm.protocal.w.a) qVar.Kh()).vIC.vYE);
            byte[] a2 = n.a(bVar.vID.vYE);
            x.i(this.TAG, "onGYNetEnd replace key:%b req :%s", Boolean.valueOf(z), ad.bk(a));
            x.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", Boolean.valueOf(z), ad.bk(a2));
            if (!z) {
                if (bi.by(a)) {
                    g.Dr();
                    a = bi.Wj(bi.oM((String) g.Dq().Db().get(8195, new byte[0])));
                    x.d(this.TAG, "dkpush userinfo key : %d[%s]", Integer.valueOf(a.length), bi.bx(a));
                }
                a = ad.g(a, a2);
                if (a == null || a.length <= 0) {
                    x.w(this.TAG, "merge key failed, use server side instead");
                    a = a2;
                }
                bVar.vID.vYE = n.N(a);
            }
            g.Dr();
            g.Do().aT(bVar.vID.kyY, bVar.vID.wIH);
            g.Dr();
            g.Do();
            com.tencent.mm.kernel.a.gB(bVar.vID.kyY);
            Assert.assertTrue(this.hHG == null);
            this.hHG = bVar;
            this.hHH = bi.Wy();
            new al(g.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                private int hHK = 0;
                private long hHL = 0;
                private int hHM = 0;

                public final boolean uG() {
                    c cVar = new c();
                    if (!g.Do().CF()) {
                        x.e(l.this.TAG, "syncRespHandler acc is not ready STOP :%s", l.this.hHG);
                        l.this.hHG = null;
                        return false;
                    } else if (l.this.hGJ) {
                        cVar.by(l.this);
                        l.this.hHG = null;
                        return false;
                    } else if (l.this.hHG == null || l.this.hHG.vID.vYH == null || l.this.hHG.vID.vYH.kyB == null) {
                        x.e(l.this.TAG, "syncRespHandler CmdList is null! Stop Processing :%s", l.this.hHG);
                        cVar.by(l.this);
                        l.this.hHG = null;
                        return false;
                    } else {
                        LinkedList linkedList = l.this.hHG.vID.vYH.kyB;
                        cVar.bw(l.this);
                        this.hHM++;
                        long Wy = bi.Wy();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < 5) {
                                if (this.hHK < linkedList.size()) {
                                    x.v(l.this.TAG, "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", Integer.valueOf(i2), Integer.valueOf(this.hHK), Integer.valueOf(linkedList.size()), Integer.valueOf(((ot) linkedList.get(this.hHK)).wet), Integer.valueOf(((ot) linkedList.get(this.hHK)).weu.wRk));
                                    linkedList.size();
                                    if (!cVar.a((ot) linkedList.get(this.hHK), false)) {
                                        x.w(l.this.TAG, "DoCmd Failed index:%d", Integer.valueOf(this.hHK));
                                    }
                                    this.hHK++;
                                }
                                if (this.hHK >= linkedList.size()) {
                                    this.hHL += bi.bA(Wy);
                                    x.i(l.this.TAG, "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", Integer.valueOf(this.hHK), Integer.valueOf(linkedList.size()), Long.valueOf(bi.bA(l.this.hHH)), Long.valueOf(this.hHL), Integer.valueOf(this.hHM), l.this.hHG);
                                    l.this.a(l.this.hHG);
                                    cVar.bx(l.this);
                                    com.tencent.mm.plugin.report.d.pVE.a(99, (long) bi.e((Integer) com.tencent.mm.plugin.report.d.a((int) this.hHL, new int[]{100, 300, 1000, 3000}, new Integer[]{Integer.valueOf(240), Integer.valueOf(ai.CTRL_BYTE), Integer.valueOf(bc.CTRL_BYTE), Integer.valueOf(bd.CTRL_BYTE), Integer.valueOf(JsApiGetSetting.CTRL_INDEX)})), 1, false);
                                    com.tencent.mm.plugin.report.d.pVE.a(99, (long) bi.e((Integer) com.tencent.mm.plugin.report.d.a(linkedList.size(), new int[]{0, 1, 2, 3, 5, 10}, new Integer[]{Integer.valueOf(az.CTRL_INDEX), Integer.valueOf(248), Integer.valueOf(an.CTRL_INDEX), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.f.c.a.CTRL_INDEX), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.f.g.CTRL_INDEX)})), 1, false);
                                    com.tencent.mm.plugin.report.d.pVE.a(99, com.tencent.mm.sdk.a.b.foreground ? 241 : 242, 1, false);
                                    com.tencent.mm.plugin.report.d.pVE.a(99, (long) l.this.hHD, 1, false);
                                    com.tencent.mm.plugin.report.d.pVE.a(99, 0, 1, false);
                                    com.tencent.mm.plugin.report.d dVar = com.tencent.mm.plugin.report.d.pVE;
                                    Object[] objArr = new Object[8];
                                    objArr[0] = Integer.valueOf(linkedList.size());
                                    objArr[1] = Long.valueOf(r10);
                                    objArr[2] = Integer.valueOf(l.this.hHD);
                                    objArr[3] = Integer.valueOf(l.this.hHG.vID.vWu);
                                    objArr[4] = Long.valueOf(this.hHL);
                                    objArr[5] = Integer.valueOf(this.hHM);
                                    objArr[6] = l.this.hHF;
                                    objArr[7] = Integer.valueOf(com.tencent.mm.sdk.a.b.foreground ? 1 : 2);
                                    dVar.h(12063, objArr);
                                    l.this.hHG = null;
                                    return false;
                                }
                                if (bi.bA(Wy) > 500) {
                                    x.d(l.this.TAG, "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", Long.valueOf(bi.bA(Wy)), Integer.valueOf(i2), Integer.valueOf(this.hHK), l.this.hHG);
                                    this.hHL += bi.bA(Wy);
                                    return true;
                                }
                                i = i2 + 1;
                            } else {
                                this.hHL += bi.bA(Wy);
                                return true;
                            }
                        }
                    }
                }
            }, true).K(50, 50);
            return;
        }
        if (this.hHG != null) {
            x.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
            this.errType = i2;
            this.errCode = i3;
            this.foE = str;
            ((b) qVar.Hv()).vID.vWu = 0;
        } else {
            this.gLE.a(i2, i3, str, this);
        }
        com.tencent.mm.plugin.report.d.pVE.a(99, 232, 1, false);
    }

    protected final void a(b bVar) {
        g.Dr();
        g.Dq().Db().set(8195, bi.bA(n.a(bVar.vID.vYE)));
        com.tencent.mm.sdk.platformtools.ad.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bi.bA(n.a(bVar.vID.vYE))).commit();
        g.Dr();
        g.Dq().Db().set(8196, Long.valueOf((long) bVar.vID.vWu));
        boolean z = ((bVar.vID.vWu & cLs) == 0 || super.Kk()) ? false : true;
        x.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", Boolean.valueOf(z), Integer.valueOf(bVar.vID.vWu), Integer.valueOf(cLs), Boolean.valueOf(super.Kk()));
        if (!(z || (bVar.vID.vWu & 256) == 0)) {
            com.tencent.mm.sdk.b.a.xmy.m(new qi());
        }
        if (!(z || (bVar.vID.vWu & 2097152) == 0)) {
            com.tencent.mm.sdk.b.a.xmy.m(new li());
        }
        com.tencent.mm.plugin.report.d.pVE.a(99, z ? 234 : 235, 1, false);
        x.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", Integer.valueOf(bVar.vID.vWu), Boolean.valueOf(this.hGP), Boolean.valueOf(z), Boolean.valueOf(hHz), Integer.valueOf(this.hGL), Boolean.valueOf(this.hHE), this.hHB);
        int i;
        if (!this.hGP && z) {
            this.hHE = true;
            a(this.hok, this.gLE);
        } else if (hHz) {
            x.i(this.TAG, "dkpush new notify pending, sync now");
            if (hHC != 0) {
                i = hHC;
                g.Dr();
                g.Do();
                f.aL(i, com.tencent.mm.kernel.a.Cn());
            }
            hHC = 0;
            this.hHB = null;
            hHz = false;
            this.hHE = true;
            a(this.hok, this.gLE);
        } else if (this.hHB != null) {
            i = hHC;
            g.Dr();
            g.Do();
            f.aL(i, com.tencent.mm.kernel.a.Cn());
            this.hHB = null;
            Qd();
            a(this.hok, this.gLE);
        } else {
            if ((this.hGL & 1) > 0) {
                g.Dr();
                g.CN().a(new h(this.hGO, bi.Wj(bi.oM((String) g.Dq().Db().get(8195, null)))), 0);
            }
            x.d(this.TAG, "sync or init end: reset selector : now = " + cLs + " default = 7");
            cLs = 7;
            this.gLE.a(this.errType, this.errCode, this.foE, this);
        }
    }

    private boolean Qe() {
        try {
            return ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) com.tencent.mm.sdk.platformtools.ad.getContext().getSystemService("power"), new Object[0])).booleanValue();
        } catch (Throwable e) {
            x.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", Boolean.valueOf(true), bi.i(e));
            return true;
        }
    }
}
