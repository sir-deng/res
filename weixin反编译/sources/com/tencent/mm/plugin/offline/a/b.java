package com.tencent.mm.plugin.offline.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends i {
    public String TAG = "MicroMsg.NetSceneOfflineAckMsg";

    public b(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("ack_key", a.biL());
        hashMap.put("req_key", a.biM());
        hashMap.put("paymsg_type", a.biN());
        hashMap.put("transactionid", a.biO());
        hashMap.put(TencentLocation.NETWORK_PROVIDER, a.getNetworkType(ad.getContext()));
        hashMap.put("processed", k.pbH ? "1" : "0");
        hashMap.put("is_pos_enabled", a.biP() ? "1" : "0");
        hashMap.put("channel", z ? "pull" : "push");
        hashMap.put("timestamp", (System.currentTimeMillis() / 1000));
        D(hashMap);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (i == 0) {
            x.v(this.TAG, "response ok");
            g.pWK.a(135, 68, 1, true);
            int optInt = jSONObject.optInt("poll_time") * 1000;
            if (optInt > 0) {
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dq().Db().a(w.a.BUSINESS_OFFLINE_GETMSG_INTERVAL_INT, Integer.valueOf(optInt));
                return;
            }
            return;
        }
        x.v(this.TAG, "response fail");
        g.pWK.a(135, 69, 1, true);
    }

    public final int azx() {
        return 1230;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineackmsg";
    }
}
