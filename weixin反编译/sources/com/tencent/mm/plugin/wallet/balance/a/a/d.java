package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ad.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.protocal.c.ayu;
import com.tencent.mm.protocal.c.ayv;
import com.tencent.mm.protocal.c.fb;

public final class d extends a<ayv> {
    public d(int i, fb fbVar, int i2) {
        b.a aVar = new b.a();
        aVar.hnT = new ayu();
        aVar.hnU = new ayv();
        aVar.uri = "/cgi-bin/mmpay-bin/preredeemfund";
        aVar.hnV = 0;
        aVar.hnW = 0;
        b Kf = aVar.Kf();
        ayu ayu = (ayu) Kf.hnQ.hnY;
        ayu.wMp = i;
        if (fbVar != null) {
            ayu.wMq = 1;
            ayu.wMr = fbVar;
        } else {
            ayu.wMq = 0;
            ayu.wMr = null;
        }
        ayu.wer = i2;
        this.gLB = Kf;
    }
}
