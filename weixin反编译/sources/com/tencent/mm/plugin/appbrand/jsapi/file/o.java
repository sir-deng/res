package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o extends a {
    private static final int CTRL_INDEX = 115;
    private static final String NAME = "getSavedFileList";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        List<AppBrandLocalMediaObject> listStoredFiles = AppBrandLocalMediaObjectManager.listStoredFiles(jVar.mAppId);
        JSONArray jSONArray = new JSONArray();
        if (!bi.cC(listStoredFiles)) {
            for (AppBrandLocalMediaObject appBrandLocalMediaObject : listStoredFiles) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(DownloadInfoColumns.FILEPATH, appBrandLocalMediaObject.fvn);
                    jSONObject2.put("size", appBrandLocalMediaObject.igZ);
                    jSONObject2.put("createTime", TimeUnit.MILLISECONDS.toSeconds(appBrandLocalMediaObject.iKM));
                    jSONArray.put(jSONObject2);
                } catch (Exception e) {
                }
            }
        }
        Map hashMap = new HashMap(1);
        hashMap.put("fileList", jSONArray);
        jVar.E(i, e("ok", hashMap));
    }
}
