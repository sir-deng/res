package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adu;
import com.tencent.mm.protocal.c.adv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gLE;
    private byte[] nWr;
    String nWs;

    public g(float f, float f2, int i, int i2, int i3, String str, String str2) {
        a aVar = new a();
        aVar.hnT = new adu();
        aVar.hnU = new adv();
        aVar.uri = "/cgi-bin/micromsg-bin/getlocimg";
        this.gLB = aVar.Kf();
        adu adu = (adu) this.gLB.hnQ.hnY;
        adu.lTZ = str2;
        if (bi.PZ()) {
            adu.wth = 1;
        } else {
            adu.wth = 0;
        }
        adu.vXy = f;
        adu.vXx = f2;
        adu.wti = i;
        x.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", Integer.valueOf(i2), Integer.valueOf(i3));
        while (i2 * i3 > 270000) {
            i2 = (int) (((double) i2) / 1.2d);
            i3 = (int) (((double) i3) / 1.2d);
        }
        x.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), adu.lTZ);
        adu.Height = i3;
        adu.Width = i2;
        this.nWs = str;
    }

    public final int getType() {
        return 648;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i2), Integer.valueOf(i3));
        try {
            this.nWr = ((adv) ((b) qVar).hnR.hnY).vNQ.wRm.oz;
            com.tencent.mm.a.e.b(this.nWs, this.nWr, this.nWr.length);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneGetLocImg", e, "", new Object[0]);
        }
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
