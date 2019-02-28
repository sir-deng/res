package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.b.a.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends a {
    public String pQo;

    public p(long j, String str, String str2, String str3, String str4, String str5, int i, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("amount", String.valueOf(j));
        hashMap.put("recv_username", str);
        hashMap.put("recv_nickname", str2);
        hashMap.put("qrcodeid", str5);
        try {
            if (!bi.oN(str3)) {
                hashMap.put("desc", URLEncoder.encode(str3, "UTF-8"));
            }
            if (!bi.oN(str4)) {
                hashMap.put("message", URLEncoder.encode(str4, "UTF-8"));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneH5F2fTransferPay", e, "", new Object[0]);
        }
        hashMap.put("currency", String.valueOf(i));
        hashMap.put("set_amount", String.valueOf(i2));
        D(hashMap);
        x.i("MicroMsg.NetSceneH5F2fTransferPay", "username: %s, nickname: %s, amount: %s, desc: %s, msg: %s, currency: %s", str, str2, Long.valueOf(j), str3, str4, Integer.valueOf(i));
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.pQo = jSONObject.optString("payurl", "");
        x.i("MicroMsg.NetSceneH5F2fTransferPay", "payurl: %s", this.pQo);
    }

    public final String azu() {
        return "/cgi-bin/mmpay-bin/h5f2ftransferpay";
    }

    public final int getType() {
        return 1529;
    }

    public final int azv() {
        return 1529;
    }
}
