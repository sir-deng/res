package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.protocal.c.apb;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public String idD;
    public String oTD;

    public d(float f, float f2, int i, String str, String str2) {
        a aVar = new a();
        aVar.hnT = new apa();
        aVar.hnU = new apb();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        this.gLB = aVar.Kf();
        apa apa = (apa) this.gLB.hnQ.hnY;
        apa.vKI = 1;
        apa.vXx = f;
        apa.vXy = f2;
        apa.wjv = i;
        apa.wjw = str;
        apa.wjx = str2;
        apa.wjy = 0;
        x.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1" + " lon:" + f + " lat:" + f2 + " pre:" + i + " gpsSource:0 mac" + str + " cell:" + str2);
    }

    public d(String str, int i, int i2) {
        a aVar = new a();
        aVar.hnT = new apa();
        aVar.hnU = new apb();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        this.gLB = aVar.Kf();
        apa apa = (apa) this.gLB.hnQ.hnY;
        apa.vXx = 0.0f;
        apa.vXy = 0.0f;
        apa.wjv = 0;
        apa.wjy = 0;
        apa.wjw = "";
        apa.wjx = "";
        apa.vKI = 2;
        apa.hKn = str;
        apa.wCI = i;
        apa.wCH = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 376;
    }

    public final int IY() {
        return ((apa) this.gLB.hnQ.hnY).vKI;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " opCode:" + IY());
        apb apb = (apb) ((b) qVar).hnR.hnY;
        if (i2 != 0) {
            this.gLE.a(i2, i3, str, this);
        } else if (IY() == 1) {
            this.idD = apb.hKn;
            this.oTD = apb.wCJ;
            this.gLE.a(i2, i3, str, this);
        } else if (IY() == 2) {
            b.He(((apa) ((b) qVar).hnQ.hnY).hKn);
            this.gLE.a(i2, i3, str, this);
        }
    }
}
