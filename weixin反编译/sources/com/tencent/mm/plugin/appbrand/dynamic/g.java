package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.dynamic.f.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Collection;

public final class g {
    private static com.tencent.mm.network.n.a iVt = new com.tencent.mm.network.n.a() {
        public final void eq(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt(DownloadInfo.STATUS, i);
            f.a("com.tencent.mm:support", bundle, a.class, null);
        }
    };

    private static final class a implements com.tencent.mm.ipcinvoker.a {
        private a() {
        }

        public final void a(Bundle bundle, c cVar) {
            Collection<c> values = d.acV().iVk.values();
            if (values != null && !values.isEmpty()) {
                com.tencent.mm.t.b.c dVar = new d();
                String str = dVar.name;
                String jSONObject = dVar.sO().toString();
                for (c cVar2 : values) {
                    if (cVar2 != null) {
                        cVar2.bb(str, jSONObject);
                    }
                }
            }
        }
    }

    public static void initialize() {
        if (ad.cgj()) {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().a(iVt);
        }
    }

    public static void release() {
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().b(iVt);
    }
}
