package com.tencent.mm.modelstat;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    long beginTime;
    long endTime;
    boolean fMC;
    long hTm;
    long hTn;
    long hTo;
    int rtType;

    public h(int i, boolean z, long j) {
        this.rtType = i;
        this.fMC = z;
        this.hTm = j;
        this.hTn = 0;
    }

    public final void Td() {
        if (this.hTn == 0) {
            this.beginTime = bi.Wy();
            this.hTo = bi.Wz();
        }
        this.hTn++;
    }

    public final void bs(long j) {
        if (this.hTm == 0) {
            this.hTm = j;
        }
        this.hTo = bi.Wz() - this.hTo;
        this.endTime = bi.Wy();
        x.d("MicroMsg.MultiSceneStat", "FIN: TIME:" + (this.endTime - this.beginTime) + " datalen:" + this.hTm + " Count:" + this.hTn + " type:" + this.rtType);
        WatchDogPushReceiver.a(this);
    }
}
