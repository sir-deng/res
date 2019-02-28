package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.gz;
import com.tencent.mm.protocal.c.ha;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE = null;

    public l(String str, int i) {
        a aVar = new a();
        aVar.hnT = new gz();
        aVar.hnU = new ha();
        aVar.uri = "/cgi-bin/micromsg-bin/bindharddevice";
        aVar.hnS = 536;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        gz gzVar = (gz) this.gLB.hnQ.hnY;
        gzVar.vSo = bi.oM(str);
        gzVar.vSH = bi.e(Integer.valueOf(i));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneBindHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        if (i2 == 0 && i3 == 0) {
            int i4;
            ha aEK = aEK();
            x.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", aEK.vSI.kyJ, aEK.vSI.vQr);
            String str2 = "MicroMsg.exdevice.NetSceneBindHardDevice";
            String str3 = "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s";
            Object[] objArr = new Object[6];
            objArr[0] = aEK.vSJ.vPY;
            objArr[1] = aEK.vSJ.wxU;
            objArr[2] = aEK.vSJ.vSj;
            objArr[3] = aEK.vSJ.wxV;
            objArr[4] = Integer.valueOf(aEK.vSJ.wxW);
            objArr[5] = aEK.vNC == 0 ? "sync" : "async";
            x.i(str2, str3, objArr);
            if (ad.aER().cw(aEK.vSJ.wxU, aEK.vSI.kyJ) != null) {
                x.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", aEK.vSJ.wxU, Boolean.valueOf(ad.aER().cx(aEK.vSI.kyJ, aEK.vSJ.wxU)));
                if (ad.aER().cx(aEK.vSI.kyJ, aEK.vSJ.wxU)) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
            } else {
                i4 = 1;
            }
            c bVar = new com.tencent.mm.plugin.exdevice.h.b();
            f.a(bVar, aEK.vSI, aEK.vSJ);
            bVar.field_url = "";
            f.a cA = u.aFs().cA(bVar.field_mac);
            if (cA != null && cA.ftb == 2) {
                x.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
                ad.aEY();
                d.co(bVar.field_mac);
                f aFs = u.aFs();
                long j = bVar.field_mac;
                if (aFs.lVT.containsKey(Long.valueOf(j))) {
                    aFs.lVT.remove(Long.valueOf(j));
                    x.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", Long.valueOf(j));
                } else {
                    x.i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", Long.valueOf(j));
                }
            }
            if (i4 != 0) {
                ad.aER().b(bVar);
            } else {
                ad.aER().e(bVar);
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 536;
    }

    public final ha aEK() {
        if (this.gLB == null || this.gLB.hnR.hnY == null) {
            return null;
        }
        return (ha) this.gLB.hnR.hnY;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
