package com.tencent.mm.plugin.appbrand.launching.a;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

public final class c extends a {

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.a.c$1 */
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

    final void a(Uri uri, int i) {
        switch (AnonymousClass1.jEl[i - 1]) {
            case 1:
                AppBrand404PageUI.show(j.iBq);
                return;
            case 2:
                AppBrand404PageUI.show(j.iBq);
                return;
            case 3:
                AppBrand404PageUI.show(j.iBq);
                return;
            case 4:
                return;
            default:
                AppBrand404PageUI.show(j.iBq);
                return;
        }
    }
}
