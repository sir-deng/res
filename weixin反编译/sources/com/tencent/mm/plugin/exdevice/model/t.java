package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfn;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE = null;

    public t(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hnT = new bfn();
        aVar.hnU = new bfo();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/searchbleharddevice";
        aVar.hnS = 1706;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bfn bfn = (bfn) this.gLB.hnQ.hnY;
        bfn.mac = str;
        if (str2 == null) {
            str2 = "";
        }
        bfn.userName = str2;
        if (str3 == null) {
            str3 = "";
        }
        bfn.category = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneSearchBLEHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1706;
    }

    public final bfo aEN() {
        return (bfo) this.gLB.hnR.hnY;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
