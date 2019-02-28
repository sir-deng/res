package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.azv;
import com.tencent.mm.protocal.c.azw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;

public final class o extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE;
    public azv nLy = null;
    public azw nLz = null;

    public o(int i, long j, int i2, long j2, boolean z) {
        a aVar = new a();
        aVar.hnT = new azv();
        aVar.hnU = new azw();
        aVar.hnS = 819;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnsync";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        long currentTimeMillis = System.currentTimeMillis();
        this.nLy = (azv) this.gLB.hnQ.hnY;
        this.nLy.wNo = q.FY();
        this.nLy.wil = i;
        this.nLy.wim = j;
        this.nLy.wMR = currentTimeMillis;
        this.nLy.wNp = i2;
        this.nLy.wMU = j2;
        if (z) {
            this.nLy.wNq = 1;
        } else {
            this.nLy.wNq = 0;
        }
        x.i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(this.nLy.wNq), Long.valueOf(currentTimeMillis));
    }

    public final int getType() {
        return 819;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nLz = (azw) ((b) qVar).hnR.hnY;
        this.gLE.a(i2, i3, str, this);
    }
}
