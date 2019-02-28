package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bvf;
import com.tencent.mm.protocal.c.bvg;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;

    public c(int i, String str, int i2, byte[] bArr, byte[] bArr2, String str2) {
        a aVar = new a();
        aVar.hnT = new bvf();
        aVar.hnU = new bvg();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipinvite";
        this.gLB = aVar.Kf();
        bvf bvf = (bvf) this.gLB.hnQ.hnY;
        bvf.wMS = i;
        bvf.xcQ = str;
        bvf.wdO = i2;
        bvf.xcR = com.tencent.mm.bp.b.be(bArr);
        bvf.xcS = com.tencent.mm.bp.b.be(bArr2);
        bvf.wMR = System.currentTimeMillis();
        if (str2 != null && !str2.equals("")) {
            bvf.xcT = str2;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSInvite", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 823;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
