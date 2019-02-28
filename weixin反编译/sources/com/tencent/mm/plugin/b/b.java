package com.tencent.mm.plugin.b;

import com.tencent.mm.y.c.c;
import com.tencent.mm.y.p;

public final class b extends p {
    private static b imW;

    private b() {
        super(c.class);
    }

    public static synchronized b Xv() {
        b bVar;
        synchronized (b.class) {
            if (imW == null) {
                imW = new b();
            }
            bVar = imW;
        }
        return bVar;
    }

    public final void fP(String str) {
        super.fP(str);
    }
}
