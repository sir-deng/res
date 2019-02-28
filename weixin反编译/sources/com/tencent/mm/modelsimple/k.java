package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.td;
import com.tencent.mm.protocal.c.te;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends com.tencent.mm.ad.k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public k(String str, int i, String str2) {
        x.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", str, Integer.valueOf(i), str2);
        a aVar = new a();
        aVar.hnT = new td();
        aVar.hnU = new te();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
        this.gLB = aVar.Kf();
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        } else if (str2.length() > 32 && i != 19) {
            str2 = str2.substring(0, 32);
        }
        td tdVar = (td) this.gLB.hnQ.hnY;
        tdVar.vTX = str;
        tdVar.vON = i;
        tdVar.wiq = com.tencent.mm.bp.b.TQ(str2);
        tdVar.wfV = com.tencent.mm.bp.b.be(new byte[0]);
        x.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", str, Integer.valueOf(i), Integer.valueOf(tdVar.wfV.oz.length));
    }

    public final int getType() {
        return 1066;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }
}
