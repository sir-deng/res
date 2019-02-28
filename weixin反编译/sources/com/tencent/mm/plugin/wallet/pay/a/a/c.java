package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public final class c extends b {
    private boolean sKE;
    private boolean sKF;
    private boolean sKG;

    public c(Authen authen, Orders orders, boolean z) {
        super(authen, orders);
        this.sKG = z;
        bKE();
    }

    private void bKE() {
        this.sKE = false;
        p.bKx();
        if (!(p.bKy().sWo == null || this.sKx.pHW == null || this.sKG)) {
            if (this.sKx.pHW.fDQ == 31 || this.sKx.pHW.fDQ == 32 || this.sKx.pHW.fDQ == 33 || this.sKx.pHW.fDQ == 42 || this.sKx.pHW.fDQ == 37) {
                this.sKE = true;
            } else {
                this.sKF = true;
            }
        }
        x.i("MicroMsg.NetSceneTenpayBalanceBindAuthen", "isLqtSns: %s, isLqtTs: %s, isBalance: %s", Boolean.valueOf(this.sKE), Boolean.valueOf(this.sKF), Boolean.valueOf(this.sKG));
    }

    protected final void S(Map<String, String> map) {
        bKE();
        if (this.sKE || this.sKF) {
            map.put("busi_scene", this.sKx.pff);
        }
    }

    public final int azx() {
        return 120;
    }

    public final String getUri() {
        bKE();
        if (this.sKE) {
            return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindauthen";
        }
        if (this.sKF) {
            return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindauthen";
        }
        return "/cgi-bin/mmpay-bin/tenpay/banpaybindauthen";
    }

    public final int Hx() {
        bKE();
        if (this.sKE) {
            return 1274;
        }
        if (this.sKF) {
            return 1259;
        }
        return 1600;
    }

    public final int a(e eVar, com.tencent.mm.ad.e eVar2) {
        if (this.sKE) {
            g.pWK.a(663, 24, 1, false);
        } else if (this.sKF) {
            g.pWK.a(663, 20, 1, false);
        }
        return super.a(eVar, eVar2);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            return;
        }
        if (this.sKE) {
            g.pWK.a(663, 25, 1, false);
        } else if (this.sKF) {
            g.pWK.a(663, 21, 1, false);
        }
    }
}
