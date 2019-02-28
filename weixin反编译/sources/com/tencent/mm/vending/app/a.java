package com.tencent.mm.vending.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.base.Vending.h;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public abstract class a implements com.tencent.mm.vending.e.b {
    Context mContext;
    private c zKa = new c();
    public c<Vending> zKb = new c();
    Map<Class, a> zKc = new ConcurrentHashMap();
    byte[] zKd = new byte[0];
    com.tencent.mm.vending.base.a<Object> zKe = new com.tencent.mm.vending.base.a<Object>() {
        protected final /* synthetic */ Object resolveAsynchronous(Object obj) {
            return L((Class) obj);
        }

        protected final Object L(Class<?> cls) {
            a aVar = (a) a.this.zKc.get(cls);
            if (aVar != null) {
                aVar.zKl = true;
                Object WW = aVar.WW();
                aVar.zKl = false;
                if (!aVar.zKk) {
                    return WW;
                }
                aVar.zKm = defer(cls);
            }
            return null;
        }
    };
    private AtomicBoolean zKf = new AtomicBoolean(false);
    boolean zKg = false;
    Map<Class, com.tencent.mm.vending.b.c<b>> zKh = new HashMap();
    public com.tencent.mm.vending.d.a zKi;

    public abstract class a<_Struct> {
        boolean zKk = false;
        boolean zKl = false;
        h zKm;

        public abstract _Struct WW();
    }

    public interface b<_Struct> {
        void aX(_Struct _struct);
    }

    public a() {
        this.zKb.keep(this.zKe);
        this.zKe.addVendingDataResolvedCallback(new com.tencent.mm.vending.base.a.a() {
            public final /* synthetic */ void ck(Object obj) {
                Class cls = (Class) obj;
                com.tencent.mm.vending.b.c cVar = (com.tencent.mm.vending.b.c) a.this.zKh.get(cls);
                if (cVar != null) {
                    cVar.a(g.cr(a.this.zKe.get(cls)));
                }
            }
        });
    }

    public void keep(com.tencent.mm.vending.e.a aVar) {
        Assert.assertTrue("target must be a ILifeCycle", aVar instanceof com.tencent.mm.vending.e.a);
        this.zKa.keep(aVar);
    }

    public final <_Struct> void a(Class<_Struct> cls, b<_Struct> bVar) {
        com.tencent.mm.vending.b.c cVar = (com.tencent.mm.vending.b.c) this.zKh.get(cls);
        if (cVar == null) {
            cVar = new com.tencent.mm.vending.b.c<b>(d.zLX) {
                public final /* synthetic */ void a(Object obj, com.tencent.mm.vending.j.a aVar) {
                    ((b) obj).aX(aVar.get(0));
                }
            };
            this.zKh.put(cls, cVar);
        }
        cVar.aE(bVar);
        Object peek = this.zKe.peek(cls);
        if (peek != null) {
            bVar.aX(peek);
        }
    }

    public final <_Struct> _Struct J(Class<_Struct> cls) {
        cAx();
        if (Looper.myLooper() == Looper.getMainLooper() && !this.zKg) {
            synchronized (this.zKd) {
                if (!this.zKg) {
                    try {
                        this.zKd.wait();
                    } catch (Throwable e) {
                        com.tencent.mm.vending.f.a.printErrStackTrace("Vending.Interactor", e, "", new Object[0]);
                    }
                }
            }
        }
        return this.zKe.get(cls);
    }

    public final void K(Class<?> cls) {
        cAx();
        this.zKe.request(cls);
    }

    public final <_Struct> void a(Class<_Struct> cls, a<_Struct> aVar) {
        cAx();
        this.zKc.put(cls, aVar);
    }

    private void cAx() {
        if (Looper.myLooper() == this.zKe.getLooper() && !this.zKf.get()) {
            com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", this);
        }
    }

    public void onCreate() {
        this.zKf.set(true);
    }

    public void onDestroy() {
        this.zKa.dead();
        this.zKb.dead();
    }
}
