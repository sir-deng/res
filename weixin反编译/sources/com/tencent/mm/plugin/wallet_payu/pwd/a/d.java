package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public String fAK;
    public String tjO;
    public String tjP;

    public d(String str, String str2) {
        this.tjO = str;
        this.tjP = str2;
        Map hashMap = new HashMap();
        hashMap.put("payu_reference", str);
        hashMap.put("new_pin", str2);
        D(hashMap);
    }

    public final int bLx() {
        return 19;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.fAK = jSONObject.optString("payu_reference");
    }
}
