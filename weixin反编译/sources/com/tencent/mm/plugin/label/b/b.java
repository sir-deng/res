package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ad.b gLB;
    private e gLE;
    public String nUl = null;

    public b(String str) {
        a aVar = new a();
        aVar.hnT = new qg();
        aVar.hnU = new qh();
        aVar.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
        aVar.hnS = 636;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.nUl = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 636;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        qg qgVar = (qg) this.gLB.hnQ.hnY;
        qgVar.wfP = this.nUl;
        if (this.nUl == null || bi.oN(this.nUl)) {
            x.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
            eVar2.a(3, -1, "[doScene]empty label is list.", this);
            return 0;
        }
        qgVar.wfP = this.nUl;
        qgVar.wfP = this.nUl;
        return a(eVar, this.gLB, this);
    }
}
