package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.protocal.c.mh;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    public mh pQs;

    public r(String str, String str2, String str3, String str4, long j, String str5) {
        a aVar = new a();
        aVar.hnT = new mg();
        aVar.hnU = new mh();
        aVar.uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        mg mgVar = (mg) this.hPx.hnQ.hnY;
        mgVar.fxT = str;
        mgVar.wbF = str2;
        mgVar.pRd = str3;
        mgVar.pQZ = str4;
        mgVar.pSo = j;
        mgVar.wbo = str5;
        x.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", str, str2, Long.valueOf(j));
    }

    public final int getType() {
        return 1779;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pQs = (mh) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pQs.lot), this.pQs.lou);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
