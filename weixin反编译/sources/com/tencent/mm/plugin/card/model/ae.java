package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abx;
import com.tencent.mm.protocal.c.aby;
import com.tencent.mm.protocal.c.baj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class ae extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public baj kRP;

    public ae(LinkedList<String> linkedList, int i) {
        a aVar = new a();
        aVar.hnT = new abx();
        aVar.hnU = new aby();
        aVar.uri = "/cgi-bin/micromsg-bin/getdynamiccardcode";
        this.gLB = aVar.Kf();
        abx abx = (abx) this.gLB.hnQ.hnY;
        abx.wrB = linkedList;
        abx.scene = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetDynamicCardCode", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            this.kRP = ((aby) this.gLB.hnR.hnY).wrC;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1382;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
