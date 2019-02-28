package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.is;
import com.tencent.mm.protocal.c.it;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    public it pPV;

    public f(String str, String str2, String str3, int i, com.tencent.mm.bp.b bVar, String str4) {
        a aVar = new a();
        aVar.hnT = new is();
        aVar.hnU = new it();
        aVar.uri = "/cgi-bin/mmpay-bin/busif2factqry";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        is isVar = (is) this.hPx.hnQ.hnY;
        isVar.pQZ = str3;
        isVar.vOg = str;
        isVar.vOh = str2;
        isVar.vOl = i;
        isVar.vVC = bVar;
        isVar.vOi = str4;
        x.i("MicroMsg.NetSceneBusiF2fActQry", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s", str, str2, Integer.valueOf(i));
    }

    public final int getType() {
        return 1680;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fActQry", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pPV = (it) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBusiF2fActQry", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pPV.kRz), this.pPV.kRA);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
