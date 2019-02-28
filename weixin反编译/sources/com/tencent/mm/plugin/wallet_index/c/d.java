package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.protocal.c.alp;
import com.tencent.mm.protocal.c.yb;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class d extends l {
    public int errCode;
    private b gLB;
    private e gLE;
    public alo tgQ;
    public alp tgR;

    public d(int i, String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7) {
        a aVar = new a();
        aVar.hnT = new yb();
        aVar.hnU = new yc();
        aVar.uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
        this.gLB = aVar.Kf();
        yb ybVar = (yb) this.gLB.hnQ.hnY;
        ybVar.fGh = str;
        ybVar.wpo = i;
        ybVar.wpp = Integer.parseInt(str2);
        ybVar.desc = str3;
        ybVar.count = i2;
        ybVar.scene = 13;
        ybVar.wpq = str4;
        ybVar.wpr = str5;
        ybVar.sign = str6;
        ybVar.wps = str7;
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.e("MicroMsg.NetSceneGetAndroidIapPackage", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            yc ycVar = (yc) this.gLB.hnR.hnY;
            x.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + ycVar.fyF + ",errMsg:" + ycVar.fyG);
            int i3 = ycVar.fyF;
            String str2 = ycVar.fyG;
            if (i3 == 0) {
                this.tgQ = ycVar.wpt;
                this.tgR = ycVar.wpu;
            }
            this.gLE.a(i, i3, str2, this);
            return;
        }
        this.gLE.a(i, i2, str, this);
    }

    public final int getType() {
        return 1130;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
