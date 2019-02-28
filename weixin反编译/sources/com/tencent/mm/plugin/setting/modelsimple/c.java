package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.xn;
import com.tencent.mm.protocal.c.xo;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public c(String str) {
        a aVar = new a();
        aVar.hnT = new xn();
        aVar.hnU = new xo();
        aVar.uri = "/cgi-bin/micromsg-bin/generalset";
        this.gLB = aVar.Kf();
        xn xnVar = (xn) this.gLB.hnQ.hnY;
        xnVar.who = 1;
        xnVar.woz = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGeneralSet", "doScene");
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 177;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGeneralSet", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        this.gLE.a(i2, i3, str, this);
    }
}
