package com.tencent.mm.cc;

import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.h.d;
import java.util.Iterator;

public class a<_Callback> extends com.tencent.mm.vending.b.a<_Callback> {

    public interface a<_Callback> {
        void az(_Callback _callback);
    }

    public a() {
        super(new e());
    }

    public a(d dVar) {
        super(dVar);
    }

    public final void a(final a<_Callback> aVar) {
        Iterator it = cAE().iterator();
        while (it.hasNext()) {
            final b bVar = (b) it.next();
            if (bVar != null) {
                if (bVar.ffx != null) {
                    this.zKU.b(bVar.ffx);
                    this.zKU.a(new com.tencent.mm.vending.c.a<Void, Void>() {
                        public final /* synthetic */ Object call(Object obj) {
                            Void voidR = (Void) obj;
                            aVar.az(bVar.zKW);
                            return voidR;
                        }
                    }, com.tencent.mm.vending.c.a.zLb, true);
                } else {
                    aVar.az(bVar.zKW);
                }
            }
        }
    }

    public b<_Callback> aE(_Callback _callback) {
        return super.a(new b(_callback, this));
    }

    public final void remove(_Callback _callback) {
        super.b(new b(_callback, this));
    }
}
