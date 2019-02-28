package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.pluginsdk.i.a.d.l;
import java.util.HashSet;
import java.util.Set;

public final class r {
    private static final Set<b> iHg = new HashSet();

    public interface a {
        void ZK();

        void ZL();

        void ZM();

        void ZN();

        void ZO();

        void ZP();

        void a(l lVar);

        void cq(boolean z);

        void jz(int i);
    }

    public interface b {
        a a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar);
    }

    public static void a(b bVar) {
        synchronized (iHg) {
            iHg.add(bVar);
        }
    }

    static a a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        synchronized (iHg) {
        }
        for (Object obj : iHg.toArray()) {
            a a = ((b) obj).a(aVar);
            if (a != null) {
                return a;
            }
        }
        return null;
    }
}
