package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aij;
import com.tencent.mm.protocal.c.aik;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE;
    private aij nLb = null;
    public aik nLc = null;

    public d() {
        a aVar = new a();
        aVar.hnT = new aij();
        aVar.hnU = new aik();
        aVar.hnS = 288;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcogiftcardlist";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.nLb = (aij) this.gLB.hnQ.hnY;
        x.i("MicroMsg.NetSceneIPCallGetGiftCardList", "NetSceneIPCallGetGiftCardList");
    }

    public final int getType() {
        return 288;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallGetGiftCardList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nLc = (aik) ((b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
