package com.tencent.mm.plugin.topstory.a.a;

public final class c {
    public boolean hMK;
    public long hMn = System.currentTimeMillis();
    public d skA;
    public boolean skB;

    public c(d dVar) {
        this.skA = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        c cVar = (c) obj;
        if (this.skA.skE.equals(cVar.skA.skE) && this.skA.skQ.equals(cVar.skA.skQ)) {
            return true;
        }
        return false;
    }
}
