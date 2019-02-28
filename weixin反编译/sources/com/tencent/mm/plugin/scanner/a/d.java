package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ia;
import com.tencent.mm.protocal.c.ib;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private String frQ;
    public b gLB;
    private e gLE;
    private String lqB;
    private int scene;

    public d(String str, int i, String str2) {
        this.frQ = str;
        this.scene = i;
        this.lqB = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        a aVar = new a();
        aVar.hnT = new ia();
        aVar.hnU = new ib();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
        aVar.hnS = 1063;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ia iaVar = (ia) this.gLB.hnQ.hnY;
        iaVar.vPI = this.frQ;
        iaVar.sfa = this.scene;
        iaVar.vUE = this.lqB;
        return a(eVar, this.gLB, this);
    }

    protected final int a(q qVar) {
        ia iaVar = (ia) ((b) qVar).hnQ.hnY;
        if (iaVar.sfa >= 0 && iaVar.vPI != null && iaVar.vPI.length() > 0) {
            return b.hoz;
        }
        x.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", Integer.valueOf(iaVar.sfa));
        return b.hoA;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1063;
    }
}
