package com.google.android.gms.analytics.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.w;

abstract class ae {
    private static volatile Handler aHk;
    final q aFo;
    final Runnable aHl = new Runnable() {
        public final void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ae.this.aFo.mU().d((Runnable) this);
                return;
            }
            boolean nH = ae.this.nH();
            ae.this.aHm = 0;
            if (nH && !ae.this.aHn) {
                ae.this.run();
            }
        }
    };
    volatile long aHm;
    private boolean aHn;

    ae(q qVar) {
        w.ag(qVar);
        this.aFo = qVar;
    }

    public final void Z(long j) {
        cancel();
        if (j >= 0) {
            this.aHm = this.aFo.aFD.currentTimeMillis();
            if (!getHandler().postDelayed(this.aHl, j)) {
                this.aFo.mT().f("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final void cancel() {
        this.aHm = 0;
        getHandler().removeCallbacks(this.aHl);
    }

    final Handler getHandler() {
        if (aHk != null) {
            return aHk;
        }
        Handler handler;
        synchronized (ae.class) {
            if (aHk == null) {
                aHk = new Handler(this.aFo.mContext.getMainLooper());
            }
            handler = aHk;
        }
        return handler;
    }

    public final boolean nH() {
        return this.aHm != 0;
    }

    public abstract void run();
}
