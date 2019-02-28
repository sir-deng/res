package com.tencent.mm.plugin.freewifi.model;

import android.os.HandlerThread;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;

public final class c {
    private HandlerThread mJO;
    private ag mJP;

    public final ag aMg() {
        if (this.mJO == null) {
            this.mJO = e.WL("FreeWifiHandlerThread_handlerThread");
            this.mJO.start();
        }
        if (this.mJP == null) {
            this.mJP = new ag(this.mJO.getLooper());
        }
        return this.mJP;
    }

    public final void release() {
        if (this.mJO != null) {
            this.mJO.quit();
            this.mJO = null;
        }
        this.mJP = null;
    }
}
