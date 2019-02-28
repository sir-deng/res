package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public final class b extends e {
    private boolean sKE = false;
    private boolean sKF;

    public final int azx() {
        return 121;
    }

    public b(p pVar, Orders orders) {
        super(pVar, orders);
        bKE();
    }

    private void bKE() {
        this.sKE = false;
        com.tencent.mm.plugin.wallet.a.p.bKx();
        if (!(com.tencent.mm.plugin.wallet.a.p.bKy().sWo == null || this.sKL.pHW == null)) {
            String str = this.sKL.pff;
            com.tencent.mm.plugin.wallet.a.p.bKx();
            if (str.equals(com.tencent.mm.plugin.wallet.a.p.bKy().sWo.field_bankcardType)) {
                if (this.sKL.pHW.fDQ == 31 || this.sKL.pHW.fDQ == 32 || this.sKL.pHW.fDQ == 33 || this.sKL.pHW.fDQ == 42 || this.sKL.pHW.fDQ == 37) {
                    this.sKE = true;
                } else {
                    this.sKF = true;
                }
            }
        }
        x.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", Boolean.valueOf(this.sKE), Boolean.valueOf(this.sKF));
    }

    protected final void S(Map<String, String> map) {
        bKE();
        if (this.sKE || this.sKF) {
            map.put("busi_scene", this.sKL.pff);
        }
    }

    public final int Hx() {
        bKE();
        if (this.sKE) {
            return 1281;
        }
        if (this.sKF) {
            return 1305;
        }
        return 1601;
    }

    public final String getUri() {
        bKE();
        if (this.sKE) {
            return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
        }
        if (this.sKF) {
            return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindverify";
        }
        return "/cgi-bin/mmpay-bin/tenpay/banpaybindverify";
    }

    public final int a(e eVar, com.tencent.mm.ad.e eVar2) {
        if (this.sKE) {
            g.pWK.a(663, 26, 1, false);
        } else if (this.sKF) {
            g.pWK.a(663, 22, 1, false);
        }
        return super.a(eVar, eVar2);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            return;
        }
        if (this.sKE) {
            g.pWK.a(663, 27, 1, false);
        } else if (this.sKF) {
            g.pWK.a(663, 23, 1, false);
        }
    }
}
