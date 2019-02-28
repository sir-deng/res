package com.tencent.mm.plugin.appbrand.l;

public class b {
    private static volatile b jMw = null;
    public a jMx = new a();
    public c jMy = new c();
    final Object jMz = new Object();

    private b() {
    }

    public static b akm() {
        if (jMw != null) {
            return jMw;
        }
        b bVar;
        synchronized (b.class) {
            if (jMw == null) {
                jMw = new b();
            }
            bVar = jMw;
        }
        return bVar;
    }
}
