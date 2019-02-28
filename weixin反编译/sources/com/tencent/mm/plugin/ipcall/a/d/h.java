package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azk;
import com.tencent.mm.protocal.c.azl;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE = null;
    public azk nLk = null;
    private azl nLl = null;

    public h(int i, long j, long j2) {
        a aVar = new a();
        aVar.hnT = new azk();
        aVar.hnU = new azl();
        aVar.hnS = 824;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnheartbeat";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        long currentTimeMillis = System.currentTimeMillis();
        this.nLk = (azk) this.gLB.hnQ.hnY;
        this.nLk.wil = i;
        this.nLk.wim = j;
        this.nLk.wMU = j2;
        this.nLk.wMR = currentTimeMillis;
        x.d("MicroMsg.NetSceneIPCallHeartBeat", "heartbeat, roomId: %d, roomKey: %d, callSeq: %d, timestamp: %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(currentTimeMillis));
    }

    public final int getType() {
        return 824;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallHeartBeat", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nLl = (azl) ((b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
