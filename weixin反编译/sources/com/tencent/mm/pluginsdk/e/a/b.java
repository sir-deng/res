package com.tencent.mm.pluginsdk.e.a;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b {
    private CountDownLatch vjA = null;

    public final void countDown() {
        if (this.vjA != null) {
            this.vjA.countDown();
            this.vjA = null;
        }
    }

    public final void b(long j, Runnable runnable) {
        x.i("MicroMsg.SyncJob", "doAsSyncJob");
        if (this.vjA == null) {
            this.vjA = new CountDownLatch(1);
        }
        ah.y(runnable);
        x.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
        if (this.vjA != null) {
            try {
                this.vjA.await(j, TimeUnit.MILLISECONDS);
            } catch (Throwable e) {
                x.w("MicroMsg.SyncJob", e.getMessage());
                x.printErrStackTrace("MicroMsg.SyncJob", e, "", new Object[0]);
            }
        }
    }
}
