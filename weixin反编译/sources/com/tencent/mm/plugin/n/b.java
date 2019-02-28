package com.tencent.mm.plugin.n;

import com.tencent.mm.ap.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.y.p;

public final class b extends p {
    private static b nHm;

    private b() {
        super(o.class);
    }

    public static synchronized b aTs() {
        b bVar;
        synchronized (b.class) {
            if (nHm == null) {
                nHm = new b();
            }
            bVar = nHm;
        }
        return bVar;
    }

    public static at Fm() {
        g.Do().CA();
        return ((a) g.h(a.class)).Fm();
    }
}
