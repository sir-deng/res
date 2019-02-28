package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bod;
import com.tencent.mm.protocal.c.boe;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public int mStatus;
    public int smY;

    public i(int i) {
        a aVar = new a();
        aVar.hnT = new bod();
        aVar.hnU = new boe();
        aVar.uri = "/cgi-bin/micromsg-bin/switchopvoiceprint";
        this.gLB = aVar.Kf();
        ((bod) this.gLB.hnQ.hnY).fvG = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 615;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSwitchOpVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        boe boe = (boe) ((b) qVar).hnR.hnY;
        if (i2 == 0 || i3 == 0) {
            this.mStatus = boe.wLS;
            this.smY = boe.wXM;
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
