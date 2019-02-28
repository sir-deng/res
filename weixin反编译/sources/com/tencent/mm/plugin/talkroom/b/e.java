package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.protocal.c.boq;
import com.tencent.mm.protocal.c.bor;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends f {
    private final b gLB;
    private com.tencent.mm.ad.e gLE;
    private final String oae;
    private int sceneType = 0;

    public e(String str, int i, long j, int i2) {
        this.sceneType = i2;
        a aVar = new a();
        aVar.hnT = new boq();
        aVar.hnU = new bor();
        aVar.uri = "/cgi-bin/micromsg-bin/talknoop";
        aVar.hnS = 335;
        aVar.hnV = f.CTRL_INDEX;
        aVar.hnW = 1000000149;
        this.gLB = aVar.Kf();
        boq boq = (boq) this.gLB.hnQ.hnY;
        boq.wil = i;
        boq.wim = j;
        boq.vND = (int) bi.Wx();
        this.oae = str;
        boq.sfa = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        x.d("MicroMsg.NetSceneTalkNoop", "doScene");
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 335;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.gLE.a(i2, i3, str, this);
        } else {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final String bFI() {
        return this.oae;
    }

    public final int bFJ() {
        return this.sceneType;
    }
}
