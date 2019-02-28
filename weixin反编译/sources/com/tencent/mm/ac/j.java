package com.tencent.mm.ac;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.fz;
import com.tencent.mm.protocal.c.ga;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.k {
    private e gLE;
    LinkedList<bet> hnm = null;
    LinkedList<alq> hnn = null;

    public j(LinkedList<bet> linkedList) {
        this.hnm = linkedList;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.hnm == null || this.hnm.size() <= 0) {
            x.e("MicroMsg.NetSceneBatchGetHeadImg", g.zo() + "doScene ReqSize==0");
            return -1;
        }
        this.gLE = eVar2;
        a aVar = new a();
        aVar.hnT = new fz();
        aVar.hnU = new ga();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
        aVar.hnS = 123;
        aVar.hnV = 15;
        aVar.hnW = 1000000015;
        q Kf = aVar.Kf();
        fz fzVar = (fz) Kf.hnQ.hnY;
        fzVar.vSd = this.hnm;
        fzVar.kyA = this.hnm.size();
        return a(eVar, Kf, this);
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 20;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + i2 + " errCode:" + i3);
        this.hnn = ((ga) ((b) qVar).hnR.hnY).vSg;
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 123;
    }
}
