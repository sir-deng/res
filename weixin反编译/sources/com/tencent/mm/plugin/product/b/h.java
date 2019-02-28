package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aff;
import com.tencent.mm.protocal.c.afg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class h extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public String pjN;
    public m pjO;
    public List<n> pjP;

    public h(m mVar, String str) {
        a aVar = new a();
        aVar.hnT = new aff();
        aVar.hnU = new afg();
        aVar.uri = "/cgi-bin/micromsg-bin/getproductdetail";
        this.gLB = aVar.Kf();
        aff aff = (aff) this.gLB.hnQ.hnY;
        this.pjN = str;
        aff.wtR = str;
        x.d("MicroMsg.NetSceneMallGetProductDetail", "pid " + str);
        aff.kzy = 0;
        this.pjO = mVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        afg afg = (afg) ((b) qVar).hnR.hnY;
        if (!bi.oN(afg.wtT)) {
            x.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + afg.wtT);
            this.pjO = m.a(this.pjO, afg.wtT);
        }
        if (i3 == 0 && afg.vXT != 0) {
            i3 = afg.vXT;
            str = afg.vXU;
        }
        if (!bi.oN(afg.wtU)) {
            x.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + afg.wtU);
            this.pjP = n.parse(afg.wtU);
        }
        x.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + i3 + ", errMsg " + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 553;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
