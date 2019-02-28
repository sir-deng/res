package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.r.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

abstract class d implements f {
    e jmL = this;

    abstract a a(j jVar, String str, JSONObject jSONObject);

    d() {
    }

    static {
        e.a.init();
    }

    public final a b(j jVar, JSONObject jSONObject) {
        String p = p(jSONObject);
        if (bi.oN(p)) {
            return new a("fail invalid path", new Object[0]);
        }
        if (jVar.iuk.mFinished) {
            return new a("fail:interrupted", new Object[0]);
        }
        a a = a(jVar, p, jSONObject);
        l.a(jVar, a.values, this.jmL);
        return a;
    }

    protected String p(JSONObject jSONObject) {
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH, null);
        if (bi.oN(optString)) {
            optString = jSONObject.optString("dirPath", null);
        }
        if (bi.oN(optString)) {
            return jSONObject.optString("path", null);
        }
        return optString;
    }
}
