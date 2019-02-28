package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.launching.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.plugin.appbrand.ui.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

final class k {
    static String tI(String str) {
        if (bi.oN(str)) {
            return "";
        }
        ComponentName componentName = new ComponentName(ad.getContext(), str);
        PackageManager packageManager = ad.getContext().getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, FileUtils.S_IWUSR);
            if (activityInfo == null) {
                return "";
            }
            return activityInfo.processName;
        } catch (NameNotFoundException e) {
            try {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(componentName, FileUtils.S_IWUSR);
                if (serviceInfo == null) {
                    return "";
                }
                return serviceInfo.processName;
            } catch (NameNotFoundException e2) {
                return "";
            }
        }
    }

    static void a(Context context, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        x.i("MicroMsg.AppBrand.PreconditionUtil", "startAppOnInitConfigGot, %s", appBrandInitConfig);
        b.b(appBrandInitConfig, appBrandStatObject);
        appBrandInitConfig.startTime = bi.Wy();
        int b = d.b(context, appBrandInitConfig, appBrandStatObject);
        if (context instanceof Activity) {
            f.a((Activity) context, appBrandStatObject);
        }
        x.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] startAppOnInitConfigGot %s", appBrandInitConfig);
        if (b == 1) {
            new com.tencent.mm.plugin.appbrand.launching.d(appBrandInitConfig, appBrandStatObject).ait();
        }
        com.tencent.mm.plugin.appbrand.config.f acm = com.tencent.mm.plugin.appbrand.config.f.acm();
        String str = appBrandInitConfig.username;
        if (appBrandInitConfig != null && !bi.oN(appBrandInitConfig.appId)) {
            synchronized (acm.iRn) {
                acm.iRn.put(appBrandInitConfig.appId, appBrandInitConfig);
            }
            if (!bi.oN(str)) {
                synchronized (acm.iRo) {
                    acm.iRo.put(str, appBrandInitConfig.appId);
                }
            }
        }
    }
}
