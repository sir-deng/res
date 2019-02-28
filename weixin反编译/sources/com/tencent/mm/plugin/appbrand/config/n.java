package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.protocal.c.buj;
import com.tencent.mm.protocal.c.cw;
import com.tencent.mm.protocal.c.dd;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public enum n {
    ;

    static cw h(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("AppConfig");
        cw cwVar = new cw();
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("VersionList");
            cwVar.vOA = new LinkedList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    buj buj = new buj();
                    buj.type = optJSONObject2.optInt(Columns.TYPE);
                    buj.version = optJSONObject2.optInt("version");
                    cwVar.vOA.add(buj);
                }
            }
        }
        return cwVar;
    }

    static String a(dd ddVar) {
        if (ddVar == null) {
            return "AppRunningFlagInfo{null}";
        }
        return "AppRunningFlagInfo{RunningFlag=" + ddVar.vOU + ", StopServiceTime" + ddVar.vOV + ", AppForbiddenReason" + ddVar.vOW + ", SessionOpenForbiddenReason" + ddVar.vOX + ", TimelineOpenForbiddenReason" + ddVar.vOY + "}";
    }
}
