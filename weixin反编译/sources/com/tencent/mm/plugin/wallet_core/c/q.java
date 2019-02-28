package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q extends i {
    public BindCardOrder sOq;

    public q(p pVar) {
        this(pVar, -1);
    }

    public q(p pVar, int i) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(pVar.pHW, hashMap, hashMap2);
        hashMap.put("flag", pVar.flag);
        if ("2".equals(pVar.flag)) {
            hashMap.put("passwd", pVar.sVs);
        }
        hashMap.put("verify_code", pVar.sVt);
        hashMap.put("token", pVar.token);
        if (!(pVar.pHW == null || bi.oN(pVar.pHW.fvC))) {
            hashMap.put("req_key", pVar.pHW.fvC);
        }
        if (i >= 0) {
            hashMap.put("realname_scene", String.valueOf(i));
            x.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", Integer.valueOf(i));
        }
        if (!bi.oN(pVar.pff)) {
            hashMap.put("bank_type", pVar.pff);
        }
        if (o.cCj()) {
            hashMap2.put("uuid_for_bindcard", o.cCl());
            hashMap2.put("bindcard_scene", o.cCk());
        }
        D(hashMap);
        aB(hashMap2);
    }

    public final int azx() {
        return 13;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("test", "test");
        this.sOq = new BindCardOrder();
        this.sOq.X(jSONObject);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindverify";
    }

    public final int Hx() {
        return 472;
    }
}
