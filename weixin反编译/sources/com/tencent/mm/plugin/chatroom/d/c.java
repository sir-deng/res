package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ad.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.protocal.c.aaz;
import com.tencent.mm.protocal.c.aba;

public final class c extends a<aba> {
    public c(String str) {
        b.a aVar = new b.a();
        com.tencent.mm.bp.a aaz = new aaz();
        aaz.wfN = str;
        aVar.hnT = aaz;
        aVar.hnU = new aba();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
        this.gLB = aVar.Kf();
    }
}
