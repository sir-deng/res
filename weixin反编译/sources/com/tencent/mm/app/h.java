package com.tencent.mm.app;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.h.d;

public final class h {
    static h ffv;
    HandlerThread ffw;
    d ffx;
    ag handler = new ag(this.ffw.getLooper());

    public h(String str) {
        this.ffw = e.dc(str, 10);
        this.ffw.start();
        this.ffx = new com.tencent.mm.vending.h.h(com.tencent.mm.cc.d.c(this.handler), str);
    }

    public final void tT() {
        if (this.ffw == null || !this.ffw.isAlive()) {
            x.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
            return;
        }
        int threadId = this.ffw.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                x.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, -8);
            x.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
        } catch (Throwable e) {
            x.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", Integer.valueOf(threadId));
            x.printErrStackTrace("MicroMsg.InitThreadController", e, "", new Object[0]);
        }
    }
}
