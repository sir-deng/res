package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.protocal.c.ni;
import com.tencent.mm.protocal.c.nj;

public final class d extends c {
    protected final void aMC() {
        a aVar = new a();
        aVar.hnT = new ni();
        aVar.hnU = new nj();
        aVar.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
        aVar.hnS = 1155;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public final int getType() {
        return 1155;
    }

    public d(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7) {
        aMC();
        ni niVar = (ni) this.gLB.hnQ.hnY;
        niVar.wcP = str;
        niVar.wcQ = str2;
        niVar.wcR = str3;
        niVar.wcS = str4;
        niVar.wcT = str5;
        niVar.wcU = j;
        niVar.wcV = str6;
        niVar.wcW = str7;
    }

    public final nj aMK() {
        return (nj) this.gLB.hnR.hnY;
    }
}
