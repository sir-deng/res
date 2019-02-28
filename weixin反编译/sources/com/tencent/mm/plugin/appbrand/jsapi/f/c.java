package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.j.e;
import com.tencent.mm.plugin.appbrand.j.i;
import com.tencent.mm.plugin.appbrand.jsapi.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class c extends a {
    public static final int CTRL_INDEX = 242;
    public static final String NAME = "createRequestTask";

    public static class a extends f {
        public static final int CTRL_INDEX = 244;
        public static final String NAME = "onRequestTaskStateChange";
    }

    protected final String agR() {
        StringBuilder stringBuilder = new StringBuilder();
        e.ajg();
        return stringBuilder.append(e.ajc()).toString();
    }

    protected final String agS() {
        return "requestTaskId";
    }

    public final void a(j jVar, JSONObject jSONObject, String str) {
        x.d("MicroMsg.JsApiCreateRequestTask", "JsApiCreateRequestTask");
        final long currentTimeMillis = System.currentTimeMillis();
        final j jVar2 = jVar;
        final String str2 = str;
        AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.j.c.a() {
            public final void sX(String str) {
                int i;
                String str2 = "MicroMsg.JsApiCreateRequestTask";
                String str3 = "onRequestResult, time: %d, data size: %d";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                if (str == null) {
                    i = 0;
                } else {
                    i = str.length();
                }
                objArr[1] = Integer.valueOf(i);
                x.d(str2, str3, objArr);
                com.tencent.mm.plugin.appbrand.j.c tY = e.ajg().tY(jVar2.mAppId);
                if (tY == null || !tY.tT(str2)) {
                    c.a(jVar2, str2, str);
                    return;
                }
                x.d("MicroMsg.JsApiCreateRequestTask", "request abort %s", str2);
            }

            public final void a(String str, Object obj, int i, JSONObject jSONObject) {
                int length;
                if (obj != null && (obj instanceof ByteBuffer)) {
                    length = ((ByteBuffer) obj).array().length;
                } else if (obj == null || !(obj instanceof String)) {
                    length = 0;
                } else {
                    length = ((String) obj).length();
                }
                x.d("MicroMsg.JsApiCreateRequestTask", "onRequestResult, time: %d, data size: %d, code %s,reqrestId %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(length), Integer.valueOf(i), str2);
                Map hashMap = new HashMap();
                hashMap.put("requestTaskId", str2);
                if (str.equalsIgnoreCase("ok")) {
                    hashMap.put("state", "success");
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, obj);
                } else {
                    hashMap.put("state", "fail");
                }
                hashMap.put("statusCode", Integer.valueOf(i));
                if (jSONObject != null) {
                    hashMap.put("header", jSONObject);
                }
                b aVar = new a();
                if ((obj != null && (obj instanceof String)) || l.a(jVar2, hashMap, aVar)) {
                    String jSONObject2 = new JSONObject(hashMap).toString();
                    f a = aVar.a(jVar2);
                    a.mData = jSONObject2;
                    a.afI();
                }
            }
        };
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bi.oN(optString)) {
            x.e("MicroMsg.JsApiCreateRequestTask", "url is null");
            a(jVar, str, "url is null or nil");
            return;
        }
        AppBrandSysConfig appBrandSysConfig = jVar.iuk.isS;
        com.tencent.mm.plugin.appbrand.config.a aVar = jVar.iuk.isT;
        int optInt = jSONObject.optInt("timeout", 0);
        if (optInt <= 0) {
            optInt = i.a(appBrandSysConfig, aVar, 0);
        }
        if (optInt <= 0) {
            optInt = 60000;
        }
        if (appBrandSysConfig.iRC <= 0) {
            x.i("MicroMsg.JsApiCreateRequestTask", "maxRequestConcurrent <= 0 use default concurrent");
        }
        Map a = i.a(jSONObject, appBrandSysConfig);
        boolean z = i.d(jVar.iuk.isR) && jSONObject.optBoolean("__skipDomainCheck__");
        boolean a2 = i.a(appBrandSysConfig, z);
        if (!a2 || i.a(appBrandSysConfig.iRM, optString)) {
            com.tencent.mm.plugin.appbrand.j.c cVar;
            if (e.ajg().tY(jVar.mAppId) == null) {
                p b = com.tencent.mm.plugin.appbrand.jsapi.e.b(jVar);
                String str3 = null;
                if (!(b == null || b.jJw == null)) {
                    str3 = b.jJw.jKI;
                }
                com.tencent.mm.plugin.appbrand.j.c cVar2 = new com.tencent.mm.plugin.appbrand.j.c(jVar.mAppId, str3, jVar.iuk.isS);
                e ajg = e.ajg();
                String str4 = jVar.mAppId;
                if (!ajg.jlp.containsKey(str4)) {
                    ajg.jlp.put(str4, cVar2);
                }
                cVar = cVar2;
            } else {
                cVar = e.ajg().tY(jVar.mAppId);
            }
            x.i("MicroMsg.JsApiCreateRequestTask", "request url: %s", optString);
            if (cVar == null) {
                a(jVar, str, "create request error");
                return;
            } else if (a2) {
                cVar.a(jVar, this, optInt, jSONObject, a, appBrandSysConfig.iRM, anonymousClass1, str, NAME);
                return;
            } else {
                x.i("MicroMsg.JsApiCreateRequestTask", "debug type, do not verify domains");
                cVar.a(jVar, this, optInt, jSONObject, a, null, anonymousClass1, str, NAME);
                return;
            }
        }
        x.i("MicroMsg.JsApiCreateRequestTask", "not in domain url %s", optString);
        a(jVar, str, "url not in domain list");
    }

    private static void a(j jVar, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("requestTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        String jSONObject = new JSONObject(hashMap).toString();
        f a = new a().a(jVar);
        a.mData = jSONObject;
        a.afI();
    }
}
