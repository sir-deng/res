package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    public String extra = "";
    public String fAR;
    public long gAW;
    public int gAw;
    public int hMA;
    public int mtO;
    public int mtP;
    public String rfQ;
    public String rfT;
    public int rnb;
    public int rup;
    public int ruq;
    public int rur;
    public int rus;
    public int rut;
    public int ruu;
    public int ruv;
    public int ruw;
    public String rux;
    public String ruy;
    public String ruz;

    public final String byz() {
        long j = 0;
        try {
            j = i.lV(this.fAR);
        } catch (Exception e) {
            x.e("AdLandingPagesReportInfo", "", e);
        }
        return i.er(j) + "," + this.rfQ + "," + this.rup + "," + this.gAw + "," + this.ruq + "," + this.rur + "," + this.rus + "," + this.rut + "," + this.ruu + "," + this.ruv + "," + this.ruw + "," + this.mtP + "," + this.mtO + "," + this.hMA + "," + this.rux + "," + this.gAW + "," + this.ruy + "," + (this.rfT == null ? "" : this.rfT) + "," + this.extra + "," + this.rnb + "," + this.ruz;
    }
}
