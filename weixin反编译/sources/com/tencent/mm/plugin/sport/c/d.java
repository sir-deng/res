package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sport.b.c;
import com.tencent.mm.protocal.c.agq;
import com.tencent.mm.protocal.c.agr;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hGV;
    agq rZS;
    agr rZT;
    c rZU;

    public d(long j, long j2, c cVar) {
        this.rZU = cVar;
        a aVar = new a();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/getsteplist";
        aVar.hnT = new agq();
        aVar.hnU = new agr();
        this.hGV = aVar.Kf();
        this.rZS = (agq) this.hGV.hnQ.hnY;
        this.rZS.wgn = (int) (j / 1000);
        this.rZS.wgo = (int) (j2 / 1000);
    }

    public final int getType() {
        return 1734;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Sport.NetSceneGetStepList", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.rZT = (agr) this.hGV.hnR.hnY;
        this.gLE.a(i2, i3, str, this);
    }
}
