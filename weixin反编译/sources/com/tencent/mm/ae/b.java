package com.tencent.mm.ae;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqk;
import com.tencent.mm.protocal.c.bql;

public final class b extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ad.b gLB;
    private e gLE;

    public b(String str) {
        a aVar = new a();
        aVar.hnT = new bqk();
        aVar.hnU = new bql();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindqq";
        this.gLB = aVar.Kf();
        ((bqk) this.gLB.hnQ.hnY).wgO = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 253;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gLE.a(i2, i3, str, this);
    }
}
