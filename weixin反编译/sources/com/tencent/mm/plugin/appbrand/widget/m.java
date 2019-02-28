package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class m extends i<l> {
    public static final String[] iHj = new String[]{i.a(l.iHk, "WxaWidgetInfo")};
    public static final String[] kaO = new String[0];

    public m(e eVar) {
        super(eVar, l.iHk, "WxaWidgetInfo", kaO);
    }

    public final l vy(String str) {
        if (bi.oN(str)) {
            return null;
        }
        c lVar = new l();
        lVar.field_appId = str;
        lVar.field_appIdHash = str.hashCode();
        if (b(lVar, "appIdHash")) {
            return lVar;
        }
        return null;
    }
}
