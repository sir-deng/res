package com.tencent.mm.plugin.order.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.az;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.aws;
import com.tencent.mm.protocal.c.awt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class g extends l {
    private b gLB;
    private e gLE;

    public g(String str, String str2, int i) {
        a aVar = new a();
        aVar.hnT = new aws();
        aVar.hnU = new awt();
        aVar.uri = "/cgi-bin/micromsg-bin/paydeluserroll";
        aVar.hnS = bf.CTRL_INDEX;
        aVar.hnV = az.CTRL_BYTE;
        this.gLB = aVar.Kf();
        aws aws = (aws) this.gLB.hnQ.hnY;
        aws.wKP = 1;
        if (!bi.oN(str)) {
            aws.pgO = str;
        }
        if (!bi.oN(str2)) {
            aws.phh = str2;
        }
        aws.vXW = i.bLR();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gLE.a(i, i2, str, this);
    }

    public final int bji() {
        return ((aws) this.gLB.hnQ.hnY).wKP;
    }

    public final String bjj() {
        return ((aws) this.gLB.hnQ.hnY).pgO;
    }

    public final int getType() {
        return bf.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
