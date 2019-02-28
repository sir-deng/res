package com.tencent.mm.booter;

import com.tencent.mm.a.h;
import com.tencent.mm.j.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.an.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class m {
    public static void run() {
        int i = g.Af().getInt("EnableFlockMultiProcSPProb", 0);
        as.Hm();
        int aJ = h.aJ(c.Cn(), 101);
        boolean z = b.cfx() || (i > 0 && aJ >= 0 && aJ <= i);
        a.setValue(a.xoP, z);
        x.i("MicroMsg.PostTaskUpdateMultiProcSPSwitchListener", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", Integer.valueOf(aJ), Integer.valueOf(i), Boolean.valueOf(z));
    }
}
