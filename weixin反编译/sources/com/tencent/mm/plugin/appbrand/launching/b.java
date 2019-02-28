package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class b {
    public static void b(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        appBrandInitConfig.iRj = com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b.aO(appBrandInitConfig.appId, appBrandInitConfig.iIZ);
        appBrandInitConfig.acj();
        boolean ap = e.Zx().ap(appBrandInitConfig.username, appBrandInitConfig.iIZ);
        if (e.Zy().ao(appBrandInitConfig.username, appBrandInitConfig.iIZ)) {
            appBrandStatObject.jMN = 1;
        } else if (ap) {
            appBrandStatObject.jMN = 2;
        } else {
            appBrandStatObject.jMN = 3;
        }
    }
}
