package com.tencent.mm.plugin.wallet_payu.create.a;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String fAK;
    public String pin;
    public String tiA;
    public String tiB;
    public String tiC;
    public String tiy;
    public String tiz;

    public a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.tiy = str;
        this.tiz = str2;
        this.pin = str3;
        this.tiB = str4;
        this.tiA = str4;
        this.tiC = str6;
        Map hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", str2);
        hashMap.put("pin", str3);
        hashMap.put("secret_question_id", str4);
        hashMap.put("secret_question_answer", str5);
        hashMap.put("payu_reference", str6);
        D(hashMap);
    }

    public final int bLx() {
        return 5;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetScenePayUCreateUser", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", Integer.valueOf(i), str, jSONObject.toString());
        this.fAK = jSONObject.optString("payu_reference");
    }
}
