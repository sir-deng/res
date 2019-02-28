package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class i extends com.tencent.mm.sdk.e.i<j> {
    public static final String iSu = com.tencent.mm.sdk.e.i.a(j.iHi, "LaunchWxaWidgetRespData");

    public final /* synthetic */ boolean a(c cVar, boolean z, String[] strArr) {
        cVar = (j) cVar;
        if (!bi.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    cVar.field_appIdHash = cVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.a(cVar, z, strArr);
    }

    public final /* synthetic */ boolean b(c cVar, boolean z, String[] strArr) {
        return a((j) cVar, z, strArr);
    }

    public final /* synthetic */ boolean b(c cVar, String[] strArr) {
        return a((j) cVar, strArr);
    }

    public i(e eVar) {
        super(eVar, j.iHi, "LaunchWxaWidgetRespData", j.fNF);
    }

    public final j a(String str, int i, int i2, aop aop) {
        if (bi.oN(str) || aop == null) {
            return null;
        }
        int i3;
        int i4;
        j jVar = new j();
        jVar.field_appIdHash = str.hashCode();
        jVar.field_appId = str;
        jVar.field_pkgType = i;
        jVar.field_widgetType = i2;
        if (a(jVar, "appId", "pkgType", "widgetType")) {
            boolean i32 = false;
        } else {
            i32 = 1;
        }
        if (com.tencent.mm.plugin.appbrand.q.i.a(jVar.field_launchAction, aop.wCm)) {
            boolean i42 = false;
        } else {
            jVar.field_launchAction = aop.wCm;
            i42 = 1;
        }
        if (!com.tencent.mm.plugin.appbrand.q.i.a(jVar.field_jsApiInfo, aop.wCh)) {
            jVar.field_jsApiInfo = aop.wCh;
            i42 = 1;
        }
        if (!com.tencent.mm.plugin.appbrand.q.i.a(jVar.field_versionInfo, aop.wCn)) {
            jVar.field_versionInfo = aop.wCn;
            i42 = 1;
        }
        if (!com.tencent.mm.plugin.appbrand.q.i.a(jVar.field_widgetSetting, aop.wCo)) {
            jVar.field_widgetSetting = aop.wCo;
            i42 = 1;
        }
        if (i42 != 0) {
            if (i32 != 0) {
                a(jVar, false);
            } else {
                a(jVar, false, "appId", "pkgType", "widgetType");
            }
        }
        if (i42 != 0) {
            a(jVar, "appId", "pkgType", "widgetType");
        }
        return jVar;
    }

    public final boolean a(j jVar, String... strArr) {
        if (!bi.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    jVar.field_appIdHash = jVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.b((c) jVar, strArr);
    }

    private boolean a(j jVar, boolean z) {
        jVar.field_appIdHash = jVar.field_appId.hashCode();
        super.a((c) jVar, z);
        return a(jVar, "appId");
    }

    private boolean a(j jVar, boolean z, String... strArr) {
        if (!bi.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    jVar.field_appIdHash = jVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.b(jVar, z, strArr);
    }
}
