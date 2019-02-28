package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public int hhQ;
    public int kwn;
    public int kwo;
    private int kwp;
    int kwq;
    int kwr;
    int kws;
    public int kwt;

    private void reset() {
        this.kwn = 0;
        this.kwo = 0;
        this.hhQ = 0;
        this.kwp = 0;
        this.kwq = 0;
        this.kwr = 0;
        this.kws = 0;
        this.kwt = 0;
    }

    public final void HZ() {
        if (this.kwn == 0) {
            reset();
            return;
        }
        x.i("MicroMsg.BakPCReportor", "report: %s", String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(this.kwn), Integer.valueOf(this.kwo), Integer.valueOf(this.hhQ), Integer.valueOf(this.kwp), Integer.valueOf(this.kwq), Integer.valueOf(this.kwr), Integer.valueOf(this.kws), Integer.valueOf(this.kwt)}));
        g.pWK.k(11103, r0);
        reset();
    }
}
