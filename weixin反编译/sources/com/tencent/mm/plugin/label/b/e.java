package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.protocal.c.bqt;
import com.tencent.mm.protocal.c.bqu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private com.tencent.mm.ad.e gLE;
    private aoh nUn = null;

    public e(int i, String str) {
        a aVar = new a();
        aVar.hnT = new bqt();
        aVar.hnU = new bqu();
        aVar.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
        aVar.hnS = 637;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        if (i >= 0 && !bi.oN(str)) {
            this.nUn = new aoh();
            this.nUn.wBT = i;
            this.nUn.wBS = str;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 637;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        bqt bqt = (bqt) this.gLB.hnQ.hnY;
        if (this.nUn != null) {
            bqt.wZq = this.nUn;
            return a(eVar, this.gLB, this);
        }
        x.e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
        eVar2.a(3, -1, "[doScene]empty label pair.", this);
        return 0;
    }
}
