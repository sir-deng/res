package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    private int aib;
    private final Thread aii;
    private final LinkedList<I> aij = new LinkedList();
    private final LinkedList<O> aik = new LinkedList();
    public final I[] ail;
    private final O[] aim;
    public int ain;
    private int aio;
    private I aip;
    private boolean aiq;
    private E exception;
    private final Object lock = new Object();
    private boolean released;

    public abstract E a(I i, O o, boolean z);

    public abstract I jm();

    public abstract O jn();

    public final /* synthetic */ void V(Object obj) {
        e eVar = (e) obj;
        synchronized (this.lock) {
            ji();
            a.ao(eVar == this.aip);
            this.aij.addLast(eVar);
            jj();
            this.aip = null;
        }
    }

    public final /* synthetic */ Object jb() {
        return jg();
    }

    public final /* synthetic */ Object jc() {
        return jh();
    }

    public g(I[] iArr, O[] oArr) {
        int i = 0;
        this.ail = iArr;
        this.ain = 2;
        for (int i2 = 0; i2 < this.ain; i2++) {
            this.ail[i2] = jm();
        }
        this.aim = oArr;
        this.aio = 2;
        while (i < this.aio) {
            this.aim[i] = jn();
            i++;
        }
        this.aii = new Thread() {
            public final void run() {
                do {
                    try {
                    } catch (Throwable e) {
                        throw new IllegalStateException(e);
                    }
                } while (g.this.jk());
            }
        };
        this.aii.start();
    }

    private I jg() {
        I i;
        synchronized (this.lock) {
            e eVar;
            ji();
            a.ap(this.aip == null);
            if (this.ain == 0) {
                eVar = null;
            } else {
                e[] eVarArr = this.ail;
                int i2 = this.ain - 1;
                this.ain = i2;
                eVar = eVarArr[i2];
            }
            this.aip = eVar;
            i = this.aip;
        }
        return i;
    }

    private O jh() {
        O o;
        synchronized (this.lock) {
            ji();
            if (this.aik.isEmpty()) {
                o = null;
            } else {
                f o2 = (f) this.aik.removeFirst();
            }
        }
        return o2;
    }

    public void a(O o) {
        synchronized (this.lock) {
            b(o);
            jj();
        }
    }

    public final void flush() {
        synchronized (this.lock) {
            this.aiq = true;
            this.aib = 0;
            if (this.aip != null) {
                a(this.aip);
                this.aip = null;
            }
            while (!this.aij.isEmpty()) {
                a((e) this.aij.removeFirst());
            }
            while (!this.aik.isEmpty()) {
                b((f) this.aik.removeFirst());
            }
        }
    }

    public final void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.aii.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void ji() {
        if (this.exception != null) {
            throw this.exception;
        }
    }

    private void jj() {
        if (jl()) {
            this.lock.notify();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean jk() {
        /*
        r6 = this;
        r1 = 0;
        r2 = r6.lock;
        monitor-enter(r2);
    L_0x0004:
        r0 = r6.released;	 Catch:{ all -> 0x0014 }
        if (r0 != 0) goto L_0x0017;
    L_0x0008:
        r0 = r6.jl();	 Catch:{ all -> 0x0014 }
        if (r0 != 0) goto L_0x0017;
    L_0x000e:
        r0 = r6.lock;	 Catch:{ all -> 0x0014 }
        r0.wait();	 Catch:{ all -> 0x0014 }
        goto L_0x0004;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        r0 = r6.released;	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x001e;
    L_0x001b:
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        r0 = r1;
    L_0x001d:
        return r0;
    L_0x001e:
        r0 = r6.aij;	 Catch:{ all -> 0x0014 }
        r0 = r0.removeFirst();	 Catch:{ all -> 0x0014 }
        r0 = (com.google.android.exoplayer2.b.e) r0;	 Catch:{ all -> 0x0014 }
        r3 = r6.aim;	 Catch:{ all -> 0x0014 }
        r4 = r6.aio;	 Catch:{ all -> 0x0014 }
        r4 = r4 + -1;
        r6.aio = r4;	 Catch:{ all -> 0x0014 }
        r3 = r3[r4];	 Catch:{ all -> 0x0014 }
        r4 = r6.aiq;	 Catch:{ all -> 0x0014 }
        r5 = 0;
        r6.aiq = r5;	 Catch:{ all -> 0x0014 }
        monitor-exit(r2);	 Catch:{ all -> 0x0014 }
        r2 = r0.iZ();
        if (r2 == 0) goto L_0x0050;
    L_0x003c:
        r1 = 4;
        r3.ca(r1);
    L_0x0040:
        r1 = r6.lock;
        monitor-enter(r1);
        r2 = r6.aiq;	 Catch:{ all -> 0x007e }
        if (r2 == 0) goto L_0x006e;
    L_0x0047:
        r6.b(r3);	 Catch:{ all -> 0x007e }
    L_0x004a:
        r6.a(r0);	 Catch:{ all -> 0x007e }
        monitor-exit(r1);	 Catch:{ all -> 0x007e }
        r0 = 1;
        goto L_0x001d;
    L_0x0050:
        r2 = r0.iY();
        if (r2 == 0) goto L_0x005b;
    L_0x0056:
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r3.ca(r2);
    L_0x005b:
        r2 = r6.a(r0, r3, r4);
        r6.exception = r2;
        r2 = r6.exception;
        if (r2 == 0) goto L_0x0040;
    L_0x0065:
        r2 = r6.lock;
        monitor-enter(r2);
        monitor-exit(r2);	 Catch:{ all -> 0x006b }
        r0 = r1;
        goto L_0x001d;
    L_0x006b:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x006b }
        throw r0;
    L_0x006e:
        r2 = r3.iY();	 Catch:{ all -> 0x007e }
        if (r2 == 0) goto L_0x0081;
    L_0x0074:
        r2 = r6.aib;	 Catch:{ all -> 0x007e }
        r2 = r2 + 1;
        r6.aib = r2;	 Catch:{ all -> 0x007e }
        r6.b(r3);	 Catch:{ all -> 0x007e }
        goto L_0x004a;
    L_0x007e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x007e }
        throw r0;
    L_0x0081:
        r2 = r6.aib;	 Catch:{ all -> 0x007e }
        r3.aib = r2;	 Catch:{ all -> 0x007e }
        r2 = 0;
        r6.aib = r2;	 Catch:{ all -> 0x007e }
        r2 = r6.aik;	 Catch:{ all -> 0x007e }
        r2.addLast(r3);	 Catch:{ all -> 0x007e }
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.b.g.jk():boolean");
    }

    private boolean jl() {
        return !this.aij.isEmpty() && this.aio > 0;
    }

    private void a(I i) {
        i.clear();
        e[] eVarArr = this.ail;
        int i2 = this.ain;
        this.ain = i2 + 1;
        eVarArr[i2] = i;
    }

    private void b(O o) {
        o.clear();
        f[] fVarArr = this.aim;
        int i = this.aio;
        this.aio = i + 1;
        fVarArr[i] = o;
    }
}
