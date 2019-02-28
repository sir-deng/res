package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

final class e implements a {
    e() {
    }

    public final String name() {
        return "LaunchApp";
    }

    public final void t(Intent intent) {
        String stringExtra = intent.getStringExtra("username");
        String stringExtra2 = intent.getStringExtra("appId");
        String stringExtra3 = intent.getStringExtra("path");
        int i = bi.getInt(intent.getStringExtra("versionType"), 0);
        int i2 = bi.getInt(intent.getStringExtra("scene"), 1030);
        String stringExtra4 = intent.getStringExtra("sceneNote");
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = i2;
        appBrandStatObject.foi = stringExtra4;
        ((d) g.h(d.class)).a(ad.getContext(), stringExtra, stringExtra2, i, 0, stringExtra3, appBrandStatObject);
    }
}
