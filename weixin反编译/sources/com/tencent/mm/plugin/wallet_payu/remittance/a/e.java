package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a {
    public int cRQ;
    public String desc;
    public double loS;
    public String pQP;
    public String pQQ;
    public int scene;
    public String username;

    public e(String str) {
        Map hashMap = new HashMap();
        hashMap.put("transfer_url", str);
        D(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetScenePayURemittanceGetUsername", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.username = jSONObject.optString("user_name");
            this.pQP = jSONObject.optString("true_name");
            this.loS = jSONObject.optDouble("fee") / 100.0d;
            this.desc = jSONObject.optString("desc");
            this.scene = jSONObject.optInt("scene");
            this.pQQ = jSONObject.optString("transfer_qrcode_id");
            this.cRQ = jSONObject.optInt("time_stamp");
        }
    }

    public final int bLx() {
        return 24;
    }
}
