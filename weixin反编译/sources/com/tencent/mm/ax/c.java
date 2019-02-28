package com.tencent.mm.ax;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.sdk.platformtools.bi;

@Deprecated
public final class c extends b {
    private qf hKE;
    public String username;

    public c(String str) {
        this(str, 0);
        this.username = str;
    }

    public c(String str, int i) {
        super(4);
        this.hKE = new qf();
        this.hKE.wfM = new bet().Vf(bi.oM(str));
        this.hKE.wfO = i;
        this.ouK = this.hKE;
    }
}
