package com.tencent.mm.ax;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.qo;
import com.tencent.mm.sdk.platformtools.bi;

@Deprecated
public final class e extends b {
    private qo hKG = new qo();

    public e(String str, long j) {
        super(9);
        this.hKG.wfM = new bet().Vf(bi.oM(str));
        this.hKG.wfT.add(Integer.valueOf((int) j));
        this.hKG.kyA = 1;
        this.ouK = this.hKG;
    }
}
