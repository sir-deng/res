package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ad.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.protocal.c.azz;
import com.tencent.mm.protocal.c.baa;

public final class e extends a<baa> {
    public e(String str, int i, int i2) {
        b.a aVar = new b.a();
        aVar.hnT = new azz();
        aVar.hnU = new baa();
        aVar.uri = "/cgi-bin/mmpay-bin/purchasefund";
        aVar.hnV = 0;
        aVar.hnW = 0;
        b Kf = aVar.Kf();
        azz azz = (azz) Kf.hnQ.hnY;
        azz.wNw = str;
        azz.wNx = i;
        azz.wer = i2;
        this.gLB = Kf;
    }
}
