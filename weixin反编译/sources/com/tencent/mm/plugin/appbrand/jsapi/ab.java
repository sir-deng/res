package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class ab extends l {
    private static final int CTRL_INDEX = 97;
    private static final String NAME = "getPublicLibVersion";

    ab() {
    }

    public final String a(j jVar, JSONObject jSONObject) {
        return n(jVar.iuk);
    }

    public final String a(p pVar) {
        return n(pVar.iuk);
    }

    private String n(e eVar) {
        boolean z = true;
        AppBrandSysConfig appBrandSysConfig = eVar.isS;
        if (appBrandSysConfig == null) {
            return e("fail", null);
        }
        Map hashMap = new HashMap();
        hashMap.put("appDebug", Boolean.valueOf(appBrandSysConfig.iRU.iJa != 0));
        hashMap.put("appMd5", bi.oM(appBrandSysConfig.iRU.frM));
        hashMap.put("appVersion", Integer.valueOf(appBrandSysConfig.iRU.iJb));
        WxaPkgWrappingInfo aaa = com.tencent.mm.plugin.appbrand.appcache.ab.aaa();
        String str = "libDebug";
        if (aaa.iJa == 0) {
            z = false;
        }
        hashMap.put(str, Boolean.valueOf(z));
        hashMap.put("libMd5", bi.oM(aaa.frM));
        hashMap.put("libVersion", Integer.valueOf(aaa.iJb));
        hashMap.put("clientVersion", Integer.valueOf(d.vHl));
        hashMap.put("system", "android");
        hashMap.put("systemVersion", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("x5Version", Integer.valueOf(com.tencent.xweb.x5.sdk.d.getTbsVersion(ad.getContext())));
        return e("ok", hashMap);
    }
}
