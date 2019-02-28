package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import java.util.LinkedList;
import java.util.List;

public final class c {
    private static long jtP = 200;
    private static long jtQ = 20;
    private f jtG;
    private final List<com.tencent.mm.plugin.appbrand.jsapi.f> jtR;
    private Runnable jtS;

    private static class a {
        static c jtU = new c();
    }

    /* synthetic */ c(byte b) {
        this();
    }

    public static c agY() {
        return a.jtU;
    }

    private static boolean agZ() {
        if (WebView.getCurWebType() == com.tencent.xweb.WebView.c.WV_KIND_X5) {
            if (WebView.getTbsCoreVersion(ad.getContext()) >= 36867) {
                return true;
            }
            return false;
        } else if (WebView.getCurWebType() != com.tencent.xweb.WebView.c.WV_KIND_CW) {
            return false;
        } else {
            return true;
        }
    }

    public static int aha() {
        return agZ() ? 5 : 20;
    }

    private c() {
        this.jtR = new LinkedList();
        jtP = (long) (agZ() ? 20 : 200);
        this.jtS = new Runnable() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r6 = this;
                r5 = 0;
                r0 = com.tencent.mm.plugin.appbrand.jsapi.k.c.this;
                r1 = r0.jtR;
                monitor-enter(r1);
                r0 = com.tencent.mm.plugin.appbrand.jsapi.k.c.this;	 Catch:{ all -> 0x006a }
                r0 = r0.jtR;	 Catch:{ all -> 0x006a }
                r0 = r0.isEmpty();	 Catch:{ all -> 0x006a }
                if (r0 == 0) goto L_0x0016;
            L_0x0014:
                monitor-exit(r1);	 Catch:{ all -> 0x006a }
            L_0x0015:
                return;
            L_0x0016:
                r0 = com.tencent.mm.plugin.appbrand.jsapi.k.c.this;	 Catch:{ all -> 0x006a }
                r0 = r0.jtR;	 Catch:{ all -> 0x006a }
                r2 = 0;
                r0 = r0.remove(r2);	 Catch:{ all -> 0x006a }
                r0 = (com.tencent.mm.plugin.appbrand.jsapi.f) r0;	 Catch:{ all -> 0x006a }
                r2 = com.tencent.mm.plugin.appbrand.jsapi.k.c.this;	 Catch:{ all -> 0x006a }
                r2 = r2.jtR;	 Catch:{ all -> 0x006a }
                r2 = r2.size();	 Catch:{ all -> 0x006a }
                monitor-exit(r1);	 Catch:{ all -> 0x006a }
                r0.afI();
                r1 = "MicroMsg.SensorJsEventPublisher";
                r3 = "publish next event(event : %s), list size is : %d.";
                r4 = 2;
                r4 = new java.lang.Object[r4];
                r0 = r0.getName();
                r4[r5] = r0;
                r0 = 1;
                r2 = java.lang.Integer.valueOf(r2);
                r4[r0] = r2;
                com.tencent.mm.sdk.platformtools.x.v(r1, r3, r4);
                r0 = com.tencent.mm.plugin.appbrand.jsapi.k.c.this;
                r1 = r0.jtR;
                monitor-enter(r1);
                r0 = com.tencent.mm.plugin.appbrand.jsapi.k.c.this;	 Catch:{ all -> 0x006d }
                r0 = r0.jtR;	 Catch:{ all -> 0x006d }
                r0 = r0.isEmpty();	 Catch:{ all -> 0x006d }
                monitor-exit(r1);	 Catch:{ all -> 0x006d }
                if (r0 != 0) goto L_0x0015;
            L_0x005e:
                r0 = com.tencent.mm.plugin.appbrand.r.c.Dt();
                r2 = com.tencent.mm.plugin.appbrand.jsapi.k.c.jtP;
                r0.g(r6, r2);
                goto L_0x0015;
            L_0x006a:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x006a }
                throw r0;
            L_0x006d:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x006d }
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.k.c.1.run():void");
            }
        };
        this.jtG = new f(jtP, new com.tencent.mm.plugin.appbrand.r.f.a() {
            public final boolean g(Object... objArr) {
                synchronized (c.this.jtR) {
                    if (c.this.jtR.isEmpty()) {
                        return false;
                    }
                    c.this.jtS.run();
                    return true;
                }
            }
        });
    }

    public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
        if (fVar == null) {
            return false;
        }
        if (!fVar.b(cVar)) {
            return false;
        }
        boolean isEmpty;
        synchronized (this.jtR) {
            isEmpty = this.jtR.isEmpty();
            if (this.jtR.isEmpty()) {
                this.jtR.add(fVar);
            } else if (((com.tencent.mm.plugin.appbrand.jsapi.f) this.jtR.get(0)).equals(fVar)) {
                this.jtR.add(0, fVar);
                this.jtR.remove(1);
            } else {
                this.jtR.remove(fVar);
                this.jtR.add(fVar);
            }
        }
        if (isEmpty && !this.jtG.i(new Object[0])) {
            x.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", fVar.getName());
            com.tencent.mm.plugin.appbrand.r.c.Dt().g(this.jtS, jtP);
        }
        return true;
    }
}
