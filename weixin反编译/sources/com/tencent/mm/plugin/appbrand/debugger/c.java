package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class c implements com.tencent.mm.plugin.appbrand.appcache.an.c, a {
    public final void u(Map<String, String> map) {
        if (DebuggerShell.acx()) {
            String str = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
            String str2 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
            int i = bi.getInt((String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
            int i2 = bi.getInt((String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
            String str3 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
            String str4 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
            String str5 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
            if (i >= 0) {
                if (i != 0) {
                    if (e.Zz() != null && !bi.oN(str4) && !bi.oN(str5)) {
                        if (e.Zz().a(str, i, str4, str5, bi.Wx(), bi.Wx() + 432000)) {
                            d.aL(str, i);
                        }
                    } else {
                        return;
                    }
                }
                x.i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp");
                b qrVar = new qr();
                qrVar.fJd.appId = str;
                qrVar.fJd.userName = str2;
                qrVar.fJd.fJg = i;
                qrVar.fJd.fJf = str3;
                qrVar.fJd.fJh = i2;
                qrVar.fJd.fwM = str4;
                qrVar.fJd.fJi = str5;
                qrVar.fJd.fJj = false;
                qrVar.fJd.scene = 1030;
                com.tencent.mm.sdk.b.a.xmy.m(qrVar);
            }
        }
    }

    public final String name() {
        return "ForceOpenAppNotify";
    }

    public final void t(Intent intent) {
        String stringExtra = intent.getStringExtra("appId");
        int intExtra = intent.getIntExtra("versionType", 0);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1030;
        ((com.tencent.mm.plugin.appbrand.n.d) g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(null, null, stringExtra, intExtra, 0, null, appBrandStatObject);
    }
}
