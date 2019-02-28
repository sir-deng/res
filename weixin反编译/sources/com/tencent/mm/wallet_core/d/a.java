package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.b;
import com.tencent.mm.wallet_core.tenpay.model.c;
import com.tencent.mm.wallet_core.tenpay.model.d;
import com.tencent.mm.wallet_core.tenpay.model.f;
import com.tencent.mm.wallet_core.tenpay.model.h;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a implements e {
    private j zQZ;
    private f zRa;
    private int zRb = 0;
    e zRc;

    public a(e eVar) {
        this.zRc = eVar;
    }

    public final boolean a(j jVar) {
        int i = o.bMc().mRetryCount;
        x.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", Boolean.valueOf(jVar.cCJ()), Integer.valueOf(this.zRb));
        if (!jVar.cCJ() || this.zRb >= i) {
            return false;
        }
        return true;
    }

    public final void b(j jVar) {
        x.i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
        this.zRb = 0;
        c(jVar);
    }

    private void c(j jVar) {
        f fVar;
        boolean z;
        this.zQZ = jVar;
        this.zQZ.pQj = true;
        g.Dr();
        g.Dp().gRu.a(385, (e) this);
        ag bMc = o.bMc();
        int i = bMc.sWt > 0 ? bMc.sWt : 10000;
        this.zRb++;
        Map cCI = this.zQZ.cCI();
        String str = (String) cCI.get("req_key");
        if (bi.oN(str)) {
            x.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
            fVar = new f(cCI);
        } else {
            x.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", str);
            x.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
            fVar = str.startsWith("sns_aa_") ? new b(cCI) : str.startsWith("sns_tf_") ? new h(cCI) : str.startsWith("sns_ff_") ? new c(cCI) : str.startsWith("ts_") ? new d(cCI) : str.startsWith("sns_") ? new com.tencent.mm.wallet_core.tenpay.model.g(cCI) : str.startsWith("offline_") ? new com.tencent.mm.wallet_core.tenpay.model.e(cCI) : new f(cCI);
        }
        this.zRa = fVar;
        this.zRa.zRt = true;
        int i2 = o.bMc().mRetryCount;
        f fVar2 = this.zRa;
        if (this.zRb >= i2) {
            z = true;
        } else {
            z = false;
        }
        int i3 = this.zRb;
        Map hashMap = new HashMap();
        hashMap.put("is_last_query", (z ? 1 : 0));
        hashMap.put("curr_query_count", String.valueOf(i3));
        fVar2.aA(hashMap);
        x.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", Integer.valueOf(i), Integer.valueOf(i2));
        g.Dr();
        g.Dp().gRu.a(this.zRa, i);
    }

    private void a(int i, int i2, String str, JSONObject jSONObject) {
        x.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + i2 + "errType = " + i);
        if (this.zQZ != null && jSONObject != null && i == 0 && i2 == 0) {
            x.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
            this.zQZ.a(i2, str, jSONObject);
            this.zRc.a(i, i2, str, this.zQZ);
        } else if (this.zRc != null) {
            x.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
            this.zRc.a(i, i2, str, this.zQZ);
        }
        x.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
        this.zRb = 0;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, kVar);
        if ((kVar instanceof f) && this.zRa.equals(kVar)) {
            g.Dr();
            g.Dp().gRu.b(385, (e) this);
            f fVar = (f) kVar;
            x.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", Integer.valueOf(i), Integer.valueOf(i2), str, fVar, Integer.valueOf(fVar.zRs));
            if (fVar.zRs == 1) {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
                a(i, i2, str, fVar.cCG());
                return;
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
                if (fVar.zRs != 2) {
                    a(i, i2, str, fVar.cCG());
                    return;
                }
            } else if (!fVar.zQG) {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
                x.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", o.bMc().sWu);
            } else if (a(this.zQZ)) {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
                c(this.zQZ);
                return;
            } else {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail");
                if (fVar.zRs == 1) {
                    a(i, i2, str, fVar.cCG());
                    return;
                }
            }
            a(this.zQZ.zRA, this.zQZ.zRB, this.zQZ.zRC, this.zQZ.zRD);
        } else if ((kVar instanceof j) && this.zQZ.equals(kVar)) {
            g.Dr();
            g.Dp().gRu.b(385, (e) this);
            if (!((j) kVar).zRH) {
                return;
            }
            if (this.zQZ.sLK) {
                x.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
                a(i, i2, str, ((j) kVar).zRD);
            } else if (this.zQZ.cCJ()) {
                x.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
                c(this.zQZ);
            } else {
                x.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", o.bMc().sWu);
                a(i, i2, r0, ((j) kVar).zRD);
            }
        }
    }
}
