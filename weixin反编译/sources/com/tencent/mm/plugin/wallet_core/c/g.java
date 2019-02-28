package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.rx;
import com.tencent.mm.protocal.c.ry;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    private rx sOw;
    public ry sOx;
    private boolean sOy;

    public g(String str, int i, boolean z) {
        this.sOy = z;
        a aVar = new a();
        aVar.hnT = new rx();
        aVar.hnU = new ry();
        if (z) {
            aVar.hnS = 1859;
            aVar.uri = "/cgi-bin/mmpay-bin/mktdrawf2flottery";
        } else {
            aVar.hnS = 2547;
            aVar.uri = "/cgi-bin/mmpay-bin/mktdrawlottery";
        }
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        this.sOw = (rx) this.hPx.hnQ.hnY;
        this.sOw.wgE = str;
        this.sOw.wgF = i;
        x.i("MicroMsg.NetSceneMktDrawLottery", "NetSceneMktDrawLottery, drawLotteryParams: %s, drawLotteryType: %s, isF2f: %s", str, Integer.valueOf(i), Boolean.valueOf(z));
    }

    public final int getType() {
        if (this.sOy) {
            return 1859;
        }
        return 2547;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMktDrawLottery", "onGYNetEnd netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.sOx = (ry) ((b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
