package com.tencent.mm.app;

import android.app.Application;
import android.content.res.Resources;
import com.tencent.mm.R;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.svg.b.c.a;

public final class m {
    private static Class<?> ffY = null;
    private static Application ffZ;
    private static Resources fga;
    private static String mPackageName = null;

    public static void d(Class<?> cls) {
        ffY = cls;
    }

    public static void cu(String str) {
        mPackageName = str;
    }

    public static void ua() {
        boolean z = true;
        x.i("MicroMsg.SVGInit", "SVG initSVGPreload");
        e.a(new a() {
            public final void i(String str, String str2, Object... objArr) {
                x.i(str, str2, objArr);
            }

            public final void e(String str, String str2, Object... objArr) {
                x.e(str, str2, objArr);
            }

            public final void d(String str, String str2, Object... objArr) {
                x.d(str, str2, objArr);
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                x.printErrStackTrace(str, th, str2, objArr);
            }
        });
        e.d(ffY);
        e.a(ffZ, fga, mPackageName);
        try {
            boolean z2 = ffZ.getBaseContext().getResources().getDrawable(R.k.dvf) != null;
            b Ef = b.Ef();
            if (z2) {
                z = false;
            }
            Ef.gUJ = z;
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SVGInit", th, "not support get svg from application context", new Object[0]);
        } finally {
            b.Ef().gUJ = true;
        }
    }

    public static void a(Application application, Resources resources) {
        e.b(application, mPackageName);
        ffZ = application;
        fga = resources;
    }
}
