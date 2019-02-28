package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.protocal.c.abj;
import com.tencent.mm.protocal.c.abk;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private com.tencent.mm.ad.e gLE;

    public e(String str) {
        x.i("MicroMsg.NetSceneGetConnectInfo", "summerbak NetSceneGetConnectInfo init, url[%s], stack[%s]", str, bi.chl());
        a aVar = new a();
        aVar.hnT = new abj();
        aVar.hnU = new abk();
        aVar.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
        this.gLB = aVar.Kf();
        ((abj) this.gLB.hnQ.hnY).URL = str;
    }

    public final int getType() {
        return 595;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final abk aqF() {
        return (abk) this.gLB.hnR.hnY;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd errType[%d], errCode[%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            abk aqF = aqF();
            d.Z(aqF.vQt.wRm.oz);
            x.i("MicroMsg.NetSceneGetConnectInfo", "onGYNetEnd id[%s], hello[%s], ok[%s], PCName[%s], PCAcctName[%s], scene[%d], resource[%s]", aqF.ID, aqF.vQP, aqF.vQQ, aqF.vQH, aqF.vQI, Integer.valueOf(aqF.sfa), aqF.wrh);
            com.tencent.mm.bp.b bVar = aqF.vQt.wRm;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
