package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqx;
import com.tencent.mm.protocal.c.bqy;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE = null;
    public String lUG;
    public String lUH;

    public m(String str, String str2) {
        this.lUG = str;
        this.lUH = str2;
        a aVar = new a();
        aVar.hnT = new bqx();
        aVar.hnU = new bqy();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
        aVar.hnS = 1040;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bqx bqx = (bqx) this.gLB.hnQ.hnY;
        bqx.wvK = str;
        bqx.lUH = str2;
    }

    public final int getType() {
        return 1040;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUpdateRankCoverAndMotto", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }
}
