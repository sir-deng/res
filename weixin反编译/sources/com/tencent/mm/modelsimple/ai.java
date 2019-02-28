package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.biv;
import com.tencent.mm.protocal.c.biw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ai extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gLE;

    public ai(String str, String str2, bes bes) {
        a aVar = new a();
        aVar.hnT = new biv();
        aVar.hnU = new biw();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetpasswd";
        this.gLB = aVar.Kf();
        biv biv = (biv) this.gLB.hnQ.hnY;
        biv.lTQ = bi.Wh(str);
        biv.wgO = str2;
        biv.vPR = bes;
        x.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, authkey:%s", str, str2, bi.bx(n.a(bes)));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 383;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gLE.a(i2, i3, str, this);
    }
}
