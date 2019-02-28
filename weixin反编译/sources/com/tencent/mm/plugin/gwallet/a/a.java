package com.tencent.mm.plugin.gwallet.a;

public final class a extends Exception {
    c nFv;

    private a(c cVar) {
        this(cVar, null);
    }

    public a(int i, String str) {
        this(new c(i, str));
    }

    private a(c cVar, Exception exception) {
        super(cVar.mMessage, exception);
        this.nFv = cVar;
    }

    public a(String str, Exception exception) {
        this(new c(-1001, str), exception);
    }
}
