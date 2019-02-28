package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.akj;
import com.tencent.mm.protocal.c.akk;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    public String ffG;
    public String fsb;
    private e gLE;
    private b hGV;

    public a(String str, String str2) {
        this.ffG = str;
        this.fsb = str2;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.uri = "/cgi-bin/mmbiz-bin/device/register";
        aVar.hnT = new akj();
        aVar.hnU = new akk();
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hGV = aVar.Kf();
        akj akj = (akj) this.hGV.hnQ.hnY;
        akj.vRQ = new com.tencent.mm.bp.b(str.getBytes());
        akj.vRS = new com.tencent.mm.bp.b(str2.getBytes());
        akj.wyn = new com.tencent.mm.bp.b("5".getBytes());
    }

    public final int getType() {
        return 1091;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gLE.a(i2, i3, str, this);
    }
}
