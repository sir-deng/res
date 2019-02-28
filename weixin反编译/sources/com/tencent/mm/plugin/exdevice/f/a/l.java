package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apc;
import com.tencent.mm.protocal.c.apd;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k {
    public int fGi;
    private b gLB = null;
    private e gLE = null;
    public String hea;
    public String lUU;

    public l(String str, String str2, int i, String str3) {
        this.lUU = str3;
        this.hea = str2;
        this.fGi = i;
        this.lUU = str3;
        a aVar = new a();
        aVar.hnT = new apc();
        aVar.hnU = new apd();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/addlike";
        aVar.hnS = 1041;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        apc apc = (apc) this.gLB.hnQ.hnY;
        apc.mcb = str2;
        apc.username = str;
        apc.fGi = i;
        apc.hds = str3;
    }

    public final int getType() {
        return 1041;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }
}
