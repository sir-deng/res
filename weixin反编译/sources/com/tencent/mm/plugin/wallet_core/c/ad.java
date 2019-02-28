package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import org.json.JSONObject;

public final class ad extends i {
    public double pQB;
    public String pRT;
    public String sPa;
    public double sPb;

    public final int azx() {
        return 0;
    }

    public final int Hx() {
        return 1689;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfergetchargefee";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("Micromsg.NetSceneTransferChargeQuery", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            x.i("Micromsg.NetSceneTransferChargeQuery", "NetSceneTransferChargeQuery request error");
            return;
        }
        this.sPa = jSONObject.optString("short_desc");
        this.pRT = jSONObject.optString("charge_desc");
        this.sPb = jSONObject.optDouble("acc_fee");
        this.pQB = jSONObject.optDouble("remain_fee") / 100.0d;
    }
}
