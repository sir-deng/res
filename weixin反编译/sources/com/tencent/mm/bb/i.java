package com.tencent.mm.bb;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.protocal.c.bge;
import com.tencent.mm.protocal.c.bgf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;

    public i(String str) {
        a aVar = new a();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchlocalpage";
        aVar.hnT = new bge();
        aVar.hnU = new bgf();
        this.gLB = aVar.Kf();
        bge bge = (bge) this.gLB.hnQ.hnY;
        bge.wRS = str;
        bge.sfa = 25;
        bge.lTZ = w.eM(ad.getContext());
        bge.wDT = g.Jk();
    }

    public final int getType() {
        return this.gLB.hnS;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebSearchLocalPage", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
