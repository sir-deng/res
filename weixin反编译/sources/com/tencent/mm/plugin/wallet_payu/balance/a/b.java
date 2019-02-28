package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String fqK;
    public String fvC;
    public boolean isRedirect;
    public String lnQ;
    public double pTQ;
    public String pin;
    public String thP;
    public String thQ;
    public String thR;
    public String thS;
    public int thT;
    public String thU;
    public String thV;
    public boolean thW;
    public String thX;

    public b(String str, String str2, String str3, double d, String str4, String str5, String str6, String str7) {
        this.pin = str;
        this.thP = str2;
        this.fvC = str3;
        this.pTQ = d;
        this.fqK = str4;
        this.thQ = str5;
        this.thR = str6;
        this.thS = str7;
        Map hashMap = new HashMap();
        hashMap.put("pin", str);
        hashMap.put("bind_serial", str5);
        hashMap.put("req_key", str3);
        hashMap.put("fee_type", str4);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("bank_type", str6);
        hashMap.put("cvv", str2);
        hashMap.put("dest_bind_serial", str7);
        D(hashMap);
    }

    public final int bLx() {
        return 10;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.lnQ = jSONObject.optString("trans_id");
        this.thT = jSONObject.optInt("response_result");
        this.isRedirect = jSONObject.optBoolean("redirect");
        this.thU = jSONObject.optString("gateway_reference");
        this.thV = jSONObject.optString("gateway_code");
        this.thW = jSONObject.optBoolean("is_force_adjust");
        this.thX = jSONObject.optString("force_adjust_code");
    }
}
