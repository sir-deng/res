package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class c extends i<b> {
    public static final String[] iHj = new String[]{i.a(b.iHk, "AppBrandCommonKVData")};
    public final e iHl;

    public c(e eVar) {
        super(eVar, b.iHk, "AppBrandCommonKVData", null);
        this.iHl = eVar;
    }

    public final boolean aY(String str, String str2) {
        if (bi.oN(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = str;
        bVar.field_value = str2;
        if (!bi.oN(bVar.field_value)) {
            return super.a(bVar);
        }
        if (super.a(bVar, new String[0])) {
            return false;
        }
        return true;
    }

    public final String get(String str, String str2) {
        if (bi.oN(str)) {
            return str2;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = str;
        if (super.b(bVar, new String[0])) {
            return bVar.field_value;
        }
        return str2;
    }

    public final void qW(String str) {
        super.fD("AppBrandCommonKVData", String.format("delete from %s where %s like '%s%%'", new Object[]{"AppBrandCommonKVData", "key", str}));
    }
}
