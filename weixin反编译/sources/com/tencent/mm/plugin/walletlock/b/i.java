package com.tencent.mm.plugin.walletlock.b;

import android.app.Activity;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum i {
    ;
    
    private boolean tnW;
    private boolean tnX;
    private Object tnY;
    public HashSet<WeakReference<Activity>> tnZ;

    private i(String str) {
        this.tnW = false;
        this.tnX = false;
        this.tnY = new Object();
        this.tnZ = new HashSet();
    }

    public final void ki(boolean z) {
        synchronized (this.tnY) {
            this.tnW = z;
        }
    }

    public final boolean bPb() {
        boolean z;
        synchronized (this.tnY) {
            z = this.tnW;
        }
        return z;
    }

    public final void kj(boolean z) {
        synchronized (this.tnY) {
            this.tnX = z;
        }
    }

    public final boolean bPc() {
        boolean z;
        synchronized (this.tnY) {
            z = this.tnX;
        }
        return z;
    }

    public final void bPd() {
        synchronized (this.tnY) {
            this.tnX = true;
        }
    }

    public final void b(WeakReference<Activity> weakReference) {
        if (this.tnZ != null) {
            if (weakReference.get() != null) {
                x.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", ((Activity) weakReference.get()).getClass().getName());
            }
            this.tnZ.add(weakReference);
        }
    }

    public final void bPe() {
        Iterator it = this.tnZ.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) ((WeakReference) it.next()).get();
            if (!(activity == null || activity.isFinishing())) {
                x.v("MicroMsg.WalletLockStatusManager", "alvinluo finish %s", activity.getClass().getName());
                activity.finish();
            }
            it.remove();
        }
    }
}
