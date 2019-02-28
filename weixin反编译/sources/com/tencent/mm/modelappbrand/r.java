package com.tencent.mm.modelappbrand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class r implements q {
    private f hlr;
    protected Map<String, i> hls = new HashMap();

    public r(f fVar) {
        this.hlr = fVar;
    }

    public r(q qVar) {
        if (qVar != null) {
            this.hlr = qVar.Jm();
            a(qVar);
        }
    }

    private void a(q qVar) {
        for (i a : qVar.Jn()) {
            a(a);
        }
    }

    public final f Jm() {
        return this.hlr;
    }

    public final <T> T iB(String str) {
        return this.hls.get(str);
    }

    public final void a(i iVar) {
        this.hls.put(iVar.getName(), iVar);
    }

    public final List<i> Jn() {
        return new ArrayList(this.hls.values());
    }
}
