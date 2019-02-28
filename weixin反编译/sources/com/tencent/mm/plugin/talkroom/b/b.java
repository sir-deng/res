package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.protocal.c.tk;
import com.tencent.mm.protocal.c.tl;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ad.b gLB;
    private e gLE;
    private int sceneType;

    public b(int i, long j, String str, int i2) {
        this.sceneType = i2;
        a aVar = new a();
        aVar.hnT = new tk();
        aVar.hnU = new tl();
        aVar.uri = "/cgi-bin/micromsg-bin/exittalkroom";
        aVar.hnV = JsApiScanCode.CTRL_INDEX;
        aVar.hnW = 1000000148;
        this.gLB = aVar.Kf();
        tk tkVar = (tk) this.gLB.hnQ.hnY;
        tkVar.wik = str;
        tkVar.wil = i;
        tkVar.wim = j;
        tkVar.sfa = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneExitTalkRoom", "doScene %d", Integer.valueOf(this.sceneType));
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 333;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneExitTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.gLE.a(i2, i3, str, this);
        } else {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
