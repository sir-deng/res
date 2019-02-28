package com.tencent.mm.plugin.wallet_core.c;

import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.nz;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class b extends l {
    private com.tencent.mm.ad.b gLB;
    private e gLE;
    public int sOr;
    public oa sOs;

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        this(str, str2, str3, str4, str5, str6, str7, 5, str8, i);
    }

    private b(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2) {
        this.sOr = 0;
        this.sOr = 5;
        a aVar = new a();
        aVar.hnT = new nz();
        aVar.hnU = new oa();
        aVar.uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
        aVar.hnS = 2728;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        nz nzVar = (nz) this.gLB.hnQ.hnY;
        nzVar.nlV = str;
        nzVar.vSO = str2;
        nzVar.wdk = str3;
        nzVar.wdl = str4;
        nzVar.wdn = str5;
        nzVar.wdm = str6;
        nzVar.wcy = str7;
        nzVar.wdo = 5;
        nzVar.vXW = i.bLR();
        nzVar.vNG = 1;
        nzVar.kyG = null;
        nzVar.nqe = null;
        nzVar.wdr = str8;
        nzVar.wdq = i2;
        boolean aKD = ((com.tencent.mm.pluginsdk.l) g.h(com.tencent.mm.pluginsdk.l.class)).aKD();
        SharedPreferences cgg = ad.cgg();
        String str9 = null;
        String str10 = null;
        if (cgg != null) {
            str9 = cgg.getString("cpu_id", null);
            str10 = cgg.getString("uid", null);
        }
        nzVar.wdD = 0;
        nzVar.rYp = str9;
        nzVar.rYq = str10;
        nzVar.wdE = aKD ? 1 : 0;
        x.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", str9, str10);
        x.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", str, str7, Integer.valueOf(5), Boolean.valueOf(aKD));
    }

    public final int getType() {
        return 580;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneCheckUserAuthJsapi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            this.sOs = (oa) ((com.tencent.mm.ad.b) qVar).hnR.hnY;
            nz nzVar = (nz) ((com.tencent.mm.ad.b) qVar).hnQ.hnY;
            if (nzVar.wcy != null) {
                if (Uri.parse(nzVar.wcy).getQueryParameter("appid") != nzVar.nlV) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(14954, this.sOs.vGu, "", Integer.valueOf(nzVar.wdo), nzVar.wdr, nzVar.nlV, Integer.valueOf(nzVar.vNG), Integer.valueOf(nzVar.wdq), nzVar.wcy, r1);
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.h(14954, this.sOs.vGu, "", Integer.valueOf(nzVar.wdo), nzVar.wdr, nzVar.nlV, Integer.valueOf(nzVar.vNG), Integer.valueOf(nzVar.wdq), nzVar.wcy);
                }
            } else if (!(nzVar.kyG == null || nzVar.nqe == null)) {
                com.tencent.mm.plugin.report.service.g.pWK.h(14954, this.sOs.vGu, "", Integer.valueOf(nzVar.wdo), nzVar.wdr, nzVar.nlV, Integer.valueOf(nzVar.vNG), Integer.valueOf(nzVar.wdq), nzVar.nqe, nzVar.kyG);
            }
            x.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.sOs.lUc + " resp.ErrMsg is " + this.sOs.lUd);
            str = this.sOs.lUd;
        }
        this.gLE.a(i, i2, str, this);
    }
}
