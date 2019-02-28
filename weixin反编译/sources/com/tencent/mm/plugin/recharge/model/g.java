package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.bnx;
import com.tencent.mm.protocal.c.bny;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class g extends l {
    private b gLB;
    private e gLE;
    public String mAppId;
    public PayInfo pHW;

    public g(MallRechargeProduct mallRechargeProduct, String str) {
        this(mallRechargeProduct.appId, mallRechargeProduct.pHt, mallRechargeProduct.frQ, str);
    }

    public g(String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.hnT = new bnx();
        aVar.hnU = new bny();
        aVar.uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
        aVar.hnS = 498;
        aVar.hnV = bs.CTRL_INDEX;
        aVar.hnW = 1000000230;
        this.gLB = aVar.Kf();
        bnx bnx = (bnx) this.gLB.hnQ.hnY;
        x.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", str4);
        this.mAppId = str;
        bnx.wnx = str;
        bnx.wnw = str2;
        bnx.wsI = str3;
        bnx.wny = str4;
        bnx.wgO = c.bMQ().NF(str2);
    }

    public final void e(int i, int i2, String str, q qVar) {
        this.pHW = new PayInfo();
        bny bny = (bny) ((b) qVar).hnR.hnY;
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + bny.vPK);
            this.pHW.appId = this.mAppId;
            this.pHW.tgP = bny.wow;
            this.pHW.fvC = bny.vPK;
        }
        if (i2 == 0) {
            i2 = bny.wnz;
        }
        if (bi.oN(str)) {
            str = bny.wnA;
        }
        this.pHW.vGk = String.valueOf(i2);
        this.pHW.foE = str != null ? str : "";
        x.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + i2 + ", errMsg " + str);
        this.gLE.a(i, i2, str, this);
    }

    public final int getType() {
        return 498;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
