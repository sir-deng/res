package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

abstract class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    abstract boolean l(Context context, String str, String str2);

    abstract boolean sP(String str);

    a() {
    }

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        final String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH, "");
        if (bi.oN(optString)) {
            jVar.E(i, e("fail filePath invalid", null));
        } else {
            c.Dt().F(new Runnable() {
                public final void run() {
                    j jVar;
                    int i;
                    e eVar;
                    String str;
                    AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(jVar.mAppId, optString);
                    if (itemByLocalId == null || bi.oN(itemByLocalId.hjJ)) {
                        jVar = jVar;
                        i = i;
                        eVar = a.this;
                        str = "fail file not exists";
                    } else if (a.this.sP(itemByLocalId.mimeType)) {
                        boolean z = false;
                        if (jVar.Vx) {
                            Context a = a.this.a(jVar);
                            if (a != null) {
                                z = a.this.l(a, itemByLocalId.hjJ, itemByLocalId.mimeType);
                            }
                        }
                        jVar = jVar;
                        i = i;
                        eVar = a.this;
                        str = z ? "ok" : "fail";
                    } else {
                        jVar.E(i, a.this.e("fail invalid file type", null));
                        return;
                    }
                    jVar.E(i, eVar.e(str, null));
                }
            });
        }
    }
}
