package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class t extends i<s> {
    public static final String[] iHj = new String[]{i.a(s.iHi, "PkgUpdateStats")};

    public t(e eVar) {
        super(eVar, s.iHi, "PkgUpdateStats", s.fNF);
    }

    final boolean af(String str, int i) {
        c sVar = new s();
        sVar.field_key = str;
        sVar.field_version = i;
        return super.a(sVar, s.iHh);
    }
}
