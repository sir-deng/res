package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.protocal.c.jd;
import com.tencent.mm.protocal.c.je;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends com.tencent.mm.ad.k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    public je pQh;

    public k(cg cgVar, String str) {
        a aVar = new a();
        aVar.hnT = new jd();
        aVar.hnU = new je();
        aVar.uri = "/cgi-bin/mmpay-bin/busif2funlockfavor";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        jd jdVar = (jd) this.hPx.hnQ.hnY;
        jdVar.vVL = cgVar;
        jdVar.vVW = str;
        x.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "NetSceneBusiF2fUnlockFavor, f2fId: %s, transId: %s, amount: %s", cgVar.vOg, cgVar.vOh, Integer.valueOf(cgVar.vOl));
    }

    public final int getType() {
        return 2702;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pQh = (je) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pQh.kRz), this.pQh.kRA);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
