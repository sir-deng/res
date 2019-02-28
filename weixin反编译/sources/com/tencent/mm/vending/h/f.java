package com.tencent.mm.vending.h;

public final class f {
    private volatile d zLl;
    volatile a zLw;

    public interface a {
        void cAL();

        void cp(Object obj);

        void interrupt();
    }

    public f(d dVar, a aVar) {
        b(dVar);
        this.zLw = aVar;
    }

    public final synchronized void b(d dVar) {
        c(dVar);
    }

    private synchronized void c(d dVar) {
        this.zLl = dVar;
    }

    private synchronized void a(final com.tencent.mm.vending.c.a aVar, final Object obj, long j, boolean z) {
        d aaZ;
        final RuntimeException runtimeException;
        Runnable anonymousClass1;
        d dVar = this.zLl;
        if (aVar instanceof e) {
            e eVar = (e) aVar;
            if (!"Vending.ANY".equals(eVar.wE())) {
                aaZ = g.aaZ(eVar.wE());
                if (aaZ == null) {
                    runtimeException = new RuntimeException("object is not right: " + obj);
                    anonymousClass1 = new Runnable() {
                        public final void run() {
                            if (f.this.zLw != null) {
                                f.this.zLw.cAL();
                            }
                            try {
                                Object call = aVar.call(obj);
                                if (f.this.zLw != null) {
                                    f.this.zLw.cp(call);
                                }
                            } catch (Throwable e) {
                                runtimeException.initCause(e);
                                throw runtimeException;
                            }
                        }
                    };
                    if (-1 < 0) {
                        aaZ.f(anonymousClass1, -1);
                    } else if (z || g.cAP() != aaZ) {
                        aaZ.f(anonymousClass1);
                    } else {
                        anonymousClass1.run();
                    }
                } else if (this.zLw != null) {
                    this.zLw.interrupt();
                }
            }
        }
        aaZ = dVar;
        if (aaZ == null) {
            runtimeException = new RuntimeException("object is not right: " + obj);
            anonymousClass1 = /* anonymous class already generated */;
            if (-1 < 0) {
                aaZ.f(anonymousClass1, -1);
            } else {
                if (z) {
                }
                aaZ.f(anonymousClass1);
            }
        } else if (this.zLw != null) {
            this.zLw.interrupt();
        }
    }

    public final void a(com.tencent.mm.vending.c.a aVar, Object obj, boolean z) {
        a(aVar, obj, -1, z);
    }
}
