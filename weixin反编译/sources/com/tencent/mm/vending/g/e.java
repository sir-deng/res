package com.tencent.mm.vending.g;

import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import com.tencent.mm.vending.h.h;
import com.tencent.mm.vending.j.k;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import junit.framework.Assert;

public class e<_Var> implements c<_Var> {
    private int mRetryCount = 0;
    f zKU = new f(this.zLm, this.zLw);
    boolean zLA = false;
    private boolean zLB = false;
    private Object zLC;
    Object zLD;
    private volatile boolean zLh = false;
    volatile d zLi = d.Idle;
    boolean zLj = false;
    private Queue<a> zLk = new LinkedList();
    private volatile com.tencent.mm.vending.h.d zLl = this.zLm;
    private volatile com.tencent.mm.vending.h.d zLm = g.cAP();
    volatile Object zLn;
    volatile boolean zLo;
    volatile Object zLp;
    a zLq;
    a zLr;
    private long zLs = -1;
    private boolean zLt = false;
    private b zLu = new b();
    private com.tencent.mm.vending.h.d zLv;
    private com.tencent.mm.vending.h.f.a zLw = new com.tencent.mm.vending.h.f.a() {
        public final void cAL() {
            f cAM = f.cAM();
            e eVar = e.this;
            Stack stack = (Stack) cAM.zLV.get();
            if (stack == null) {
                stack = new Stack();
                cAM.zLV.set(stack);
            }
            stack.push(eVar);
        }

        public final void cp(Object obj) {
            ((Stack) f.cAM().zLV.get()).pop();
            synchronized (e.this) {
                e.this.zLq = e.this.zLr;
                e.this.zLr = null;
                if (e.this.zLj) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "gonna retry, do not store functional result.", new Object[0]);
                } else {
                    e.this.zLn = obj;
                }
                if (e.this.zLi == d.Interrupted) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "interrupted, just return", new Object[0]);
                } else if (e.this.zLi == d.Pausing) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pausing, just return.", new Object[0]);
                } else {
                    e.this.zLi = d.Resolved;
                    e.this.co(e.this.cn(obj));
                }
            }
        }

        public final void interrupt() {
            e.this.nO(true);
        }
    };
    List<Pair<com.tencent.mm.vending.g.d.a, com.tencent.mm.vending.h.d>> zLx;
    private List<Pair<com.tencent.mm.vending.g.d.b, com.tencent.mm.vending.h.d>> zLy;
    private boolean zLz = false;

    private static class a {
        public com.tencent.mm.vending.h.d ffx;
        public com.tencent.mm.vending.c.a gTQ;
        public long mInterval;
        public boolean zLM;

        public a(com.tencent.mm.vending.c.a aVar, com.tencent.mm.vending.h.d dVar, long j, boolean z) {
            this.gTQ = aVar;
            this.ffx = dVar;
            this.mInterval = j;
            this.zLM = z;
        }
    }

    public static class c extends Error {
        public c(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    private enum d {
        Idle,
        Resolved,
        Invoking,
        Pausing,
        Interrupted,
        AllDone
    }

    class b implements b {
        b() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void cm(java.lang.Object r7) {
            /*
            r6 = this;
            r1 = com.tencent.mm.vending.g.e.this;
            monitor-enter(r1);
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r0 = r0.zLi;	 Catch:{ all -> 0x0037 }
            r2 = com.tencent.mm.vending.g.e.d.Interrupted;	 Catch:{ all -> 0x0037 }
            if (r0 != r2) goto L_0x0019;
        L_0x000b:
            r0 = "Vending.Pipeline";
            r2 = "interrupted, skip this interrupt.";
            r3 = 0;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0037 }
            com.tencent.mm.vending.f.a.i(r0, r2, r3);	 Catch:{ all -> 0x0037 }
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
        L_0x0018:
            return;
        L_0x0019:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r0 = com.tencent.mm.vending.g.e.a(r0);	 Catch:{ all -> 0x0037 }
            if (r0 != 0) goto L_0x003a;
        L_0x0021:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r0 = r0.zLi;	 Catch:{ all -> 0x0037 }
            r2 = com.tencent.mm.vending.g.e.d.Pausing;	 Catch:{ all -> 0x0037 }
            if (r0 == r2) goto L_0x003a;
        L_0x0029:
            r0 = "Vending.Pipeline";
            r2 = "interrupt not in func scope or pending, skip this retryOrInterrupt.";
            r3 = 0;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0037 }
            com.tencent.mm.vending.f.a.i(r0, r2, r3);	 Catch:{ all -> 0x0037 }
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
            goto L_0x0018;
        L_0x0037:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
            throw r0;
        L_0x003a:
            r0 = "Vending.Pipeline";
            r2 = "interrupt Pipeline(%s)";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0037 }
            r4 = 0;
            r5 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r3[r4] = r5;	 Catch:{ all -> 0x0037 }
            com.tencent.mm.vending.f.a.i(r0, r2, r3);	 Catch:{ all -> 0x0037 }
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r2 = 0;
            r0.nO(r2);	 Catch:{ all -> 0x0037 }
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r2 = 1;
            r0.zLA = r2;	 Catch:{ all -> 0x0037 }
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r0.zLD = r7;	 Catch:{ all -> 0x0037 }
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r0 = r0.zLx;	 Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x007a;
        L_0x0060:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r0 = r0.zLx;	 Catch:{ all -> 0x0037 }
            r2 = r0.iterator();	 Catch:{ all -> 0x0037 }
        L_0x0068:
            r0 = r2.hasNext();	 Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x007a;
        L_0x006e:
            r0 = r2.next();	 Catch:{ all -> 0x0037 }
            r0 = (android.util.Pair) r0;	 Catch:{ all -> 0x0037 }
            r3 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0037 }
            r3.a(r0, r7);	 Catch:{ all -> 0x0037 }
            goto L_0x0068;
        L_0x007a:
            monitor-exit(r1);	 Catch:{ all -> 0x0037 }
            goto L_0x0018;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vending.g.e.b.cm(java.lang.Object):void");
        }

        public final void cAH() {
            synchronized (e.this) {
                synchronized (e.this) {
                    if (e.this.zLi == d.Interrupted || e.this.zLi == d.Idle) {
                        com.tencent.mm.vending.f.a.w("Vending.Pipeline", "current is state(%s), ignore pause.", e.this.zLi);
                    } else if (!e.a(e.this)) {
                        com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of a functional scope on %s!", e.this);
                    } else if (e.b(e.this)) {
                        e.this.zLi = d.Pausing;
                    } else {
                        com.tencent.mm.vending.f.a.e("Vending.Pipeline", "you are using mario().pause() out of calling thread on %s!", e.this);
                    }
                }
            }
        }

        public final void t(Object... objArr) {
            synchronized (e.this) {
                if (e.this.zLi != d.Pausing) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "state is not pausing %s, skip this wormhole", e.this.zLi);
                    return;
                }
                e eVar = e.this;
                Object v = objArr.length == 0 ? null : objArr.length == 1 ? objArr[0] : k.v(objArr);
                eVar.zLp = v;
                e.this.zLo = true;
                com.tencent.mm.vending.f.a.i("Vending.Pipeline", "pipline(%s) wormhole().", e.this);
                resume();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void resume() {
            /*
            r6 = this;
            r1 = com.tencent.mm.vending.g.e.this;
            monitor-enter(r1);
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r0 = r0.zLi;	 Catch:{ all -> 0x0045 }
            r2 = com.tencent.mm.vending.g.e.d.Pausing;	 Catch:{ all -> 0x0045 }
            if (r0 == r2) goto L_0x001e;
        L_0x000b:
            r0 = "Vending.Pipeline";
            r2 = "this Pipeline(%s) is not pausing! why call resume?";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0045 }
            r4 = 0;
            r5 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r3[r4] = r5;	 Catch:{ all -> 0x0045 }
            com.tencent.mm.vending.f.a.e(r0, r2, r3);	 Catch:{ all -> 0x0045 }
            monitor-exit(r1);	 Catch:{ all -> 0x0045 }
        L_0x001d:
            return;
        L_0x001e:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r0 = com.tencent.mm.vending.g.e.a(r0);	 Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0048;
        L_0x0026:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r2 = com.tencent.mm.vending.g.e.d.Resolved;	 Catch:{ all -> 0x0045 }
            r0.zLi = r2;	 Catch:{ all -> 0x0045 }
        L_0x002c:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r0 = com.tencent.mm.vending.g.e.b(r0);	 Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0043;
        L_0x0034:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r2 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r3 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r3 = r3.zLn;	 Catch:{ all -> 0x0045 }
            r2 = r2.cn(r3);	 Catch:{ all -> 0x0045 }
            r0.co(r2);	 Catch:{ all -> 0x0045 }
        L_0x0043:
            monitor-exit(r1);	 Catch:{ all -> 0x0045 }
            goto L_0x001d;
        L_0x0045:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0045 }
            throw r0;
        L_0x0048:
            r0 = com.tencent.mm.vending.g.e.this;	 Catch:{ all -> 0x0045 }
            r2 = com.tencent.mm.vending.g.e.d.Invoking;	 Catch:{ all -> 0x0045 }
            r0.zLi = r2;	 Catch:{ all -> 0x0045 }
            goto L_0x002c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vending.g.e.b.resume():void");
        }
    }

    static /* synthetic */ boolean a(e eVar) {
        return eVar.zLr != null;
    }

    static /* synthetic */ boolean b(e eVar) {
        return eVar.zLu == g.cAI();
    }

    public c<_Var> aaX(String str) {
        if (str == null) {
            Assert.assertNotNull("schedulerTypeString should not be null!", str);
        } else {
            this.zLl = g.aaZ(str);
            Assert.assertNotNull("mCurrentScheduler should not be null!", this.zLl);
        }
        return this;
    }

    public c<_Var> a(com.tencent.mm.vending.h.d dVar) {
        if (dVar == null) {
            Assert.assertNotNull("scheduler should not be null!", dVar);
        } else {
            this.zLl = dVar;
        }
        return this;
    }

    public c<_Var> b(com.tencent.mm.vending.e.b bVar) {
        Assert.assertNotNull("keeper should not be null!", bVar);
        bVar.keep(this);
        return this;
    }

    public synchronized c<_Var> gt(long j) {
        this.zLs = j;
        return this;
    }

    public c<_Var> nN(boolean z) {
        this.zLt = z;
        return this;
    }

    public synchronized c<_Var> a(final com.tencent.mm.vending.g.c.a<_Var> aVar) {
        u(new Object[0]);
        a(new com.tencent.mm.vending.c.a<_Var, _Var>() {
            public final _Var call(_Var _var) {
                return aVar.call();
            }
        }, true);
        return this;
    }

    public synchronized c<_Var> u(Object... objArr) {
        c<_Var> cVar;
        if (this.zLi != d.Idle) {
            cVar = this;
        } else {
            this.zLi = d.Resolved;
            Object v = objArr.length == 0 ? null : objArr.length == 1 ? objArr[0] : k.v(objArr);
            this.zLn = v;
            co(this.zLn);
            v = this;
        }
        return cVar;
    }

    public void dead() {
        nO(true);
    }

    public final b cAI() {
        return this.zLu;
    }

    public <_Ret> c<_Ret> e(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return aaX("Vending.UI").b(aVar);
    }

    public <_Ret> c<_Ret> c(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return aaX("Vending.LOGIC").b(aVar);
    }

    public <_Ret> c<_Ret> d(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return aaX("Vending.HEAVY_WORK").b(aVar);
    }

    private synchronized <_Ret> c<_Ret> a(com.tencent.mm.vending.c.a<_Ret, _Var> aVar, boolean z) {
        c<_Ret> cVar;
        cAJ();
        this.zLk.add(new a(aVar, this.zLl, this.zLs, z));
        this.zLs = -1;
        Object cVar2;
        if (this.zLi == d.Idle) {
            cVar2 = this;
        } else if (this.zLi != d.Resolved) {
            cVar2 = this;
        } else {
            co(this.zLn);
            cVar2 = this;
        }
        return cVar2;
    }

    public synchronized <_Ret> c<_Ret> b(com.tencent.mm.vending.c.a<_Ret, _Var> aVar) {
        return a((com.tencent.mm.vending.c.a) aVar, this.zLt);
    }

    private synchronized void cAJ() {
        if (this.zLh) {
            throw new c("This Pipeline(%s) has terminate and do not allow any next().", this);
        }
    }

    final synchronized void a(final Pair<com.tencent.mm.vending.g.d.a, com.tencent.mm.vending.h.d> pair, final Object obj) {
        com.tencent.mm.vending.h.d dVar = (com.tencent.mm.vending.h.d) pair.second;
        Runnable anonymousClass3 = new Runnable() {
            public final void run() {
                ((com.tencent.mm.vending.g.d.a) pair.first).aW(obj);
            }
        };
        if (dVar == null) {
            com.tencent.mm.vending.f.a.e("Vending.Pipeline", "Default scheduler %s is not available!!!", this.zLm);
        }
        dVar.f(anonymousClass3);
    }

    private synchronized void b(final Pair<com.tencent.mm.vending.g.d.b, com.tencent.mm.vending.h.d> pair, final Object obj) {
        final RuntimeException runtimeException = new RuntimeException("object is not right: " + obj);
        new f((com.tencent.mm.vending.h.d) pair.second, null).a(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                return aaF();
            }

            private Void aaF() {
                try {
                    ((com.tencent.mm.vending.g.d.b) pair.first).aB(obj);
                    return zLb;
                } catch (Throwable e) {
                    if (runtimeException.getCause() == null) {
                        runtimeException.initCause(e);
                    }
                    throw runtimeException;
                }
            }
        }, null, this.zLt);
    }

    private synchronized void a(com.tencent.mm.vending.g.d.a aVar, com.tencent.mm.vending.h.d dVar) {
        cAK();
        if (this.zLx == null) {
            this.zLx = new LinkedList();
        }
        Pair pair = new Pair(aVar, dVar);
        if (this.zLA) {
            a(pair, this.zLD);
        } else {
            this.zLx.add(pair);
        }
    }

    private synchronized void a(com.tencent.mm.vending.g.d.b bVar, com.tencent.mm.vending.h.d dVar) {
        cAK();
        co(this.zLn);
        if (this.zLy == null) {
            this.zLy = new LinkedList();
        }
        Pair pair = new Pair(bVar, dVar);
        if (this.zLz) {
            b(pair, this.zLC);
        } else {
            this.zLy.add(pair);
        }
    }

    public final synchronized d<_Var> cAK() {
        this.zLh = true;
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.g.d.a aVar) {
        a(aVar, this.zLm);
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.g.d.b<_Var> bVar) {
        a((com.tencent.mm.vending.g.d.b) bVar, this.zLm);
        return this;
    }

    public final synchronized d<_Var> a(com.tencent.mm.vending.h.d dVar, com.tencent.mm.vending.g.d.b<_Var> bVar) {
        a((com.tencent.mm.vending.g.d.b) bVar, dVar);
        return this;
    }

    final synchronized void nO(boolean z) {
        if (!(this.zLi == d.Interrupted || this.zLi == d.AllDone)) {
            if (z) {
                if (this.zLk.size() > 0) {
                    com.tencent.mm.vending.f.a.w("Vending.Pipeline", "Pipe is not finish and be interrupt! %s pipes did not run", Integer.valueOf(this.zLk.size()));
                }
            }
            this.zLi = d.Interrupted;
            this.zLk.clear();
            this.zLn = null;
            if (this.zLv != null) {
                this.zLv.cancel();
            }
        }
    }

    final synchronized Object cn(Object obj) {
        if (this.zLj) {
            this.mRetryCount++;
            com.tencent.mm.vending.f.a.i("Vending.Pipeline", "Functional %s, gonna retry %s.", this.zLq.gTQ.toString(), Integer.valueOf(this.mRetryCount));
            ((LinkedList) this.zLk).add(0, this.zLq);
            this.zLj = false;
        } else {
            if (this.zLo) {
                this.zLn = this.zLp;
                this.zLp = null;
                this.zLo = false;
            } else {
                this.zLn = obj;
            }
            this.mRetryCount = 0;
        }
        return this.zLn;
    }

    final synchronized void co(final Object obj) {
        if (this.zLi == d.Resolved) {
            this.zLi = d.Invoking;
            a aVar = (a) this.zLk.peek();
            if (aVar != null) {
                final com.tencent.mm.vending.c.a aVar2 = aVar.gTQ;
                com.tencent.mm.vending.h.d dVar = aVar.ffx;
                long j = aVar.mInterval;
                final boolean z = aVar.zLM;
                if (this.zLi == d.Pausing) {
                    com.tencent.mm.vending.f.a.i("Vending.Pipeline", "This pipeline is Pausing. We will stop dequeFunctionAndInvoke and waiting resume() call", new Object[0]);
                } else {
                    this.zLr = (a) this.zLk.poll();
                    this.zKU.b(dVar);
                    if (j < 0) {
                        this.zKU.a(aVar2, obj, z);
                    } else {
                        if (Looper.myLooper() == null) {
                            this.zLv = new com.tencent.mm.vending.h.c();
                        } else {
                            this.zLv = new h(Looper.myLooper(), Looper.myLooper().toString());
                        }
                        this.zLv.f(new Runnable() {
                            public final void run() {
                                e.this.zKU.a(aVar2, obj, z);
                            }
                        }, j);
                    }
                }
            } else if (this.zLh) {
                this.zLi = d.AllDone;
                this.zLz = true;
                this.zLC = obj;
                if (this.zLy != null) {
                    for (Pair b : this.zLy) {
                        b(b, this.zLC);
                    }
                }
            } else {
                this.zLi = d.Resolved;
            }
        }
    }
}
