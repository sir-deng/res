package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.w;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class o implements c {
    final Lock aKJ = new ReentrantLock();
    final h aKY;
    final Map<a<?>, Integer> aKZ;
    private final int aKc;
    private final int aKd;
    final Looper aKf;
    final com.google.android.gms.common.b aKg;
    final com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> aKh;
    volatile p aLA;
    private ConnectionResult aLB = null;
    private final Set<r<?>> aLC = Collections.newSetFromMap(new WeakHashMap());
    final Set<e<?>> aLD = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    private final d aLE = new d() {
        public final void c(e<?> eVar) {
            o.this.aLD.remove(eVar);
        }
    };
    private final com.google.android.gms.common.api.c.b aLF = new com.google.android.gms.common.api.c.b() {
        public final void dh(int i) {
            o.this.aKJ.lock();
            try {
                o.this.aLA.dh(i);
            } finally {
                o.this.aKJ.unlock();
            }
        }

        public final void e(Bundle bundle) {
            o.this.aKJ.lock();
            try {
                o.this.aLA.e(bundle);
            } finally {
                o.this.aKJ.unlock();
            }
        }
    };
    private final com.google.android.gms.common.internal.l.a aLG = new com.google.android.gms.common.internal.l.a() {
        public final boolean isConnected() {
            return o.this.aLA instanceof l;
        }
    };
    final Condition aLp;
    final l aLq;
    final Queue<e<?>> aLr = new LinkedList();
    volatile boolean aLs;
    long aLt = 120000;
    long aLu = 5000;
    final a aLv;
    BroadcastReceiver aLw;
    final Map<com.google.android.gms.common.api.a.c<?>, com.google.android.gms.common.api.a.b> aLx = new HashMap();
    final Map<com.google.android.gms.common.api.a.c<?>, ConnectionResult> aLy = new HashMap();
    Set<Scope> aLz = new HashSet();
    final Context mContext;

    static abstract class b {
        private final p aLK;

        protected b(p pVar) {
            this.aLK = pVar;
        }

        public final void b(o oVar) {
            oVar.aKJ.lock();
            try {
                if (oVar.aLA == this.aLK) {
                    ok();
                    oVar.aKJ.unlock();
                }
            } finally {
                oVar.aKJ.unlock();
            }
        }

        protected abstract void ok();
    }

    interface d {
        void c(e<?> eVar);
    }

    interface e<A extends com.google.android.gms.common.api.a.b> {
        void a(Status status);

        void a(A a);

        void a(d dVar);

        void c(Status status);

        void cancel();

        com.google.android.gms.common.api.a.c<A> nU();
    }

    final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    o oVar = o.this;
                    oVar.aKJ.lock();
                    try {
                        if (oVar.ou()) {
                            oVar.connect();
                        }
                        oVar.aKJ.unlock();
                        return;
                    } catch (Throwable th) {
                        oVar.aKJ.unlock();
                    }
                case 2:
                    o.a(o.this);
                    return;
                case 3:
                    ((b) message.obj).b(o.this);
                    return;
                case 4:
                    throw ((RuntimeException) message.obj);
                default:
                    new StringBuilder("Unknown message id: ").append(message.what);
                    return;
            }
        }
    }

    private static class c extends BroadcastReceiver {
        private WeakReference<o> aLL;

        c(o oVar) {
            this.aLL = new WeakReference(oVar);
        }

        public final void onReceive(Context context, Intent intent) {
            Uri data = intent.getData();
            String str = null;
            if (data != null) {
                str = data.getSchemeSpecificPart();
            }
            if (str != null && str.equals("com.google.android.gms")) {
                o oVar = (o) this.aLL.get();
                if (oVar != null) {
                    o.a(oVar);
                }
            }
        }
    }

    public o(Context context, Looper looper, h hVar, com.google.android.gms.common.b bVar, com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> aVar, Map<a<?>, Object> map, ArrayList<com.google.android.gms.common.api.c.b> arrayList, ArrayList<com.google.android.gms.common.api.c.c> arrayList2, int i, int i2) {
        this.mContext = context;
        this.aLq = new l(looper, this.aLG);
        this.aKf = looper;
        this.aLv = new a(looper);
        this.aKg = bVar;
        this.aKc = i;
        this.aKd = i2;
        this.aKZ = new HashMap();
        this.aLp = this.aKJ.newCondition();
        this.aLA = new n(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.aLq.a((com.google.android.gms.common.api.c.b) it.next());
        }
        it = arrayList2.iterator();
        while (it.hasNext()) {
            this.aLq.a((com.google.android.gms.common.api.c.c) it.next());
        }
        Map map2 = hVar.aNQ;
        for (a aVar2 : map.keySet()) {
            int i3;
            Object cVar;
            Object obj = map.get(aVar2);
            if (map2.get(aVar2) != null) {
                i3 = ((com.google.android.gms.common.internal.h.a) map2.get(aVar2)).aNT ? 1 : 2;
            } else {
                i3 = 0;
            }
            this.aKZ.put(aVar2, Integer.valueOf(i3));
            if ((aVar2.aJT != null ? 1 : null) != null) {
                w.d(aVar2.aJR != null, "This API was constructed with a ClientBuilder. Use getClientBuilder");
                com.google.android.gms.common.api.a.e eVar = aVar2.aJR;
                cVar = new com.google.android.gms.common.internal.c(context, looper, eVar.oc(), this.aLF, a(aVar2, i3), hVar, eVar.ob());
            } else {
                cVar = aVar2.nT().a(context, looper, hVar, obj, this.aLF, a(aVar2, i3));
            }
            this.aLx.put(aVar2.nU(), cVar);
        }
        this.aKY = hVar;
        this.aKh = aVar;
    }

    private final com.google.android.gms.common.api.c.c a(final a<?> aVar, final int i) {
        return new com.google.android.gms.common.api.c.c() {
            public final void a(ConnectionResult connectionResult) {
                o.this.aKJ.lock();
                try {
                    o.this.aLA.a(connectionResult, aVar, i);
                } finally {
                    o.this.aKJ.unlock();
                }
            }
        };
    }

    static /* synthetic */ void a(o oVar) {
        oVar.aKJ.lock();
        try {
            if (oVar.aLs) {
                oVar.connect();
            }
            oVar.aKJ.unlock();
        } catch (Throwable th) {
            oVar.aKJ.unlock();
        }
    }

    public final ConnectionResult a(TimeUnit timeUnit) {
        ConnectionResult connectionResult;
        w.d(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.aKJ.lock();
        try {
            connect();
            long toNanos = timeUnit.toNanos(30);
            while (this.aLA instanceof m) {
                toNanos = this.aLp.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (this.aLA instanceof l) {
                connectionResult = ConnectionResult.aJC;
                this.aKJ.unlock();
            } else if (this.aLB != null) {
                connectionResult = this.aLB;
                this.aKJ.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.aKJ.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.aKJ.unlock();
        }
        return connectionResult;
    }

    public final <A extends com.google.android.gms.common.api.a.b, R extends g, T extends com.google.android.gms.common.api.k.a<R, A>> T a(T t) {
        w.e(t.aJS != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        w.e(this.aLx.containsKey(t.aJS), "GoogleApiClient is not configured to use the API required for this call.");
        this.aKJ.lock();
        try {
            T a = this.aLA.a(t);
            return a;
        } finally {
            this.aKJ.unlock();
        }
    }

    public final void a(com.google.android.gms.common.api.c.b bVar) {
        this.aLq.a(bVar);
    }

    public final void a(com.google.android.gms.common.api.c.c cVar) {
        this.aLq.a(cVar);
    }

    final void a(b bVar) {
        this.aLv.sendMessage(this.aLv.obtainMessage(3, bVar));
    }

    public final void a(String str, PrintWriter printWriter) {
        printWriter.append(str).append("mState=").append(this.aLA.getName());
        printWriter.append(" mResuming=").print(this.aLs);
        printWriter.append(" mWorkQueue.size()=").print(this.aLr.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.aLD.size());
        String str2 = str + "  ";
        for (a aVar : this.aKZ.keySet()) {
            printWriter.append(str).append(aVar.mName).println(":");
            ((com.google.android.gms.common.api.a.b) this.aLx.get(aVar.nU())).a(str2, printWriter);
        }
    }

    public final <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.k.a<? extends g, A>> T b(T t) {
        w.e(t.aJS != null, "This task can not be executed (it's probably a Batch or malformed)");
        this.aKJ.lock();
        try {
            if (this.aLs) {
                this.aLr.add(t);
                while (!this.aLr.isEmpty()) {
                    e eVar = (e) this.aLr.remove();
                    b(eVar);
                    eVar.c(Status.aKs);
                }
            } else {
                t = this.aLA.b(t);
                this.aKJ.unlock();
            }
            return t;
        } finally {
            this.aKJ.unlock();
        }
    }

    public final void b(com.google.android.gms.common.api.c.b bVar) {
        l lVar = this.aLq;
        w.ag(bVar);
        synchronized (lVar.aNX) {
            if (!lVar.aOq.remove(bVar)) {
                new StringBuilder("unregisterConnectionCallbacks(): listener ").append(bVar).append(" not found");
            } else if (lVar.aOv) {
                lVar.aOr.add(bVar);
            }
        }
    }

    public final void b(com.google.android.gms.common.api.c.c cVar) {
        l lVar = this.aLq;
        w.ag(cVar);
        synchronized (lVar.aNX) {
            if (!lVar.aOs.remove(cVar)) {
                new StringBuilder("unregisterConnectionFailedListener(): listener ").append(cVar).append(" not found");
            }
        }
    }

    final <A extends com.google.android.gms.common.api.a.b> void b(e<A> eVar) {
        this.aLD.add(eVar);
        eVar.a(this.aLE);
    }

    public final void connect() {
        this.aKJ.lock();
        try {
            this.aLA.connect();
        } finally {
            this.aKJ.unlock();
        }
    }

    public final void disconnect() {
        this.aKJ.lock();
        try {
            ou();
            this.aLA.disconnect();
        } finally {
            this.aKJ.unlock();
        }
    }

    final void f(ConnectionResult connectionResult) {
        this.aKJ.lock();
        try {
            this.aLB = connectionResult;
            this.aLA = new n(this);
            this.aLA.begin();
            this.aLp.signalAll();
        } finally {
            this.aKJ.unlock();
        }
    }

    public final Looper getLooper() {
        return this.aKf;
    }

    public final boolean isConnected() {
        return this.aLA instanceof l;
    }

    public final boolean isConnecting() {
        return this.aLA instanceof m;
    }

    final void ot() {
        for (e eVar : this.aLD) {
            eVar.a(null);
            eVar.cancel();
        }
        this.aLD.clear();
        for (r rVar : this.aLC) {
            rVar.aLN = null;
        }
        this.aLC.clear();
    }

    final boolean ou() {
        if (!this.aLs) {
            return false;
        }
        this.aLs = false;
        this.aLv.removeMessages(2);
        this.aLv.removeMessages(1);
        if (this.aLw != null) {
            this.mContext.getApplicationContext().unregisterReceiver(this.aLw);
            this.aLw = null;
        }
        return true;
    }
}
