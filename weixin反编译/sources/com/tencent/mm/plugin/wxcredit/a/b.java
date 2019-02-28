package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends i {
    public String name;
    public String token;
    public String ufv;
    public boolean ufw = true;

    public b(String str, int i, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("bank_type", str2);
        hashMap.put("check_pwd_scene", String.valueOf(i));
        D(hashMap);
        hashMap = new HashMap();
        hashMap.put("check_pwd_scene", String.valueOf(i));
        aB(hashMap);
    }

    public final int azx() {
        return 63;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            this.token = jSONObject.optString("session_key");
            if ("1".equals(jSONObject.optString("all_info"))) {
                this.ufw = false;
                return;
            }
            this.ufw = true;
            this.name = jSONObject.optString("name");
            this.ufv = jSONObject.optString("cre_id");
        }
    }
}
