package com.tencent.mm.plugin.appbrand.jsapi.f;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.j.h;
import com.tencent.mm.plugin.appbrand.j.i;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e extends a {
    public static final int CTRL_INDEX = 272;
    public static final String NAME = "createUploadTask";

    public static class a extends f {
        public static final int CTRL_INDEX = 274;
        public static final String NAME = "onUploadTaskStateChange";
    }

    static /* synthetic */ boolean b(j jVar, String str) {
        com.tencent.mm.plugin.appbrand.j.f ua = h.aji().ua(jVar.mAppId);
        if (ua == null || !ua.tT(str)) {
            return false;
        }
        x.i("MicroMsg.JsApiCreateUploadTask", "upload abort %s", str);
        return true;
    }

    protected final String agR() {
        StringBuilder stringBuilder = new StringBuilder();
        h.aji();
        return stringBuilder.append(h.ajc()).toString();
    }

    protected final String agS() {
        return "uploadTaskId";
    }

    public final void a(j jVar, JSONObject jSONObject, String str) {
        x.d("MicroMsg.JsApiCreateUploadTask", "JsApiCreateUploadTask");
        String str2 = jVar.mAppId;
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH);
        if (bi.oN(optString)) {
            a(jVar, str, "filePath is null");
            return;
        }
        x.i("MicroMsg.JsApiCreateUploadTask", "tempFilePath " + optString);
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str2, optString);
        if (itemByLocalId == null) {
            a(jVar, str, "fail:file doesn't exist");
            return;
        }
        final String str3 = itemByLocalId.hjJ;
        String str4 = itemByLocalId.mimeType;
        x.i("MicroMsg.JsApiCreateUploadTask", "filePath(%s)", str3);
        final j jVar2 = jVar;
        final String str5 = str;
        com.tencent.mm.plugin.appbrand.j.f.a anonymousClass1 = new com.tencent.mm.plugin.appbrand.j.f.a() {
            public final void sY(String str) {
                if (!e.b(jVar2, str5)) {
                    e.a(jVar2, str5, str);
                }
            }

            public final void c(int i, String str, int i2) {
                if (i == 0) {
                    x.d("MicroMsg.JsApiCreateUploadTask", "success: file name %s, result %s , errMsg %d", str3, str, Integer.valueOf(i));
                    Map hashMap = new HashMap();
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str);
                    hashMap.put("statusCode", Integer.valueOf(i2));
                    hashMap.put("uploadTaskId", str5);
                    hashMap.put("state", "success");
                    String jSONObject = new JSONObject(hashMap).toString();
                    f a = new a().a(jVar2);
                    a.mData = jSONObject;
                    a.afI();
                } else if (!e.b(jVar2, str5)) {
                    x.e("MicroMsg.JsApiCreateUploadTask", "error: file name %s, result %s , errMsg %d", str3, str, Integer.valueOf(i));
                    e.a(jVar2, str5, str);
                }
            }

            public final void g(int i, long j, long j2) {
                Map hashMap = new HashMap();
                hashMap.put("uploadTaskId", str5);
                hashMap.put("state", "progressUpdate");
                hashMap.put("progress", Integer.valueOf(i));
                hashMap.put("totalBytesSent", Long.valueOf(j));
                hashMap.put("totalBytesExpectedToSend", Long.valueOf(j2));
                String jSONObject = new JSONObject(hashMap).toString();
                f a = new a().a(jVar2);
                a.mData = jSONObject;
                a.afI();
            }
        };
        AppBrandSysConfig appBrandSysConfig = jVar.iuk.isS;
        com.tencent.mm.plugin.appbrand.config.a aVar = jVar.iuk.isT;
        Map a = i.a(jSONObject, appBrandSysConfig);
        String optString2 = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bi.oN(optString2)) {
            x.i("MicroMsg.JsApiCreateUploadTask", "url is null");
            a(jVar, str, "url is null or nil");
            return;
        }
        boolean z;
        boolean a2;
        int optInt;
        p b;
        String str6;
        com.tencent.mm.plugin.appbrand.j.f fVar;
        h aji;
        com.tencent.mm.plugin.appbrand.j.f fVar2;
        String str7;
        if (i.d(jVar.iuk.isR)) {
            if (jSONObject.optBoolean("__skipDomainCheck__")) {
                z = true;
                a2 = i.a(appBrandSysConfig, z);
                if (a2 || i.a(appBrandSysConfig.iRO, optString2)) {
                    if (appBrandSysConfig.iRD <= 0) {
                        x.i("MicroMsg.JsApiCreateUploadTask", "concurrent <= 0 ");
                    }
                    optInt = jSONObject.optInt("timeout", 0);
                    if (optInt <= 0) {
                        optInt = i.a(appBrandSysConfig, aVar, 2);
                    }
                    if (optInt <= 0) {
                        optInt = 60000;
                    }
                    if (h.aji().ua(str2) != null) {
                        b = com.tencent.mm.plugin.appbrand.jsapi.e.b(jVar);
                        str6 = null;
                        if (!(b == null || b.jJw == null)) {
                            str6 = b.jJw.jKI;
                        }
                        fVar = new com.tencent.mm.plugin.appbrand.j.f(str2, str6, jVar.iuk.isS);
                        aji = h.aji();
                        if (!aji.jlp.containsKey(str2)) {
                            aji.jlp.put(str2, fVar);
                        }
                        fVar2 = fVar;
                    } else {
                        fVar2 = h.aji().ua(str2);
                    }
                    if (optString.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                        str7 = "wx-file." + itemByLocalId.iKK;
                    } else {
                        str7 = org.a.a.a.a.getName(optString);
                    }
                    if (fVar2 != null) {
                        x.i("MicroMsg.JsApiCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", Boolean.valueOf(a2), Integer.valueOf(optInt));
                        if (a2) {
                            fVar2.a(optInt, str4, str3, jSONObject, a, null, anonymousClass1, str, NAME, str7);
                        }
                        fVar2.a(optInt, str4, str3, jSONObject, a, appBrandSysConfig.iRO, anonymousClass1, str, NAME, str7);
                        return;
                    }
                }
                x.i("MicroMsg.JsApiCreateUploadTask", "not in domain url %s", optString2);
                a(jVar, str, "url not in domain list");
                return;
            }
        }
        z = false;
        a2 = i.a(appBrandSysConfig, z);
        if (a2) {
        }
        if (appBrandSysConfig.iRD <= 0) {
            x.i("MicroMsg.JsApiCreateUploadTask", "concurrent <= 0 ");
        }
        optInt = jSONObject.optInt("timeout", 0);
        if (optInt <= 0) {
            optInt = i.a(appBrandSysConfig, aVar, 2);
        }
        if (optInt <= 0) {
            optInt = 60000;
        }
        if (h.aji().ua(str2) != null) {
            fVar2 = h.aji().ua(str2);
        } else {
            b = com.tencent.mm.plugin.appbrand.jsapi.e.b(jVar);
            str6 = null;
            str6 = b.jJw.jKI;
            fVar = new com.tencent.mm.plugin.appbrand.j.f(str2, str6, jVar.iuk.isS);
            aji = h.aji();
            if (aji.jlp.containsKey(str2)) {
                aji.jlp.put(str2, fVar);
            }
            fVar2 = fVar;
        }
        if (optString.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            str7 = "wx-file." + itemByLocalId.iKK;
        } else {
            str7 = org.a.a.a.a.getName(optString);
        }
        if (fVar2 != null) {
            x.i("MicroMsg.JsApiCreateUploadTask", "before do upload, checkDomains = %b, timeout %d", Boolean.valueOf(a2), Integer.valueOf(optInt));
            if (a2) {
                fVar2.a(optInt, str4, str3, jSONObject, a, appBrandSysConfig.iRO, anonymousClass1, str, NAME, str7);
                return;
            }
            fVar2.a(optInt, str4, str3, jSONObject, a, null, anonymousClass1, str, NAME, str7);
        }
    }

    private static void a(j jVar, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("uploadTaskId", str);
        hashMap.put("state", "fail");
        hashMap.put("errMsg", str2);
        String jSONObject = new JSONObject(hashMap).toString();
        f a = new a().a(jVar);
        a.mData = jSONObject;
        a.afI();
    }
}
