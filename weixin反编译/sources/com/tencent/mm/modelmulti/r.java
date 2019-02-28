package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ah;
import com.tencent.mm.f.a.li;
import com.tencent.mm.f.a.qi;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.atv;
import com.tencent.mm.protocal.c.atw;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.c.ou;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class r {
    private static Boolean hIV = null;
    private WakerLock gzR = null;
    public Queue<c> hIW = new LinkedList();
    public Queue<c> hIX = new LinkedList();
    private HashMap<c, Long> hIY = new HashMap();
    public c hIZ = null;
    private long hJa = 0;

    interface b {
        boolean ih(int i);
    }

    class d implements c {
        d() {
        }

        public final boolean b(Queue<c> queue) {
            PInt pInt = new PInt();
            g.Dr();
            g.Do();
            byte[] a = com.tencent.mm.booter.f.a(pInt, com.tencent.mm.kernel.a.Cn());
            String str = "MicroMsg.SyncService";
            String str2 = "%s index:%d, buf.len:%d ";
            Object[] objArr = new Object[3];
            objArr[0] = this;
            objArr[1] = Integer.valueOf(pInt.value);
            objArr[2] = Integer.valueOf(a != null ? a.length : -1);
            x.i(str, str2, objArr);
            if (pInt.value == 0 || bi.by(a)) {
                return false;
            }
            atw atw;
            final int i = pInt.value;
            atw atw2 = null;
            try {
                com.tencent.mm.protocal.w.b bVar = new com.tencent.mm.protocal.w.b();
                bVar.E(a);
                atw = bVar.vID;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.d.pVE.a(99, 38, 1, false);
                x.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed ", this, Integer.valueOf(i));
                g.Dr();
                g.Do();
                com.tencent.mm.booter.f.aL(i, com.tencent.mm.kernel.a.Cn());
                atw = atw2;
            } catch (Error e2) {
                com.tencent.mm.plugin.report.d.pVE.a(99, 39, 1, false);
                long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
                long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
                x.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", this, Integer.valueOf(i), Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory));
                r.assertTrue("LightPush memory error", false);
                atw = atw2;
            }
            if (atw == null) {
                return false;
            }
            com.tencent.mm.plugin.report.d.pVE.a(99, 20, 1, false);
            a aVar = new a(r.this, this, true, atw, new b() {
                public final boolean ih(int i) {
                    x.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", d.this, Integer.valueOf(i));
                    int i2 = i;
                    g.Dr();
                    g.Do();
                    com.tencent.mm.booter.f.aL(i2, com.tencent.mm.kernel.a.Cn());
                    g.Dt().F(new Runnable(d.this) {
                        public final void run() {
                            boolean z = true;
                            if (com.tencent.mm.kernel.a.Cz() || !g.Do().CF()) {
                                x.w("MicroMsg.SyncService", "begin to doLoop but MMCore account has not ready or MMCore is hold.");
                                return;
                            }
                            c dVar;
                            if (r3 != null) {
                                x.i("MicroMsg.SyncService", "finish proc:%s running:%s RunTime:%s ", r3, r.this.hIZ, Long.valueOf(bi.bA(r.this.hJa)));
                                if (r3 != r.this.hIZ) {
                                    for (c dVar2 : r.this.hIY.keySet()) {
                                        x.w("MicroMsg.SyncService", "check unfinish proc :%s timediff:%s", dVar2, Long.valueOf(bi.bA(((Long) r.this.hIY.get(dVar2)).longValue())));
                                    }
                                    r.assertTrue("oldproc timeout, should in timeoutMap:" + r3, bi.a((Long) r.this.hIY.remove(r3), -1) != -1);
                                    return;
                                }
                                r.a(r3, r.this.hJa);
                                r.this.hIZ = null;
                                r.this.hJa = 0;
                                r.this.Qm();
                            }
                            if (r.this.hIZ != null) {
                                if (bi.bA(r.this.hJa) > 90000) {
                                    x.w("MicroMsg.SyncService", "tryStart last proc:%s TIMEOUT:%s Run Next Now.", r.this.hIZ, Long.valueOf(bi.bA(r.this.hJa)));
                                    r.d(r.this, r.this.hIZ);
                                    r.this.hIY.put(r.this.hIZ, Long.valueOf(r.this.hJa));
                                    r.this.hIZ = null;
                                    r.this.hJa = 0;
                                    r.this.Qm();
                                } else {
                                    x.i("MicroMsg.SyncService", "tryStart last proc:%s running:%s ", r.this.hIZ, Long.valueOf(bi.bA(r.this.hJa)));
                                    return;
                                }
                            }
                            com.tencent.mm.plugin.zero.b.b bVar = (com.tencent.mm.plugin.zero.b.b) g.h(com.tencent.mm.plugin.zero.b.b.class);
                            if (bVar.bYG().Ih()) {
                                x.w("MicroMsg.SyncService", "Warning: Set SyncService Pause Now.");
                                bVar.bYG().If();
                            } else if (bVar.bYG().Ii()) {
                                x.w("MicroMsg.SyncService", "Warning: SyncService is Paused.");
                            } else {
                                dVar2 = new d();
                                if (dVar2.b(null)) {
                                    r.this.lM("LightPush");
                                    r.this.hIZ = dVar2;
                                    r.this.hJa = bi.Wy();
                                    return;
                                }
                                while (!r.this.hIX.isEmpty()) {
                                    dVar2 = (c) r.this.hIX.poll();
                                    x.i("MicroMsg.SyncService", "tryStart check NotifyData ListSize:%s proc:%s", Integer.valueOf(r.this.hIX.size()), dVar2);
                                    if (dVar2 != null && dVar2.b(null)) {
                                        r.this.lM("NotifyData");
                                        r.this.hIZ = dVar2;
                                        r.this.hJa = bi.Wy();
                                        return;
                                    }
                                }
                                if (!r.this.hIW.isEmpty()) {
                                    dVar2 = (c) r.this.hIW.poll();
                                    x.i("MicroMsg.SyncService", "tryStart check Sync ListSize:%s proc:%s", Integer.valueOf(r.this.hIW.size()), dVar2);
                                    if (dVar2 != null && dVar2.b(r.this.hIW)) {
                                        r.this.lM("NetSync");
                                        r.this.hIZ = dVar2;
                                        r.this.hJa = bi.Wy();
                                        return;
                                    }
                                }
                                x.i("MicroMsg.SyncService", "tryStart FINISH Check running:%s sync:%s notify:%s", r.this.hIZ, Integer.valueOf(r.this.hIW.size()), Integer.valueOf(r.this.hIX.size()));
                                String str = "";
                                if (!(r.this.hIZ == null && r.this.hIW.isEmpty() && r.this.hIX.isEmpty())) {
                                    z = false;
                                }
                                r.assertTrue(str, z);
                            }
                        }
                    });
                    return true;
                }
            }, (byte) 0);
            return true;
        }

        public final String toString() {
            return "LightPush[" + hashCode() + "]";
        }
    }

    class a {
        int hHb;
        boolean hJe;
        atw hJf;
        b hJg;
        c hJh;
        al hJi;

        /* synthetic */ a(r rVar, c cVar, boolean z, atw atw, b bVar, byte b) {
            this(cVar, z, atw, bVar);
        }

        private a(c cVar, boolean z, atw atw, b bVar) {
            this.hHb = 0;
            this.hJe = false;
            this.hJf = null;
            this.hJg = null;
            this.hJi = new al(g.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    if (g.Do().CF() && !com.tencent.mm.kernel.a.Cz()) {
                        g.Dr();
                        if (g.Dq() != null) {
                            g.Dr();
                            if (g.Dq().Db() != null) {
                                LinkedList linkedList = a.this.hJf.vYH.kyB;
                                com.tencent.mm.plugin.zero.c cVar = new com.tencent.mm.plugin.zero.c();
                                cVar.bw(a.this.hJh);
                                long Wy = bi.Wy();
                                while (a.this.hHb < linkedList.size()) {
                                    linkedList.size();
                                    if (!cVar.a((ot) linkedList.get(a.this.hHb), false)) {
                                        com.tencent.mm.plugin.report.d.pVE.a(99, 46, 1, false);
                                    }
                                    a aVar = a.this;
                                    aVar.hHb++;
                                    x.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", a.this.hJh, Long.valueOf(bi.bA(Wy)), Integer.valueOf(linkedList.size()), Integer.valueOf(a.this.hHb - 1));
                                    if (bi.bA(Wy) >= 500) {
                                        break;
                                    }
                                }
                                cVar.bx(a.this.hJh);
                                if (a.this.hHb < linkedList.size()) {
                                    x.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", a.this.hJh, Long.valueOf(bi.bA(Wy)), Integer.valueOf(linkedList.size()), Integer.valueOf(a.this.hHb - 1));
                                    return true;
                                }
                                r.a(a.this.hJe, a.this.hJf, a.this.hJh);
                                a.this.hJg.ih(linkedList.size());
                                return false;
                            }
                        }
                    }
                    Object[] objArr = new Object[4];
                    objArr[0] = a.this.hJh;
                    objArr[1] = Boolean.valueOf(g.Do().CF());
                    objArr[2] = Boolean.valueOf(com.tencent.mm.kernel.a.Cz());
                    g.Dr();
                    objArr[3] = g.Dq();
                    x.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", objArr);
                    a.this.hJg.ih(0);
                    return false;
                }
            }, true);
            this.hJg = bVar;
            this.hJh = cVar;
            this.hJe = z;
            this.hJf = atw;
            this.hHb = 0;
            String str = "";
            boolean z2 = (this.hJg == null || this.hJh == null) ? false : true;
            r.assertTrue(str, z2);
            if (this.hJf == null) {
                r.assertTrue("resp Not null", false);
                x.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", this.hJh);
                this.hJg.ih(0);
                return;
            }
            if (g.Do().CF() && !com.tencent.mm.kernel.a.Cz()) {
                g.Dr();
                if (g.Dq() != null) {
                    g.Dr();
                    if (g.Dq().Db() != null) {
                        r.a((r) r.this, atw);
                        long j = (long) atw.wII;
                        if (String.valueOf(j).length() == 10) {
                            j *= 1000;
                        }
                        long currentTimeMillis = System.currentTimeMillis() - j;
                        long j2 = currentTimeMillis / 1000;
                        x.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", Long.valueOf(System.currentTimeMillis()), Long.valueOf(j), Long.valueOf(currentTimeMillis), Long.valueOf(j2));
                        g.Dr();
                        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_CLIENT_SERVER_DIFF_TIME_LONG, Long.valueOf(currentTimeMillis));
                        g.Dr();
                        g.Do().aT(this.hJf.kyY, this.hJf.wIH);
                        g.Dr();
                        g.Do();
                        com.tencent.mm.kernel.a.gB(this.hJf.kyY);
                        if (this.hJf.vYH == null || this.hJf.vYH.kyB == null || this.hJf.vYH.kyB.size() <= 0) {
                            x.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", this.hJh);
                            r.a(z, this.hJf, this.hJh);
                            this.hJg.ih(0);
                            return;
                        }
                        x.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", this.hJh, Integer.valueOf(this.hJf.vYH.kyB.size()), Integer.valueOf(this.hJf.kyY), Integer.valueOf(this.hJf.wIH));
                        this.hJi.K(50, 50);
                        return;
                    }
                }
            }
            Object[] objArr = new Object[4];
            objArr[0] = this.hJh;
            objArr[1] = Boolean.valueOf(g.Do().CF());
            objArr[2] = Boolean.valueOf(com.tencent.mm.kernel.a.Cz());
            g.Dr();
            objArr[3] = g.Dq();
            x.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", objArr);
            this.hJg.ih(0);
        }
    }

    class e extends k implements c, com.tencent.mm.network.k {
        int cLs;
        com.tencent.mm.ad.e hJm;
        boolean hJn;
        private boolean hJo = false;
        private q hoZ;
        int scene;

        public final boolean b(Queue<c> queue) {
            String str;
            String str2 = "MicroMsg.SyncService";
            String str3 = "%s begin run scene:%s selector:%s isContinue:%s List:%s";
            Object[] objArr = new Object[5];
            objArr[0] = this;
            objArr[1] = Integer.valueOf(this.scene);
            objArr[2] = Integer.valueOf(this.cLs);
            objArr[3] = Boolean.valueOf(this.hJn);
            if (queue == null) {
                str = "null";
            } else {
                str = Integer.valueOf(queue.size());
            }
            objArr[4] = str;
            x.i(str2, str3, objArr);
            if (queue != null) {
                r.a(r.this, (Queue) queue);
                boolean z = false;
                boolean z2 = false;
                while (!queue.isEmpty()) {
                    e eVar = (e) queue.poll();
                    this.cLs |= eVar.cLs;
                    if (eVar.scene == 3) {
                        z = true;
                    } else if (eVar.hJn) {
                        z2 = true;
                    }
                    x.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", this, Integer.valueOf(queue.size()), eVar, Integer.valueOf(eVar.scene), Integer.valueOf(eVar.cLs), Boolean.valueOf(eVar.hJn), Boolean.valueOf(z2), Boolean.valueOf(z));
                }
                if (z) {
                    this.scene = 3;
                } else if (z2) {
                    this.scene = 6;
                }
            }
            if (g.Do().CF() && !com.tencent.mm.kernel.a.Cz()) {
                g.Dr();
                if (g.Dq() != null) {
                    g.Dr();
                    if (g.Dq().Db() != null) {
                        g.Dr();
                        long a = bi.a((Long) g.Dq().Db().get(8196, null), 0);
                        if (a != 0) {
                            g.Dr();
                            g.Dq().Db().set(8196, Long.valueOf(0));
                            this.cLs = (int) (((long) this.cLs) | a);
                            this.cLs &= 95;
                        }
                        int i = this.scene == 3 ? 1 : 0;
                        if (this.scene == HardCoderJNI.FUNC_REG_ANR_CALLBACK) {
                            this.cLs |= 16;
                            this.scene = 7;
                        } else if (this.scene == HardCoderJNI.FUNC_REG_PRELOAD_BOOT_RESOURCE) {
                            this.cLs |= 64;
                            this.scene = 7;
                        } else if (this.scene == 3) {
                            this.cLs |= 262144;
                            this.scene = 3;
                        }
                        if (this.hJn) {
                            this.scene = 6;
                        }
                        this.hoZ = new com.tencent.mm.modelmulti.l.a();
                        atv atv = ((com.tencent.mm.protocal.w.a) this.hoZ.Kh()).vIC;
                        atv.wIG = i;
                        atv.vYD = this.cLs;
                        atv.sfa = this.scene;
                        g.Dr();
                        atv.vYE = n.N(bi.Wj(bi.oM((String) g.Dq().Db().get(8195, new byte[0]))));
                        atv.wIF = new ou();
                        atv.vQr = com.tencent.mm.protocal.d.DEVICE_TYPE;
                        x.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", this, Long.valueOf(a), Integer.valueOf(atv.wIG), Integer.valueOf(atv.vYD), Integer.valueOf(this.scene), atv.vQr);
                        x.i("MicroMsg.SyncService", "%s Req synckey %s", this, ad.bk(bi.Wj(str)));
                        r.a(this);
                        g.Dr();
                        if (g.Dp().gRu.a((k) this, 0)) {
                            return true;
                        }
                        com.tencent.mm.plugin.report.d.pVE.h(11098, Integer.valueOf(3500), this.scene + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + r.Qe());
                        x.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", this);
                        com.tencent.mm.plugin.report.d.pVE.a(99, 41, 1, false);
                        return false;
                    }
                }
            }
            Object[] objArr2 = new Object[4];
            objArr2[0] = this;
            objArr2[1] = Boolean.valueOf(g.Do().CF());
            objArr2[2] = Boolean.valueOf(com.tencent.mm.kernel.a.Cz());
            g.Dr();
            objArr2[3] = g.Dq();
            x.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", objArr2);
            return false;
        }

        public final String toString() {
            return "NetSync[" + hashCode() + "]";
        }

        public e(int i, int i2, boolean z) {
            this.scene = i;
            this.cLs = i2;
            this.hJn = z;
        }

        public final int getType() {
            return 138;
        }

        public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
            this.hJm = eVar2;
            return a(eVar, this.hoZ, this);
        }

        public final boolean Km() {
            return false;
        }

        public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
            if (qVar == null || qVar.getType() != 138) {
                int i4;
                com.tencent.mm.plugin.report.d.pVE.a(99, 44, 1, false);
                String str2 = "MicroMsg.SyncService";
                String str3 = "%s onGYNetEnd error type:%d";
                Object[] objArr = new Object[2];
                objArr[0] = this;
                if (qVar == null) {
                    i4 = -2;
                } else {
                    i4 = qVar.getType();
                }
                objArr[1] = Integer.valueOf(i4);
                x.e(str2, str3, objArr);
            } else if (this.hJo) {
                x.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", this);
            } else {
                boolean z;
                int cgq;
                this.hJo = true;
                r.assertTrue("Check rr failed.", qVar == this.hoZ);
                if (i2 == 0 && i3 == 0) {
                    z = true;
                } else {
                    x.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", this, Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
                    if (i2 == 4 && i3 == -2006) {
                        x.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", this);
                        com.tencent.mm.plugin.report.d.pVE.a(99, 42, 1, false);
                        z = false;
                    } else {
                        com.tencent.mm.plugin.report.d.pVE.h(11098, Integer.valueOf(3501), this.scene + ";" + i2 + ";" + i3 + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + r.Qe());
                        com.tencent.mm.plugin.report.d.pVE.a(99, 43, 1, false);
                        this.hJm.a(i2, i3, str, this);
                        g.Dt().F(/* anonymous class already generated */);
                        return;
                    }
                }
                atw atw = ((com.tencent.mm.protocal.w.b) qVar.Hv()).vID;
                boolean z2 = HardCoderJNI.hcReceiveMsgEnable;
                int i5 = HardCoderJNI.hcReceiveMsgDelay;
                int i6 = HardCoderJNI.hcReceiveMsgCPU;
                int i7 = HardCoderJNI.hcReceiveMsgIO;
                if (HardCoderJNI.hcReceiveMsgThr) {
                    cgq = g.Dt().cgq();
                } else {
                    cgq = 0;
                }
                i5 = HardCoderJNI.startPerformance(z2, i5, i6, i7, cgq, HardCoderJNI.hcReceiveMsgTimeout, 201, HardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
                final atw atw2 = atw;
                a aVar = new a(r.this, this, z, atw, new b() {
                    public final boolean ih(int i) {
                        g.Dr();
                        g.Dq().Db().set(8196, Long.valueOf((long) atw2.vWu));
                        boolean z = (atw2.vWu & e.this.cLs) != 0;
                        x.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s", e.this, Integer.valueOf(atw2.vWu), Boolean.valueOf(z), Integer.valueOf(atw2.vWu & 256));
                        if (!(z || (atw2.vWu & 256) == 0)) {
                            com.tencent.mm.sdk.b.a.xmy.m(new qi());
                        }
                        if (!(z || (atw2.vWu & 2097152) == 0)) {
                            com.tencent.mm.sdk.b.a.xmy.m(new li());
                        }
                        if (z) {
                            if (i == 0 && e.this.hJn) {
                                x.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", e.this);
                            } else {
                                r.this.d(e.this.scene, e.this.cLs, true);
                            }
                        }
                        e.this.hJm.a(0, 0, "", e.this);
                        g.Dt().F(/* anonymous class already generated */);
                        HardCoderJNI.stopPerformace(HardCoderJNI.hcReceiveMsgEnable, i5);
                        return true;
                    }
                }, (byte) 0);
            }
        }
    }

    class f implements c {
        int hGL;
        atw hJf;
        long hJs;

        public f(com.tencent.mm.protocal.w.b bVar, int i, long j) {
            this.hJf = bVar == null ? null : bVar.vID;
            this.hJs = j;
            this.hGL = i;
        }

        public final boolean b(Queue<c> queue) {
            if (this.hJf == null) {
                com.tencent.mm.plugin.report.d.pVE.a(99, 40, 1, false);
                x.e("MicroMsg.SyncService", "%s run resp == null", this);
                return false;
            } else if (10018 == com.tencent.mm.platformtools.r.ifN) {
                x.e("MicroMsg.SyncService", "%s Give up for test", this);
                return false;
            } else {
                a aVar = new a(r.this, this, true, this.hJf, new b() {
                    public final boolean ih(int i) {
                        x.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", f.this, f.this.hJf, Integer.valueOf(f.this.hGL), Long.valueOf(f.this.hJs));
                        if ((f.this.hGL & 1) > 0) {
                            g.Dr();
                            g.CN().a(new h(f.this.hJs, bi.Wj(bi.oM((String) g.Dq().Db().get(8195, null)))), 0);
                        }
                        g.Dt().F(/* anonymous class already generated */);
                        return true;
                    }
                }, (byte) 0);
                com.tencent.mm.plugin.report.d.pVE.a(99, 21, 1, false);
                return true;
            }
        }

        public final String toString() {
            return "NotifyData[" + hashCode() + "]";
        }
    }

    public interface c {
        boolean b(Queue<c> queue);
    }

    static /* synthetic */ void a(c cVar, long j) {
        if (cVar != null) {
            com.tencent.mm.plugin.report.d.pVE.a(99, (long) bi.e((Integer) com.tencent.mm.plugin.report.d.a((int) bi.bA(j), new int[]{200, 500, 800, 1500, 3000, 5000, 10000, 30000, 60000, 90000}, new Integer[]{Integer.valueOf(70), Integer.valueOf(71), Integer.valueOf(72), Integer.valueOf(73), Integer.valueOf(74), Integer.valueOf(75), Integer.valueOf(76), Integer.valueOf(77), Integer.valueOf(78), Integer.valueOf(79), Integer.valueOf(80)})), 1, false);
        }
    }

    static /* synthetic */ void a(e eVar) {
        com.tencent.mm.plugin.report.d.pVE.a(99, (long) eVar.scene, 1, false);
        com.tencent.mm.plugin.report.d.pVE.a(99, 0, 1, false);
        com.tencent.mm.plugin.report.d.pVE.a(99, com.tencent.mm.sdk.a.b.foreground ? 241 : 242, 1, false);
    }

    static /* synthetic */ void a(r rVar, c cVar) {
        if (cVar == null) {
            com.tencent.mm.plugin.report.d.pVE.h(11098, Integer.valueOf(3550), com.tencent.mm.sdk.a.b.foreground + ";" + Qe());
            com.tencent.mm.plugin.report.d.pVE.a(99, 48, 1, false);
        } else if (cVar instanceof e) {
            com.tencent.mm.plugin.report.d.pVE.h(11098, Integer.valueOf(3551), com.tencent.mm.sdk.a.b.foreground + ";" + Qe());
            com.tencent.mm.plugin.report.d.pVE.a(99, 49, 1, false);
        } else if (cVar instanceof f) {
            com.tencent.mm.plugin.report.d.pVE.h(11098, Integer.valueOf(3552), com.tencent.mm.sdk.a.b.foreground + ";" + Qe());
            com.tencent.mm.plugin.report.d.pVE.a(99, 50, 1, false);
        } else if (cVar instanceof d) {
            com.tencent.mm.plugin.report.d.pVE.h(11098, Integer.valueOf(3553), com.tencent.mm.sdk.a.b.foreground + ";" + Qe());
            com.tencent.mm.plugin.report.d.pVE.a(99, 51, 1, false);
        } else {
            com.tencent.mm.plugin.report.d.pVE.h(11098, Integer.valueOf(3554), com.tencent.mm.sdk.a.b.foreground + ";" + Qe());
            com.tencent.mm.plugin.report.d.pVE.a(99, 52, 1, false);
        }
    }

    static /* synthetic */ void a(r rVar, atw atw) {
        int size = (atw.vYH == null || atw.vYH.kyB == null || atw.vYH.kyB.size() <= 0) ? 0 : atw.vYH.kyB.size();
        com.tencent.mm.plugin.report.d.pVE.a(99, (long) bi.e((Integer) com.tencent.mm.plugin.report.d.a(size, new int[]{0, 1, 2, 3, 5, 10}, new Integer[]{Integer.valueOf(az.CTRL_INDEX), Integer.valueOf(248), Integer.valueOf(an.CTRL_INDEX), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.f.c.a.CTRL_INDEX), Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.f.g.CTRL_INDEX)})), 1, false);
        if (!Qe()) {
            com.tencent.mm.plugin.report.d.pVE.a(99, size > 0 ? 221 : 218, 1, false);
        } else if (com.tencent.mm.sdk.a.b.foreground) {
            com.tencent.mm.plugin.report.d.pVE.a(99, size > 0 ? 219 : 216, 1, false);
        } else {
            com.tencent.mm.plugin.report.d.pVE.a(99, size > 0 ? 220 : 217, 1, false);
        }
    }

    static /* synthetic */ void a(r rVar, Queue queue) {
        if (queue != null && !queue.isEmpty()) {
            if (queue.size() >= 5) {
                com.tencent.mm.plugin.report.d.pVE.h(11098, Integer.valueOf(3590), queue.size() + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + Qe());
            }
            com.tencent.mm.plugin.report.d.pVE.a(99, (long) bi.e((Integer) com.tencent.mm.plugin.report.d.a(queue.size(), new int[]{1, 2, 3, 4, 5, 10}, new Integer[]{Integer.valueOf(60), Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(63), Integer.valueOf(64), Integer.valueOf(65), Integer.valueOf(66)})), 1, false);
        }
    }

    static /* synthetic */ void a(boolean z, atw atw, c cVar) {
        g.Dr();
        byte[] Wj = bi.Wj(bi.oM((String) g.Dq().Db().get(8195, new byte[0])));
        byte[] a = n.a(atw.vYE);
        x.i("MicroMsg.SyncService", "processResp %s synckey req:%s  shouldMerge:%s", cVar, ad.bk(Wj), Boolean.valueOf(z));
        x.i("MicroMsg.SyncService", "processResp %s synckey resp:%s", cVar, ad.bk(a));
        if (atw.vYE == null || atw.vYE.wRk <= 0) {
            com.tencent.mm.plugin.report.d.pVE.a(99, 47, 1, false);
            return;
        }
        if (z) {
            byte[] g = ad.g(Wj, a);
            x.i("MicroMsg.SyncService", "processResp %s synckey merge:%s", cVar, ad.bk(g));
            if (g == null || g.length <= 0) {
                g = a;
            }
            atw.vYE = n.N(g);
        }
        if (Arrays.equals(Wj, n.a(atw.vYE))) {
            x.i("MicroMsg.SyncService", "processResp %s  Sync Key Not change, not save", cVar);
            return;
        }
        g.Dr();
        g.Dq().Db().set(8195, bi.bA(n.a(atw.vYE)));
        com.tencent.mm.sdk.platformtools.ad.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bi.bA(n.a(atw.vYE))).commit();
    }

    static /* synthetic */ void d(r rVar, c cVar) {
        if (cVar instanceof e) {
            com.tencent.mm.plugin.report.d.pVE.h(11098, Integer.valueOf(3571), com.tencent.mm.sdk.a.b.foreground + ";" + Qe());
            com.tencent.mm.plugin.report.d.pVE.a(99, com.tencent.mm.sdk.a.b.foreground ? 30 : 34, 1, false);
        } else if (cVar instanceof f) {
            com.tencent.mm.plugin.report.d.pVE.h(11098, Integer.valueOf(3572), com.tencent.mm.sdk.a.b.foreground + ";" + Qe());
            com.tencent.mm.plugin.report.d.pVE.a(99, com.tencent.mm.sdk.a.b.foreground ? 31 : 35, 1, false);
        } else if (cVar instanceof d) {
            com.tencent.mm.plugin.report.d.pVE.h(11098, Integer.valueOf(3573), com.tencent.mm.sdk.a.b.foreground + ";" + Qe());
            com.tencent.mm.plugin.report.d.pVE.a(99, com.tencent.mm.sdk.a.b.foreground ? 32 : 36, 1, false);
        } else {
            com.tencent.mm.plugin.report.d.pVE.h(11098, Integer.valueOf(3574), com.tencent.mm.sdk.a.b.foreground + ";" + Qe());
            com.tencent.mm.plugin.report.d.pVE.a(99, com.tencent.mm.sdk.a.b.foreground ? 33 : 37, 1, false);
        }
    }

    private static boolean EW() {
        if (com.tencent.mm.kernel.a.Cz() || !g.Do().CF()) {
            return false;
        }
        if (hIV != null) {
            return hIV.booleanValue();
        }
        hIV = Boolean.valueOf(true);
        return true;
    }

    private static void assertTrue(String str, boolean z) {
        if (!z) {
            x.e("MicroMsg.SyncService", "ASSERT now msg:%s", str);
            Assert.assertTrue(str, z);
        }
    }

    public final int a(long j, int i, String str) {
        int i2 = 0;
        x.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s [%s] ", Boolean.valueOf(EW()), Long.valueOf(j), Integer.valueOf(i), str, bi.chl());
        if ((256 & j) != 0) {
            com.tencent.mm.sdk.b.a.xmy.m(new qi());
        }
        if ((2097152 & j) != 0) {
            com.tencent.mm.sdk.b.a.xmy.m(new li());
        }
        long j2 = ((-257 & j) & -2097153) & 95;
        if (j2 != 0 && g.Do().CF()) {
            g.Dr();
            if (g.Dq().Db() != null) {
                g.Dr();
                g.Dq().Db().set(8196, Long.valueOf(j2));
                if (r1) {
                    i2 = d(i, 7, false);
                } else {
                    k lVar = new l(i);
                    x.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", Integer.valueOf(lVar.hashCode()));
                    g.Dr();
                    if (g.Dp().gRu.a(lVar, 0)) {
                        i2 = r1;
                    } else {
                        x.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", Integer.valueOf(r1));
                    }
                }
            }
        }
        if (!bi.oN(str)) {
            com.tencent.mm.sdk.b.b ahVar = new ah();
            ahVar.fpb.type = 3;
            ahVar.fpb.fpd = str;
            com.tencent.mm.sdk.b.a.xmy.m(ahVar);
        }
        return i2;
    }

    public final void a(com.tencent.mm.protocal.w.b bVar, int i, long j) {
        x.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s [%s]", Boolean.valueOf(EW()), bVar, Integer.valueOf(i), Long.valueOf(j), bi.chl());
        if (EW()) {
            a(new f(bVar, i, j));
            return;
        }
        g.Dr();
        g.Dp().gRu.a(new l(bVar, i, j), 0);
    }

    public final int ig(int i) {
        x.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", Boolean.valueOf(EW()), Integer.valueOf(i), bi.chl());
        if (EW()) {
            return d(i, 7, false);
        }
        k lVar = new l(i);
        g.Dr();
        g.Dp().gRu.a(lVar, 0);
        return lVar.hashCode();
    }

    private int d(int i, int i2, boolean z) {
        c eVar = new e(i, i2, z);
        a(eVar);
        return eVar.hashCode();
    }

    private synchronized void lM(String str) {
        boolean z = true;
        synchronized (this) {
            x.i("MicroMsg.SyncService", "wakelock tag:%s syncWakerLock:%s [%s]", str, this.gzR, bi.chl());
            if (this.gzR == null) {
                this.gzR = new WakerLock(com.tencent.mm.sdk.platformtools.ad.getContext(), new IAutoUnlockCallback() {
                    public final void autoUnlockCallback() {
                        x.e("MicroMsg.SyncService", "ERROR: %s auto unlock syncWakerLock", r.this.hIZ);
                        r.a(r.this, r.this.hIZ);
                    }
                });
            }
            String str2 = "lock";
            if (this.gzR.isLocking()) {
                z = false;
            }
            assertTrue(str2, z);
            if (!com.tencent.mm.sdk.a.b.foreground) {
                this.gzR.lock(30000, str);
            }
        }
    }

    private synchronized void Qm() {
        if (this.gzR == null || !this.gzR.isLocking()) {
            String str;
            String str2 = "MicroMsg.SyncService";
            String str3 = "wakeUnlock syncWakerLock locking?:%s foreground:%s";
            Object[] objArr = new Object[2];
            if (this.gzR == null) {
                str = "null";
            } else {
                str = Boolean.valueOf(this.gzR.isLocking());
            }
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground);
            x.w(str2, str3, objArr);
        } else {
            this.gzR.unLock();
        }
    }

    private void a(final c cVar) {
        if (m.Qf()) {
            x.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", cVar);
            return;
        }
        g.Dt().F(new Runnable() {
            public final void run() {
                if (cVar != null) {
                    if (cVar instanceof f) {
                        r.this.hIX.add(cVar);
                    } else {
                        r.this.hIW.add(cVar);
                    }
                }
                g.Dt().F(/* anonymous class already generated */);
            }
        });
    }

    private static boolean Qe() {
        try {
            return ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) com.tencent.mm.sdk.platformtools.ad.getContext().getSystemService("power"), new Object[0])).booleanValue();
        } catch (Throwable e) {
            com.tencent.mm.plugin.report.d.pVE.a(99, 45, 1, false);
            x.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", Boolean.valueOf(true), bi.i(e));
            return true;
        }
    }
}
