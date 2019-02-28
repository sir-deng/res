package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import java.util.List;
import org.json.JSONArray;

public final class c {
    public List<b> jAZ = null;
    public String jhM = "ok";

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mErrorMsg:");
        stringBuilder.append(this.jhM);
        stringBuilder.append(" mWifiList:");
        if (this.jAZ == null || this.jAZ.size() <= 0) {
            stringBuilder.append("null:");
        } else {
            for (b bVar : this.jAZ) {
                stringBuilder.append(" WiFiItem:");
                stringBuilder.append(bVar);
            }
        }
        return stringBuilder.toString();
    }

    public final JSONArray ain() {
        JSONArray jSONArray = new JSONArray();
        for (b sO : this.jAZ) {
            jSONArray.put(sO.sO());
        }
        return jSONArray;
    }
}
