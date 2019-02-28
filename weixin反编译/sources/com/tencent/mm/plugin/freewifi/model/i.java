package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bq;
import com.tencent.mm.protocal.c.br;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private String fGh;
    private final b gLB;
    private e gLE;

    private i() {
        a aVar = new a();
        aVar.hnT = new bq();
        aVar.hnU = new br();
        aVar.uri = "/cgi-bin/mmo2o-bin/addcontact";
        aVar.hnS = 1703;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public i(String str, String str2, int i, String str3) {
        this();
        this.fGh = str;
        bq bqVar = (bq) this.gLB.hnQ.hnY;
        bqVar.nqc = str;
        bqVar.nlE = str2;
        bqVar.vKK = i;
        bqVar.vKL = str3;
        x.i("MicroMsg.FreeWifi.NetSceneAddContact", "appid = %s", str);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FreeWifi.NetSceneAddContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.fGh);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1703;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
