package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ty;
import com.tencent.mm.protocal.c.tz;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private e gLE;
    final b hGV;

    public d(String str) {
        a aVar = new a();
        com.tencent.mm.bp.a tyVar = new ty();
        com.tencent.mm.bp.a tzVar = new tz();
        aVar.hnT = tyVar;
        aVar.hnU = tzVar;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmget";
        this.hGV = aVar.Kf();
        tyVar.wiB = str;
        x.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "[oneliang][NetSceneExtDeviceLoginConfirmGet]loginUrl:%s", str);
    }

    public final int getType() {
        return 971;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneExtDeviceLoginConfirmGet", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
        this.gLE.a(i2, i3, str, this);
    }
}
