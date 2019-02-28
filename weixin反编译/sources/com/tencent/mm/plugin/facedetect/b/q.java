package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.bob;
import com.tencent.mm.protocal.c.boc;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public boolean mlh = false;
    public boolean mli = false;

    public q(int i) {
        a aVar = new a();
        aVar.hnT = new bob();
        aVar.hnU = new boc();
        aVar.uri = "/cgi-bin/micromsg-bin/switchopface";
        aVar.hnS = 938;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((bob) this.gLB.hnQ.hnY).vKI = i;
    }

    public final int getType() {
        return 938;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        boc boc = (boc) ((b) qVar).hnR.hnY;
        this.mlh = boc.wXK;
        this.mli = boc.wXL;
        x.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.mlh), Boolean.valueOf(this.mli));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
