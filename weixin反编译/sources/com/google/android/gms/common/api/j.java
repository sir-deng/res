package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class j<R extends g> implements e<R> {
    private h<R> aKA;
    private volatile R aKB;
    private volatile boolean aKC;
    private boolean aKD;
    private boolean aKE;
    private q aKF;
    private final Object aKw = new Object();
    protected final a<R> aKx;
    private final CountDownLatch aKy = new CountDownLatch(1);
    private final ArrayList<Object> aKz = new ArrayList();

    public static class a<R extends g> extends Handler {
        public a() {
            this(Looper.getMainLooper());
        }

        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    Object obj = pair.first;
                    Object obj2 = pair.second;
                    return;
                case 2:
                    ((j) message.obj).a(Status.aKt);
                    return;
                default:
                    Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
                    return;
            }
        }
    }

    protected j(Looper looper) {
        this.aKx = new a(looper);
    }

    private void b(R r) {
        this.aKB = r;
        this.aKF = null;
        this.aKy.countDown();
        g gVar = this.aKB;
        if (this.aKA != null) {
            this.aKx.removeMessages(2);
            if (!this.aKD) {
                a aVar = this.aKx;
                aVar.sendMessage(aVar.obtainMessage(1, new Pair(this.aKA, oj())));
            }
        }
        Iterator it = this.aKz.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.aKz.clear();
    }

    private static void c(g gVar) {
        if (gVar instanceof f) {
            try {
                ((f) gVar).release();
            } catch (RuntimeException e) {
                new StringBuilder("Unable to release ").append(gVar);
            }
        }
    }

    private boolean it() {
        return this.aKy.getCount() == 0;
    }

    private R oj() {
        R r;
        boolean z = true;
        synchronized (this.aKw) {
            if (this.aKC) {
                z = false;
            }
            w.d(z, "Result has already been consumed.");
            w.d(it(), "Result is not ready.");
            r = this.aKB;
            this.aKB = null;
            this.aKA = null;
            this.aKC = true;
        }
        oi();
        return r;
    }

    public final void a(Status status) {
        synchronized (this.aKw) {
            if (!it()) {
                a(b(status));
                this.aKE = true;
            }
        }
    }

    public final void a(R r) {
        boolean z = true;
        synchronized (this.aKw) {
            if (this.aKE || this.aKD) {
                c(r);
                return;
            }
            w.d(!it(), "Results have already been set");
            if (this.aKC) {
                z = false;
            }
            w.d(z, "Result has already been consumed");
            b((g) r);
        }
    }

    public abstract R b(Status status);

    public final R b(TimeUnit timeUnit) {
        boolean z = true;
        boolean z2 = 2 <= 0 || Looper.myLooper() != Looper.getMainLooper();
        w.d(z2, "await must not be called on the UI thread when time is greater than zero.");
        if (this.aKC) {
            z = false;
        }
        w.d(z, "Result has already been consumed.");
        try {
            if (!this.aKy.await(2, timeUnit)) {
                a(Status.aKt);
            }
        } catch (InterruptedException e) {
            a(Status.aKr);
        }
        w.d(it(), "Result is not ready.");
        return oj();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cancel() {
        /*
        r2 = this;
        r1 = r2.aKw;
        monitor-enter(r1);
        r0 = r2.aKD;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.aKC;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.aKB;	 Catch:{ all -> 0x0023 }
        c(r0);	 Catch:{ all -> 0x0023 }
        r0 = 0;
        r2.aKA = r0;	 Catch:{ all -> 0x0023 }
        r0 = 1;
        r2.aKD = r0;	 Catch:{ all -> 0x0023 }
        r0 = com.google.android.gms.common.api.Status.aKu;	 Catch:{ all -> 0x0023 }
        r0 = r2.b(r0);	 Catch:{ all -> 0x0023 }
        r2.b(r0);	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000c;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.j.cancel():void");
    }

    public final R og() {
        boolean z = true;
        w.d(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
        if (this.aKC) {
            z = false;
        }
        w.d(z, "Result has already been consumed");
        try {
            this.aKy.await();
        } catch (InterruptedException e) {
            a(Status.aKr);
        }
        w.d(it(), "Result is not ready.");
        return oj();
    }

    protected void oi() {
    }
}
