package com.tencent.mm.plugin.appbrand.jsapi;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ad.b;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.protocal.c.btr;
import com.tencent.mm.protocal.c.bts;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bq extends a {
    public static final int CTRL_INDEX = 313;
    public static final String NAME = "verifyPlugin";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null || jSONObject.opt(SlookAirButtonFrequentContactAdapter.DATA) == null) {
            jVar.E(i, e("fail:data is null or nil", null));
            return;
        }
        String str = jVar.mAppId;
        a btr = new btr();
        b.a aVar = new b.a();
        aVar.hnT = btr;
        aVar.hnU = new bts();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/verifyplugin";
        aVar.hnS = 1714;
        aVar.hnV = 0;
        aVar.hnW = 0;
        btr.fGh = str;
        btr.xbs = jSONObject.opt(SlookAirButtonFrequentContactAdapter.DATA).toString();
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.Kf(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, b bVar) {
                boolean z = true;
                if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                    bts bts = (bts) bVar.hnR.hnY;
                    Map hashMap = new HashMap();
                    try {
                        hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, new JSONObject(bts.xbt));
                        jVar.E(i, bq.this.e("ok", hashMap));
                        return;
                    } catch (Exception e) {
                        jVar.E(i, bq.this.e("fail:resp invalid", null));
                        return;
                    }
                }
                String str2 = "MicroMsg.JsApiVerifyPlugin";
                String str3 = "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %b";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = str;
                if (bVar.hnR.hnY != null) {
                    z = false;
                }
                objArr[3] = Boolean.valueOf(z);
                x.e(str2, str3, objArr);
                jVar.E(i, bq.this.e("fail:cgi fail", null));
            }
        });
    }
}
