package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public int cRQ;
    public String fvC;
    public String lnQ;
    public String pin;
    public String sHQ;
    public String sXi;
    public String thP;
    public String thU;
    public String thV;
    public String thX;
    public double tjn;
    public String tjo;
    public double tjp;
    public String tjq;
    public boolean tjr;
    public boolean tjs;
    public String tjt;
    public String tju;
    public String tjv;

    public b(String str, double d, String str2, String str3, String str4, String str5, String str6) {
        this.fvC = str;
        this.tjn = d;
        this.tjo = str2;
        this.sXi = str3;
        this.sHQ = str4;
        this.thP = str5;
        this.pin = str6;
        Map hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str2);
        hashMap.put("bank_type", str3);
        hashMap.put("bind_serial", str4);
        if (!str3.equals("SVA_PAYU")) {
            hashMap.put("cvv", str5);
        }
        hashMap.put("pin", str6);
        D(hashMap);
    }

    public final int bLx() {
        return 9;
    }

    public final boolean isSuccess() {
        return this.tjt.equals("1");
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.lnQ = jSONObject.optString("trans_id");
            this.tjp = jSONObject.optDouble("total_fee") / 100.0d;
            this.tjq = jSONObject.optString("fee_type");
            this.tjr = jSONObject.optBoolean("redirect");
            this.thU = jSONObject.optString("gateway_reference");
            this.thV = jSONObject.optString("gateway_code");
            this.tjt = jSONObject.optString("pay_status");
            this.cRQ = jSONObject.optInt("timestamp");
            this.tju = jSONObject.optString("pay_status_name");
            this.tjv = jSONObject.optString("bank_type");
            this.tjs = jSONObject.optBoolean("is_force_adjust");
            this.thX = jSONObject.optString("force_adjust_code");
        }
    }
}
