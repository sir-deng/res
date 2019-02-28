package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.task.c;

public final class g {
    int aIt;
    long[] itS;
    int itT;
    int itU;
    private int itV = 0;
    boolean itW;
    boolean itX;
    int mType;

    public final void o(int i, long j) {
        if (i == 0) {
            this.itS = new long[13];
            this.itV = c.akU() ? 1 : 0;
        }
        if (i < this.itS.length && this.itS[i] == 0) {
            this.itS[i] = j;
        }
    }

    final void e(String str, int i, int i2, int i3) {
        int i4;
        int i5 = 1;
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
        Object[] objArr = new Object[13];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(this.aIt);
        objArr[2] = Integer.valueOf(this.mType);
        objArr[3] = Integer.valueOf(i);
        objArr[4] = "";
        objArr[5] = "";
        objArr[6] = Long.valueOf(this.itS[i2]);
        objArr[7] = Integer.valueOf(this.itT);
        objArr[8] = Integer.valueOf(this.itV);
        objArr[9] = Integer.valueOf(this.itU);
        if (this.itW) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        objArr[10] = Integer.valueOf(i4);
        if (!this.itX) {
            i5 = 0;
        }
        objArr[11] = Integer.valueOf(i5);
        objArr[12] = Integer.valueOf(i3);
        gVar.h(13886, objArr);
    }
}
