package com.tencent.mm.plugin.welab;

import com.tencent.mm.bx.h;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class PluginWelab extends f implements a, c, d, com.tencent.mm.plugin.welab.a.a {
    private c tVt = new c();
    private boolean tVu;

    public void installed() {
        alias(com.tencent.mm.plugin.welab.a.a.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(g gVar) {
        if (gVar.DZ()) {
            x.v("PluginWelab", "configure");
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.d.class, new com.tencent.mm.kernel.c.d(new d()));
            ((b) com.tencent.mm.kernel.g.k(b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a() {
                public final void a(i.f fVar, i.g gVar, boolean z) {
                    b.bWh();
                    b.L(PluginWelab.this.tVu, !z);
                }

                public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
                }
            });
        }
    }

    public void execute(g gVar) {
        x.v("PluginWelab", "execute");
    }

    public String toString() {
        return "plugin-welab";
    }

    public void onDataBaseOpened(h hVar, h hVar2) {
        x.v("PluginWelab", "onDataBaseOpened");
        b.bWh().tVV = new com.tencent.mm.plugin.welab.c.a(hVar);
    }

    public void onDataBaseClosed(h hVar, h hVar2) {
    }

    public void onAccountInitialized(e.c cVar) {
        x.v("PluginWelab", "onAccountInitialized");
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.a.class, new com.tencent.mm.plugin.welab.a.b());
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.c.class, new com.tencent.mm.plugin.welab.a.c());
        this.tVu = cVar.gSl;
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("newabtestlabs", this.tVt, true);
    }

    public void onAccountRelease() {
        x.v("PluginWelab", "onAccountRelease");
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("newabtestlabs", this.tVt, true);
    }

    public HashMap<Integer, h.d> collectDatabaseFactory() {
        x.v("PluginWelab", "collectDatabaseFactory");
        HashMap<Integer, h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("LabAppInfo".hashCode()), new h.d() {
            public final String[] wn() {
                return new String[]{com.tencent.mm.sdk.e.i.a(com.tencent.mm.plugin.welab.c.a.a.gKN, "LabAppInfo")};
            }
        });
        return hashMap;
    }
}
