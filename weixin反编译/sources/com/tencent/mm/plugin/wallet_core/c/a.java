package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.np;
import com.tencent.mm.protocal.c.nq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.c.o;

public final class a extends l {
    public b gLB;
    private e gLE;
    public int sOr;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2) {
        this.sOr = 0;
        this.sOr = i;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new np();
        aVar.hnU = new nq();
        aVar.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        aVar.hnS = 580;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        np npVar = (np) this.gLB.hnQ.hnY;
        npVar.nlV = str;
        npVar.vSO = str2;
        npVar.wdk = str3;
        npVar.wdl = str4;
        npVar.wdn = str5;
        npVar.wdm = str6;
        npVar.wcy = str7;
        npVar.wdo = i;
        npVar.vXW = i.bLR();
        if (o.cCj()) {
            npVar.wdp = o.cCl();
        }
        npVar.vNG = 1;
        npVar.wdr = str8;
        npVar.wdq = i2;
        x.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", str, str7, Integer.valueOf(i));
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i) {
        this.sOr = 0;
        this.sOr = 16;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new np();
        aVar.hnU = new nq();
        aVar.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        aVar.hnS = 580;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        np npVar = (np) this.gLB.hnQ.hnY;
        npVar.nlV = str;
        npVar.vSO = str2;
        npVar.wdk = str3;
        npVar.wdl = str4;
        npVar.wdn = str5;
        npVar.wdm = str6;
        npVar.wdo = 16;
        npVar.kyG = str7;
        npVar.nqe = str8;
        npVar.vNG = 2;
        npVar.wdr = str9;
        npVar.wdq = i;
        npVar.vXW = i.bLR();
        if (o.cCj()) {
            npVar.wdp = o.cCl();
        }
        x.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", str, str7, str8);
    }

    public final int getType() {
        return 580;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            nq nqVar = (nq) ((b) qVar).hnR.hnY;
            x.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + nqVar.lUc + " resp.ErrMsg is " + nqVar.lUd);
            np npVar = (np) ((b) qVar).hnQ.hnY;
            if (npVar.wcy != null) {
                if (Uri.parse(npVar.wcy).getQueryParameter("appid") != npVar.nlV) {
                    g.pWK.h(14954, nqVar.vGu, "", Integer.valueOf(npVar.wdo), npVar.wdr, npVar.nlV, Integer.valueOf(npVar.vNG), Integer.valueOf(npVar.wdq), npVar.wcy, r2);
                } else {
                    g.pWK.h(14954, nqVar.vGu, "", Integer.valueOf(npVar.wdo), npVar.wdr, npVar.nlV, Integer.valueOf(npVar.vNG), Integer.valueOf(npVar.wdq), npVar.wcy);
                }
            } else if (!(npVar.kyG == null || npVar.nqe == null)) {
                g.pWK.h(14954, nqVar.vGu, "", Integer.valueOf(npVar.wdo), npVar.wdr, npVar.nlV, Integer.valueOf(npVar.vNG), Integer.valueOf(npVar.wdq), npVar.nqe, npVar.kyG);
            }
            x.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + nqVar.lUc + " resp.ErrMsg is " + nqVar.lUd);
            str = nqVar.lUd;
        }
        this.gLE.a(i, i2, str, this);
    }

    public final String biB() {
        return ((nq) this.gLB.hnR.hnY).token;
    }

    public final String bLs() {
        return ((nq) this.gLB.hnR.hnY).vGu;
    }
}
