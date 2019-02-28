package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class o extends i {
    public o(int i, int i2, int i3, String str) {
        this(i, i2, i3, 0, str);
    }

    public o(int i, int i2, int i3) {
        this(i, i2, 0, i3, "");
    }

    private o(int i, int i2, int i3, int i4, String str) {
        Map hashMap = new HashMap();
        hashMap.put("residue_num", String.valueOf(i));
        hashMap.put("entry_scene", String.valueOf(i2));
        hashMap.put("is_snapshot", String.valueOf(i3));
        hashMap.put("user_view_digit", String.valueOf(i4));
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        hashMap.put("code_ver", stringBuilder.append(g.Dq().Db().get(a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, (Object) "")).toString());
        hashMap.put("card_id", com.tencent.mm.plugin.offline.c.a.kOh);
        hashMap.put("user_card_id", com.tencent.mm.plugin.offline.c.a.pfa);
        hashMap.put("card_code", com.tencent.mm.plugin.offline.c.a.pfb);
        hashMap.put("ext_business_attach", str);
        D(hashMap);
        x.i("MicroMsg.NetSceneTenpayWxOfflineShowCode", "hy: residue_num == %d, entryscene = %d,is_snapshot = %d, user_view_digit: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        x.d("MicroMsg.NetSceneTenpayWxOfflineShowCode", "card_id=%s,  user_card_id=%s,  card_code:%s ", com.tencent.mm.plugin.offline.c.a.kOh, com.tencent.mm.plugin.offline.c.a.pfa, com.tencent.mm.plugin.offline.c.a.pfb);
    }

    public final int azx() {
        return 102;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final int Hx() {
        return 572;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineshowcode";
    }
}
