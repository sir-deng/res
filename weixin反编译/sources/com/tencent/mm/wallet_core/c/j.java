package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.protocal.c.ayz;
import com.tencent.mm.protocal.c.aza;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends l {
    public final b gLB;
    private e gLE;
    public String lEs;
    public String tgL;
    public String tgM;

    public j(String str, String str2, String str3, int i, int i2, String str4) {
        a aVar = new a();
        aVar.hnT = new ayz();
        aVar.hnU = new aza();
        aVar.uri = "/cgi-bin/micromsg-bin/preparepurchase";
        aVar.hnV = JsApiCheckIsSupportFaceDetect.CTRL_INDEX;
        aVar.hnW = 1000000214;
        this.gLB = aVar.Kf();
        ayz ayz = (ayz) this.gLB.hnQ.hnY;
        this.lEs = str;
        ayz.vPI = str;
        this.tgM = str2;
        ayz.wMx = str2;
        this.tgL = str3;
        ayz.wMy = str3;
        ayz.pgW = i2;
        ayz.wMz = i;
        ayz.nqi = str4;
        x.d("MicroMsg.NetScenePreparePurchase", "productId:" + str + ",price:" + str2 + ",currencyType:" + str3 + ",payType:" + i2);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.e("MicroMsg.NetScenePreparePurchase", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            this.gLE.a(i, i2, str, this);
        } else {
            this.gLE.a(i, i2, str, this);
        }
    }

    public final int getType() {
        return 422;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
