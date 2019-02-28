package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.akg;
import com.tencent.mm.protocal.c.akh;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends k implements com.tencent.mm.network.k {
    private String fsi;
    private b gLB = null;
    private e gLE = null;
    String lSO;

    public r(String str, String str2, String str3, int i, byte[] bArr) {
        a aVar = new a();
        aVar.hnT = new akg();
        aVar.hnU = new akh();
        aVar.uri = "/cgi-bin/micromsg-bin/harddeviceauth";
        aVar.hnS = 541;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        akg akg = (akg) this.gLB.hnQ.hnY;
        ake ake = new ake();
        ake.vQr = str2;
        ake.kyJ = str3;
        akg.vSI = ake;
        akg.wyf = i;
        akg.wyg = new bes().bl(bArr);
        this.lSO = str3;
        this.fsi = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        c zM = ad.aER().zM(this.lSO);
        if (i2 == 0 && i3 == 0) {
            akh akh = (akh) this.gLB.hnR.hnY;
            if (zM != null) {
                byte[] aEL = aEL();
                if (aEL != null) {
                    zM.field_authBuf = aEL;
                }
                zM.ggI = akh.wyk;
                zM.ggu = true;
                zM.ggH = akh.wyj;
                zM.ggu = true;
                byte[] CM = CM();
                if (CM != null) {
                    u.aFs().b(zM.field_mac, CM, 2);
                    if (u.aFt().lQh != null) {
                        u.aFt().lQh.setChannelSessionKey(zM.field_mac, CM);
                    }
                    zM.field_sessionKey = CM;
                }
                CM = aEM();
                if (CM != null) {
                    u.aFs().b(zM.field_mac, CM, 3);
                    zM.field_sessionBuf = CM;
                }
                CM = aEL();
                if (aEL != null) {
                    u.aFs().b(zM.field_mac, CM, 1);
                    zM.field_authBuf = aEL;
                }
                zM.ggJ = System.currentTimeMillis() / 1000;
                zM.ggu = true;
                if (2 == u.aFs().cz(zM.field_mac)) {
                    ad.aFc();
                    e.e(this.fsi, zM.field_url, 2, zM.field_deviceID);
                }
                u.aFs().cC(zM.field_mac);
                boolean c = ad.aER().c(zM, new String[0]);
                x.i("MicroMsg.exdevice.NetSceneHardDeviceAuth", "update local device auth infos = %b", Boolean.valueOf(c));
            } else {
                x.e("MicroMsg.exdevice.NetSceneHardDeviceAuth", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceIdServer == null");
            }
        } else {
            if (zM != null) {
                u.aFs().cD(zM.field_mac);
                ad.aFc();
                e.e(this.fsi, zM.field_url, 4, zM.field_deviceID);
            }
            ad.aFc();
            e.bi(this.fsi, 3);
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 541;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    private byte[] CM() {
        try {
            return ((akh) this.gLB.hnR.hnY).vPQ.wRm.oz;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }

    public final byte[] aEL() {
        try {
            return ((akh) this.gLB.hnR.hnY).wyi.wRm.oz;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }

    private byte[] aEM() {
        try {
            return ((akh) this.gLB.hnR.hnY).wyh.wRm.oz;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.exdevice.NetSceneHardDeviceAuth", e, "", new Object[0]);
            return null;
        }
    }
}
