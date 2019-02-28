package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.protocal.c.azh;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE = null;
    public azg nKV = null;
    private azh nKW = null;

    public a(int i, long j, String str, String str2, int i2, long j2) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new azg();
        aVar.hnU = new azh();
        aVar.hnS = 843;
        aVar.uri = "/cgi-bin/micromsg-bin/pstncancelinvite";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        long currentTimeMillis = System.currentTimeMillis();
        this.nKV = (azg) this.gLB.hnQ.hnY;
        this.nKV.wil = i;
        this.nKV.wim = j;
        this.nKV.npV = str;
        this.nKV.wMR = currentTimeMillis;
        this.nKV.wMS = i2;
        this.nKV.wMT = str2;
        this.nKV.wMU = j2;
        x.d("MicroMsg.NetSceneIPCallCancel", "roomId: %d, roomKey: %d, toUsername: %s, timestamp: %d, inviteId: %d, phoneNumber: %s, callseq: %d", Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(currentTimeMillis), Integer.valueOf(i2), str2, Long.valueOf(j2));
    }

    public final int getType() {
        return 843;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallCancel", "errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nKW = (azh) ((b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
