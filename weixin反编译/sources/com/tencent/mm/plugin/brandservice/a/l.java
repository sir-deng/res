package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqe;
import com.tencent.mm.protocal.c.aqh;
import com.tencent.mm.protocal.c.aqi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class l extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;

    public l(String str, LinkedList<aqe> linkedList) {
        a aVar = new a();
        aVar.hnT = new aqh();
        aVar.hnU = new aqi();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
        this.gLB = aVar.Kf();
        aqh aqh = (aqh) this.gLB.hnQ.hnY;
        aqh.wzf = str;
        aqh.wDK = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1030;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
        return a(eVar, this.gLB, this);
    }
}
