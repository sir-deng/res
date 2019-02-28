package com.tencent.mm.plugin.appbrand.appcache;

public final class aa {
    private static int iHm;

    static synchronized void jB(int i) {
        synchronized (aa.class) {
            iHm = i;
        }
    }

    public static synchronized int ZX() {
        int i;
        synchronized (aa.class) {
            i = iHm;
        }
        return i;
    }
}
