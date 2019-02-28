package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bax;
import com.tencent.mm.protocal.c.bay;

public final class x extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public int hPA;
    public int hPz = 1;

    public x(int i) {
        a aVar = new a();
        aVar.hnT = new bax();
        aVar.hnU = new bay();
        aVar.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
        aVar.hnS = 255;
        aVar.hnV = 132;
        aVar.hnW = 1000000132;
        this.gLB = aVar.Kf();
        ((bax) this.gLB.hnQ.hnY).sfa = i;
        this.hPA = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 255;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gLE.a(i2, i3, str, this);
    }
}
