package com.tencent.mm.plugin.sns;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.hr;
import com.tencent.mm.f.a.oa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.p;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.blg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<hr> implements e {
    private int qEh;
    private blf qEi;
    private m qEj;
    private al qEk;

    public d() {
        this.xmG = hr.class.getName().hashCode();
    }

    private boolean a(hr hrVar) {
        if (hrVar instanceof hr) {
            this.qEh = hrVar.fyR.fuw;
            this.qEj = ae.bwf().xG(this.qEh);
            this.qEi = ai.m(this.qEj);
            if (this.qEi == null || ((this.qEi.wGH != 3 || this.qEi.wVc == null || this.qEi.wVc.size() <= 0) && (this.qEi.wGH != 5 || this.qEi.wFx == null || this.qEi.wFx.size() <= 0))) {
                k pVar = new p(this.qEj.field_snsId);
                ((blg) pVar.gLB.hnQ.hnY).wVi = 1;
                g.Dr();
                g.Dp().gRu.a((int) i.CTRL_INDEX, (e) this);
                g.Dr();
                g.Dp().gRu.a(pVar, 0);
                this.qEk = new al(new a() {
                    public final boolean uG() {
                        b oaVar = new oa();
                        oaVar.fGM.fyT = null;
                        com.tencent.mm.sdk.b.a.xmy.m(oaVar);
                        return false;
                    }
                }, false);
                this.qEk.K(10000, 10000);
                return true;
            }
            hrVar.fyS.fyT = this.qEi;
            return true;
        }
        x.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.GetSnsObjectDetailListener", "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.qEk.TN();
        if (i == 0 && i2 == 0) {
            m eS = ae.bwf().eS(this.qEj.field_snsId);
            b oaVar = new oa();
            oaVar.fGM.fyT = ai.m(eS);
            com.tencent.mm.sdk.b.a.xmy.m(oaVar);
            return;
        }
        b oaVar2 = new oa();
        oaVar2.fGM.fyT = null;
        com.tencent.mm.sdk.b.a.xmy.m(oaVar2);
    }
}
