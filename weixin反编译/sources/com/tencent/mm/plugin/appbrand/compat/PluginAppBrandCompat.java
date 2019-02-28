package com.tencent.mm.plugin.appbrand.compat;

import android.support.annotation.Keep;
import com.tencent.mm.f.a.ad;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.n.c.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.b.b;

@Keep
public final class PluginAppBrandCompat extends f implements c, e {
    private final com.tencent.mm.sdk.b.c bannerOnInitListener = new com.tencent.mm.sdk.b.c<ad>() {
        {
            this.xmG = ad.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            g.h(d.class);
            return false;
        }
    };

    public final void installed() {
        super.installed();
        alias(e.class);
    }

    public final void configure(com.tencent.mm.kernel.b.g gVar) {
    }

    public final void execute(com.tencent.mm.kernel.b.g gVar) {
        if (gVar.DZ()) {
            g.a(com.tencent.mm.plugin.appbrand.compat.a.f.class, new com.tencent.mm.kernel.c.d(new com.tencent.mm.plugin.appbrand.m.d()));
            g.a(com.tencent.mm.plugin.appbrand.compat.a.d.class, new com.tencent.mm.kernel.c.d(new b()));
            g.Dr().a(new com.tencent.mm.kernel.api.g() {
                public final void um() {
                    com.tencent.mm.plugin.appbrand.ui.banner.d.alO();
                }

                public final void aI(boolean z) {
                }
            });
        } else {
            g.a(a.class, new com.tencent.mm.kernel.c.d(new com.tencent.mm.plugin.appbrand.jsapi.n.d()));
        }
        g.a(com.tencent.mm.plugin.appbrand.compat.a.a.class, new com.tencent.mm.kernel.c.d(new a()));
        g.a(com.tencent.mm.plugin.appbrand.compat.a.c.class, new com.tencent.mm.kernel.c.d(new k()));
    }

    public final void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        this.bannerOnInitListener.cfB();
    }

    public final void onAccountRelease() {
        this.bannerOnInitListener.dead();
    }
}
