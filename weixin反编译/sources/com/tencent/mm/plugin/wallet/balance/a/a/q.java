package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.avv;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    private avu sFi;
    public avv sFj;

    public q(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new avu();
        aVar.hnU = new avv();
        aVar.uri = "/cgi-bin/mmpay-bin/openlqbaccount";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        this.sFi = (avu) this.hPx.hnQ.hnY;
        this.sFi.vSz = str;
        this.sFi.wKh = str2;
        x.i("MicroMsg.NetSceneOpenLqbAccount", "NetSceneOpenLqbAccount, eCardType: %s, extraData: %s", str, str2);
    }

    public final int getType() {
        return 2996;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.sFj = (avv) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, retcode: %s, retmsg: %s", Integer.valueOf(this.sFj.kRz), this.sFj.kRA);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
