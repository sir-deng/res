package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.g;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends ae {
    private a lWN;
    private g lWP;

    public i(int i) {
        this.lWP = new g(i);
    }

    public final boolean a(m mVar, d dVar) {
        if (u.aFs().cE(this.lWP.kGc)) {
            this.lWN = new a(this.lWP, dVar);
            return this.lWN.b(mVar);
        }
        x.w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", Long.valueOf(this.lWP.kGc));
        return true;
    }
}
