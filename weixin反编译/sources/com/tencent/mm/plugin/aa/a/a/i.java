package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.n;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    private n ijv;
    public o ijw;

    public i(String str, long j, int i, String str2) {
        a aVar = new a();
        aVar.hnT = new n();
        aVar.hnU = new o();
        aVar.uri = "/cgi-bin/mmpay-bin/newaapay";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        this.ijv = (n) this.hPx.hnQ.hnY;
        this.ijv.vJI = str;
        this.ijv.vKb = j;
        this.ijv.scene = i;
        this.ijv.vJJ = str2;
        x.i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", this.ijv.vJI, Long.valueOf(this.ijv.vKb), Integer.valueOf(this.ijv.scene), this.ijv.vJJ);
    }

    public final int getType() {
        return 1629;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ijw = (o) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", Integer.valueOf(this.ijw.lot), this.ijw.lou, this.ijw.fFi);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
