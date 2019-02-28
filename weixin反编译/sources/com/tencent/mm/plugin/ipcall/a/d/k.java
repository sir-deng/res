package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azp;
import com.tencent.mm.protocal.c.azq;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends com.tencent.mm.ad.k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE = null;
    public azp nLq = null;
    public azq nLr = null;

    public k(int i, long j, long j2) {
        a aVar = new a();
        aVar.hnT = new azp();
        aVar.hnU = new azq();
        aVar.hnS = 726;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnredirect";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.nLq = (azp) this.gLB.hnQ.hnY;
        this.nLq.wil = i;
        this.nLq.wim = j;
        this.nLq.wMU = j2;
    }

    public final int getType() {
        return 726;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nLr = (azq) ((b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
