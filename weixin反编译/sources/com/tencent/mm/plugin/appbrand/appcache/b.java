package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ad.a;
import com.tencent.mm.protocal.c.aiz;
import com.tencent.mm.protocal.c.aja;

public final class b extends a<aja> {
    public final com.tencent.mm.ad.b gLB;

    public b(String str, int i, String str2, int i2, int i3) {
        aiz aiz = new aiz();
        aiz.vVm = i;
        aiz.fGh = str;
        aiz.wwT = str2;
        aiz.wwU = i2;
        aiz.wwV = i3;
        this(aiz);
    }

    public b(aiz aiz) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnS = 1139;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxacdndownloadurl";
        aVar.hnT = aiz;
        aVar.hnU = new aja();
        com.tencent.mm.ad.b Kf = aVar.Kf();
        this.gLB = Kf;
        this.gLB = Kf;
    }

    public b(String str, int i, String str2, int i2) {
        this(str, i, str2, i2, 0);
    }
}
