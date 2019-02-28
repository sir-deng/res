package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aux;
import com.tencent.mm.protocal.c.auy;
import com.tencent.mm.protocal.c.buo;
import java.util.LinkedList;

public final class a extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public a(LinkedList<buo> linkedList, int i) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new aux();
        aVar.hnU = new auy();
        aVar.uri = "/cgi-bin/micromsg-bin/opvoicereminder";
        this.gLB = aVar.Kf();
        aux aux = (aux) this.gLB.hnQ.hnY;
        aux.vKI = 1;
        aux.wJA = linkedList;
        aux.wJz = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 331;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gLE.a(i2, i3, str, this);
    }
}
