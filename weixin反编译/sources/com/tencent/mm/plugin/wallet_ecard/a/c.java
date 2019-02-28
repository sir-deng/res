package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.gt;
import com.tencent.mm.protocal.c.gu;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public gu tfY;

    public c(String str, String str2, String str3, String str4, int i) {
        a aVar = new a();
        aVar.hnT = new gt();
        aVar.hnU = new gu();
        aVar.uri = "/cgi-bin/mmpay-bin/bindecard";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        gt gtVar = (gt) this.gLB.hnQ.hnY;
        gtVar.vSz = str;
        gtVar.vSA = str2;
        gtVar.sVt = str3;
        gtVar.vSB = str4;
        gtVar.fDt = i;
        x.i("MicroMsg.NetSceneBindECard", "cardType: %s, reqSerial: %s, openScene: %s, verifyCode: %s, bindToken: %s", str, str2, Integer.valueOf(i), str3, str4);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBindECard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tfY = (gu) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneBindECard", "ret_code: %d, ret_msg: %s", Integer.valueOf(this.tfY.kRz), this.tfY.kRA);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1986;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
