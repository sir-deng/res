package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ad.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.protocal.c.baq;
import com.tencent.mm.protocal.c.bar;

public final class g extends a<bar> {
    private b hPx;
    private baq sEn = null;

    public g() {
        b.a aVar = new b.a();
        aVar.hnT = new baq();
        aVar.hnU = new bar();
        aVar.hnS = 1211;
        aVar.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        this.sEn = (baq) this.hPx.hnQ.hnY;
        this.sEn.time_stamp = (int) System.currentTimeMillis();
        this.gLB = aVar.Kf();
    }
}
