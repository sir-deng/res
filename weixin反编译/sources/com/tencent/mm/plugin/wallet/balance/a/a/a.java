package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.protocal.c.or;

public final class a extends com.tencent.mm.ad.a<or> {
    public a(String str, int i) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new oq();
        aVar.hnU = new or();
        aVar.uri = "/cgi-bin/mmpay-bin/closefundaccount";
        aVar.hnV = 0;
        aVar.hnW = 0;
        b Kf = aVar.Kf();
        oq oqVar = (oq) Kf.hnQ.hnY;
        oqVar.weq = str;
        oqVar.wer = i;
        this.gLB = Kf;
    }
}
