package com.tencent.d.a.c;

import org.json.JSONException;
import org.json.JSONObject;

public final class i {
    private long AlB = -1;
    private String AlE = null;
    public String AlF = null;
    private String AlG = "";
    private String AlH = "";
    private String AlI = "";
    private String AlJ = "";
    private String AlK = "";
    public int AlL = 20;
    public String AlM = "";
    public String signature = "";

    public final String toString() {
        return "SoterSignatureResult{rawValue='" + this.AlE + '\'' + ", fid='" + this.AlF + '\'' + ", counter=" + this.AlB + ", TEEName='" + this.AlG + '\'' + ", TEEVersion='" + this.AlH + '\'' + ", FpName='" + this.AlI + '\'' + ", FpVersion='" + this.AlJ + '\'' + ", cpuId='" + this.AlK + '\'' + ", saltLen=" + this.AlL + ", jsonValue='" + this.AlM + '\'' + ", signature='" + this.signature + '\'' + '}';
    }

    public static i acj(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            i iVar = new i();
            iVar.AlM = str;
            iVar.AlE = jSONObject.optString("raw");
            iVar.AlF = jSONObject.optString("fid");
            iVar.AlB = jSONObject.optLong("counter");
            iVar.AlG = jSONObject.optString("tee_n");
            iVar.AlH = jSONObject.optString("tee_v");
            iVar.AlI = jSONObject.optString("fp_n");
            iVar.AlJ = jSONObject.optString("fp_v");
            iVar.AlK = jSONObject.optString("cpu_id");
            iVar.AlL = jSONObject.optInt("rsa_pss_saltlen", 20);
            return iVar;
        } catch (JSONException e) {
            c.e("Soter.SoterSignatureResult", "soter: convert from json failed." + e.toString(), new Object[0]);
            return null;
        }
    }
}
