package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqv;
import com.tencent.mm.protocal.c.bqw;

public final class y extends k implements com.tencent.mm.network.k {
    private String ffG;
    private String fsb;
    private b gLB;
    private e gLE;
    public String ggL;
    private int lSS = 0;

    public y(String str, String str2, String str3) {
        this.ggL = str3;
        this.ffG = str;
        this.fsb = str2;
    }

    public final int getType() {
        return 1263;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        a aVar = new a();
        aVar.hnT = new bqv();
        aVar.hnU = new bqw();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
        aVar.hnS = 1263;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bqv bqv = (bqv) this.gLB.hnQ.hnY;
        bqv.ggL = this.ggL;
        bqv.pck = this.ffG;
        bqv.devicetype = this.fsb;
        bqv.wZr = this.lSS;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gLE.a(i2, i3, str, this);
    }
}
