package com.tencent.mm.modelstat;

public final class f {
    private static f hTg = null;
    public com.tencent.mm.a.f<String, Long> hTh = new com.tencent.mm.a.f(10);
    public String hTi;

    public static f Tb() {
        if (hTg == null) {
            hTg = new f();
        }
        return hTg;
    }

    private f() {
    }

    public final void q(String str, long j) {
        if (this.hTh != null) {
            this.hTi = str;
            this.hTh.put(str, Long.valueOf(j));
        }
    }
}
