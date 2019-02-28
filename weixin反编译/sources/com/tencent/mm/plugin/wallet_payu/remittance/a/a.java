package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String fHE;
    public String fqK;
    public String fvC;
    public double pTQ;
    public String pin;
    public String sHQ;
    public int thT;
    public int tjS;
    public double tjT;
    public String tjU;

    public a(String str, String str2, double d, String str3, int i, String str4, String str5, String str6) {
        this.fvC = str;
        this.pin = str2;
        this.pTQ = d;
        this.fqK = str3;
        this.tjS = i == 2 ? 0 : i;
        this.fHE = str4;
        this.sHQ = str5;
        Map hashMap = new HashMap();
        hashMap.put("pin", str2);
        hashMap.put("req_key", str);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str3);
        hashMap.put("transfer_type", String.valueOf(i));
        hashMap.put("target_username", str4);
        hashMap.put("bind_serial", str5);
        hashMap.put("transfer_qrcode_id", str6);
        D(hashMap);
    }

    public final int bLx() {
        return 14;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.thT = jSONObject.optInt("response_result");
        this.tjT = bi.getDouble(jSONObject.optString("total_fee"), 0.0d);
        this.tjU = jSONObject.optString("fee_type");
    }
}
