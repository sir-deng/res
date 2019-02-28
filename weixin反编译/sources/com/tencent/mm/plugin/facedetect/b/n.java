package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bcw;
import com.tencent.mm.protocal.c.bcx;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k, e {
    private b gLB;
    private e gLE;
    private boolean mkY = false;
    private String mlc = null;

    public n(long j, String str, String str2) {
        a aVar = new a();
        aVar.hnT = new bcw();
        aVar.hnU = new bcx();
        aVar.uri = "/cgi-bin/micromsg-bin/registerface";
        aVar.hnS = 918;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bcw bcw = (bcw) this.gLB.hnQ.hnY;
        bcw.wqd = j;
        bcw.wPD = str;
        bcw.wPE = str2;
    }

    public final int getType() {
        return 918;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bcx bcx = (bcx) ((b) qVar).hnR.hnY;
        if (i2 == 0 && i3 == 0) {
            this.mkY = bcx.wPG == 0;
            this.mlc = bcx.wPF;
            i3 = bcx.wPG;
            x.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", Boolean.valueOf(this.mkY));
        } else if (!(bcx == null || bcx.wPG == 0)) {
            x.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
            i3 = bcx.wPG;
        }
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final boolean aGO() {
        return true;
    }

    public final String aGP() {
        return this.mlc;
    }
}
