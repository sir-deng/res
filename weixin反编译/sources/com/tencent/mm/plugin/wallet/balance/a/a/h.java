package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ad.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.protocal.c.bcr;
import com.tencent.mm.protocal.c.bcs;

public final class h extends a<bcs> {
    public h(int i, String str, String str2, int i2) {
        b.a aVar = new b.a();
        aVar.hnT = new bcr();
        aVar.hnU = new bcs();
        aVar.uri = "/cgi-bin/mmpay-bin/redeemfund";
        aVar.hnV = 0;
        aVar.hnW = 0;
        b Kf = aVar.Kf();
        bcr bcr = (bcr) Kf.hnQ.hnY;
        bcr.wMp = i;
        bcr.weq = str;
        bcr.wMs = str2;
        bcr.wer = i2;
        this.gLB = Kf;
    }
}
