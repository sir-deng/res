package com.tencent.mm.plugin.appbrand.r.a;

import android.content.Context;

public enum a implements e {
    ;
    
    public static final c jYh = null;
    private final e jYi;

    private a(String str) {
        this.jYi = new b();
    }

    static {
        jYh = new c();
    }

    public final void init(Context context) {
        this.jYi.init(context);
    }

    public final void release() {
        this.jYi.release();
    }

    public final c amt() {
        return this.jYi.amt();
    }
}
