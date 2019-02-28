package com.tencent.mm.plugin.soter;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.c.d;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.soter.d.b;
import com.tencent.mm.sdk.platformtools.x;

public class PluginSoter extends f implements c, a {
    private d rYc = null;
    private boolean rYd = false;

    public String name() {
        return "plugin-soter";
    }

    public void execute(g gVar) {
        if (gVar.DZ()) {
            x.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", gVar.gQd);
            this.rYd = true;
            x.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
            this.rYc = new d();
            safeAddListener(this.rYc);
        }
    }

    public void uninstalled() {
        super.uninstalled();
        safeRemoveListener(this.rYc);
    }

    private void safeAddListener(com.tencent.mm.sdk.b.c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.PluginSoter", "hy: listener is null or id is invalid");
        } else if (com.tencent.mm.sdk.b.a.xmy.d(cVar)) {
            x.w("MicroMsg.PluginSoter", "hy: already has listener");
        } else {
            com.tencent.mm.sdk.b.a.xmy.b(cVar);
        }
    }

    private void safeRemoveListener(com.tencent.mm.sdk.b.c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.PluginSoter", "alvinluo listener is null");
        } else {
            com.tencent.mm.sdk.b.a.xmy.c(cVar);
        }
    }

    public void onAccountInitialized(e.c cVar) {
        x.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", Boolean.valueOf(this.rYd));
        if (this.rYd) {
            h.bDA();
            b.a(false, false, null);
        }
    }

    public void onAccountRelease() {
        x.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
    }
}
