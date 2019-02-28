package com.tencent.mm.plugin.appbrand.app;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.task.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static volatile boolean iFo = false;

    static void Zi() {
        ah.y(new Runnable() {
            public final void run() {
                Looper.myQueue().addIdleHandler(new IdleHandler() {
                    public final boolean queueIdle() {
                        Looper.myQueue().removeIdleHandler(this);
                        if (!b.iFo) {
                            x.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "start misc preload");
                            AppBrandMainProcessService.afr();
                            c.a(null, false);
                        }
                        return false;
                    }
                });
            }
        });
    }

    public static void Zj() {
        x.i("MicroMsg.AppBrandProcessProfileInit[applaunch]", "setSkipMiscPreload %b", Boolean.valueOf(true));
        iFo = true;
    }
}
