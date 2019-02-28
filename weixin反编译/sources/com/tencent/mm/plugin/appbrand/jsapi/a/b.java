package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.rg;
import com.tencent.mm.protocal.c.rh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 206;
    public static final String NAME = "deleteUserAutoFillData";

    public final void a(final p pVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData data is invalid");
            pVar.E(i, e("fail:data is invalid", null));
            return;
        }
        Object optString = jSONObject.optString("groupKey");
        int optInt = jSONObject.optInt("groupId", 0);
        if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData groupKey is invalid");
            pVar.E(i, e("fail:groupKey is invalid", null));
            return;
        }
        x.i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData appId:%s, groupId:%d, groupKey:%s", pVar.mAppId, Integer.valueOf(optInt), optString);
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new rg();
        aVar.hnU = new rh();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
        aVar.hnS = 1194;
        aVar.hnV = 0;
        aVar.hnW = 0;
        com.tencent.mm.ad.b Kf = aVar.Kf();
        rg rgVar = (rg) Kf.hnQ.hnY;
        rgVar.wgc = optString;
        rgVar.fGh = r3;
        rgVar.wgd = optInt;
        rgVar.cPf = 1;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(Kf, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
                if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                    x.i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData success");
                    pVar.E(i, b.this.e("ok", null));
                    return;
                }
                x.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
                pVar.E(i, b.this.e("fail:cgi fail", null));
            }
        });
    }
}
