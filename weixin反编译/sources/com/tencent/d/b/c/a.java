package com.tencent.d.b.c;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.d.a.c.c;
import com.tencent.d.b.f.f;
import com.tencent.d.b.f.g;
import junit.framework.Assert;

public final class a {
    public CancellationSignal AlR = null;

    static /* synthetic */ void cGV() {
        f cHb = f.cHb();
        synchronized (cHb.Amx) {
            c.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
            if (f.Amw.size() != 0) {
                for (int i = 0; i < f.Amw.size(); i++) {
                    g.cHd().A(new com.tencent.d.b.f.f.AnonymousClass3(f.Amw.keyAt(i)));
                }
            }
        }
    }

    public a() {
        Assert.assertTrue(VERSION.SDK_INT >= 16);
        cGU();
    }

    @SuppressLint({"NewApi"})
    public final boolean od(final boolean z) {
        c.v("Soter.SoterFingerprintCanceller", "soter: publishing cancellation. should publish: %b", Boolean.valueOf(z));
        if (this.AlR.isCanceled()) {
            c.i("Soter.SoterFingerprintCanceller", "soter: cancellation signal already expired.", new Object[0]);
            return false;
        } else if (VERSION.SDK_INT < 23) {
            g.cHd().A(new Runnable() {
                public final void run() {
                    c.v("Soter.SoterFingerprintCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
                    a.this.AlR.cancel();
                    if (z) {
                        a.cGV();
                    }
                }
            });
            return true;
        } else {
            g.cHd().A(new Runnable() {
                public final void run() {
                    a.this.AlR.cancel();
                }
            });
            g.cHd().k(new Runnable() {
                public final void run() {
                    c.w("Soter.SoterFingerprintCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", Long.valueOf(350));
                    a.cGV();
                }
            }, 350);
            return true;
        }
    }

    @SuppressLint({"NewApi"})
    public final void cGU() {
        this.AlR = new CancellationSignal();
    }
}
