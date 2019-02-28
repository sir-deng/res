package com.tencent.mm.plugin.appbrand.j;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class h {
    private static AtomicInteger jGP = new AtomicInteger(1);
    public HashMap<String, f> jlp;

    private static class a {
        private static h jHq = new h();
    }

    /* synthetic */ h(byte b) {
        this();
    }

    private h() {
        this.jlp = new HashMap();
    }

    public static int ajc() {
        return jGP.incrementAndGet();
    }

    public static h aji() {
        return a.jHq;
    }

    public final f ua(String str) {
        if (this.jlp.containsKey(str)) {
            return (f) this.jlp.get(str);
        }
        return null;
    }
}
