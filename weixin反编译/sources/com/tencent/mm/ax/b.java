package com.tencent.mm.ax;

import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.sdk.platformtools.bi;

@Deprecated
public final class b extends com.tencent.mm.plugin.messenger.foundation.a.a.e.b {
    private qc hKD = new qc();

    public b(String str) {
        super(7);
        this.hKD.wfM = new bet().Vf(bi.oM(str));
        this.ouK = this.hKD;
    }
}
