package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.protocal.c.aet;
import com.tencent.mm.protocal.c.aeu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONObject;

public final class e extends k implements com.tencent.mm.network.k {
    private b gLB;
    private com.tencent.mm.ad.e gLE;
    public ArrayList<MallRechargeProduct> pHG = null;
    public String pHH;
    public String pHI;
    public String pHJ;
    public String pHK;
    public String pHt;

    public e(String str) {
        a aVar = new a();
        aVar.hnT = new aet();
        aVar.hnU = new aeu();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
        aVar.hnS = 496;
        aVar.hnV = JsApiOpenWeRunSetting.CTRL_INDEX;
        aVar.hnW = 1000000228;
        this.gLB = aVar.Kf();
        aet aet = (aet) this.gLB.hnQ.hnY;
        this.pHt = str;
        aet.wnw = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            aeu aeu = (aeu) ((b) qVar).hnR.hnY;
            String str2 = aeu.wsK;
            x.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList " + str2);
            if (!bi.oN(str2)) {
                try {
                    this.pHG = b.a(this.pHt, new JSONObject(str2).getJSONArray("pay_product_list"));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e, "", new Object[0]);
                }
            }
            if (!bi.oN(aeu.wtO)) {
                try {
                    JSONObject jSONObject = new JSONObject(aeu.wtO);
                    this.pHH = jSONObject.optString("balance_link");
                    this.pHJ = jSONObject.optString("recharge_link");
                    this.pHI = jSONObject.optString("balance_wording");
                    this.pHK = jSONObject.optString("recharge_wording");
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e2, "", new Object[0]);
                }
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 496;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
