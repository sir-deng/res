package com.tencent.mm.ax;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.asa;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.bi;

@Deprecated
public final class k extends b {
    private asa hKM = new asa();

    public k(String str, int i) {
        super(20);
        this.hKM.vNv = new bet().Vf(bi.oM(str));
        this.hKM.kyY = i;
        this.ouK = this.hKM;
    }
}
