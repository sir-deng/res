package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apu;
import com.tencent.mm.protocal.c.apv;
import com.tencent.mm.sdk.platformtools.x;

public final class af extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;

    public af(int i, String str) {
        a aVar = new a();
        aVar.hnT = new apu();
        aVar.hnU = new apv();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
        this.gLB = aVar.Kf();
        apu apu = (apu) this.gLB.hnQ.hnY;
        apu.offset = i;
        apu.asN = 20;
        apu.lang = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetServiceAppList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1060;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.NetSceneGetServiceAppList", "do scene");
        return a(eVar, this.gLB, this);
    }
}
