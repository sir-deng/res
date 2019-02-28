package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class ac extends a {
    public static final int CTRL_INDEX = 51;
    public static final String NAME = "saveFile";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        f.a c = c(jVar, jSONObject);
        jVar.E(i, e(c.foE, c.values));
    }

    static f.a c(j jVar, JSONObject jSONObject) {
        String str = jVar.mAppId;
        String optString = jSONObject.optString("tempFilePath");
        String optString2 = jSONObject.optString(DownloadInfoColumns.FILEPATH);
        if (bi.oN(optString)) {
            x.e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
            return new f.a("fail", new Object[0]);
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, optString);
        boolean z = itemByLocalId != null && e.bO(itemByLocalId.hjJ);
        x.i("MicroMsg.JsApiSaveFile", "get temp obj = %s, fileExists = %b", itemByLocalId, Boolean.valueOf(z));
        if (!z || bi.oN(itemByLocalId.hjJ)) {
            return new f.a("fail tempFilePath file not exist", new Object[0]);
        }
        Map map;
        if (!bi.oN(optString2)) {
            str = a(jVar.iuk, itemByLocalId.hjJ, optString2);
            map = null;
            if ("ok".equals(str)) {
                map = new HashMap();
                map.put("savedFilePath", optString2);
            }
            return new f.a(str, new Object[0]).w(map);
        } else if (itemByLocalId.iKL) {
            return new f.a("ok", new Object[0]);
        } else {
            x.i("MicroMsg.JsApiSaveFile", "before markPermanent, quota = %d, occupation = %d, fileLength = %d", Long.valueOf(com.tencent.mm.plugin.appbrand.config.j.re(str)), Long.valueOf(AppBrandLocalMediaObjectManager.getStoredFilesOccupation(str)), Long.valueOf(new File(itemByLocalId.hjJ).length()));
            if (AppBrandLocalMediaObjectManager.getStoredFilesOccupation(str) + new File(itemByLocalId.hjJ).length() > com.tencent.mm.plugin.appbrand.config.j.re(str)) {
                return new f.a(String.format(Locale.US, "fail:exceed quota %dM", new Object[]{Long.valueOf(r4 / 1048576)}), new Object[0]);
            }
            AppBrandLocalMediaObject markPermanent = AppBrandLocalMediaObjectManager.markPermanent(jVar.mAppId, itemByLocalId);
            optString2 = "MicroMsg.JsApiSaveFile";
            String str2 = "after markPermanent, (obj==null): %b, obj.localId: %s, obj.path: %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(markPermanent == null);
            objArr[1] = markPermanent == null ? null : markPermanent.fvn;
            objArr[2] = markPermanent == null ? null : markPermanent.hjJ;
            x.i(optString2, str2, objArr);
            if (markPermanent == null || bi.oN(markPermanent.fvn) || bi.oN(markPermanent.hjJ)) {
                return new f.a("fail", new Object[0]);
            }
            map = new HashMap(1);
            map.put("savedFilePath", markPermanent.fvn);
            return new f.a("ok", new Object[0]).w(map);
        }
    }

    public static String a(com.tencent.mm.plugin.appbrand.e eVar, String str, String str2) {
        com.tencent.mm.plugin.appbrand.appstorage.j qp = eVar.isU.qp(str2);
        if (qp == com.tencent.mm.plugin.appbrand.appstorage.j.RET_NOT_EXISTS || qp == com.tencent.mm.plugin.appbrand.appstorage.j.ERR_IS_FILE) {
            try {
                qp = eVar.isU.d(str2, new FileInputStream(str));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiSaveFile", e, "saveToNewFS", new Object[0]);
                return "fail read tempFilePath error";
            }
        }
        switch (qp) {
            case ERR_PERMISSION_DENIED:
                return String.format("fail permission denied, open \"%s\"", new Object[]{str2});
            case ERR_PARENT_DIR_NOT_EXISTS:
                return String.format("fail no such file or directory \"%s\"", new Object[]{str2});
            case ERR_IS_DIRECTORY:
                return String.format("fail illegal operation on a directory, open \"%s\"", new Object[]{str2});
            case OK:
                return "ok";
            default:
                return "fail " + qp.name();
        }
    }
}
