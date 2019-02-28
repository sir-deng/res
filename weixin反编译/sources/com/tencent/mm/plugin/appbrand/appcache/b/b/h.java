package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.d.g;
import com.tencent.mm.protocal.c.cdg;
import com.tencent.mm.protocal.c.cdo;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends a<Boolean, cdo> {
    final /* bridge */ /* synthetic */ cdg aY(Object obj) {
        return ((cdo) obj).xiG;
    }

    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        boolean z;
        cdo cdo = (cdo) obj;
        com.tencent.mm.plugin.appbrand.appcache.b.d.h hVar = (com.tencent.mm.plugin.appbrand.appcache.b.d.h) e.u(com.tencent.mm.plugin.appbrand.appcache.b.d.h.class);
        int i = cdo.xiY;
        int i2 = cdo.xiG.xiE;
        if (bi.oN(str)) {
            z = false;
        } else {
            c gVar = new g();
            gVar.field_username = str;
            boolean b = hVar.b(gVar, new String[0]);
            gVar.field_appVersion = i;
            gVar.field_reportId = i2;
            z = b ? hVar.c(gVar, new String[0]) : hVar.b(gVar);
        }
        x.i("MicroMsg.AppBrand.Predownload.CmdUpdateVersion", "call, username %s, version %d, reportId %d, update %b", str, Integer.valueOf(cdo.xiY), Integer.valueOf(cdo.xiG.xiE), Boolean.valueOf(z));
        int i3 = a.iJQ;
        a.o((long) cdo.xiG.xiE, z ? 155 : 156);
        return Boolean.valueOf(z);
    }

    final String aaC() {
        return "CmdUpdateVersion";
    }
}
