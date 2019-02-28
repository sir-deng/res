package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqz;
import com.tencent.mm.protocal.c.bra;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE = null;
    public int lVl;
    public int lVm;
    public int opType;

    public n(int i, int i2) {
        this.opType = i;
        this.lVl = i2;
        a aVar = new a();
        aVar.hnT = new bqz();
        aVar.hnU = new bra();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
        aVar.hnS = 1044;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bqz bqz = (bqz) this.gLB.hnQ.hnY;
        bqz.fGi = this.opType;
        bqz.fEo = this.lVl;
    }

    public final int getType() {
        return 1044;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUpdateRankSetting", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.lVm = ((bra) this.gLB.hnR.hnY).fEo;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
