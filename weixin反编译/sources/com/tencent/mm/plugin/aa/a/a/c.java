package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ad.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.protocal.c.w;
import com.tencent.mm.protocal.c.x;

public final class c extends a<x> {
    public c(int i, int i2, int i3, String str, int i4, int i5, String str2) {
        b.a aVar = new b.a();
        com.tencent.mm.bp.a wVar = new w();
        wVar.asN = i;
        wVar.offset = i2;
        wVar.type = i3;
        wVar.vKw = str;
        wVar.vKx = i4;
        wVar.vKy = i5;
        wVar.vKz = str2;
        aVar.hnT = wVar;
        aVar.hnU = new x();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        this.gLB = aVar.Kf();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s, bill_id: %s, trans_id: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, str2);
    }

    public c(int i, int i2, int i3) {
        b.a aVar = new b.a();
        com.tencent.mm.bp.a wVar = new w();
        wVar.asN = i;
        wVar.offset = i2;
        wVar.type = i3;
        aVar.hnT = wVar;
        aVar.hnU = new x();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        this.gLB = aVar.Kf();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
