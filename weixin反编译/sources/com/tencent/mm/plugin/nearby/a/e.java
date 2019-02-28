package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ac.h;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aox;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.aoz;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class e extends k implements com.tencent.mm.network.k {
    final b gLB;
    private com.tencent.mm.ad.e gLE;

    public e(String str) {
        a aVar = new a();
        aVar.hnT = new aoy();
        aVar.hnU = new aoz();
        aVar.uri = "/cgi-bin/micromsg-bin/getroommember";
        this.gLB = aVar.Kf();
        ((aoy) this.gLB.hnQ.hnY).hKn = str;
        x.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:" + str);
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 377;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aoz aoz = (aoz) this.gLB.hnR.hnY;
        if (i2 != 0) {
            this.gLE.a(i2, i3, str, this);
            return;
        }
        List arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < aoz.vNu.size()) {
                h hVar = new h();
                hVar.username = ((aox) aoz.vNu.get(i5)).kyG;
                hVar.hni = ((aox) aoz.vNu.get(i5)).wbY;
                hVar.hnh = ((aox) aoz.vNu.get(i5)).wbZ;
                hVar.bC(true);
                arrayList.add(hVar);
                i4 = i5 + 1;
            } else {
                n.JW().H(arrayList);
                this.gLE.a(i2, i3, str, this);
                return;
            }
        }
    }
}
