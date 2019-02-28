package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.protocal.c.tt;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public int fvo;
    private e gLE;
    private final com.tencent.mm.ad.b hGV;

    public b(int i) {
        this.fvo = i;
        a aVar = new a();
        com.tencent.mm.bp.a tsVar = new ts();
        com.tencent.mm.bp.a ttVar = new tt();
        aVar.hnT = tsVar;
        aVar.hnU = ttVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
        tsVar.nne = i;
        tsVar.wiA = 1;
        this.hGV = aVar.Kf();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneExtDeviceControl", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 792;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }
}
