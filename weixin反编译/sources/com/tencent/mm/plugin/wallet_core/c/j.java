package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.tp;
import com.tencent.mm.protocal.c.tq;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    private tp sOE;
    public tq sOF;
    private boolean sOy;

    public j(String str, boolean z) {
        this.sOy = z;
        a aVar = new a();
        aVar.hnT = new tp();
        aVar.hnU = new tq();
        if (z) {
            aVar.hnS = 2529;
            aVar.uri = "/cgi-bin/mmpay-bin/mktf2fmodifyexposure";
        } else {
            aVar.hnS = 2888;
            aVar.uri = "/cgi-bin/mmpay-bin/mktmodifyexposure";
        }
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        this.sOE = (tp) this.hPx.hnQ.hnY;
        this.sOE.wiw = str;
    }

    public final int getType() {
        if (this.sOy) {
            return 2529;
        }
        return 2888;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMktModifyExposure", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.sOF = (tq) ((b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
