package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.sdk.platformtools.x;

public abstract class d implements Runnable {
    public abstract void execute();

    public abstract String getName();

    public d() {
        x.i("MicroMsg.WearBaseWorkerTask", "Create %s", getName());
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            execute();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WearBaseWorkerTask", e, "run task %s occur exception: %s", getName(), e.getMessage());
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        x.i("MicroMsg.WearBaseWorkerTask", "execute %s | use time %d", getName(), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
    }
}
