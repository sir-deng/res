package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public String fAK;
    public String id;
    public boolean mkY;
    public String oik;
    public String tkj;

    public b(String str, String str2, String str3) {
        this.id = str2;
        this.oik = str3;
        this.fAK = str;
        Map hashMap = new HashMap();
        hashMap.put(SlookAirButtonFrequentContactAdapter.ID, str2);
        hashMap.put("answer", str3);
        hashMap.put("payu_reference", str);
        D(hashMap);
    }

    public final int bLx() {
        return 18;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.mkY = jSONObject.optBoolean("verified");
        this.tkj = jSONObject.optString("payu_reference");
    }
}
