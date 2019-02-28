package com.tencent.mm.ax;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.qi;
import com.tencent.mm.sdk.platformtools.bi;

@Deprecated
public final class d extends b {
    private qi hKF = new qi();

    public d(String str, long j) {
        super(8);
        this.hKF.wfM = new bet().Vf(bi.oM(str));
        this.hKF.vNT = j;
        this.ouK = this.hKF;
    }
}
