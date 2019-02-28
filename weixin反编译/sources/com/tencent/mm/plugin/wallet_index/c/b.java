package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.mm.protocal.c.xi;
import com.tencent.mm.protocal.c.xj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class b extends l {
    private com.tencent.mm.ad.b gLB;
    private e gLE;
    public String tgO;
    public String tgP;

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, String str9) {
        a aVar = new a();
        aVar.hnT = new xi();
        aVar.hnU = new xj();
        aVar.uri = "/cgi-bin/mmpay-bin/genmallprepay";
        aVar.hnV = k.CTRL_BYTE;
        aVar.hnW = 1000000189;
        this.gLB = aVar.Kf();
        xi xiVar = (xi) this.gLB.hnQ.hnY;
        xiVar.nlV = str;
        xiVar.wdl = str4;
        xiVar.wdk = str3;
        xiVar.wdm = str5;
        xiVar.wdn = str2;
        xiVar.vSO = str6;
        xiVar.wcy = str7;
        xiVar.wou = str8;
        xiVar.vKK = i;
        xiVar.nqi = str9;
        if (i2 > 0) {
            xiVar.sfa = i2;
        }
        x.d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[]{str, str4, str3, str5, str2, str6, str7, str8, Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneGenMallPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        xj xjVar = (xj) ((com.tencent.mm.ad.b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", Integer.valueOf(xjVar.lUc), xjVar.lUd);
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetSceneGenMallPrepay", "rr " + xjVar.wov);
            this.tgO = xjVar.wov;
            this.tgP = xjVar.wow;
        }
        String str2 = xjVar.lUd;
        this.gLE.a(i, xjVar.lUc, str2, this);
    }

    public final int getType() {
        return 2755;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
