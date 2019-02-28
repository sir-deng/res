package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import org.json.JSONObject;

public final class e extends i {
    public String sQb;
    public String sQc;
    public String sQd;
    public String sQe;
    public int sQf;
    public long sQg;
    public String title;

    public final int azx() {
        return 1614;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + i + ";errMsg=" + str);
        if (i == 0 && jSONObject != null) {
            this.sQb = jSONObject.optString("agreed_flag", "0");
            this.title = jSONObject.optString("title", "");
            this.sQc = jSONObject.optString("service_protocol_wording", "");
            this.sQd = jSONObject.optString("service_protocol_url", "");
            this.sQe = jSONObject.optString("button_wording", "");
            this.sQg = jSONObject.optLong("delay_expired_time", 0);
            if (this.sQg > 0) {
                g.Dr();
                g.Dq().Db().a(a.USERINFO_WALLET_REALNAME_DISCLAIMER_QUERY_EXPIRED_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis() + (this.sQg * 1000)));
            }
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamegetduty";
    }

    public final int Hx() {
        return 1614;
    }
}
