package com.tencent.mm.ax;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.bi;

@Deprecated
public final class n extends b {
    private asw hKP = new asw();

    public n(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10) {
        super(1);
        this.hKP.wfM = new bet().Vf(bi.oM(str));
        this.hKP.wzM = new bet().Vf(bi.oM(str2));
        this.hKP.vMd = 0;
        this.hKP.wHe = new bet().Vf(bi.oM(str3));
        this.hKP.wHf = new bet().Vf(bi.oM(str4));
        this.hKP.kyY = 0;
        byte[] d = e.d(bi.oM(str5), 0, -1);
        this.hKP.wHb = new com.tencent.mm.bp.b(d == null ? new byte[0] : d);
        this.hKP.wHa = d == null ? 0 : d.length;
        this.hKP.hxe = 0;
        this.hKP.hxi = 0;
        this.hKP.hxh = bi.oM(str6);
        this.hKP.hxg = bi.oM(str7);
        this.hKP.hxf = bi.oM(str8);
        this.hKP.vMg = i;
        this.hKP.wCs = bi.oM(str9);
        this.hKP.wHk = 0;
        this.hKP.hxj = bi.oM(str10);
        this.hKP.wCu = 0;
        this.hKP.wCt = "";
        this.ouK = this.hKP;
    }
}
