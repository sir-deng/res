package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ac extends i {
    public String sOM;
    public String sOX;

    public ac(p pVar, String str) {
        Map hashMap = new HashMap();
        hashMap.put("verify_code", pVar.sVt);
        hashMap.put("token", pVar.token);
        hashMap.put("passwd", pVar.sVs);
        hashMap.put("relation_key", str);
        D(hashMap);
    }

    public final int azx() {
        return 124;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null && i == 0) {
            this.sOM = jSONObject.optString("token_type");
            this.sOX = jSONObject.optString("usertoken");
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankverifysms";
    }

    public final int Hx() {
        return 1604;
    }
}
