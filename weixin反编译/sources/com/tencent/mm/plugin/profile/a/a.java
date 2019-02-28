package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.protocal.c.aiv;
import com.tencent.mm.protocal.c.aiw;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public String pmM;

    public a(String str, String str2) {
        this.pmM = str;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new aiv();
        aVar.hnU = new aiw();
        aVar.uri = "/cgi-bin/micromsg-bin/getwburl";
        aVar.hnS = g.CTRL_INDEX;
        this.gLB = aVar.Kf();
        aiv aiv = (aiv) this.gLB.hnQ.hnY;
        aiv.kyG = str2;
        as.Hm();
        String oM = bi.oM((String) c.Db().get(46, null));
        aiv.vPZ = new bes().bl(bi.Wj(oM));
        as.Hm();
        String oM2 = bi.oM((String) c.Db().get(72, null));
        aiv.woH = new bes().bl(bi.Wj(oM2));
        x.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + str + ", a2=" + oM + " , newa2:" + oM2);
    }

    public final int getType() {
        return g.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", Integer.valueOf(i2), Integer.valueOf(i3), getURL());
        this.gLE.a(i2, i3, str, this);
    }

    public final String getURL() {
        return ((aiw) this.gLB.hnR.hnY).URL;
    }
}
