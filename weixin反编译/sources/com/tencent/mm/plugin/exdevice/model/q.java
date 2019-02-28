package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.ago;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends k implements com.tencent.mm.network.k {
    public b gLB = null;
    private e gLE = null;

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneGetSportDeviceList", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1267;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        a aVar = new a();
        aVar.hnT = new ago();
        aVar.hnU = new agp();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/getsportdevicelist";
        aVar.hnS = 1267;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        return a(eVar, this.gLB, this);
    }
}
