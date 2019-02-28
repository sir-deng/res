package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.b;
import com.tencent.mm.plugin.appbrand.ui.h;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<String, e> isq = new HashMap();
    private static Map<String, android.support.v4.app.a.a> isr = new HashMap();
    private static final Map<String, AppBrandStatObject> iss = new HashMap();
    private static Map<String, h> ist = new HashMap();

    public static void a(String str, e eVar) {
        if (!bi.oN(str)) {
            synchronized (isq) {
                isq.put(str, eVar);
            }
            if (eVar != null && eVar.isR != null) {
                b.aJ(str, eVar.isR.foo);
            }
        }
    }

    public static e pi(String str) {
        if (bi.oN(str)) {
            return null;
        }
        e eVar;
        synchronized (isq) {
            eVar = (e) isq.get(str);
        }
        return eVar;
    }

    public static void a(String str, android.support.v4.app.a.a aVar) {
        isr.put(str, aVar);
    }

    public static void a(String str, int i, String[] strArr, int[] iArr) {
        if (isr.containsKey(str)) {
            ((android.support.v4.app.a.a) isr.remove(str)).onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public static void pj(String str) {
        isr.remove(str);
    }

    public static AppBrandSysConfig pk(String str) {
        return pi(str) == null ? null : pi(str).isS;
    }

    public static void a(String str, AppBrandStatObject appBrandStatObject) {
        synchronized (iss) {
            iss.put(str, appBrandStatObject);
        }
    }

    public static AppBrandStatObject pl(String str) {
        AppBrandStatObject appBrandStatObject;
        synchronized (iss) {
            appBrandStatObject = (AppBrandStatObject) iss.get(str);
        }
        return appBrandStatObject;
    }

    public static void a(String str, h hVar) {
        ist.put(str, hVar);
    }

    public static h pm(String str) {
        return (h) ist.get(str);
    }

    public static void pn(String str) {
        ist.remove(str);
    }
}
