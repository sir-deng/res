package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ad.a;
import com.tencent.mm.protocal.c.auk;
import com.tencent.mm.protocal.c.aul;

public final class b extends a<aul> {
    public b(int i) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new auk();
        aVar.hnU = new aul();
        aVar.uri = "/cgi-bin/mmpay-bin/onclickpurchase";
        aVar.hnV = 0;
        aVar.hnW = 0;
        com.tencent.mm.ad.b Kf = aVar.Kf();
        ((auk) Kf.hnQ.hnY).wer = i;
        this.gLB = Kf;
    }
}
