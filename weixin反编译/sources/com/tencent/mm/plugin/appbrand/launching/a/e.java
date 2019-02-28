package com.tencent.mm.plugin.appbrand.launching.a;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

final class e extends a {

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.a.e$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] jEl = new int[a.aiJ().length];

        static {
            try {
                jEl[a.jEe - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jEl[a.jEg - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jEl[a.jEf - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                jEl[a.jEd - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    e() {
    }

    final void a(Uri uri, int i) {
        int i2 = 1;
        String queryParameter = uri == null ? "" : uri.getQueryParameter("appid");
        switch (AnonymousClass1.jEl[i - 1]) {
            case 1:
                int i3;
                if (uri == null || !uri.getBooleanQueryParameter("debug", false)) {
                    boolean i32 = false;
                } else {
                    i32 = 1;
                }
                AppBrand404PageUI.show(j.iDG);
                if (i32 == 0) {
                    i2 = 0;
                }
                a.C(queryParameter, 2, i2 + 1);
                return;
            case 2:
                AppBrand404PageUI.show(j.iDw);
                a.C("", 3, 2);
                return;
            case 3:
                AppBrand404PageUI.show(j.iDx);
                a.C("", 4, 2);
                return;
            case 4:
                return;
            default:
                AppBrand404PageUI.show(j.iBq);
                return;
        }
    }
}
