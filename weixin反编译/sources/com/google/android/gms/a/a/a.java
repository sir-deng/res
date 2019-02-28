package com.google.android.gms.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import com.google.android.gms.c.d;
import com.google.android.gms.common.c;
import com.google.android.gms.common.e;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.w;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class a {
    private static boolean aEp = false;
    h aEj;
    d aEk;
    boolean aEl;
    Object aEm = new Object();
    b aEn;
    final long aEo;
    private final Context mContext;

    public static final class a {
        public final String aEq;
        public final boolean aEr;

        public a(String str, boolean z) {
            this.aEq = str;
            this.aEr = z;
        }

        public final String toString() {
            return "{" + this.aEq + "}" + this.aEr;
        }
    }

    static class b extends Thread {
        private WeakReference<a> aEs;
        private long aEt;
        CountDownLatch aEu = new CountDownLatch(1);
        boolean aEv = false;

        public b(a aVar, long j) {
            this.aEs = new WeakReference(aVar);
            this.aEt = j;
            start();
        }

        private void disconnect() {
            a aVar = (a) this.aEs.get();
            if (aVar != null) {
                aVar.finish();
                this.aEv = true;
            }
        }

        public final void run() {
            try {
                if (!this.aEu.await(this.aEt, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }
    }

    private a(Context context) {
        w.ag(context);
        this.mContext = context;
        this.aEl = false;
        this.aEo = -1;
    }

    private static d a(h hVar) {
        try {
            return com.google.android.gms.c.d.a.n(hVar.pl());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private void mb() {
        w.aO("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.aEl) {
                finish();
            }
            this.aEj = w(this.mContext);
            this.aEk = a(this.aEj);
            this.aEl = true;
        }
    }

    private a mc() {
        a aVar;
        w.aO("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.aEl) {
                synchronized (this.aEm) {
                    if (this.aEn == null || !this.aEn.aEv) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    mb();
                    if (!this.aEl) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e) {
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            w.ag(this.aEj);
            w.ag(this.aEk);
            aVar = new a(this.aEk.getId(), this.aEk.av(true));
        }
        synchronized (this.aEm) {
            if (this.aEn != null) {
                this.aEn.aEu.countDown();
                try {
                    this.aEn.join();
                } catch (InterruptedException e3) {
                }
            }
            if (this.aEo > 0) {
                this.aEn = new b(this, this.aEo);
            }
        }
        return aVar;
    }

    private static h w(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            if (aEp) {
                com.google.android.gms.common.b.nS();
                switch (com.google.android.gms.common.b.C(context)) {
                    case 0:
                    case 2:
                        break;
                    default:
                        throw new IOException("Google Play services not available");
                }
            }
            try {
                e.E(context);
            } catch (Throwable e) {
                throw new IOException(e);
            }
            Object hVar = new h();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (com.google.android.gms.common.stats.b.pj().a(context, intent, hVar, 1)) {
                    return hVar;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e2) {
                IOException iOException = new IOException(e2);
            }
        } catch (NameNotFoundException e3) {
            throw new c(9);
        }
    }

    public static a x(Context context) {
        a aVar = new a(context);
        try {
            aVar.mb();
            a mc = aVar.mc();
            return mc;
        } finally {
            aVar.finish();
        }
    }

    protected final void finalize() {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.w.aO(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x000f;
    L_0x000b:
        r0 = r3.aEj;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
    L_0x0010:
        return;
    L_0x0011:
        r0 = r3.aEl;	 Catch:{ IllegalArgumentException -> 0x002e }
        if (r0 == 0) goto L_0x0020;
    L_0x0015:
        r0 = com.google.android.gms.common.stats.b.pj();	 Catch:{ IllegalArgumentException -> 0x002e }
        r1 = r3.mContext;	 Catch:{ IllegalArgumentException -> 0x002e }
        r2 = r3.aEj;	 Catch:{ IllegalArgumentException -> 0x002e }
        r0.a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002e }
    L_0x0020:
        r0 = 0;
        r3.aEl = r0;	 Catch:{ all -> 0x002b }
        r0 = 0;
        r3.aEk = r0;	 Catch:{ all -> 0x002b }
        r0 = 0;
        r3.aEj = r0;	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0 = move-exception;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.a.a.a.finish():void");
    }
}
