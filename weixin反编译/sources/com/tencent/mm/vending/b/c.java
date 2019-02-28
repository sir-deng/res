package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.j.a;
import java.util.Iterator;

public abstract class c<_Callback> extends a<_Callback> {
    public abstract void a(_Callback _callback, a aVar);

    public c(d dVar) {
        super(dVar);
    }

    public final synchronized void cAF() {
        a(null);
    }

    public final synchronized void a(final a aVar) {
        Iterator it = cAE().iterator();
        while (it.hasNext()) {
            final b bVar = (b) it.next();
            if (bVar != null) {
                if (bVar.ffx != null) {
                    this.zKU.b(bVar.ffx);
                } else {
                    this.zKU.b(d.cAP());
                }
                this.zKU.a(new com.tencent.mm.vending.c.a<Void, Void>() {
                    public final /* synthetic */ Object call(Object obj) {
                        Void voidR = (Void) obj;
                        c.this.a(bVar.zKW, aVar);
                        return voidR;
                    }
                }, com.tencent.mm.vending.c.a.zLb, true);
            }
        }
    }

    public final b<_Callback> aE(_Callback _callback) {
        return a(new b(_callback, this));
    }
}
