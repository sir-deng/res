package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class d extends i<a> {
    public static final String[] iHj = new String[]{i.a(a.iHk, "AppBrandAppLaunchUsernameDuplicateRecord")};
    public final e iHl;

    public d(e eVar) {
        super(eVar, a.iHk, "AppBrandAppLaunchUsernameDuplicateRecord", a.fNF);
        this.iHl = eVar;
    }

    public final boolean t(String str, long j) {
        if (bi.oN(str)) {
            return false;
        }
        c aVar = new a();
        aVar.field_username = str;
        boolean b = b(aVar, new String[0]);
        aVar.field_updateTime = j;
        return b ? c(aVar, new String[0]) : b(aVar);
    }
}
