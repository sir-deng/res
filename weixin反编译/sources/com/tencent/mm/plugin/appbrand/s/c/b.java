package com.tencent.mm.plugin.appbrand.s.c;

public class b extends Exception {
    public int jZE;

    public b() {
        this.jZE = 1002;
    }

    public b(String str) {
        super(str);
        this.jZE = 1002;
    }

    public b(int i, Throwable th) {
        super(th);
        this.jZE = i;
    }
}
