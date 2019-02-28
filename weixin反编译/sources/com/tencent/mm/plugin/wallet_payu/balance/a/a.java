package com.tencent.mm.plugin.wallet_payu.balance.a;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String fqK;
    public String fvC;
    public double pTQ;

    public a(double d, String str) {
        this.pTQ = d;
        this.fqK = str;
        Map hashMap = new HashMap();
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        D(hashMap);
    }

    public final int bLx() {
        return 20;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.fvC = jSONObject.optString("prepayid");
    }
}
