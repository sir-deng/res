package com.tencent.mm.plugin.fps_lighter.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.fps_lighter.b.b;
import com.tencent.mm.plugin.fps_lighter.b.c;
import com.tencent.mm.plugin.fps_lighter.b.e;
import com.tencent.mm.plugin.fps_lighter.b.g;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements c {
    private c mFY;
    private int mFZ;
    private int mGa;
    private e mGb = g.aLv().mGU;

    public a(c cVar) {
        this.mFY = cVar;
    }

    public final void a(int i, long j, long j2, int i2, int i3, boolean z, long j3, boolean z2) {
        if (com.tencent.mm.plugin.fps_lighter.e.a.qh(i2) == com.tencent.mm.plugin.fps_lighter.e.a.a.BAD && !z) {
            x.i("MicroMsg.FrameAnalyseCallback", "Scene:%s pre:%s droppedFrames:%s isInputHandling:%s isOnCreateConsuming:%s", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z));
            b bVar = g.aLv().mGT;
            long[] mainThreadBuffer = !this.mGb.fBn ? null : GMTrace.getMainThreadBuffer();
            long startTime = j2 - GMTrace.getStartTime();
            x.i("MicroMsg.FPSAnalyser", "[immediateExec] preIndex:%s,curIndex：%s droopedCount:%s previousFrameMS:%s scene:%s isOnCreateConsuming:%s", Integer.valueOf(this.mFZ), Integer.valueOf(e.aLt()), Long.valueOf((long) i2), Long.valueOf(j - GMTrace.getStartTime()), Integer.valueOf(i), Boolean.valueOf(z));
            Runnable aVar = new com.tencent.mm.plugin.fps_lighter.d.a(mainThreadBuffer, r4, r5, r6, r8, startTime, i3, i, z, j3, z2);
            aVar.mHu = bVar;
            g.aLv();
            g.VV().post(aVar);
        }
        this.mFZ = this.mGa;
        this.mGa = this.mGb.mGE;
        this.mGb.aLu();
    }

    public final void E(int i, boolean z) {
        if (i == Integer.MAX_VALUE) {
            if (z) {
                e eVar = g.aLv().mGU;
                if (!eVar.fBn) {
                    if (!GMTrace.isInit()) {
                        GMTrace.init(true);
                    }
                    GMTrace.startTrace();
                    eVar.mGE = GMTrace.getMainThreadIndex();
                    x.i("MicroMsg.FpsGMTraceHandler", "[startTrace] start:%s", Integer.valueOf(eVar.mGE));
                    eVar.fBn = true;
                }
            } else {
                g.aLv().mGU.stopTrace();
            }
        }
        this.mFZ = this.mGa;
        this.mGa = this.mGb.mGE;
        this.mGb.aLu();
    }

    public final String toString() {
        return "MicroMsg.FrameAnalyseCallback";
    }
}
