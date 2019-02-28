package com.tencent.mm.modelfriend;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.i;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.protocal.c.bnq;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.at;
import java.util.Iterator;

public final class s extends k implements com.tencent.mm.network.k {
    public static a hya;
    e gLE;
    private int hoC;
    public final q hoZ;

    public static class b extends i {
        private final com.tencent.mm.protocal.m.a hye = new com.tencent.mm.protocal.m.a();
        private final com.tencent.mm.protocal.m.b hyf = new com.tencent.mm.protocal.m.b();

        protected final d Hu() {
            return this.hye;
        }

        public final com.tencent.mm.protocal.k.e Hv() {
            return this.hyf;
        }

        public final int getType() {
            return c.CTRL_INDEX;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/bindopmobileforreg";
        }

        public final int Ke() {
            return 1;
        }
    }

    public interface a {
        String Or();
    }

    public s(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, 11, str2, 0, str3, str4);
        com.tencent.mm.protocal.m.a aVar = (com.tencent.mm.protocal.m.a) this.hoZ.Kh();
        aVar.vIg.vSX = str5;
        aVar.vIg.vSY = str6;
    }

    public s(String str, int i, String str2, int i2, String str3, String str4) {
        this(str, i, str2, 0, str3);
        ((com.tencent.mm.protocal.m.a) this.hoZ.Kh()).vIg.vQc = str4;
    }

    public s(String str, int i, String str2, int i2, String str3) {
        this.gLE = null;
        this.hoC = 2;
        this.hoZ = new b();
        com.tencent.mm.protocal.m.a aVar = (com.tencent.mm.protocal.m.a) this.hoZ.Kh();
        aVar.vIg.vQC = i;
        x.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + str + " opcode:" + i + " verifyCode:" + str2);
        aVar.vIg.vSS = str;
        aVar.vIg.vST = str2;
        aVar.vIg.vSU = i2;
        aVar.vIg.vSV = str3;
        aVar.vIg.lTZ = w.cfV();
        aVar.vIg.vQq = com.tencent.mm.kernel.a.CI();
        if (bi.oN(aVar.vIg.vSX) && bi.oN(aVar.vIg.vSY)) {
            aVar.vIg.vSX = hya != null ? hya.Or() : "";
            aVar.vIg.vSY = com.tencent.mm.protocal.d.vHj;
        }
    }

    public final void hH(int i) {
        ((com.tencent.mm.protocal.m.a) this.hoZ.Kh()).vIg.vTa = i;
    }

    public final void hI(int i) {
        ((com.tencent.mm.protocal.m.a) this.hoZ.Kh()).vIg.vTb = i;
    }

    public final int IY() {
        return ((com.tencent.mm.protocal.m.a) this.hoZ.Kh()).vIg.vQC;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        com.tencent.mm.protocal.m.a aVar = (com.tencent.mm.protocal.m.a) this.hoZ.Kh();
        if (aVar.vIg.vSS == null || aVar.vIg.vSS.length() <= 0) {
            x.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + aVar.vIg.vSS);
            return -1;
        } else if ((aVar.vIg.vQC != 6 && aVar.vIg.vQC != 9) || (aVar.vIg.vST != null && aVar.vIg.vST.length() > 0)) {
            return a(eVar, this.hoZ, this);
        } else {
            x.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + aVar.vIg.vSS);
            return -1;
        }
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    protected final int Bo() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final void a(a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        com.tencent.mm.protocal.m.b bVar = (com.tencent.mm.protocal.m.b) qVar.Hv();
        if (bVar == null || bVar.vIh == null) {
            x.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg not set as ret:%s", bVar);
        } else {
            int i4 = bVar.vIh.vQg;
            x.i("MicroMsg.NetSceneBindMobileForReg", "summerauth mmtls bindopreg:%s", Integer.valueOf(i4));
            g.Dr();
            g.Dq().gRO.set(47, Integer.valueOf(i4));
            com.tencent.mm.network.e eVar = g.Dp().gRu.hoF;
            if (eVar != null) {
                eVar.bJ((i4 & 1) == 0);
            }
        }
        if (i2 == 4 && i3 == -301) {
            at.a(true, bVar.vIh.vTi, bVar.vIh.vTj, bVar.vIh.vTh);
            this.hoC--;
            if (this.hoC <= 0) {
                this.gLE.a(3, -1, "", this);
            } else {
                a(this.hok, this.gLE);
            }
        } else if (i2 == 4 && i3 == -240) {
            x.i("MicroMsg.NetSceneBindMobileForReg", "summerauth bindopreg MM_ERR_AUTO_RETRY_REQUEST redirectCount:%s", Integer.valueOf(this.hoC));
            this.hoC--;
            if (this.hoC <= 0) {
                this.gLE.a(3, -1, "", this);
            } else {
                a(this.hok, this.gLE);
            }
        } else if (i2 == 4 && i3 == -102) {
            final int i5 = qVar.Kh().vHZ.ver;
            x.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i5));
            g.Dt().F(new Runnable() {
                public final void run() {
                    new m().a(s.this.hok, new e() {
                        public final void a(int i, int i2, String str, k kVar) {
                            x.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                s.this.a(s.this.hok, s.this.gLE);
                            } else {
                                s.this.gLE.a(i, i2, "", s.this);
                            }
                        }
                    });
                }
            });
        } else if (i2 == 0 && i3 == 0) {
            at.a(false, bVar.vIh.vTi, bVar.vIh.vTj, bVar.vIh.vTh);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.c.b.jg(Om());
            }
            this.gLE.a(i2, i3, str, this);
        } else {
            x.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final String Ob() {
        return ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vTg;
    }

    public final String getUsername() {
        return ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vPp;
    }

    public final String Oc() {
        return ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.fsK;
    }

    public final String Od() {
        return ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vQc;
    }

    public final String Oe() {
        return ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vTn;
    }

    public final int Of() {
        return ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vTc;
    }

    public final String Og() {
        return ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vTp;
    }

    public final String Oh() {
        return ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vTq;
    }

    public final int Oi() {
        bjx bjx = ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 6) {
                    return bi.getInt(bnq.wXD, 3);
                }
            }
        }
        return 3;
    }

    public final int Oj() {
        bjx bjx = ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 4) {
                    return bi.getInt(bnq.wXD, 30);
                }
            }
        }
        return 30;
    }

    public final int Ok() {
        bjx bjx = ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 5) {
                    return bi.getInt(bnq.wXD, 0);
                }
            }
        }
        return 0;
    }

    public final boolean Ol() {
        int i;
        bjx bjx = ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 7) {
                    i = bi.getInt(bnq.wXD, 0);
                    break;
                }
            }
        }
        i = 0;
        return i > 0;
    }

    private int Om() {
        bjx bjx = ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 1) {
                    return bi.getInt(bnq.wXD, 0);
                }
            }
        }
        return 0;
    }

    public final boolean On() {
        int i;
        bjx bjx = ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 10) {
                    i = bi.getInt(bnq.wXD, 0);
                    break;
                }
            }
        }
        i = 0;
        return i > 0;
    }

    public final String Oo() {
        bjx bjx = ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 14) {
                    return bnq.wXD;
                }
            }
        }
        return null;
    }

    public final String Op() {
        bjx bjx = ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vQb;
        if (!(bjx == null || bjx.wTP == null || bjx.wTP.size() <= 0)) {
            Iterator it = bjx.wTP.iterator();
            while (it.hasNext()) {
                bnq bnq = (bnq) it.next();
                if (bnq.pWg == 15) {
                    return bnq.wXD;
                }
            }
        }
        return null;
    }

    public final String Oq() {
        return ((com.tencent.mm.protocal.m.b) this.hoZ.Hv()).vIh.vTd;
    }

    public final void le(String str) {
        ((com.tencent.mm.protocal.m.a) this.hoZ.Kh()).vIg.vTd = str;
    }
}
