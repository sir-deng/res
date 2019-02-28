package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bex;
import com.tencent.mm.protocal.c.kf;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class f extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public f(LinkedList<bex> linkedList, String str) {
        int i = 0;
        a aVar = new a();
        aVar.hnT = new kf();
        aVar.hnU = new kg();
        aVar.uri = "/cgi-bin/micromsg-bin/cancelpreorder";
        this.gLB = aVar.Kf();
        kf kfVar = (kf) this.gLB.hnQ.hnY;
        kfVar.vXR = linkedList;
        if (linkedList != null) {
            i = linkedList.size();
        }
        kfVar.phc = i;
        kfVar.vXS = str;
        x.d("MicroMsg.NetSceneMallCancelPreOrder", "lockId " + str);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        kg kgVar = (kg) ((b) qVar).hnR.hnY;
        if (i3 == 0 && kgVar.vXT != 0) {
            i3 = kgVar.vXT;
            str = kgVar.vXU;
        }
        x.d("MicroMsg.NetSceneMallCancelPreOrder", "errCode " + i3 + ", errMsg " + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 555;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
