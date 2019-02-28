package com.tencent.mm.q;

import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.y.p;

public final class h extends p implements c {
    private static h gLI;

    public static synchronized h Bq() {
        h hVar;
        synchronized (h.class) {
            if (gLI == null) {
                gLI = new h();
            }
            hVar = gLI;
        }
        return hVar;
    }

    private h() {
        super(i.class);
    }

    public final void onAccountInitialized(e.c cVar) {
        super.onAccountInitialized(cVar);
    }
}
