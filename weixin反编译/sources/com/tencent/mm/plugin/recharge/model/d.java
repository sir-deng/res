package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.c.ado;
import com.tencent.mm.protocal.c.adp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import org.json.JSONObject;

public final class d extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;
    public String int;
    public int pHA;
    public MallRechargeProduct pHD = null;
    public List<MallRechargeProduct> pHE = null;
    public String pHF;
    public String pHt;
    public String pHu = null;

    public d(int i, String str, String str2, String str3, String str4, String str5) {
        this.pHt = str;
        this.pHA = i;
        this.int = str5;
        this.pHF = str2;
        a aVar = new a();
        aVar.hnT = new ado();
        aVar.hnU = new adp();
        aVar.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
        aVar.hnS = 497;
        aVar.hnV = be.CTRL_INDEX;
        aVar.hnW = 1000000229;
        this.gLB = aVar.Kf();
        ado ado = (ado) this.gLB.hnQ.hnY;
        ado.wnw = str;
        ado.wnx = str3;
        ado.wsI = str2;
        ado.wny = str4;
        ado.wgO = c.bMQ().NF(str);
        x.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[]{str, str3, str2, str4}));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + i3 + ", errMsg " + str);
        adp adp = (adp) ((b) qVar).hnR.hnY;
        x.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + adp.wnB);
        String str2 = adp.wnB;
        this.pHu = "";
        if (!bi.oN(str2)) {
            String[] split = str2.split("&");
            if (split != null && split.length > 0) {
                Object obj = 1;
                for (String split2 : split) {
                    String[] split3 = split2.split("=");
                    if (split3.length == 2) {
                        if (obj == null) {
                            this.pHu += " ";
                        } else {
                            obj = null;
                        }
                        this.pHu += split3[1];
                    }
                }
            }
        }
        if (!bi.oN(adp.wsK)) {
            try {
                this.pHE = b.a(this.pHt, new JSONObject(adp.wsK).optJSONArray("product_info"));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e, "", new Object[0]);
            }
        }
        if (i2 == 0 && i3 == 0) {
            str2 = adp.wsJ;
            x.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product " + str2);
            if (!bi.oN(str2)) {
                try {
                    this.pHD = b.d(this.pHt, new JSONObject(str2));
                    this.pHD.pHu = this.pHu;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e2, "", new Object[0]);
                }
            }
        }
        x.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[]{Integer.valueOf(adp.wnz), adp.wnA, Integer.valueOf(adp.wnC), adp.wnD}));
        if (i3 == 0) {
            if (adp.wnC != 0) {
                i3 = adp.wnC;
            } else {
                i3 = adp.wnz;
            }
        }
        if (bi.oN(str)) {
            if (bi.oN(adp.wnD)) {
                str = adp.wnA;
            } else {
                str = adp.wnD;
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 497;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
