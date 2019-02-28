package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adm;
import com.tencent.mm.protocal.c.adn;
import com.tencent.mm.protocal.c.ce;
import com.tencent.mm.protocal.c.tr;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class g extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public LinkedList<tr> pjF;
    public String pjN;

    public g(String str, String str2, ce ceVar) {
        a aVar = new a();
        aVar.hnT = new adm();
        aVar.hnU = new adn();
        aVar.uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
        this.gLB = aVar.Kf();
        adm adm = (adm) this.gLB.hnQ.hnY;
        this.pjN = str;
        adm.vWE = str;
        x.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid " + str);
        adm.vXS = str2;
        adm.wsF = ceVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        adn adn = (adn) ((b) qVar).hnR.hnY;
        if (i2 == 0 && i3 == 0 && adn.vXT == 0) {
            x.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + adn.wsH);
            this.pjF = adn.wsG;
        }
        if (i3 == 0 && adn.vXT != 0) {
            i3 = adn.vXT;
            str = adn.vXU;
        }
        x.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + i3 + ", errMsg " + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 578;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
