package com.tencent.mm.plugin.appbrand.r;

public final class f {
    private long jXH;
    private long jXI;
    private a jXJ;

    public interface a {
        boolean g(Object... objArr);
    }

    public f(long j, a aVar) {
        this.jXH = j;
        this.jXJ = aVar;
    }

    public final boolean i(Object... objArr) {
        boolean z = false;
        if (!((System.currentTimeMillis() - this.jXI < this.jXH) || this.jXJ == null)) {
            z = this.jXJ.g(objArr);
            if (z) {
                this.jXI = System.currentTimeMillis();
            }
        }
        return z;
    }
}
