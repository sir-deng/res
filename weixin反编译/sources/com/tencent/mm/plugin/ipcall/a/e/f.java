package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.mm.plugin.report.service.g;

public final class f extends a {
    public int nLH = 0;
    public int nLI = 0;
    public int nLJ = 0;
    public int nLK = 0;
    public int nLL = -9999;
    public String nLM = "";
    public int nLN = 0;
    public int nLO = 0;

    public final void start() {
        super.start();
    }

    public final void reset() {
        this.nLH = 0;
        this.nLI = 0;
        this.nLJ = 0;
        this.nLK = 0;
        this.nLL = -9999;
        this.nLM = "";
        this.nLN = 0;
        this.nLO = 0;
    }

    protected final void aUI() {
        g.pWK.h(14182, Integer.valueOf(this.nLH), Integer.valueOf(this.nLI), Integer.valueOf(this.nLJ), Integer.valueOf(this.nLK), Integer.valueOf(this.nLL), this.nLM, Integer.valueOf(this.nLN), Integer.valueOf(this.nLO));
    }
}
