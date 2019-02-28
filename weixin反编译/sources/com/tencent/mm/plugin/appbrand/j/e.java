package com.tencent.mm.plugin.appbrand.j;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class e {
    private static AtomicInteger jGP = new AtomicInteger(1);
    public HashMap<String, c> jlp;

    private static class a {
        private static e jHj = new e();
    }

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
        this.jlp = new HashMap();
    }

    public static int ajc() {
        return jGP.incrementAndGet();
    }

    public static e ajg() {
        return a.jHj;
    }

    public final c tY(String str) {
        if (this.jlp.containsKey(str)) {
            return (c) this.jlp.get(str);
        }
        return null;
    }
}
