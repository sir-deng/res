package com.tencent.mm.af;

import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.p;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class l implements o, b, com.tencent.mm.kernel.api.bucket.b, c {
    private o hrF;
    private p hrG;

    public final o Fi() {
        return this.hrF;
    }

    public final p Fj() {
        return this.hrG;
    }

    public final String FC() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        return stringBuilder.append(g.Dq().gRT).append("brandicon/").toString();
    }

    public final List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"brandicon/"});
        return linkedList;
    }

    public final void onAccountInitialized(e.c cVar) {
        com.tencent.mm.plugin.messenger.foundation.a.a.c aZO = ((h) g.h(h.class)).aZO();
        com.tencent.mm.storage.e oVar = new o(aZO);
        this.hrF = oVar;
        aZO.a(oVar);
        this.hrG = new p(((h) g.h(h.class)).Fk());
    }

    public final void onAccountRelease() {
    }

    public final void parallelsDependency() {
        a.a(this, c.class).aJ(g.k(n.class));
    }
}
