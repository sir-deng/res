package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.azm;
import com.tencent.mm.protocal.c.azn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;

public final class i extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE = null;
    public azm nLm = null;
    public azn nLn = null;

    public i(String str, String str2, int i, int i2, int i3) {
        a aVar = new a();
        aVar.hnT = new azm();
        aVar.hnU = new azn();
        aVar.hnS = 991;
        aVar.uri = "/cgi-bin/micromsg-bin/pstninvite";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        long currentTimeMillis = System.currentTimeMillis();
        int aVt = c.aVt();
        azm azm = (azm) this.gLB.hnQ.hnY;
        azm.npW = q.FY();
        azm.wMT = str2;
        azm.npV = str;
        azm.wMS = i;
        azm.wdO = aVt;
        azm.wNb = 1;
        azm.wMR = currentTimeMillis;
        azm.wNa = i2;
        azm.wNc = i3;
        this.nLm = azm;
        x.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", str, str2, Integer.valueOf(i), Integer.valueOf(aVt), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final int getType() {
        return 991;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nLn = (azn) ((b) qVar).hnR.hnY;
        if (i2 == 0 || i3 == 0) {
            if (this.gLE != null) {
                this.gLE.a(i2, i3, str, this);
            }
        } else if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
