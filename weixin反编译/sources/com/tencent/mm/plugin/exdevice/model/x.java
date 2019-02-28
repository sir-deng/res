package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.bqm;
import com.tencent.mm.protocal.c.bqn;

public final class x extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public ake lSR;

    public x(ake ake, int i) {
        this.lSR = ake;
        a aVar = new a();
        aVar.hnT = new bqm();
        aVar.hnU = new bqn();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindharddevice";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bqm bqm = (bqm) this.gLB.hnQ.hnY;
        bqm.vSI = ake;
        bqm.vNC = i;
    }

    public final int getType() {
        return 537;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.exdevice.NetSceneUnBindHardDevice", "onGYNetEnd netId = %d, errType= %d, errCode = %d , errMsg =%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        i iVar = i.lSx;
        i.cu(0);
        com.tencent.mm.plugin.exdevice.h.b zM = ad.aER().zM(this.lSR.kyJ);
        if (zM != null) {
            if (!(u.aFt().lQh == null || u.aFt().lQh.cG(zM.field_mac))) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
            }
            if (!ad.aER().cx(this.lSR.kyJ, this.lSR.vQr)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", this.lSR.kyJ);
        }
        if (!(i2 == 0 && i3 == 0)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", Integer.valueOf(537));
        }
        bqn bqn = (this.gLB == null || this.gLB.hnR.hnY == null) ? null : (bqn) this.gLB.hnR.hnY;
        if (bqn == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
        }
        this.gLE.a(i2, i3, str, this);
    }
}
