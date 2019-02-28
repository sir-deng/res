package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amk;
import com.tencent.mm.protocal.c.aml;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends com.tencent.mm.ad.k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gQm;

    public k(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new amk();
        aVar.hnU = new aml();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetuseropenid";
        this.gLB = aVar.Kf();
        amk amk = (amk) this.gLB.hnQ.hnY;
        amk.kyG = str2;
        amk.nlV = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1566;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetUserOpenId", "doScene");
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }
}
