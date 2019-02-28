package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.d;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ad.e gLE;
    private b hPx;
    private d ijn;
    public com.tencent.mm.protocal.c.e ijo;
    public int scene;

    public e(String str, int i, String str2) {
        a aVar = new a();
        aVar.hnT = new d();
        aVar.hnU = new com.tencent.mm.protocal.c.e();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclose";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        this.ijn = (d) this.hPx.hnQ.hnY;
        this.ijn.vJJ = str2;
        this.ijn.vJI = str;
        this.ijn.scene = i;
        this.scene = i;
        x.d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", this.ijn.vJI, Integer.valueOf(i));
    }

    public final int getType() {
        return 1530;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        x.i("MicroMsg.NetSceneAAClose", "doScene");
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ijo = (com.tencent.mm.protocal.c.e) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", Integer.valueOf(this.ijo.lot), this.ijo.lou);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
