package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bji;
import com.tencent.mm.protocal.c.bjj;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjs;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class g extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public String kRA;
    public String kRy;
    public int kRz;

    public g(int i, LinkedList<bjk> linkedList, String str, String str2, bjs bjs, int i2, bmz bmz) {
        a aVar = new a();
        aVar.hnT = new bji();
        aVar.hnU = new bjj();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecarditem";
        this.gLB = aVar.Kf();
        bji bji = (bji) this.gLB.hnQ.hnY;
        bji.wTr = i;
        bji.hfI = linkedList;
        bji.wTs = str;
        bji.wqy = str2;
        x.i("MicroMsg.NetSceneShareCardItem", "list length is " + linkedList.size());
        bji.wTt = bjs;
        bji.fHR = i2;
        bji.vLw = bmz;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(902), Integer.valueOf(i2), Integer.valueOf(i3));
        bjj bjj;
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
            bjj = (bjj) this.gLB.hnR.hnY;
            if (bjj != null) {
                this.kRy = bjj.kRy;
                this.kRz = bjj.kRz;
                this.kRA = bjj.kRA;
            }
        } else {
            bjj = (bjj) this.gLB.hnR.hnY;
            if (bjj != null) {
                this.kRy = bjj.kRy;
                this.kRz = bjj.kRz;
                this.kRA = bjj.kRA;
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 902;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
