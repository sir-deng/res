package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.azt;
import com.tencent.mm.protocal.c.azu;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;

public final class n extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE = null;
    public azt nLw = null;
    private azu nLx = null;

    public n(int i, long j, long j2, int i2) {
        a aVar = new a();
        aVar.hnT = new azt();
        aVar.hnU = new azu();
        aVar.hnS = 723;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        long currentTimeMillis = System.currentTimeMillis();
        this.nLw = (azt) this.gLB.hnQ.hnY;
        this.nLw.npW = q.FY();
        this.nLw.wil = i;
        this.nLw.wim = j;
        this.nLw.wMU = j2;
        this.nLw.kyY = i2;
        this.nLw.wMR = currentTimeMillis;
        x.i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
    }

    public final int getType() {
        return 723;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallShutDown", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nLx = (azu) ((b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
