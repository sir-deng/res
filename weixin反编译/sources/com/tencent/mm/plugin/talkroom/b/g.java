package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.protocal.c.bou;
import com.tencent.mm.protocal.c.bov;
import com.tencent.mm.protocal.c.bow;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class g extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public g(LinkedList<bou> linkedList, int i) {
        a aVar = new a();
        aVar.hnT = new bov();
        aVar.hnU = new bow();
        aVar.uri = "/cgi-bin/micromsg-bin/talkstatreport";
        aVar.hnS = r.CTRL_INDEX;
        this.gLB = aVar.Kf();
        bov bov = (bov) this.gLB.hnQ.hnY;
        bov.wYb = linkedList.size();
        bov.wYc = linkedList;
        bov.sfa = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneTalkStatReport", "doScene");
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return r.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneTalkStatReport", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.gLE.a(i2, i3, str, this);
        } else {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
