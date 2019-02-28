package com.tencent.mm.plugin.wallet_index.c.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.awz;
import com.tencent.mm.protocal.c.axa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class a extends l {
    private b gLB;
    private e gLE;
    public String jumpUrl;
    public String prepayId;
    public String tgP;
    public String tha;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new awz();
        aVar.hnU = new axa();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggenprepay";
        this.gLB = aVar.Kf();
        awz awz = (awz) this.gLB.hnQ.hnY;
        awz.nlV = str;
        awz.wdl = str4;
        awz.wdk = str2;
        awz.wdm = str5;
        awz.wdn = str6;
        awz.vSO = str3;
        awz.wcy = str7;
        awz.wou = str8;
        awz.vKK = i;
        x.d("MicroMsg.NetSceneIbgPayGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str2, str5, str6, str3, str7, str8}));
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay raw net errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        axa axa = (axa) ((b) qVar).hnR.hnY;
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url. biz_errcode: %d, biz_errmsg: %s", Integer.valueOf(axa.lUc), axa.lUd);
            str = axa.lUd;
            i2 = axa.lUc;
            this.jumpUrl = axa.nkN;
            this.prepayId = axa.wov;
            this.tgP = axa.wow;
            this.tha = axa.wKZ;
        } else {
            x.e("MicroMsg.NetSceneIbgPayGenPrepay", "hy: gen ibg prepay jump url failed");
            this.jumpUrl = null;
        }
        if (bi.oN(str)) {
            str = ad.getContext().getString(i.uXI);
        }
        this.gLE.a(i, i2, str, this);
    }

    public final int getType() {
        return 1563;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
