package com.tencent.mm.t.c;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.t.b.e;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private final Map<String, e> gQH = new HashMap();

    public final void a(e eVar) {
        this.gQH.put(eVar.getName(), eVar);
    }

    public final e fu(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return (e) this.gQH.get(str);
    }
}
