package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ag extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public ag(String str) {
        a aVar = new a();
        aVar.hnT = new bin();
        aVar.hnU = new bio();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetemailpwd";
        this.gLB = aVar.Kf();
        ((bin) this.gLB.hnQ.hnY).vTg = bi.Wh(str);
        x.d("MicroMsg.NetSceneSetEmailPwd", "md5 " + str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 382;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSetEmailPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gLE.a(i2, i3, str, this);
    }
}
