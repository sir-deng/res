package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.asx;
import com.tencent.mm.protocal.c.asy;
import com.tencent.mm.protocal.c.btc;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class d extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    private LinkedList<btc> nUm = new LinkedList();

    public d(LinkedList<btc> linkedList) {
        a aVar = new a();
        aVar.hnT = new asx();
        aVar.hnU = new asy();
        aVar.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
        aVar.hnS = 638;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.nUm = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 638;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
        this.gLE = eVar2;
        asx asx = (asx) this.gLB.hnQ.hnY;
        asx.wHo = this.nUm;
        asx.wri = this.nUm.size();
        return a(eVar, this.gLB, this);
    }
}
