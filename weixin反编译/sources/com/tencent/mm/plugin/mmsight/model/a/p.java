package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.x;

public class p implements f {
    volatile int frameCount = 0;
    long kJN = 0;
    int mBg;
    int nZY;
    int oBA = -1;
    int oBB = -1;
    int oBC = -1;
    int oBD = -1;
    int oBE = -1;
    boolean oyN;
    long ozw = 0;

    public p(boolean z, int i, int i2, int i3) {
        this.oyN = z;
        this.oBB = i;
        this.nZY = i2;
        this.mBg = i3;
        x.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", Boolean.valueOf(z), Integer.valueOf(this.oBB), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final int ti(int i) {
        if (i < 0) {
            x.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
            return -1;
        }
        this.oBA = i;
        synchronized (p.class) {
            this.frameCount = 0;
        }
        this.kJN = 0;
        return 0;
    }

    public final void stop() {
        synchronized (p.class) {
            this.frameCount = 0;
        }
        this.kJN = 0;
    }

    public final long bbw() {
        if (0 != this.kJN) {
            return System.currentTimeMillis() - this.kJN;
        }
        x.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
        return 0;
    }
}
