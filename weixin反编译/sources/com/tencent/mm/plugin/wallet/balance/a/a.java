package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends i {
    public String fxT = null;

    public a(int i, String str, String str2, String str3, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("flag", String.valueOf(i));
        hashMap.put("passwd", str);
        hashMap.put("req_key", str3);
        hashMap.put("verify_code", str2);
        hashMap.put("pay_scene", String.valueOf(i2));
        D(hashMap);
        hashMap = new HashMap();
        if (o.cCj()) {
            hashMap.put("uuid_for_bindcard", o.cCl());
            hashMap.put("bindcard_scene", o.cCk());
        }
        aB(hashMap);
    }

    public final int azx() {
        return 76;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayBalanceSave", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.fxT = jSONObject.optString("req_key");
        }
    }

    public final int Hx() {
        return 1506;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/verifybind";
    }
}
