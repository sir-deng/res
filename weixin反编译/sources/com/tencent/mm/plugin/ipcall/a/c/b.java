package com.tencent.mm.plugin.ipcall.a.c;

import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public String countryCode = "";
    public String int = "";
    public long nHP = 0;
    public int nJe = 0;
    public long nJf = 0;
    public int nJh = 0;
    public long nKA = 0;
    public int nKB = 0;
    public long nKC = 0;
    public int nKD = 0;
    public long nKE = 0;
    public int nKF = 0;
    public String nKG = "";
    public long nKH = 0;
    public long nKI = 0;
    public long nKJ = 0;
    public long nKK = 0;
    public String nKL = "";
    public String nKM = "";
    public String nKN = "";
    public long nKO = 0;
    public long nKP = 0;
    public long nKQ = 0;
    public int nKR = 0;
    public int nKS = 0;
    public int nKT = 0;
    public int nKU = 0;
    public int nKu = 0;
    public int nKv = 0;
    public int nKw = 0;
    public int nKx = 0;
    public int nKy = 0;
    public long nKz = 0;

    public final void aUC() {
        x.i("MicroMsg.IPCallReportHelper", "selfShutdown");
        this.nKy = 1;
    }

    public final void aUD() {
        x.i("MicroMsg.IPCallReportHelper", "selfCancel");
        this.nKx = 1;
        if (this.nKQ == 0 && this.nKH != 0) {
            this.nKQ = System.currentTimeMillis() - this.nKH;
            x.d("MicroMsg.IPCallReportHelper", "cancelTime: %d", Long.valueOf(this.nKQ));
        }
    }

    public final void aUE() {
        x.i("MicroMsg.IPCallReportHelper", "channelConnect");
        this.nKB = 1;
    }

    public final void aUF() {
        if (this.nKT == 0) {
            this.nKT = 1;
        }
    }

    public final void aUG() {
        x.d("MicroMsg.IPCallReportHelper", "markConnect");
        if (this.nKO == 0) {
            this.nKO = System.currentTimeMillis();
            this.nKP = this.nKO - this.nKH;
            x.d("MicroMsg.IPCallReportHelper", "connectTime: %d", Long.valueOf(this.nKP));
        }
    }

    public final void aUH() {
        x.d("MicroMsg.IPCallReportHelper", "markStartTalk");
        if (this.nKJ == 0) {
            this.nKJ = System.currentTimeMillis();
        }
    }
}
