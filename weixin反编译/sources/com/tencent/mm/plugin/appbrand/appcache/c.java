package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.o;
import com.tencent.mm.ad.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.launching.i;
import com.tencent.mm.protocal.c.ahc;
import com.tencent.mm.protocal.c.ahd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.g;

public final class c extends a<ahd> {
    private final b gLB;

    public c(String str, String str2, String str3, int i) {
        b.a aVar = new b.a();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/gettestcodedownloadinfo";
        com.tencent.mm.bp.a ahc = new ahc();
        ahc.fGh = str;
        ahc.wvh = str2;
        ahc.wvi = str3;
        ahc.vYi = i;
        if (i == 1) {
            try {
                ahc.wvj = new o(g.fA(((i) e.u(i.class)).aG(str, i)).optLong("dev_key")).intValue();
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.CgiGetTestCodeDownloadInfo", "opt devKey %s", e);
            }
        }
        aVar.hnT = ahc;
        aVar.hnU = new ahd();
        b Kf = aVar.Kf();
        this.gLB = Kf;
        this.gLB = Kf;
    }
}
