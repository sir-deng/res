package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bvn;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;

    public f(long j, long j2, int i) {
        a aVar = new a();
        aVar.hnT = new bvn();
        aVar.hnU = new bvo();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipsync";
        this.gLB = aVar.Kf();
        bvn bvn = (bvn) this.gLB.hnQ.hnY;
        bvn.xcP = j;
        bvn.wim = j2;
        bvn.xcZ = i;
        bvn.wMR = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 818;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
