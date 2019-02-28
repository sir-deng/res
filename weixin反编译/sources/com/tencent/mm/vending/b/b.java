package com.tencent.mm.vending.b;

import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class b<_Callback> implements a {
    public d ffx;
    private int mPriority = -1;
    private a zKV;
    public _Callback zKW;
    private int zKX;

    public final b<_Callback> a(com.tencent.mm.vending.e.b bVar) {
        Assert.assertNotNull(bVar);
        bVar.keep(this);
        return this;
    }

    public b(_Callback _callback, a aVar) {
        Assert.assertNotNull("Callback should not be null!", _callback);
        this.zKX = _callback.hashCode();
        this.zKW = _callback;
        this.zKV = aVar;
    }

    public final int hashCode() {
        return this.zKX;
    }

    public final boolean equals(Object obj) {
        return obj != null && obj.hashCode() == this.zKX;
    }

    public final void dead() {
        Assert.assertNotNull(this.zKV);
        this.zKV.b(this);
    }
}
