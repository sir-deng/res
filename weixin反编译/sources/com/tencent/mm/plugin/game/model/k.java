package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class k {
    JSONObject nhr = new JSONObject();

    protected k(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.GameServerData", "Null or nil json string");
            return;
        }
        try {
            this.nhr = new JSONObject(str);
        } catch (JSONException e) {
            x.e("MicroMsg.GameServerData", "Json parsing error");
        }
    }

    protected final JSONArray optJSONArray(String str) {
        return this.nhr.optJSONArray(str);
    }

    private static String f(JSONObject jSONObject, String str) {
        if (jSONObject == null || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    protected static LinkedList<d> n(JSONArray jSONArray) {
        LinkedList<d> linkedList = new LinkedList();
        if (jSONArray == null || jSONArray.length() == 0) {
            x.i("MicroMsg.GameServerData", "Null or empty json array");
            return linkedList;
        }
        x.i("MicroMsg.GameServerData", "Parsing json AppInfo, size: %d", Integer.valueOf(jSONArray.length()));
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj;
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                x.e("MicroMsg.GameServerData", "Invalid json object");
                obj = null;
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("YYB");
                String f = f(optJSONObject, "appID");
                if (bi.oN(f)) {
                    x.e("MicroMsg.GameServerData", "No AppID field, abort");
                    obj = null;
                } else {
                    x.i("MicroMsg.GameServerData", "Parsing AppID: %s", f);
                    obj = new d();
                    obj.field_appId = f;
                    obj.field_appName = f(optJSONObject, "name");
                    obj.field_appIconUrl = f(optJSONObject, "iconURL");
                    obj.field_appType = ",1,";
                    obj.field_packageName = f(optJSONObject, "AndroidPackageName");
                    obj.cO(f(optJSONObject, "downloadURL"));
                    obj.cR(f(optJSONObject, "AndroidApkMd5"));
                    f = f(optJSONObject, "GooglePlayDownloadUrl");
                    int optInt = optJSONObject.optInt("GooglePlayDownloadFlag");
                    obj.cS(f);
                    if (!bi.oN(f)) {
                        x.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", f, Integer.valueOf(optInt));
                        obj.ev(optInt);
                    }
                    if (optJSONObject2 != null) {
                        obj.ev(optJSONObject2.optInt("AndroidDownloadFlag"));
                    }
                    if (optJSONObject2 != null) {
                        obj.cX(f(optJSONObject2, "DownloadUrl"));
                        obj.cY(f(optJSONObject2, "ApkMd5"));
                        obj.cV(f(optJSONObject2, "PreemptiveUrl"));
                        obj.cW(f(optJSONObject2, "ExtInfo"));
                        obj.ew(optJSONObject2.optInt("SupportedVersionCode"));
                    }
                    obj.ngz = f(optJSONObject, "desc");
                    obj.ngy = f(optJSONObject, "brief");
                    obj.type = optJSONObject.optInt(Columns.TYPE, 0);
                    obj.status = optJSONObject.optInt(DownloadInfo.STATUS);
                    obj.ngB = f(optJSONObject, "webURL");
                    obj.ngC = f(optJSONObject, "adUrl");
                    obj.fpi = f(optJSONObject, "noticeid");
                    obj.ngD = optJSONObject.optBoolean("isSubscribed");
                    obj.versionCode = optJSONObject.optInt(DownloadInfoColumns.VERSIONCODE);
                    if (optJSONObject2 != null) {
                        obj.ngE = f(optJSONObject2, "DownloadTipsWording");
                        obj.ngF = f(optJSONObject2, "BackBtnWording");
                        obj.ngG = f(optJSONObject2, "DownloadBtnWording");
                    }
                }
            }
            if (obj != null) {
                linkedList.add(obj);
            }
        }
        return linkedList;
    }
}
