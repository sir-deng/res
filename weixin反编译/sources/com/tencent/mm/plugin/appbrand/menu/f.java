package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.ui.base.n;

public final class f extends a {
    public f() {
        super(m.jGn - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        AppBrandSysConfig appBrandSysConfig = pVar.iuk.isS;
        if (appBrandSysConfig.iRU.iJa == 1) {
            CharSequence string;
            if (appBrandSysConfig.iRv) {
                string = context.getString(j.iCJ);
            } else {
                string = context.getString(j.iCQ);
            }
            nVar.f(m.jGn - 1, string);
        }
    }

    public final void a(Context context, p pVar, String str, l lVar) {
        if ((!pVar.iuk.isS.iRv ? 1 : 0) != 0) {
            AppBrandPerformanceManager.uw(str);
            Toast.makeText(context, j.iCR, 0).show();
            return;
        }
        AppBrandPerformanceManager.ux(str);
        Toast.makeText(context, j.iCK, 0).show();
    }
}
