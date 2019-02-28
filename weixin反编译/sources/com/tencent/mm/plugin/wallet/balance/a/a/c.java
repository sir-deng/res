package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ad.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.protocal.c.aum;
import com.tencent.mm.protocal.c.aun;

public final class c extends a<aun> {
    public c(int i) {
        b.a aVar = new b.a();
        aVar.hnT = new aum();
        aVar.hnU = new aun();
        aVar.uri = "/cgi-bin/mmpay-bin/onclickredeem";
        aVar.hnV = 0;
        aVar.hnW = 0;
        b Kf = aVar.Kf();
        ((aum) Kf.hnQ.hnY).wer = i;
        this.gLB = Kf;
    }
}
