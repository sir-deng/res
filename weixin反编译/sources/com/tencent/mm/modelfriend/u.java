package com.tencent.mm.modelfriend;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.i;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.protocal.c.bnq;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.at;
import java.util.Iterator;

public final class u extends k implements com.tencent.mm.network.k {
    private e gLE;
    private int hoC;
    public q hoZ;

    public static class a extends i {
        private com.tencent.mm.protocal.p.a hyg = new com.tencent.mm.protocal.p.a();
        private b hyh = new b();

        public final int getType() {
            return 481;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/emailreg";
        }

        public final com.tencent.mm.protocal.k.e Hv() {
            return this.hyh;
        }

        protected final d Hu() {
            return this.hyg;
        }

        public final int Ke() {
            return 1;
        }
    }

    private u(int i, String str, String str2, String str3) {
        this.hoC = 2;
        this.hoZ = new a();
        com.tencent.mm.protocal.p.a aVar = (com.tencent.mm.protocal.p.a) this.hoZ.Kh();
        aVar.vIo.vQC = i;
        aVar.vIo.vSE = str;
        aVar.vIo.lTZ = w.cfV();
        aVar.vIo.vTg = bi.Wh(str2);
        aVar.vIo.wgL = str3;
        aVar.vIo.vQq = as.CI();
        aVar.vIo.wgM = com.tencent.mm.compatible.e.q.getSimCountryIso();
        aVar.vIo.wgN = 1;
    }

    public u(String str, String str2, String str3) {
        this(2, str, str2, str3);
    }

    public u(String str, String str2) {
        this(1, str, str2, "");
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hoZ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        b bVar = (b) qVar.Hv();
        if (i2 == 4 && i3 == -301) {
            at.a(true, bVar.vIp.vTi, bVar.vIp.vTj, bVar.vIp.vTh);
            this.hoC--;
            if (this.hoC <= 0) {
                this.gLE.a(3, -1, "", this);
            } else {
                a(this.hok, this.gLE);
            }
        } else if (i2 == 0 && i3 == 0) {
            at.a(false, bVar.vIp.vTi, bVar.vIp.vTj, bVar.vIp.vTh);
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.c.b.jg(Om());
            }
            this.gLE.a(i2, i3, str, this);
        } else {
            x.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.gLE.a(i2, i3, str, this);
        }
    }

    protected final int Bo() {
        return 5;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    public final int Om() {
        bjx bjx = ((b) this.hoZ.Hv()).vIp.vQb;
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

    public final int getType() {
        return 481;
    }
}
