package com.tencent.e;

public final class a implements com.tencent.e.b.a {
    private g AvH;
    private boolean AvI = true;

    protected a(g gVar) {
        this.AvH = gVar;
    }

    public final void w(String str, Object obj) {
        if (this.AvI) {
            f cIl = f.cIl();
            if (obj == null) {
                throw new h("TpfServiceCenter|registerService|name or service should not be null");
            }
            synchronized (cIl.AvO) {
                cIl.AvM.put(str, obj);
            }
        }
    }
}
