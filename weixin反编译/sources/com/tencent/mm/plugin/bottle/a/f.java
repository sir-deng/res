package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ac.h;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aye;
import com.tencent.mm.protocal.c.ayf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.Map;

public final class f extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    boolean kGz = false;

    public f() {
        a aVar = new a();
        aVar.hnT = new aye();
        aVar.hnU = new ayf();
        aVar.uri = "/cgi-bin/micromsg-bin/pickbottle";
        aVar.hnS = 155;
        aVar.hnV = 54;
        aVar.hnW = 1000000054;
        this.gLB = aVar.Kf();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 155;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetScenePickBottle", "onGYNetEnd type:" + i2 + " code:" + i3);
        if (i2 == 4 && (i3 == -2002 || i3 == -56)) {
            c.ny(0);
            c.nz(0);
        }
        ayf ayf = (ayf) this.gLB.hnR.hnY;
        if (i2 == 4) {
            switch (i3) {
                case -56:
                    break;
                default:
                    c.nz(ayf.wqr);
                    c.ny(ayf.wqq);
                    break;
            }
        }
        if (i2 == 0 && i3 == 0) {
            this.kGz = true;
            x.d("MicroMsg.NetScenePickBottle", "bottle pack:pack:" + ayf.wqr + " throw:" + ayf.wqq);
            String[] strArr = null;
            if (ayf.wJH != null) {
                strArr = ayf.wJH.split(":");
            }
            if (strArr != null && strArr.length >= 2) {
                String str2 = strArr[0];
                as.Hm();
                ag Xv = c.Ff().Xv(str2);
                if (Xv == null || !Xv.field_username.equals(str2)) {
                    ag xVar = new com.tencent.mm.storage.x();
                    xVar.setUsername(str2);
                    xVar.dc(ayf.kzN == null ? "" : ayf.kzN);
                    xVar.eC(3);
                    h hVar = new h();
                    hVar.username = str2;
                    hVar.fWZ = 3;
                    hVar.bC(true);
                    hVar.fEo = -1;
                    try {
                        Map y = bj.y(ayf.wsn, "userinfo");
                        if (y != null) {
                            xVar.eD(bi.getInt((String) y.get(".userinfo.$sex"), 0));
                            xVar.dp((String) y.get(".userinfo.$signature"));
                            xVar.dv(RegionCodeDecoder.ai((String) y.get(".userinfo.$country"), (String) y.get(".userinfo.$province"), (String) y.get(".userinfo.$city")));
                            x.d("MicroMsg.NetScenePickBottle", "user:" + str2 + " sig:" + xVar.signature + " sex" + xVar.fXa + " city:" + xVar.getCity() + " prov:" + xVar.getProvince());
                            hVar.hni = (String) y.get(".userinfo.$bigheadimgurl");
                            hVar.hnh = (String) y.get(".userinfo.$smallheadimgurl");
                            hVar.fEo = -1;
                            x.d("MicroMsg.NetScenePickBottle", "dkhurl user:[%s] big:[%s] sm:[%s]", str2, hVar.JM(), hVar.JN());
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.NetScenePickBottle", "Set Contact failed " + e.getMessage() + " user:" + str2);
                    }
                    as.Hm();
                    c.Ff().Q(xVar);
                    n.JW().a(hVar);
                }
            }
            x.d("MicroMsg.NetScenePickBottle", "getBottleType " + ayf.wLR);
            x.d("MicroMsg.NetScenePickBottle", "getMsgType " + ayf.nlX);
            x.d("MicroMsg.NetScenePickBottle", "getBottleInfo " + ayf.wJH);
            x.d("MicroMsg.NetScenePickBottle", "getUserInfo " + ayf.wsn);
            x.d("MicroMsg.NetScenePickBottle", "getNickName " + ayf.kzN);
            x.d("MicroMsg.NetScenePickBottle", "getUserStatus " + ayf.wLS);
            x.d("MicroMsg.NetScenePickBottle", "getThrowCount " + ayf.wqq);
            x.d("MicroMsg.NetScenePickBottle", "getPickCount " + ayf.wqr);
            x.d("MicroMsg.NetScenePickBottle", "getDistance " + ayf.wLT);
        } else if (i3 == -56) {
            c.nz(ayf.wqr);
            c.nz(ayf.wqq);
        }
        this.gLE.a(i2, i3, str, this);
    }

    final ayf ask() {
        return (ayf) this.gLB.hnR.hnY;
    }
}
