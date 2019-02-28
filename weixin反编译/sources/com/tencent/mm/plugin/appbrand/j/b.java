package com.tencent.mm.plugin.appbrand.j;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static AtomicInteger jGP = new AtomicInteger(1);
    public HashMap<String, a> jlp;

    private static class a {
        private static b jGQ = new b();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this.jlp = new HashMap();
    }

    public static int ajc() {
        return jGP.incrementAndGet();
    }

    public static b ajd() {
        return a.jGQ;
    }

    public final a tV(String str) {
        if (this.jlp.containsKey(str)) {
            return (a) this.jlp.get(str);
        }
        return null;
    }
}
