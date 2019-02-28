package com.tencent.mm.sdk.e;

import android.os.Looper;

public abstract class m implements g {
    private final k<b, a> xrX = new k<b, a>() {
        protected final /* synthetic */ void p(Object obj, Object obj2) {
            b bVar = (b) obj;
            a aVar = (a) obj2;
            if (m.this.NK()) {
                bVar.a(aVar.fwU, aVar.xsi, aVar.obj);
            }
        }
    };

    private class a {
        int fwU;
        Object obj;
        m xsi;

        a(int i, m mVar, Object obj) {
            this.fwU = i;
            this.obj = obj;
            this.xsi = mVar;
        }
    }

    public interface b {
        void a(int i, m mVar, Object obj);
    }

    public abstract boolean NK();

    public final void a(b bVar) {
        if (bVar != null) {
            this.xrX.a(bVar, Looper.getMainLooper());
        }
    }

    public final void b(b bVar) {
        if (bVar != null) {
            this.xrX.remove(bVar);
        }
    }

    public final void b(int i, m mVar, Object obj) {
        this.xrX.cb(new a(i, mVar, obj));
        this.xrX.doNotify();
    }
}
