package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.xk;
import com.tencent.mm.protocal.c.xl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class c extends l {
    private b gLB;
    private e gLE;
    public String tgO;
    public String tgP;

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2) {
        a aVar = new a();
        aVar.hnT = new xk();
        aVar.hnU = new xl();
        aVar.uri = "/cgi-bin/mmpay-bin/genprepay";
        aVar.hnV = k.CTRL_BYTE;
        aVar.hnW = 1000000189;
        this.gLB = aVar.Kf();
        com.tencent.mm.plugin.soter.c.c bDz = com.tencent.mm.plugin.soter.c.b.bDz();
        String str9 = bDz.rYp;
        String str10 = bDz.rYq;
        xk xkVar = (xk) this.gLB.hnQ.hnY;
        xkVar.nlV = str;
        xkVar.wdl = str4;
        xkVar.wdk = str3;
        xkVar.wdm = str5;
        xkVar.wdn = str2;
        xkVar.vSO = str6;
        xkVar.wcy = str7;
        xkVar.wou = str8;
        xkVar.vKK = i;
        xkVar.wox = str9;
        xkVar.nqb = str10;
        xkVar.vXW = i.bLR();
        if (i2 > 0) {
            xkVar.sfa = i2;
        }
        x.d("MicroMsg.NetSceneGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[]{str, str4, str3, str5, str2, str6, str7, str8, Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneGenPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        xl xlVar = (xl) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", Integer.valueOf(xlVar.lUc), xlVar.lUd);
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetSceneGenPrepay", "rr " + xlVar.wov);
            this.tgO = xlVar.wov;
            this.tgP = xlVar.wow;
        }
        String str2 = xlVar.lUd;
        this.gLE.a(i, xlVar.lUc, str2, this);
    }

    public final int getType() {
        return 398;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
