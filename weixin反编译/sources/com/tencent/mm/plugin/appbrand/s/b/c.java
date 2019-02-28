package com.tencent.mm.plugin.appbrand.s.b;

import com.tencent.mm.plugin.appbrand.s.b.a.b;
import com.tencent.mm.plugin.appbrand.s.e.a;
import com.tencent.mm.plugin.appbrand.s.e.f;

public class c extends b {
    public final int a(a aVar) {
        if (b.d((f) aVar) == 13) {
            return b.jZv;
        }
        return b.jZw;
    }

    public final com.tencent.mm.plugin.appbrand.s.e.b a(com.tencent.mm.plugin.appbrand.s.e.b bVar) {
        super.a(bVar);
        bVar.put("Sec-WebSocket-Version", "13");
        return bVar;
    }

    public a amA() {
        return new c();
    }
}
