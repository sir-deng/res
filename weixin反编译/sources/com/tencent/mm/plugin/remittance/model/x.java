package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x extends i {
    public x(String str, String str2, int i, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("receiver_name", str2);
        hashMap.put("from", String.valueOf(i2));
        hashMap.put("invalid_time", String.valueOf(i));
        D(hashMap);
    }

    public final int azx() {
        return 0;
    }

    public final int Hx() {
        return 1545;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferresendmsg";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        com.tencent.mm.sdk.platformtools.x.d("Micromsg.NetSceneTenpayRemittanceResendMsg", "errCode " + i + " errMsg: " + str);
    }
}
