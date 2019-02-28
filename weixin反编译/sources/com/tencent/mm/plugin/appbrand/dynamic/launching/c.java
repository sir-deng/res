package com.tencent.mm.plugin.appbrand.dynamic.launching;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.protocal.c.nd;
import com.tencent.mm.protocal.c.ne;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    private final String appId;
    private final String frM;
    private final String iXA;
    private final boolean iXB;

    public enum a {
        ;

        static {
            iXC = 1;
            iXD = 2;
            iXE = 3;
            iXF = 4;
            iXG = 5;
            iXH = 6;
            iXI = new int[]{iXC, iXD, iXE, iXF, iXG, iXH};
        }
    }

    private c(String str, String str2, String str3) {
        this.appId = str;
        this.frM = str2;
        this.iXA = str3;
        this.iXB = false;
    }

    public c(String str, String str2, String str3, byte b) {
        this(str, str2, str3);
    }

    private void h(int i, String str, String str2) {
        ((com.tencent.mm.plugin.appbrand.a.c) g.h(com.tencent.mm.plugin.appbrand.a.c.class)).Zf().a(this.appId, i, str, str2, 0, 0);
    }

    public final int adu() {
        String str = this.appId;
        String str2 = this.frM;
        String str3 = this.iXA;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        com.tencent.mm.bp.a ndVar = new nd();
        ndVar.fGh = str;
        ndVar.wcC = str2;
        ndVar.wcD = str3;
        aVar.hnT = ndVar;
        aVar.hnU = new ne();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkdemoinfo";
        aVar.hnS = 1124;
        com.tencent.mm.ad.a.a c = d.c(aVar.Kf());
        if (c.errType == 0 && c.errCode == 0) {
            try {
                ne neVar = (ne) c.fKE;
                if (neVar.wcE == null) {
                    x.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, null wxaapp resp", this.appId);
                    return a.iXG - 1;
                }
                x.i("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, wxa.ErrCode %d, has_new_demo %b, url %s, md5 %s", this.appId, Integer.valueOf(neVar.wcE.lUc), Boolean.valueOf(neVar.wcF), neVar.wcG, neVar.wcH);
                if (neVar.wcE.lUc != 0) {
                    return neVar.wcE.lUc;
                }
                if (!(!neVar.wcF || bi.oN(neVar.wcH) || bi.oN(neVar.wcG))) {
                    h(2, neVar.wcG, neVar.wcH);
                }
                if (!(!neVar.wcI || bi.oN(neVar.wcK) || bi.oN(neVar.wcJ))) {
                    h(10001, neVar.wcJ, neVar.wcK);
                }
                return a.iXC - 1;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", e, "CgiCheckDemoInfo, appId %s, cast response failed", this.appId);
                return a.iXG - 1;
            }
        }
        x.e("MicroMsg.AppBrand.PrepareStepOpBanCheckDemoInfo", "CgiCheckDemoInfo, appId %s, errType %d, errCode %d, errMsg %s", this.appId, Integer.valueOf(c.errType), Integer.valueOf(c.errCode), c.foE);
        return a.iXF - 1;
    }
}
