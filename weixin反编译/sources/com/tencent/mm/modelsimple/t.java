package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aga;
import com.tencent.mm.protocal.c.agb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b hOJ;

    public t() {
        a aVar = new a();
        aVar.hnT = new aga();
        aVar.hnU = new agb();
        aVar.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
        this.hOJ = aVar.Kf();
        ((aga) this.hOJ.hnQ.hnY).kzz = 0;
        x.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", Integer.valueOf(0), bi.chl());
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            g.pWK.a(405, 2, 1, true);
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 725;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        g.pWK.a(405, 1, 1, true);
        return a(eVar, this.hOJ, this);
    }
}
