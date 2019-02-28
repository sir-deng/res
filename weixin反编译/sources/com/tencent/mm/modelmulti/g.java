package com.tencent.mm.modelmulti;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.i;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.c.atp;
import com.tencent.mm.protocal.c.atq;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class g extends k implements com.tencent.mm.network.k {
    e gLE;
    final Queue<a> hAk = new LinkedList();
    f hCU = null;
    boolean hGJ = false;
    com.tencent.mm.compatible.util.g.a hGM;
    private StringBuilder hGN = new StringBuilder();
    final atp hGX = new atp();
    int hGY = 0;
    boolean hGZ = false;
    int hHa = 0;
    int hHb = 0;
    private final al hmy = new al(com.tencent.mm.kernel.g.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            float f = 1.0f;
            if (!com.tencent.mm.kernel.g.Do().CF() || com.tencent.mm.kernel.a.Cz()) {
                x.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
                return false;
            } else if (g.this.hGJ) {
                x.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", Integer.valueOf(g.this.hashCode()));
                return false;
            } else if (g.this.hAk.isEmpty()) {
                x.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
                return false;
            } else {
                boolean z;
                x.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", Integer.valueOf(g.this.hashCode()), Long.valueOf(g.this.hGM.zp()), Integer.valueOf(g.this.hAk.size()), Integer.valueOf(g.this.hGY), Boolean.valueOf(g.this.hGZ), Integer.valueOf(g.this.hHb), Integer.valueOf(g.this.hHa));
                com.tencent.mm.kernel.g.Dr();
                long dA = com.tencent.mm.kernel.g.Dq().gRU.dA(Thread.currentThread().getId());
                c cVar = new c();
                cVar.bw("NetSceneInit");
                int i = g.this.hGZ ? 40 : 10;
                int i2 = 0;
                while (i2 < i) {
                    final a aVar = (a) g.this.hAk.peek();
                    if (aVar.hHg != Integer.MAX_VALUE) {
                        LinkedList linkedList = aVar.hHf.wIe;
                        if (linkedList != null && linkedList.size() > aVar.hAx) {
                            linkedList.size();
                            if (cVar.a((ot) linkedList.get(aVar.hAx), true)) {
                                aVar.hAx++;
                                g gVar = g.this;
                                gVar.hHb++;
                                i2++;
                            }
                        }
                        g.this.hAk.poll();
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().Db().set(8197, bi.bA(n.a(aVar.hHf.wIa)));
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().Db().set(8198, bi.bA(n.a(aVar.hHf.wIb)));
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().Db().set(16, Integer.valueOf(0));
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().Db().set(8196, Long.valueOf((long) aVar.hHf.wIc));
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().Db().lO(true);
                        z = true;
                        break;
                    }
                    boolean z2;
                    String str = "in Queue tail , resp should be null";
                    if (aVar.hHf == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Assert.assertTrue(str, z2);
                    com.tencent.mm.kernel.g.Dr();
                    String str2 = (String) com.tencent.mm.kernel.g.Dq().Db().get(8198, null);
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().set(8195, str2);
                    ad.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", str2).commit();
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().set(8197, "");
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().set(8198, "");
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().set(15, Integer.valueOf(1));
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().lO(true);
                    x.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", Integer.valueOf(g.this.hashCode()), Long.valueOf(g.this.hGM.zp()), Integer.valueOf(g.this.hGY), Integer.valueOf(g.this.hHa), Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                    com.tencent.mm.kernel.g.Dt().F(new Runnable() {
                        public final void run() {
                            g.this.gLE.a(aVar.errType, aVar.errCode, aVar.foE, g.this);
                        }
                    });
                    z = false;
                }
                z = true;
                cVar.bx("NetSceneInit");
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dq().gRU.fT(dA);
                k kVar = g.this;
                if (kVar.hCU == null) {
                    x.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
                } else {
                    int i3 = kVar.hGY > 50 ? 50 : kVar.hGY;
                    if (kVar.hGZ) {
                        float f2 = ((float) kVar.hHb) / ((float) kVar.hHa);
                        if (f2 > 1.0f) {
                            f2 = 1.0f;
                        }
                        float f3 = f2;
                        i = (int) ((((float) (100 - i3)) * f2) + ((float) i3));
                        f = f3;
                    } else {
                        i = i3;
                    }
                    x.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", Integer.valueOf(kVar.hHb), Integer.valueOf(kVar.hHa), Float.valueOf(f), Integer.valueOf(i3));
                    kVar.hCU.a(i, 100, kVar);
                }
                return z;
            }
        }
    }, true);
    private int retryCount = 3;

    public static class b extends i {
        private final com.tencent.mm.protocal.v.a hHh = new com.tencent.mm.protocal.v.a();
        private final com.tencent.mm.protocal.v.b hHi = new com.tencent.mm.protocal.v.b();

        protected final d Hu() {
            return this.hHh;
        }

        public final com.tencent.mm.protocal.k.e Hv() {
            return this.hHi;
        }

        public final int getType() {
            return v.CTRL_INDEX;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newinit";
        }
    }

    class a {
        int errCode;
        int errType;
        String foE;
        int hAx = 0;
        atq hHf;
        int hHg = 0;

        a() {
        }
    }

    public g(f fVar) {
        x.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", Integer.valueOf(hashCode()), bi.chl());
        this.hGN.append("stack:" + bi.chl() + " time:" + bi.Wx());
        this.hCU = fVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.hGM = new com.tencent.mm.compatible.util.g.a();
        this.gLE = eVar2;
        atp atp = this.hGX;
        com.tencent.mm.kernel.g.Dr();
        atp.kyG = (String) com.tencent.mm.kernel.g.Dq().Db().get(2, null);
        Assert.assertTrue("by DK: req.UserName is null", !bi.oN(this.hGX.kyG));
        this.hGX.lTZ = w.cfV();
        return a(eVar, null, null);
    }

    private int a(com.tencent.mm.network.e eVar, bes bes, bes bes2) {
        this.hGN.append(" lastd:" + this.hol + " dotime:" + bi.Wx() + " net:" + ao.getNetType(ad.getContext()));
        q bVar = new b();
        if (bes == null) {
            com.tencent.mm.kernel.g.Dr();
            bes = n.N(bi.Wj(bi.oM((String) com.tencent.mm.kernel.g.Dq().Db().get(8197, null))));
        }
        if (bes2 == null) {
            com.tencent.mm.kernel.g.Dr();
            bes2 = n.N(bi.Wj(bi.oM((String) com.tencent.mm.kernel.g.Dq().Db().get(8198, null))));
        }
        com.tencent.mm.kernel.g.Dr();
        if (bi.e((Integer) com.tencent.mm.kernel.g.Dq().Db().get(16, null)) == 0 || (bes != null && bes.wRk > 0)) {
            com.tencent.mm.kernel.g.Dr();
            if (bi.oM((String) com.tencent.mm.kernel.g.Dq().Db().get(8195, null)).length() <= 0) {
                bVar.Kh().vHV = 3;
            } else {
                bVar.Kh().vHV = 4;
            }
        } else {
            bVar.Kh().vHV = 7;
        }
        this.hGX.wIa = bes;
        this.hGX.wIb = bes2;
        ((com.tencent.mm.protocal.v.a) bVar.Kh()).vIA = this.hGX;
        x.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", Integer.valueOf(hashCode()), Long.valueOf(this.hGM.zp()), Integer.valueOf(this.hGY), this.hGX.kyG, this.hGX.lTZ, Integer.valueOf(bVar.Kh().vHV), bi.bA(n.a(bes)), bi.bA(n.a(bes2)));
        this.hGY++;
        return a(eVar, bVar, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.hGN.append(" endtime:" + bi.Wx());
        x.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i));
        if (i2 == 4 && i3 == -100) {
            x.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
            this.hGJ = true;
            this.gLE.a(i2, i3, str, this);
        } else if ((i2 == 0 && i3 == 0) || (i2 == 4 && i3 == -17)) {
            atq atq = ((com.tencent.mm.protocal.v.b) qVar.Hv()).vIB;
            this.hHa += atq.wId;
            x.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(this.hGM.zp()), Integer.valueOf(this.hHa), Integer.valueOf(this.hGY), Integer.valueOf(atq.vWu));
            a(this.hGY - 1, i2, i3, str, atq);
            if ((atq.vWu & 7) == 0 || super.Kk()) {
                x.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", Integer.valueOf(hashCode()), Long.valueOf(this.hGM.zp()), Integer.valueOf(this.hGY));
                this.hGZ = true;
                a(Integer.MAX_VALUE, 0, 0, "", null);
            } else if (a(this.hok, atq.wIa, atq.wIb) == -1) {
                x.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
                a(Integer.MAX_VALUE, 3, -1, "", null);
            }
        } else {
            x.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (this.retryCount > 0) {
                this.retryCount--;
                if (a(this.hok, null, null) != -1) {
                    return;
                }
            }
            this.hGJ = true;
            this.gLE.a(3, -1, "", this);
        }
    }

    public final boolean Kj() {
        return true;
    }

    protected final void cancel() {
        x.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", bi.chl());
        super.cancel();
        this.hGJ = true;
    }

    private void a(int i, int i2, int i3, String str, atq atq) {
        a aVar = new a();
        aVar.hHg = i;
        aVar.errCode = i3;
        aVar.errType = i2;
        aVar.foE = str;
        aVar.hHf = atq;
        this.hAk.add(aVar);
        if (this.hmy.cgx()) {
            this.hmy.K(50, 50);
        }
    }

    public final String getInfo() {
        return this.hGN.toString();
    }

    protected final int Bo() {
        return 500;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    public final boolean Kk() {
        return super.Kk();
    }

    public final int getType() {
        return v.CTRL_INDEX;
    }
}
