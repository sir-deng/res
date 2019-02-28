package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.yy;
import com.tencent.mm.protocal.c.yz;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private b gLB;
    private com.tencent.mm.ad.e gLE;
    public yz sOt;

    public e(String str) {
        a aVar = new a();
        aVar.hnT = new yy();
        aVar.hnU = new yz();
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getbanpaymobileinfo";
        this.gLB = aVar.Kf();
        yy yyVar = (yy) this.gLB.hnQ.hnY;
        x.d("MicroMsg.NetSceneGetBanpayMobileInfo", "req_key: %s", str);
        yyVar.fxT = str;
    }

    public final int getType() {
        return 1667;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBanpayMobileInfo", "NetSceneGetBanpayMobileInfo, netId: %s, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.sOt = (yz) this.gLB.hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
