package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class h extends a {
    private long nLA;
    public long nLB;
    private long nLW = 0;
    public long nLX = 0;
    public long nLY = 0;
    public long nLZ = 0;

    public final void start() {
        super.start();
        this.nLA = System.currentTimeMillis();
    }

    public final void reset() {
        this.nLA = 0;
        this.nLB = 0;
        this.nLW = 0;
        this.nLX = 0;
        this.nLY = 0;
        this.nLZ = 0;
    }

    protected final void aUI() {
        g.pWK.h(12931, Long.valueOf(this.nLA), Long.valueOf(this.nLB), Long.valueOf(this.nLW), Long.valueOf(this.nLX), Long.valueOf(this.nLY), Long.valueOf(this.nLZ));
    }
}
