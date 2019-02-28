package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import org.json.JSONObject;

public final class b {
    public String jAT = "";
    public String jAU = "";
    public int jAV;
    public boolean jAW = false;
    public boolean jAX = false;
    public boolean jAY = false;

    public final String toString() {
        return "WiFiItem{mSsid='" + this.jAT + '\'' + ", mBssid='" + this.jAU + '\'' + ", mSignalStrength=" + this.jAV + ", mSecurity=" + this.jAW + '}';
    }

    public final JSONObject sO() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SSID", this.jAT);
        jSONObject.put("BSSID", this.jAU);
        jSONObject.put("secure", this.jAW);
        jSONObject.put("signalStrength", this.jAV);
        return jSONObject;
    }
}
