package c.t.m.g;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public final class x {
    public ThreadPoolExecutor a;

    public static class a {
        private static final x a = new x();
    }

    private x() {
        this.a = (ThreadPoolExecutor) Executors.newCachedThreadPool(new o("HalleyBusiTaskPoolHolder"));
    }

    /* synthetic */ x(byte b) {
        this();
    }
}
