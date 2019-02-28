package com.tencent.mm.plugin.messenger.foundation.a;

import android.util.SparseArray;
import com.tencent.mm.cc.c;

public final class s {
    private static SparseArray<a> our = new SparseArray();
    private static c<r> ous;

    private static class a<T extends com.tencent.mm.bp.a> extends com.tencent.mm.cc.a<q<T>> implements q<T> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void f(final T t) {
            a(new com.tencent.mm.cc.a.a<q<T>>() {
                public final /* synthetic */ void az(Object obj) {
                    ((q) obj).f(t);
                }
            });
        }

        public final void e(final T t) {
            a(new com.tencent.mm.cc.a.a<q<T>>() {
                public final /* synthetic */ void az(Object obj) {
                    ((q) obj).e(t);
                }
            });
        }
    }

    public static synchronized <T extends com.tencent.mm.bp.a> void a(int i, q<T> qVar) {
        synchronized (s.class) {
            a aVar = (a) our.get(i);
            if (aVar == null) {
                aVar = new a();
                our.put(i, aVar);
            }
            aVar.aE(qVar);
        }
    }

    public static synchronized void a(q qVar) {
        synchronized (s.class) {
            a aVar = (a) our.get(5);
            if (aVar != null) {
                aVar.remove(qVar);
                if (aVar.size() == 0) {
                    our.remove(5);
                }
            }
        }
    }

    public static synchronized <T extends com.tencent.mm.bp.a> void h(T t) {
        synchronized (s.class) {
            a aVar = (a) our.get(5);
            if (aVar != null) {
                aVar.f(t);
            }
        }
    }

    public static synchronized <T extends com.tencent.mm.bp.a> void b(int i, T t) {
        synchronized (s.class) {
            a aVar = (a) our.get(i);
            if (aVar != null) {
                aVar.e(t);
            }
        }
    }

    public static final c<r> aZP() {
        return ous;
    }

    public static final void b(c<r> cVar) {
        ous = cVar;
    }
}
