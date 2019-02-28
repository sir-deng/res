package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends i {
    public String pbQ;
    public int pbR;
    public String pbS;

    public d() {
        Map hashMap = new HashMap();
        g.Dr();
        Object obj = g.Dq().Db().get(a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, null);
        if (obj != null) {
            hashMap.put("ack_key", (String) obj);
        }
        hashMap.put("timestamp", System.currentTimeMillis());
        D(hashMap);
    }

    public final int azx() {
        return 1981;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinegetmsg";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            com.tencent.mm.plugin.report.service.g.pWK.a(135, 56, 1, true);
            this.pbQ = jSONObject.optString("appmsg");
            this.pbR = jSONObject.optInt("poll_time") * 1000;
            this.pbS = jSONObject.optString("ack_key");
            if (this.pbR > 0) {
                g.Dr();
                g.Dq().Db().a(a.BUSINESS_OFFLINE_GETMSG_INTERVAL_INT, Integer.valueOf(this.pbR));
            }
            g.Dr();
            g.Dq().Db().a(a.BUSINESS_OFFLINE_GETMSG_ACK_KEY_STRING, this.pbS);
            return;
        }
        com.tencent.mm.plugin.report.service.g.pWK.a(135, 57, 1, true);
    }

    public final boolean bhI() {
        return false;
    }
}
