package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lw;
import com.tencent.mm.protocal.c.lx;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    private b gLB;
    private com.tencent.mm.ad.e gLE;
    public lx lpi;

    public e(int i, int i2, String str, String str2, String str3, int i3, String str4, String str5, String str6, String str7, String str8) {
        a aVar = new a();
        aVar.hnT = new lw();
        aVar.hnU = new lx();
        aVar.hnS = 1336;
        aVar.uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        lw lwVar = (lw) this.gLB.hnQ.hnY;
        lwVar.oeK = i;
        lwVar.wbu = i2;
        lwVar.wbs = str;
        lwVar.wbt = str2;
        lwVar.pQT = str3;
        lwVar.fDM = i3;
        lwVar.wbv = str4;
        lwVar.wbp = str5;
        lwVar.wbw = str6;
        lwVar.wbx = str7;
        lwVar.wby = str8;
    }

    public final int getType() {
        return 1336;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.lpi = (lx) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", Integer.valueOf(this.lpi.lot), this.lpi.lou);
        if (!(this.lpb || this.lpi.lot == 0)) {
            this.lpc = true;
        }
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }
}
