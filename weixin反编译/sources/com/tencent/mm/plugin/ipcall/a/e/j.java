package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class j extends a {
    private long nLA;
    public long nLB;
    public long nMa = 0;
    public long nMb = 0;
    public long nMc = 0;

    public final void start() {
        super.start();
        this.nLA = System.currentTimeMillis();
    }

    public final void reset() {
        this.nLA = 0;
        this.nLB = 0;
        this.nMa = 0;
        this.nMb = 0;
        this.nMc = 0;
    }

    protected final void aUI() {
        g.pWK.h(12934, Long.valueOf(this.nLA), Long.valueOf(this.nLB), Long.valueOf(this.nMa), Long.valueOf(this.nMb), Long.valueOf(this.nMc));
    }
}
