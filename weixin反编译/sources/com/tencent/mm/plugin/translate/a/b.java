package com.tencent.mm.plugin.translate.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahe;
import com.tencent.mm.protocal.c.ahf;
import com.tencent.mm.protocal.c.bqc;
import com.tencent.mm.protocal.c.bqd;
import java.util.LinkedList;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ad.b gLB;
    private e gLE = null;
    public LinkedList<bqd> smh;

    public b(LinkedList<bqc> linkedList) {
        a aVar = new a();
        aVar.hnT = new ahe();
        aVar.hnU = new ahf();
        aVar.uri = "/cgi-bin/micromsg-bin/gettranstext";
        aVar.hnS = 631;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ahe ahe = (ahe) this.gLB.hnQ.hnY;
        ahe.wvm = linkedList;
        ahe.kyz = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 631;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        ahf ahf = (ahf) this.gLB.hnR.hnY;
        this.gLE.a(i2, i3, str, this);
        this.smh = ahf.wvm;
    }
}
