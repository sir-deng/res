package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardPayCheck";
    private b gLB;
    private e gLE;
    private lv lph;

    public d(String str, String str2, String str3, int i, String str4, String str5) {
        a aVar = new a();
        aVar.hnT = new lu();
        aVar.hnU = new lv();
        aVar.hnS = 1960;
        aVar.uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        lu luVar = (lu) this.gLB.hnQ.hnY;
        luVar.fxT = str;
        luVar.wbr = str2;
        luVar.vOh = str3;
        luVar.oeK = i;
        luVar.wbp = str4;
        luVar.wbo = str5;
        x.i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", str2, Integer.valueOf(i));
    }

    public final int getType() {
        return 1960;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.lph = (lv) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", Integer.valueOf(this.lph.lot), this.lph.lou);
        if (!(this.lpb || this.lph.lot == 0)) {
            this.lpc = true;
        }
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }
}
