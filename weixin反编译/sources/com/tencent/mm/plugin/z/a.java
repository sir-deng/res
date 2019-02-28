package com.tencent.mm.plugin.z;

import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.y.p;

public final class a extends p {
    private static a pje;

    public static synchronized a bjr() {
        a aVar;
        synchronized (a.class) {
            if (pje == null) {
                pje = new a();
            }
            aVar = pje;
        }
        return aVar;
    }

    private a() {
        super(c.class);
    }
}
