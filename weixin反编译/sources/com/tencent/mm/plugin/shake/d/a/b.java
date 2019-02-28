package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.agy;
import com.tencent.mm.protocal.c.agz;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public com.tencent.mm.ad.b gLB;
    private e gLE;
    private String qvI;
    private int scene;

    public b(String str, int i) {
        this.qvI = str;
        this.scene = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        a aVar = new a();
        aVar.hnT = new agy();
        aVar.hnU = new agz();
        aVar.uri = "/cgi-bin/micromsg-bin/gettvinfo";
        aVar.hnS = 552;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        agy agy = (agy) this.gLB.hnQ.hnY;
        agy.wvg = this.qvI;
        agy.sfa = this.scene;
        return a(eVar, this.gLB, this);
    }

    protected final int a(q qVar) {
        agy agy = (agy) ((com.tencent.mm.ad.b) qVar).hnQ.hnY;
        if (agy.sfa >= 0 && agy.wvg != null && agy.wvg.length() > 0) {
            return b.hoz;
        }
        x.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", Integer.valueOf(agy.sfa));
        return b.hoA;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 552;
    }
}
