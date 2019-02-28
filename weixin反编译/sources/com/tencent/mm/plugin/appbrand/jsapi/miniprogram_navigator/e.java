package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

final class e {

    public static final class a {
        public int fJn;
        public String fJo;
        public String foi;
        public int scene;
    }

    interface b {
        void cQ(boolean z);
    }

    static void a(j jVar, String str, int i, int i2, String str2, a aVar, JSONObject jSONObject, b bVar) {
        String str3;
        x.i("MicroMsg.MiniProgramNavigator", "navigateTo sourceType:%d", Integer.valueOf(i2));
        String str4 = "";
        n nVar = jVar.iuk.isX;
        p aeO = (nVar == null || nVar.ajy() == null) ? null : nVar.ajy().aeO();
        if (aeO != null) {
            str4 = aeO.afe();
        }
        String str5 = jVar.mAppId + ":" + jVar.iuk.isR.iub;
        AppBrandStatObject pl = com.tencent.mm.plugin.appbrand.a.pl(jVar.mAppId);
        final AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        int i3 = (aVar == null || aVar.scene == 0) ? 1037 : aVar.scene;
        appBrandStatObject.scene = i3;
        appBrandStatObject.fJm = pl.fJm;
        if (aVar == null || aVar.scene == 0 || bi.oN(aVar.foi)) {
            str3 = str5;
        } else {
            str3 = String.format("%s:%s", new Object[]{str5, aVar.foi});
        }
        appBrandStatObject.foi = str3;
        appBrandStatObject.fJn = aVar != null ? aVar.fJn : 0;
        appBrandStatObject.fJo = aVar != null ? aVar.fJo : null;
        final AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.appId = jVar.mAppId;
        appBrandLaunchReferrer.iRq = jSONObject == null ? "{}" : jSONObject.toString();
        appBrandLaunchReferrer.iRp = 1;
        appBrandLaunchReferrer.url = str4;
        appBrandLaunchReferrer.fqY = i2;
        i.pF(jVar.mAppId).iui = str;
        i.pF(jVar.mAppId).iuj = str2;
        final b bVar2 = bVar;
        str5 = str2;
        final j jVar2 = jVar;
        final String str6 = str;
        final int i4 = i;
        MainProcessTask appBrandPreInitTask = new AppBrandPreInitTask(str, i, appBrandStatObject, new com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a() {
            public final void a(AppBrandInitConfig appBrandInitConfig) {
                if (appBrandInitConfig != null) {
                    if (bVar2 != null) {
                        bVar2.cQ(true);
                    }
                    appBrandInitConfig.startTime = System.currentTimeMillis();
                    appBrandInitConfig.iRi = com.tencent.mm.plugin.appbrand.appcache.a.pP(str5);
                    appBrandInitConfig.iRl.a(appBrandLaunchReferrer);
                    c.a(jVar2.mAppId, c.c.LAUNCH_MINI_PROGRAM);
                    if (appBrandInitConfig.YI()) {
                        g.jEI.a(jVar2.getContext(), null, str6, str5, i4, -1, appBrandStatObject, appBrandLaunchReferrer, null);
                        return;
                    }
                    com.tencent.mm.plugin.appbrand.e eVar = jVar2.iuk;
                    eVar.isP.a(eVar, appBrandInitConfig, appBrandStatObject);
                } else if (bVar2 != null) {
                    bVar2.cQ(false);
                }
            }
        });
        appBrandPreInitTask.afy();
        AppBrandMainProcessService.a(appBrandPreInitTask);
    }
}
