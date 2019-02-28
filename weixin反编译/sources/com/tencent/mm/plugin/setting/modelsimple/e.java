package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.ahm;
import com.tencent.mm.protocal.c.ahn;

public final class e extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ad.e gLE;
    public ahn qlZ;
    public byte[] qma;

    public e(byte[] bArr) {
        this.qma = bArr;
    }

    public final int getType() {
        return 1146;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        a aVar = new a();
        com.tencent.mm.bp.a ahm = new ahm();
        if (this.qma != null) {
            ahm.wvB = n.N(this.qma).wRm;
        }
        aVar.hnT = ahm;
        this.qlZ = new ahn();
        aVar.hnU = this.qlZ;
        aVar.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
        aVar.hnS = 1146;
        aVar.hnV = 0;
        aVar.hnW = 0;
        return a(eVar, aVar.Kf(), this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.qlZ = (ahn) ((b) qVar).hnR.hnY;
        this.gLE.a(i2, this.qlZ.wfW.fun, this.qlZ.wfW.fuo, this);
    }
}
