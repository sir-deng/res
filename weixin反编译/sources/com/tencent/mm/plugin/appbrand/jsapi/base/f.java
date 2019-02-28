package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.mm.plugin.appbrand.jsapi.c;

public final class f {
    int jgb;
    c jkC;

    f(c cVar, int i) {
        this.jkC = cVar;
        this.jgb = i;
    }

    public final void sE(String str) {
        this.jkC.E(this.jgb, str);
    }
}
