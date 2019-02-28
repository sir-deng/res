package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.AnonymousClass4;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_INDEX = 218;
    public static final String NAME = "sendBizRedPacket";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", jVar.mAppId);
            a aVar = a.jsn;
            b.a anonymousClass1 = new b.a() {
                public final void a(int i, String str, Map<String, Object> map) {
                    switch (i) {
                        case 1:
                            jVar.E(i, h.this.e("ok", null));
                            return;
                        case 2:
                            if (bi.oN(str)) {
                                jVar.E(i, h.this.e("fail", null));
                                return;
                            }
                            jVar.E(i, h.this.e(String.format("fail %s", new Object[]{str}), null));
                            return;
                        default:
                            jVar.E(i, h.this.e("cancel", null));
                            return;
                    }
                }
            };
            g gVar = new g(jSONObject);
            gVar.frE = 16;
            MMActivity.a anonymousClass4 = new AnonymousClass4(anonymousClass1);
            Intent intent = new Intent();
            intent.putExtra("key_way", 3);
            intent.putExtra("appId", gVar.appId);
            intent.putExtra("timeStamp", gVar.timeStamp);
            intent.putExtra("nonceStr", gVar.nonceStr);
            intent.putExtra("packageExt", gVar.packageExt);
            intent.putExtra("signtype", gVar.signType);
            intent.putExtra("paySignature", gVar.fDO);
            intent.putExtra("key_static_from_scene", 100004);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, gVar.url);
            a.jCj = anonymousClass4;
            d.a(a, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent, aVar.hashCode() & 65535, false);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiSendBizRedPacket", e.getMessage());
            jVar.E(i, e("fail", null));
        }
    }
}
