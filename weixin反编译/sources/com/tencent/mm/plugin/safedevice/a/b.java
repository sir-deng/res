package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.brb;
import com.tencent.mm.protocal.c.brc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public String deviceName;
    public String ffG;
    public String fsb;
    private com.tencent.mm.ad.b gLB;
    private e gLE;

    public b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hnT = new brb();
        aVar.hnU = new brc();
        aVar.uri = "/cgi-bin/micromsg-bin/updatesafedevice";
        this.gLB = aVar.Kf();
        this.ffG = str;
        this.deviceName = str2;
        this.fsb = str3;
        brb brb = (brb) this.gLB.hnQ.hnY;
        brb.wfU = str;
        brb.nkW = str2;
        brb.vQr = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + i2 + ", errCode = " + i3);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 361;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bi.oN(this.ffG) || bi.oN(this.deviceName) || bi.oN(this.fsb)) {
            x.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
            return -1;
        }
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
