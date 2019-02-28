package com.tencent.mm.plugin.mmsight.model.b;

import android.os.Process;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    int bitrate;
    boolean fBn = false;
    int frameCount = 0;
    int hvP;
    int hvQ;
    int iqY;
    int iqZ;
    int mBg;
    int nZY;
    int oBL;
    a oCA;
    Thread oCB;

    private class a implements Runnable {
        int oAM;
        volatile int oAZ;
        Object oBg;
        boolean oCC;

        private a() {
            this.oBg = new Object();
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void run() {
            if (this.oAM == -1) {
                this.oAM = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                x.i("MicroMsg.MMSightRemuxX264Encoder", "encodeTid: %s", Integer.valueOf(this.oAM));
            }
            this.oAZ = 0;
            synchronized (this.oBg) {
                long Wz;
                while (!this.oCC) {
                    Wz = bi.Wz();
                    x.i("MicroMsg.MMSightRemuxX264Encoder", "try trigger encode");
                    int triggerEncodeForSegment = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.oAZ), false);
                    x.i("MicroMsg.MMSightRemuxX264Encoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(bi.bB(Wz)), Integer.valueOf(this.oAZ), Integer.valueOf(triggerEncodeForSegment), Long.valueOf(Thread.currentThread().getId()));
                    if (triggerEncodeForSegment == this.oAZ) {
                        try {
                            Thread.sleep(20);
                        } catch (Exception e) {
                            x.e("MicroMsg.MMSightRemuxX264Encoder", "thread sleep error");
                        }
                    }
                    this.oAZ = triggerEncodeForSegment;
                }
                Wz = bi.Wz();
                this.oAZ = MP4MuxerJNI.triggerEncodeForSegment(this.oAZ, true);
                x.i("MicroMsg.MMSightRemuxX264Encoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", Long.valueOf(bi.bB(Wz)), Integer.valueOf(this.oAZ), Long.valueOf(Thread.currentThread().getId()));
            }
        }
    }

    public e(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.iqY = i;
        this.iqZ = i2;
        this.nZY = i3;
        this.mBg = i4;
        this.bitrate = i5;
        this.oBL = i6;
        this.hvP = 2;
        this.hvQ = i7;
    }
}
