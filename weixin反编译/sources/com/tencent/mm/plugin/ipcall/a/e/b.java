package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class b extends a {
    private long nLA;
    public long nLB;
    public long nLC = 0;
    public long nLD = 0;
    public long nLE = 0;

    public final void start() {
        super.start();
        this.nLA = System.currentTimeMillis();
    }

    public final void reset() {
        this.nLA = 0;
        this.nLB = 0;
        this.nLC = 0;
        this.nLD = 0;
        this.nLE = 0;
    }

    protected final void aUI() {
        g.pWK.h(12930, Long.valueOf(this.nLA), Long.valueOf(this.nLB), Long.valueOf(this.nLC), Long.valueOf(this.nLD), Long.valueOf(this.nLE));
    }
}
