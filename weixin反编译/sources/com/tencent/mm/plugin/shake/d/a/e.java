package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.bek;

public abstract class e extends k implements com.tencent.mm.network.k {
    protected boolean qvK = false;
    long qvL = 0;

    public abstract bek bsP();

    public e(long j) {
        this.qvL = j;
    }

    public final boolean bsO() {
        return this.qvK;
    }
}
