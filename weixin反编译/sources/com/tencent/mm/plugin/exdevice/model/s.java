package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.protocal.c.fi;
import com.tencent.mm.sdk.platformtools.x;

public final class s extends k implements com.tencent.mm.network.k {
    private e gQm = null;
    private String lRC = null;
    private b lSP = null;

    public s(String str, String str2, String str3, int i) {
        a aVar = new a();
        aVar.hnT = new akl();
        aVar.hnU = new akm();
        aVar.uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
        aVar.hnS = 1090;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.lSP = aVar.Kf();
        akl akl = (akl) this.lSP.hnQ.hnY;
        akl.vRS = com.tencent.mm.bp.b.TQ(str2);
        akl.vRQ = com.tencent.mm.bp.b.TQ(str3);
        akl.nne = i;
        this.lRC = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        ad.aER().zM(this.lRC);
        if (i2 == 0 && i3 == 0) {
            fi fiVar = ((akm) this.lSP.hnR.hnY).wRa;
            int i4 = fiVar.vQL;
            if (fiVar.vRT.wRp) {
                String str2 = fiVar.vRT.wRo;
            }
            x.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + i4 + ",msg=" + str);
        }
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1090;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        return a(eVar, this.lSP, this);
    }
}
