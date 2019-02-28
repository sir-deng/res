package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ad.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.protocal.c.ajh;
import com.tencent.mm.protocal.c.aji;

class r extends a<aji> {
    r(int i, int i2, int i3, int i4) {
        b.a aVar = new b.a();
        com.tencent.mm.bp.a ajh = new ajh();
        ajh.aAk = i;
        ajh.condition = i2;
        ajh.wxA = i3;
        ajh.wxB = i4;
        aVar.hnT = ajh;
        aVar.hnU = new aji();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
        this.gLB = aVar.Kf();
    }
}
