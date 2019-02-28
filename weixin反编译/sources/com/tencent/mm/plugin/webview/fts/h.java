package com.tencent.mm.plugin.webview.fts;

import android.os.Build.VERSION;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.aj.a.a;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.aj.a.f;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.protocal.c.cbe;
import com.tencent.mm.protocal.c.cbf;
import com.tencent.mm.protocal.c.oz;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends a implements k {
    private b gLB;
    private e gLE;
    private d hlp;

    public h(d dVar) {
        boolean z = true;
        this.hlp = dVar;
        this.tqp = dVar.foW;
        this.wn = dVar.offset;
        this.itU = dVar.scene;
        this.tqo = dVar.fEg;
        this.hlp = dVar;
        this.tqr = dVar.tqK;
        b.a aVar = new b.a();
        aVar.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        aVar.hnT = new cbe();
        aVar.hnU = new cbf();
        this.gLB = aVar.Kf();
        cbe cbe = (cbe) this.gLB.hnQ.hnY;
        cbe.vUN = dVar.offset;
        cbe.wDS = g.Af(1);
        cbe.wQu = dVar.tqs;
        cbe.wnX = dVar.foW;
        cbe.wDT = g.Jk();
        cbe.sfa = dVar.scene;
        cbe.vWw = dVar.lKv;
        cbe.xhg = dVar.tqu;
        cbe.xfZ = dVar.tqz;
        oz ozVar = new oz();
        ozVar.aAM = "client_system_version";
        ozVar.weB = (long) VERSION.SDK_INT;
        dVar.tqD.add(ozVar);
        cbe.xhh = dVar.tqD;
        cbe.xgc = dVar.frp;
        this.tqq = dVar.hMN;
        int i = dVar.scene;
        String str = dVar.frp;
        String str2 = dVar.tpV;
        String str3 = dVar.lKv;
        int i2 = dVar.offset;
        if (dVar.tqs != 1) {
            z = false;
        }
        f.a(i, str, str2, str3, i2, z, dVar.hMN, dVar.foW, dVar.hMM, dVar.tqJ);
    }

    public final int getType() {
        return 1943;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        com.tencent.mm.bb.g.bk(this.itU, 2);
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        boolean z = i2 == 0 && i3 == 0;
        f.a(this.hlp.scene, this.hlp.frp, this.hlp.tpV, this.hlp.lKv, this.hlp.offset, this.hlp.tqs == 1, this.hlp.hMN, z, this.hlp.foW, this.hlp.hMM, this.hlp.tqJ);
        if (i3 == -1) {
            com.tencent.mm.bb.g.bk(this.itU, 4);
        } else if (i2 == 0 && i3 == 0) {
            com.tencent.mm.bb.g.bk(this.itU, 3);
        } else {
            com.tencent.mm.bb.g.bk(this.itU, 8);
        }
        this.gLE.a(i2, i3, str, this);
    }

    private cbf bPX() {
        return (cbf) this.gLB.hnR.hnY;
    }

    public final String Ji() {
        return bPX() != null ? bPX().vUV : "";
    }

    public final int Jj() {
        return bPX() != null ? bPX().xgi : 0;
    }
}
