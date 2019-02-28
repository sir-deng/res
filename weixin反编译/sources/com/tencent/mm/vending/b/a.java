package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import java.util.LinkedList;
import junit.framework.Assert;

public abstract class a<_Callback> {
    protected d ffx;
    private LinkedList<b> zKT;
    public f zKU;

    public a() {
        this(g.cAP());
    }

    public a(d dVar) {
        this.zKT = new LinkedList();
        Assert.assertNotNull(dVar);
        this.ffx = dVar;
        this.zKU = new f(dVar, null);
    }

    public final synchronized b a(b bVar) {
        this.zKT.add(bVar);
        return bVar;
    }

    public final synchronized void b(b bVar) {
        if (bVar != null) {
            this.zKT.remove(bVar);
        }
    }

    public final synchronized LinkedList<b> cAE() {
        return new LinkedList(this.zKT);
    }

    public final synchronized int size() {
        return this.zKT.size();
    }

    public final synchronized boolean contains(_Callback _callback) {
        return this.zKT.contains(new b(_callback, this));
    }
}
