package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public long kkQ = 0;
    public int kkR;
    private int kkS;
    private int kkT;
    public int kkU;
    public int kkV;
    public int kkW;
    public StringBuilder kkX = new StringBuilder();
    public StringBuilder kkY = new StringBuilder();

    public final void cd(int i, int i2) {
        this.kkS = i;
        this.kkT = i2;
        if (this.kkQ <= 0) {
            x.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
            return;
        }
        x.i("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime:%s mCountAtOpen:%s mCountAtClose:%s mCloseType:%s mScrollCount:%s mOpenAppBrandList:%s mDeleteCount:%s mDeleteAppBrandList:%s", Long.valueOf(this.kkQ), Integer.valueOf(this.kkR), Integer.valueOf(this.kkS), Integer.valueOf(this.kkT), Integer.valueOf(this.kkU), this.kkX.toString(), Integer.valueOf(this.kkV), this.kkY.toString());
        g.pWK.h(15081, Long.valueOf(this.kkQ), Integer.valueOf(this.kkR), Integer.valueOf(this.kkS), Integer.valueOf(this.kkT), Integer.valueOf(this.kkU), this.kkX.toString(), Integer.valueOf(this.kkV), this.kkY.toString(), Integer.valueOf(this.kkW));
        this.kkQ = 0;
        this.kkV = 0;
        this.kkU = 0;
        this.kkT = 0;
        this.kkS = 0;
        this.kkR = 0;
        this.kkX = new StringBuilder();
        this.kkY = new StringBuilder();
    }
}
