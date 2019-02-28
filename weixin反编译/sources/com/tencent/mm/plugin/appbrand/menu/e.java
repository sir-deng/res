package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.ui.base.n;

public final class e extends a {
    public e() {
        super(m.jGv - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        if (AppBrandPerformanceManager.uy(str)) {
            nVar.f(m.jGv - 1, context.getString(j.iCM));
        }
    }

    public final void a(final Context context, p pVar, final String str, l lVar) {
        Toast.makeText(context, j.iCO, 0).show();
        c.Dt().F(new Runnable() {
            public final void run() {
                final boolean uB = com.tencent.mm.plugin.appbrand.performance.a.uB(str);
                c.runOnUiThread(new Runnable() {
                    public final void run() {
                        Toast.makeText(context, uB ? j.iCP : j.iCN, 0).show();
                    }
                });
            }
        });
    }
}
