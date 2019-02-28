package com.tencent.mm.wallet_core.f;

import java.util.WeakHashMap;

public final class a {
    public WeakHashMap<Object, Boolean> zRl = new WeakHashMap();

    private static class a {
        static a zRm = new a();
    }

    public static synchronized a cCB() {
        a aVar;
        synchronized (a.class) {
            aVar = a.zRm;
        }
        return aVar;
    }
}
