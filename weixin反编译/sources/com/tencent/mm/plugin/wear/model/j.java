package com.tencent.mm.plugin.wear.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    HandlerThread handlerThread;
    ag jFp;

    private class a extends ag {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            d dVar = (d) message.obj;
            if (dVar != null) {
                try {
                    dVar.run();
                } catch (Exception e) {
                    x.printErrStackTrace("MicroMsg.Wear.WearWorker", e.getCause(), "run task %s occur exception", dVar.getName());
                }
            }
        }
    }

    public j() {
        if (com.tencent.mm.compatible.util.d.fP(18)) {
            this.handlerThread = e.WL("WearWorker_worker_thread");
            this.handlerThread.start();
            this.jFp = new a(this.handlerThread.getLooper());
            x.i("MicroMsg.Wear.WearWorker", "start worker %d", Integer.valueOf(this.handlerThread.getThreadId()));
        }
    }

    public final void a(d dVar) {
        if (this.jFp != null) {
            this.jFp.sendMessage(this.jFp.obtainMessage(0, dVar));
        }
    }
}
