package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b implements e {
    static RetryPayInfo sEm;
    private j zQZ;
    private int zRb = 0;
    e zRc;

    private boolean cCy() {
        if (this.zRb >= cCz()) {
            return false;
        }
        return true;
    }

    private static int cCz() {
        if (sEm == null || !sEm.cCF()) {
            return 0;
        }
        return sEm.zRo;
    }

    public b(e eVar) {
        this.zRc = eVar;
    }

    public final boolean d(j jVar) {
        int i = (sEm == null || !sEm.cCF()) ? 0 : sEm.zRn;
        int cCz = cCz();
        this.zRb++;
        if (this.zRb > cCz) {
            return false;
        }
        this.zQZ = jVar;
        this.zQZ.pQj = true;
        g.Dr();
        g.Dp().gRu.a(385, (e) this);
        this.zQZ.cCK();
        int i2 = this.zRb;
        int i3 = this.zRb >= cCz ? 1 : 0;
        Map hashMap = new HashMap();
        hashMap.put("retry_count", String.valueOf(i2));
        hashMap.put("is_last_retry", String.valueOf(i3));
        jVar.aA(hashMap);
        x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", Integer.valueOf(i), Integer.valueOf(cCz));
        g.Dr();
        g.Dp().gRu.a((k) jVar, i);
        return true;
    }

    private void a(int i, int i2, String str, JSONObject jSONObject) {
        x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + i2 + "errType = " + i);
        if (this.zQZ != null && jSONObject != null && i == 0 && i2 == 0) {
            x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
            this.zQZ.a(i2, str, jSONObject);
            this.zRc.a(i, i2, str, this.zQZ);
        } else if (this.zRc != null) {
            x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
            this.zRc.a(i, i2, str, this.zQZ);
        }
        x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
        this.zRb = 0;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, kVar);
        if (kVar instanceof j) {
            if (kVar instanceof ITenpaySave) {
                RetryPayInfo bJV = ((ITenpaySave) kVar).bJV();
                if (bJV.cCF()) {
                    sEm = bJV;
                }
            }
            g.Dr();
            g.Dp().gRu.b(385, (e) this);
            if (!((j) kVar).zRH) {
                return;
            }
            if (this.zQZ.sLK) {
                x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
                a(i, i2, str, ((j) kVar).zRD);
            } else if (this.zQZ.zRI && cCy()) {
                x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", Boolean.valueOf(this.zQZ.zRI), Boolean.valueOf(cCy()));
                if (!d(this.zQZ)) {
                    c(i, i2, kVar);
                }
            } else if (((j) kVar).zQG) {
                x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
                if (!d(this.zQZ)) {
                    c(i, i2, kVar);
                }
            } else {
                x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", sEm.zRp);
                a(i, i2, r0, ((j) kVar).zRD);
            }
        }
    }

    private void c(int i, int i2, k kVar) {
        a(i, i2, sEm.zRp, ((j) kVar).zRD);
    }
}
