package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.bey;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 205;
    public static final String NAME = "setUserAutoFillData";

    public final void a(final p pVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData data is invalid");
            pVar.E(i, e("fail:data is invalid", null));
            return;
        }
        String optString = jSONObject.optString("dataList");
        x.i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData appId:%s, dataList:%s", pVar.mAppId, optString);
        b.a aVar = new b.a();
        aVar.hnT = new bey();
        aVar.hnU = new bez();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
        aVar.hnS = 1180;
        aVar.hnV = 0;
        aVar.hnW = 0;
        b Kf = aVar.Kf();
        bey bey = (bey) Kf.hnQ.hnY;
        bey.fGh = r2;
        bey.wvG = optString;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(Kf, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, b bVar) {
                if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                    x.i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData success");
                    pVar.E(i, g.this.e("ok", null));
                    return;
                }
                x.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
                pVar.E(i, g.this.e("fail:cgi fail", null));
            }
        });
    }
}
