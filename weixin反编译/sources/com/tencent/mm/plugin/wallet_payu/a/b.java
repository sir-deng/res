package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String fAK;
    public boolean tiW;
    public String tiy;
    public String tiz;

    public b(String str, String str2) {
        this.tiy = str;
        this.tiz = str2;
        Map hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        D(hashMap);
    }

    public final int bLx() {
        return 12;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetScenePayUGenerateOtp", "hy: get NetScenePayUGenerateOtp info. errCode: %d, errMsg:%s, json:%s", Integer.valueOf(i), str, jSONObject.toString());
        this.tiW = jSONObject.optBoolean("has_mobile");
        this.fAK = jSONObject.optString("payu_reference");
    }
}
