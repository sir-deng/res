package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static String cf(Context context) {
        if (!ao.isConnected(context)) {
            return "offline";
        }
        if (ao.isWifi(context)) {
            return "wifi";
        }
        if (ao.is4G(context)) {
            return "4g";
        }
        if (ao.is3G(context)) {
            return "3g";
        }
        if (ao.is2G(context)) {
            return "2g";
        }
        return "unknown";
    }

    public static void a(int i, String str, String str2, int i2, String str3, String str4) {
        x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, appid %s, appversion %d, appidlist %snearbyAppIdCount %s, nearbyAppIdList %s", Integer.valueOf(13533), Integer.valueOf(i), bi.oM(str), Integer.valueOf(0), str2, Integer.valueOf(i2), str3);
        g.pWK.h(13533, Integer.valueOf(i), bi.oM(str), Integer.valueOf(0), str2, Integer.valueOf(i2), str3, Integer.valueOf(0), str4);
    }

    public static void a(String str, int i, int i2, int i3, String str2) {
        int uD = uD(str);
        x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), appId %s, appVersion %s, appState : %d, eventId %d, scene %d, sceneId %s, appType %s", Integer.valueOf(13801), str, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(uD));
        g.pWK.h(13801, str, Integer.valueOf(0), Integer.valueOf(i), Long.valueOf(bi.Wx()), Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(uD));
    }

    public static void a(String str, int i, int i2, long j, boolean z) {
        String cf = cf(ad.getContext());
        if (bi.oN(cf)) {
            cf = "unknown";
        }
        x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, sessionId %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, networkType %s, eventId %d,eventRusult %d, eventPercent %d, installCostTime %s, eventTime %s, useModule %b, appType %s", Integer.valueOf(13537), Integer.valueOf(1000), "", "", str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", cf, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Long.valueOf(j), Long.valueOf(bi.Wx()), Boolean.valueOf(z), Integer.valueOf(uD(str)));
        g gVar = g.pWK;
        Object[] objArr = new Object[16];
        objArr[0] = Integer.valueOf(1000);
        objArr[1] = "";
        objArr[2] = "";
        objArr[3] = str;
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(0);
        objArr[6] = Integer.valueOf(0);
        objArr[7] = "";
        objArr[8] = cf;
        objArr[9] = Integer.valueOf(i);
        objArr[10] = Integer.valueOf(i2);
        objArr[11] = Integer.valueOf(0);
        objArr[12] = Long.valueOf(j);
        objArr[13] = Long.valueOf(r2);
        objArr[14] = Integer.valueOf(z ? 1 : 0);
        objArr[15] = Integer.valueOf(r1);
        gVar.h(13537, objArr);
    }

    public static void a(String str, String str2, int i, String str3, long j, int i2, int i3) {
        AppBrandStatObject pl = com.tencent.mm.plugin.appbrand.a.pl(str);
        if (pl == null) {
            x.e("MicroMsg.AppBrandReporterManager", "statObject is Null!");
            return;
        }
        String str4 = "";
        if (!bi.oN(str2)) {
            if (str2.contains(".html")) {
                str4 = str2.substring(0, str2.lastIndexOf(".html") + 5);
            }
        }
        String str5 = "";
        try {
            str5 = p.encode(bi.oM(str4), "UTF-8");
        } catch (Throwable e) {
            x.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
            x.printErrStackTrace("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
        }
        AppBrandSysConfig pk = com.tencent.mm.plugin.appbrand.a.pk(str);
        int i4 = pk == null ? 0 : pk.iRU.iJb;
        int i5 = pk == null ? 0 : pk.iRU.iJa + 1;
        String oM = bi.oM(str3);
        if (i == 18) {
            if (!bi.oN(str3)) {
                if (str3.contains(".html")) {
                    oM = str3.substring(0, str3.lastIndexOf(".html") + 5);
                }
            }
            try {
                oM = p.encode(bi.oM(oM), "UTF-8");
            } catch (Throwable e2) {
                x.e("MicroMsg.AppBrandReporterManager", "encode actionNote error!");
                x.printErrStackTrace("MicroMsg.AppBrandReporterManager", e2, "", new Object[0]);
            }
        }
        String oM2 = bi.oM(pl.foi);
        String oM3 = bi.oM(h.pA(str).iub);
        if (pl.scene == 0) {
            pl.scene = 1000;
        }
        int i6 = pl.fJn;
        String str6 = pl.fJo;
        int uD = uD(str);
        x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote : %s, sessionId : %s, appid : %s, appversion : %d, appState : %d, usedState : %d, pagePath : %s, action : %d, actionNote : %s,actionTime : %s, actionResult : %d, actionErrorcode : %d, preScene : %d, preSceneNote : %s, appType : %d", Integer.valueOf(13539), Integer.valueOf(pl.scene), oM2, oM3, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(pl.jMN), str4, Integer.valueOf(i), oM, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), str6, Integer.valueOf(uD));
        g.pWK.h(13539, Integer.valueOf(pl.scene), oM2, oM3, str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(pl.jMN), str5, Integer.valueOf(i), oM, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), str6, Integer.valueOf(uD));
    }

    public static void C(String str, int i, int i2) {
        if (!"@LibraryAppId".equals(str)) {
            int i3;
            Object obj;
            int i4 = 1000;
            String str2 = "";
            int i5 = 0;
            int i6 = 0;
            if (bi.oN(str)) {
                String obj2 = str2;
                i3 = 0;
                i6 = 1000;
                i5 = 1000;
                i4 = 0;
            } else {
                AppBrandStatObject pl = com.tencent.mm.plugin.appbrand.a.pl(str);
                if (pl != null) {
                    i6 = pl.scene == 0 ? 1000 : pl.scene;
                    str2 = bi.oM(pl.foi);
                    i4 = i6;
                    i6 = pl.jMN;
                }
                AppBrandSysConfig pk = com.tencent.mm.plugin.appbrand.a.pk(str);
                if (!(pk == null || pk.iRU == null)) {
                    i5 = pk.iRU.iJb;
                }
                if (!(i2 != 0 || pk == null || pk.iRU == null)) {
                    i2 = pk.iRU.iJa + 1;
                }
                obj2 = str2;
                i3 = i6;
                i6 = uD(str);
                int i7 = i5;
                i5 = i4;
                i4 = i7;
            }
            x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %s, sceneNote %s, appId %s, appVersion %s, appState %s, usedState %s, pagetype %s, targetAction %s, appType %s", Integer.valueOf(13541), Integer.valueOf(i5), obj2, str, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(3), Integer.valueOf(i6));
            g.pWK.h(13541, Integer.valueOf(i5), obj2, str, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(3), "", Integer.valueOf(i6));
        }
    }

    public static void a(String str, int i, int i2, int i3, int i4) {
        g.pWK.h(14369, str, Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(1));
    }

    public static int uD(String str) {
        int i = 0;
        if ("@LibraryAppId".equals(str)) {
            return 0;
        }
        if (ad.cgj()) {
            WxaAttributes g = e.Zs().g(str, "appInfo", "brandIconURL", "nickname");
            if (g != null) {
                i = g.acq().hqv;
            } else {
                x.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = attrs!");
            }
        } else if (!bi.oN(str)) {
            com.tencent.mm.plugin.appbrand.e pi = com.tencent.mm.plugin.appbrand.a.pi(str);
            AppBrandInitConfig appBrandInitConfig = pi == null ? null : pi.isR;
            if (appBrandInitConfig != null) {
                i = appBrandInitConfig.foo;
            } else {
                x.i("MicroMsg.AppBrandReporterManager", "getServiceTypeForReport null = initConfig! appServiceType:%s", Integer.valueOf(b.uE(str)));
                i = r1;
            }
        }
        return i + 1000;
    }
}
