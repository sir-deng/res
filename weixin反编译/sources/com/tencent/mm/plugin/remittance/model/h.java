package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.protocal.c.iy;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    public iy pQe;

    public h(cg cgVar, String str) {
        a aVar = new a();
        aVar.hnT = new ix();
        aVar.hnU = new iy();
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fpaycheck";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        ix ixVar = (ix) this.hPx.hnQ.hnY;
        ixVar.vVL = cgVar;
        ixVar.vVM = str;
        x.i("MicroMsg.NetSceneBusiF2fPayCheck", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s req: %s", cgVar.vOg, cgVar.vOh, Integer.valueOf(cgVar.vOl), a.a(cgVar));
    }

    public final int getType() {
        return 1241;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pQe = (iy) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBusiF2fPayCheck", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pQe.kRz), this.pQe.kRA);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
