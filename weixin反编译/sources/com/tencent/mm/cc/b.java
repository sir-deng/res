package com.tencent.mm.cc;

import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private final byte[] gPR = new byte[1];
    private long zTe = -1;

    public final void cDg() {
        synchronized (this.gPR) {
            if (this.gPR[0] == (byte) 0) {
                this.gPR[0] = (byte) 1;
                this.zTe = Thread.currentThread().getId();
                j.i("MicroMsg.WxConsumedLock", "lock %s", this);
            } else {
                try {
                    if (this.zTe != Thread.currentThread().getId()) {
                        j.i("MicroMsg.WxConsumedLock", "lock waiting %s", this);
                        this.gPR.wait();
                        j.i("MicroMsg.WxConsumedLock", "unlock waiting %s", this);
                    } else {
                        j.i("MicroMsg.WxConsumedLock", "reenter lock not need waiting %s", this);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WxConsumedLock", e, "", new Object[0]);
                }
            }
        }
    }

    public final void done() {
        synchronized (this.gPR) {
            if (this.gPR[0] != (byte) 0) {
                this.gPR[0] = (byte) 0;
                this.zTe = -1;
                this.gPR.notifyAll();
                j.i("MicroMsg.WxConsumedLock", "notify done %s", this);
            }
        }
    }
}
