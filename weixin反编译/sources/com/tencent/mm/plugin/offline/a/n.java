package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n extends i {
    public static String pce = "";
    public static String pcx = "";
    private int lot = -1;
    private String lou = "";
    public int pbU = -1;
    public String pbV = "";
    public String pcA = "";
    final Map<String, String> pcB = new HashMap();
    public String pcy = "";
    public String pcz = "";

    public n(String str, int i) {
        this.pcB.put("device_id", q.yM());
        this.pcB.put("timestamp", str);
        this.pcB.put("scene", String.valueOf(i));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(q.yM());
        stringBuilder.append("&");
        stringBuilder.append(str);
        this.pcB.put("sign", ac.VF(stringBuilder.toString()));
        StringBuilder stringBuilder2 = new StringBuilder();
        g.Dr();
        this.pcB.put("code_ver", stringBuilder2.append(g.Dq().Db().get(a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, (Object) "")).toString());
        D(this.pcB);
    }

    public final int azx() {
        return 49;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            pce = jSONObject.optString("limit_fee");
            pcx = jSONObject.optString("is_show_order_detail");
            String optString = jSONObject.optString("pay_amount");
            String optString2 = jSONObject.optString("pay_number");
            String optString3 = jSONObject.optString("card_logos");
            k.bhD();
            k.aA(196629, pce);
            k.bhD();
            k.aA(196641, pcx);
            k.bhD();
            k.aA(196645, optString);
            k.bhD();
            k.aA(196646, optString2);
            com.tencent.mm.plugin.offline.c.a.HD(optString3);
            this.lot = jSONObject.optInt("retcode");
            this.lou = jSONObject.optString("retmsg");
            this.pbU = jSONObject.optInt("wx_error_type");
            this.pbV = jSONObject.optString("wx_error_msg");
            this.pcy = jSONObject.optString("get_code_flag");
            this.pcz = jSONObject.optString("micropay_pause_flag");
            this.pcA = jSONObject.optString("micropay_pause_word");
        }
    }

    public final int Hx() {
        return 568;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinequeryuser";
    }
}
