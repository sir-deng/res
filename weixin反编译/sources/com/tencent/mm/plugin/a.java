package com.tencent.mm.plugin;

import com.tencent.mm.modelstat.q;
import com.tencent.mm.y.p;

public final class a extends p {
    private static a ihM;

    public static synchronized a WH() {
        a aVar;
        synchronized (a.class) {
            if (ihM == null) {
                ihM = new a();
            }
            aVar = ihM;
        }
        return aVar;
    }

    private a() {
        super(q.class);
    }
}
