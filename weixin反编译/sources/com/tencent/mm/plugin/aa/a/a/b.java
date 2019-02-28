package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ad.a;
import com.tencent.mm.protocal.c.r;
import com.tencent.mm.protocal.c.s;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a<s> {
    public b(String str, String str2, int i) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        com.tencent.mm.bp.a rVar = new r();
        rVar.vJI = str;
        rVar.vJJ = str2;
        rVar.scene = i;
        aVar.hnT = rVar;
        aVar.hnU = new s();
        aVar.uri = "/cgi-bin/mmpay-bin/newaapayurge";
        this.gLB = aVar.Kf();
        x.i("MicroMsg.CgiAAPayUrge", "CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", str, str2, Integer.valueOf(i));
    }
}
