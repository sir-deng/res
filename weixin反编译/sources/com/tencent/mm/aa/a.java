package com.tencent.mm.aa;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.gv;
import com.tencent.mm.protocal.c.gw;

public final class a extends k implements com.tencent.mm.network.k {
    public static int hlf = 1;
    public static int hlg = 2;
    private b gLB;
    private e gLE;

    public a(int i, String str) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new gv();
        aVar.hnU = new gw();
        aVar.uri = "/cgi-bin/micromsg-bin/bindemail";
        this.gLB = aVar.Kf();
        gv gvVar = (gv) this.gLB.hnQ.hnY;
        gvVar.vKI = i;
        gvVar.vSE = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 256;
    }

    public final int IY() {
        return ((gv) this.gLB.hnQ.hnY).vKI;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gLE.a(i2, i3, str, this);
    }
}
