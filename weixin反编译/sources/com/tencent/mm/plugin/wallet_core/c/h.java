package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ys;
import com.tencent.mm.protocal.c.yt;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    public yt sOA;
    public long sOB;
    private ys sOz;

    public h(String str, long j) {
        a aVar = new a();
        aVar.hnT = new ys();
        aVar.hnU = new yt();
        aVar.uri = "/cgi-bin/mmpay-bin/mktgetaward";
        this.hPx = aVar.Kf();
        this.sOz = (ys) this.hPx.hnQ.hnY;
        this.sOz.wpI = str;
        this.sOB = j;
        x.i("MicroMsg.NetSceneMktGetAward", "NetSceneMktGetAward, get_award_params: %s, activityId: %s", str, Long.valueOf(j));
    }

    public final int getType() {
        return 2948;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMktGetAward", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.sOA = (yt) ((b) qVar).hnR.hnY;
        if (i2 == 0 || i3 == 0) {
            x.i("MicroMsg.NetSceneMktGetAward", "ret_code: %s, ret_msg: %s, result_code: %s, alert_wording: %s, btn_wording: %s", Integer.valueOf(this.sOA.kRz), this.sOA.kRA, Integer.valueOf(this.sOA.wpJ), this.sOA.wpK, this.sOA.wpL);
        }
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
