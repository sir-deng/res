package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqf;
import com.tencent.mm.protocal.c.aqg;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    public b gLB;
    private com.tencent.mm.ad.e gLE;

    public e(String str) {
        a aVar = new a();
        aVar.hnT = new aqf();
        aVar.hnU = new aqg();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/getallrecvtmpmsgoption";
        this.gLB = aVar.Kf();
        ((aqf) this.gLB.hnQ.hnY).wzf = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1031;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "do scene");
        return a(eVar, this.gLB, this);
    }
}
