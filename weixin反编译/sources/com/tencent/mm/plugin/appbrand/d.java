package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.f.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.w.a;

public final class d {
    private static final c<e> isN = new c<e>() {
        {
            this.xmG = e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (!((e) bVar).fnJ.fnK && g.Do().CF()) {
                long longValue = ((Long) g.Dq().Db().get(a.USERINFO_APP_BRAND_PRUNE_PKG_NEXT_TIME_SEC_LONG, Long.valueOf(0))).longValue();
                long Wx = bi.Wx();
                if (Wx >= longValue) {
                    d.uc();
                    g.Dq().Db().a(a.USERINFO_APP_BRAND_PRUNE_PKG_NEXT_TIME_SEC_LONG, Long.valueOf(Wx + 86400));
                }
            }
            return false;
        }
    };

    static /* synthetic */ void uc() {
        com.tencent.mm.plugin.appbrand.r.c.Dt().F(am.iIC);
        com.tencent.mm.plugin.appbrand.r.c.Dt().F(com.tencent.mm.plugin.appbrand.appstorage.d.iIC);
    }

    public static void setup() {
        com.tencent.mm.sdk.b.a.xmy.a(isN);
    }

    public static void release() {
        com.tencent.mm.sdk.b.a.xmy.c(isN);
    }
}
