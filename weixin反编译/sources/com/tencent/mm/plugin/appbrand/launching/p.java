package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.launching.k.b;
import com.tencent.mm.sdk.f.e;

public abstract class p implements k {
    public volatile b jDt;
    final q jDu;

    public abstract String aiD();

    public abstract void prepare();

    p(q qVar) {
        this.jDu = qVar;
    }

    final void d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        b bVar = this.jDt;
        if (bVar != null) {
            bVar.b(wxaPkgWrappingInfo);
        }
    }

    public final void a(b bVar) {
        this.jDt = bVar;
    }

    public final void prepareAsync() {
        e.post(new Runnable() {
            public final void run() {
                p.this.prepare();
            }
        }, "AppBrandLaunchPrepareJob#" + aiD());
    }
}
