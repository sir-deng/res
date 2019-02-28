package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.ax.r;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bg;

public final class d implements c, h {
    ad oub;
    bg ouc;
    av oud;
    af oue;
    r ouf;
    bd oug;
    ai ouh;

    public final /* synthetic */ b FQ() {
        g.Dr();
        g.Do().CA();
        return this.ouh;
    }

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.d Fe() {
        g.Dr();
        g.Do().CA();
        return this.ouf;
    }

    public final /* synthetic */ ar Ff() {
        g.Dr();
        g.Do().CA();
        return this.oub;
    }

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.g Fg() {
        g.Dr();
        g.Do().CA();
        return this.ouc;
    }

    public final /* synthetic */ as Fk() {
        g.Dr();
        g.Do().CA();
        return this.oue;
    }

    public final /* synthetic */ f Fn() {
        g.Dr();
        g.Do().CA();
        return this.oug;
    }

    public final /* synthetic */ com.tencent.mm.plugin.messenger.foundation.a.a.c aZO() {
        g.Dr();
        g.Do().CA();
        return this.oud;
    }

    public final void onAccountInitialized(e.c cVar) {
    }

    public final void onAccountRelease() {
        if (this.oub != null) {
            ad adVar = this.oub;
            adVar.xGz.clear();
            adVar.xGA.clear();
        }
        if (this.ouf != null) {
            com.tencent.mm.ad.e eVar = this.ouf;
            g.Dr();
            g.Dp().gRu.b(681, eVar);
            g.Dr();
            g.Dp().gRu.b(806, eVar);
        }
    }
}
