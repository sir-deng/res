package com.tencent.mm.plugin.fps_lighter.b;

import com.tencent.gmtrace.GMTrace;
import com.tencent.gmtrace.GMTraceHandler;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class e extends GMTraceHandler {
    public boolean fBn = false;
    public int mGE;
    private int mGF;
    c mGG;

    public e(c cVar) {
        this.mGG = cVar;
    }

    public final void stopTrace() {
        if (this.fBn) {
            GMTrace.stopTrace();
            this.mGF = GMTrace.getMainThreadIndex();
            x.i("MicroMsg.FpsGMTraceHandler", "[stopTrace] start:%s end:%s", Integer.valueOf(this.mGE), Integer.valueOf(this.mGF));
            this.fBn = false;
        }
    }

    public static int aLt() {
        return GMTrace.getMainThreadIndex();
    }

    public final void aLu() {
        if (this.fBn) {
            this.mGE = GMTrace.getMainThreadIndex();
        } else {
            x.e("MicroMsg.FpsGMTraceHandler", "its never start!");
        }
    }

    public final List<Integer> getPointId() {
        return null;
    }

    public final void syncDo(int i, long j) {
    }

    public final void postBufferData(boolean z) {
    }
}
