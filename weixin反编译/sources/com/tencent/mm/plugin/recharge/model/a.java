package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class a {
    public static final int[] pHo = new int[]{-1, -1};
    public static final int[] pHp = new int[]{-2, -2};
    public int fqY;
    public String name;
    public String pHq;
    public String pHr;
    public int[] pHs;

    public a(String str, String str2, int i) {
        this(str, str2, "", i);
    }

    public a(String str, String str2, String str3, int i) {
        this.pHs = pHo;
        this.pHq = str;
        this.name = str2;
        this.pHr = str3;
        this.fqY = i;
    }

    public final JSONObject bna() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("record", bi.aD(this.pHq, ""));
            jSONObject.put("name", bi.aD(this.name, ""));
            jSONObject.put("location", bi.aD(this.pHr, ""));
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallInputRecord", e, "", new Object[0]);
            return null;
        }
    }

    public static a S(JSONObject jSONObject) {
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("record");
        String optString3 = jSONObject.optString("location");
        if (bi.oN(optString2)) {
            return null;
        }
        return new a(optString2, optString, optString3, 2);
    }
}
