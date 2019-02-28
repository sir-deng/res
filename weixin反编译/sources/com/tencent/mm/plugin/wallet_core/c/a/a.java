package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aww;
import com.tencent.mm.protocal.c.awx;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new aww();
        aVar.hnU = new awx();
        aVar.uri = "/cgi-bin/mmpay-bin/payibgcheckjsapisign";
        this.gLB = aVar.Kf();
        aww aww = (aww) this.gLB.hnQ.hnY;
        aww.nlV = str;
        aww.wdl = str4;
        aww.wdk = str2;
        aww.wdm = str5;
        aww.wdn = str6;
        aww.vSO = str3;
        aww.wcy = str7;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIbgCheckJsapi", "check jsapi: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        awx awx = (awx) ((b) qVar).hnR.hnY;
        if (i3 == 0 && i2 == 0) {
            i3 = awx.lUc;
            str = awx.lUd;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1767;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
