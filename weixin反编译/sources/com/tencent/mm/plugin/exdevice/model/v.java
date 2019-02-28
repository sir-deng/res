package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.bgr;
import com.tencent.mm.protocal.c.bgs;
import com.tencent.mm.sdk.platformtools.x;

public final class v extends k implements com.tencent.mm.network.k {
    public b gLB = null;
    private e gLE = null;

    public v(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hnT = new bgr();
        aVar.hnU = new bgs();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/searchwifiharddevice";
        aVar.hnS = 1270;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bgr bgr = (bgr) this.gLB.hnQ.hnY;
        bgr.vSI = new ake();
        bgr.vSI.vQr = str;
        bgr.vSI.kyJ = str2;
        bgr.wSf = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneSearchWiFiHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1270;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
