package com.tencent.mm.cc;

import com.tencent.mm.kernel.j;

public final class k {
    public final byte[] gPR = new byte[1];

    public final void done() {
        synchronized (this.gPR) {
            if (this.gPR[0] == (byte) -1) {
                this.gPR[0] = (byte) 1;
                this.gPR.notifyAll();
                j.i("MicroMsg.WxWaitingLock", "notify done %s", this);
            }
        }
    }
}
