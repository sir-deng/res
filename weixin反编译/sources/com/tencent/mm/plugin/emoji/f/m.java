package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.acf;
import com.tencent.mm.protocal.c.acg;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public byte[] lEK = null;
    private String lEL;

    public m(String str, byte[] bArr) {
        a aVar = new a();
        aVar.hnT = new acf();
        aVar.hnU = new acg();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
        aVar.hnS = 299;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.lEK = bArr;
        this.lEL = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + i2 + "   errCode:" + i3);
        acg acg = (acg) ((b) qVar).hnR.hnY;
        if (acg.vOx != null) {
            this.lEK = n.a(acg.vOx);
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 299;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        acf acf = (acf) this.gLB.hnQ.hnY;
        if (this.lEK != null) {
            acf.vOw = n.N(this.lEK);
        } else {
            acf.vOw = new bes();
        }
        acf.vPI = this.lEL;
        return a(eVar, this.gLB, this);
    }

    public final acg aCA() {
        return (acg) this.gLB.hnR.hnY;
    }
}
