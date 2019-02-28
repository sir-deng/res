package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ad.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.protocal.c.c;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a<c> {
    public d(String str, String str2) {
        b.a aVar = new b.a();
        com.tencent.mm.bp.a bVar = new com.tencent.mm.protocal.c.b();
        bVar.vJI = str;
        bVar.vJJ = str2;
        aVar.hnT = bVar;
        aVar.hnU = new c();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclosenotify";
        this.gLB = aVar.Kf();
        x.i("MicroMsg.CgiCloseAAUrgeNotify", "CgiCloseAAUrgeNotify, billNo: %s, chatroom: %s", str, str2);
    }
}
