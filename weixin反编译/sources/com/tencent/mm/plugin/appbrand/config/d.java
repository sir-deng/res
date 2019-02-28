package com.tencent.mm.plugin.appbrand.config;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public d iQi;
    public d iQj;
    public boolean mFinished;

    public interface a {
        void a(b bVar, boolean z);
    }

    private static class c {
        public a iQo;
        public b iQp;
        public String name;
        public boolean success;

        public /* synthetic */ c(a aVar, b bVar, boolean z, String str, byte b) {
            this(aVar, bVar, z, str);
        }

        private c(a aVar, b bVar, boolean z, String str) {
            this.iQo = aVar;
            this.iQp = bVar;
            this.success = z;
            this.name = str;
        }
    }

    private static final class e {
        private static final d iQr = new d();
    }

    public enum b {
        PORTRAIT(1),
        LANDSCAPE(6);
        
        public int iQm;

        private b(int i) {
            this.iQm = i;
        }
    }

    private class d {
        public a iQo;
        public b iQp;

        /* synthetic */ d(d dVar, b bVar, a aVar, byte b) {
            this(bVar, aVar);
        }

        private d(b bVar, a aVar) {
            this.iQp = bVar;
            this.iQo = aVar;
        }

        public final String toString() {
            return "Req{" + this.iQp + ", " + this.iQo + "}";
        }
    }

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.mFinished = false;
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.app.Activity r8, com.tencent.mm.plugin.appbrand.config.d.b r9, com.tencent.mm.plugin.appbrand.config.d.a r10) {
        /*
        r7 = this;
        r6 = 1;
        r5 = 0;
        r1 = bR(r8);
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r2 = "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s]";
        r3 = 3;
        r3 = new java.lang.Object[r3];
        r3[r5] = r9;
        r3[r6] = r10;
        r4 = 2;
        r3[r4] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        if (r8 != 0) goto L_0x002f;
    L_0x001b:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r2 = new java.lang.RuntimeException;
        r2.<init>();
        r3 = "No Activity found when request device orientation";
        r4 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r0, r2, r3, r4);
        a(r10, r1, r5);
    L_0x002e:
        return;
    L_0x002f:
        if (r9 != 0) goto L_0x0035;
    L_0x0031:
        a(r10, r1, r5);
        goto L_0x002e;
    L_0x0035:
        if (r9 != r1) goto L_0x0048;
    L_0x0037:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r1 = "requestDeviceOrientation currentOrientation hit. [%s]";
        r2 = new java.lang.Object[r6];
        r2[r5] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        a(r10, r9, r6);
        goto L_0x002e;
    L_0x0048:
        r0 = 0;
        monitor-enter(r7);
        r2 = r7.mFinished;	 Catch:{ all -> 0x0059 }
        if (r2 == 0) goto L_0x005c;
    L_0x004e:
        r0 = "MicroMsg.AppBrandDeviceOrientationHandler";
        r1 = "requestDeviceOrientation mFinished = true";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x0059 }
        monitor-exit(r7);	 Catch:{ all -> 0x0059 }
        goto L_0x002e;
    L_0x0059:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0059 }
        throw r0;
    L_0x005c:
        r2 = r7.iQi;	 Catch:{ all -> 0x0059 }
        if (r2 != 0) goto L_0x0076;
    L_0x0060:
        r2 = new com.tencent.mm.plugin.appbrand.config.d$d;	 Catch:{ all -> 0x0059 }
        r3 = 0;
        r2.<init>(r7, r9, r10, r3);	 Catch:{ all -> 0x0059 }
        r7.iQi = r2;	 Catch:{ all -> 0x0059 }
        r2 = r7.iQi;	 Catch:{ all -> 0x0059 }
        a(r8, r2);	 Catch:{ all -> 0x0059 }
    L_0x006d:
        monitor-exit(r7);	 Catch:{ all -> 0x0059 }
        if (r0 == 0) goto L_0x002e;
    L_0x0070:
        r0 = r0.iQo;
        a(r0, r1, r5);
        goto L_0x002e;
    L_0x0076:
        r2 = r7.iQj;	 Catch:{ all -> 0x0059 }
        if (r2 == 0) goto L_0x007c;
    L_0x007a:
        r0 = r7.iQj;	 Catch:{ all -> 0x0059 }
    L_0x007c:
        r2 = new com.tencent.mm.plugin.appbrand.config.d$d;	 Catch:{ all -> 0x0059 }
        r3 = 0;
        r2.<init>(r7, r9, r10, r3);	 Catch:{ all -> 0x0059 }
        r7.iQj = r2;	 Catch:{ all -> 0x0059 }
        goto L_0x006d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.config.d.a(android.app.Activity, com.tencent.mm.plugin.appbrand.config.d$b, com.tencent.mm.plugin.appbrand.config.d$a):void");
    }

    public static void a(Activity activity, d dVar) {
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", dVar);
        activity.setRequestedOrientation(dVar.iQp.iQm);
    }

    public static b bR(Context context) {
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return null;
        }
        x.i("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
        return b(context.getResources().getConfiguration());
    }

    private static void a(a aVar, b bVar, boolean z) {
        if (aVar != null) {
            aVar.a(bVar, z);
        }
    }

    public static b qX(String str) {
        if ("landscape".equals(str)) {
            return b.LANDSCAPE;
        }
        if ("portrait".equals(str)) {
            return b.PORTRAIT;
        }
        return null;
    }

    public static b a(AppBrandInitConfig appBrandInitConfig, a aVar) {
        b bVar = null;
        if (!(aVar == null || aVar.iPI == null)) {
            x.i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex]AppBrandAppConfig has deviceOrientation field [%s]", aVar.acb());
            bVar = qX(aVar.acb());
        }
        if (bVar == null) {
            if (!appBrandInitConfig.YI()) {
                return b.PORTRAIT;
            }
            x.i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex]AppBrandInitConfig has orientation field [%s]", appBrandInitConfig.iRe);
            bVar = qX(appBrandInitConfig.iRe);
        }
        if (bVar == null) {
            return b.PORTRAIT;
        }
        return bVar;
    }

    public static b b(Configuration configuration) {
        if (configuration == null) {
            x.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == null ");
            return null;
        } else if (configuration.orientation == 2) {
            x.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
            return b.LANDSCAPE;
        } else if (configuration.orientation == 1) {
            x.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
            return b.PORTRAIT;
        } else {
            x.i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", Integer.valueOf(configuration.orientation));
            return null;
        }
    }
}
