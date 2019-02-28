package com.tencent.mm.plugin.wallet.pay.a.e;

import com.tencent.mm.plugin.wallet_core.e.b;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class f extends j {
    private int pRF = -1;
    public Orders sKw = null;

    public f(p pVar, Orders orders) {
        String str = null;
        int i = -1;
        this.sKw = orders;
        if (pVar.pHW != null) {
            this.pRF = pVar.pHW.fDQ;
            i = pVar.pHW.fDM;
        }
        List list = orders.sUf;
        if (list.size() > 0) {
            str = ((Commodity) list.get(0)).fvD;
        }
        a(orders.fvC, str, this.pRF, i, pVar.pff, pVar.pfg);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        x.i("MicroMsg.NetSceneTenpayVertifyReg", "hy: has pwd: %b", Boolean.valueOf(!bi.oN(pVar.sVs)));
        a(pVar.pHW, hashMap, hashMap2, r0);
        hashMap.put("flag", pVar.flag);
        hashMap.put("passwd", pVar.sVs);
        hashMap.put("verify_code", pVar.sVt);
        hashMap.put("token", pVar.token);
        hashMap.put("favorcomposedid", pVar.sQO);
        hashMap.put("default_favorcomposedid", pVar.sQN);
        D(hashMap);
        aB(hashMap2);
    }

    public final int azx() {
        return 16;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            x.d("MicroMsg.NetSceneTenpayVertifyReg", "Pay Success! saving bind_serial:" + jSONObject.optString("bind_serial"));
            if ("1".equals(jSONObject.optString("pay_flag"))) {
                this.sLK = true;
                this.sKw = Orders.a(jSONObject, this.sKw);
            } else {
                this.sLK = false;
            }
            x.i("MicroMsg.NetSceneTenpayVertifyReg", "mPayScene:" + this.pRF);
            if (this.pRF == 39) {
                x.i("MicroMsg.NetSceneTenpayVertifyReg", "it's the sns scene, parse the sns pay data");
                b.ae(jSONObject);
                return;
            }
            x.i("MicroMsg.NetSceneTenpayVertifyReg", "it's not the sns scene");
        }
    }

    public String getUri() {
        if (this.pRF == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveverifyreg";
        }
        if (this.pRF == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchverifyreg";
        }
        return "/cgi-bin/mmpay-bin/tenpay/verifyreg";
    }

    public int Hx() {
        if (this.pRF == 11) {
            return 1684;
        }
        if (this.pRF == 21) {
            return 1608;
        }
        return 474;
    }

    public final boolean bKD() {
        if (this.pRF == 11 || this.pRF == 21) {
            return true;
        }
        return false;
    }
}
