package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ma;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardSetPhotoWord";
    private b gLB;
    private e gLE;
    public String kMY;
    public mb lpl;

    public h(String str) {
        a aVar = new a();
        aVar.hnT = new ma();
        aVar.hnU = new mb();
        aVar.hnS = 1649;
        aVar.uri = "/cgi-bin/mmpay-bin/setrewardqrcodephotoword";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((ma) this.gLB.hnQ.hnY).kMY = str;
        this.kMY = str;
        if (str.length() > 0 && str.length() <= 3) {
            g.pWK.a(724, 0, 1, false);
        } else if (str.length() > 3) {
            g.pWK.a(724, 1, 1, false);
        }
    }

    public final int getType() {
        return 1649;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.lpl = (mb) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "retcode: %s, retmsg: %s", Integer.valueOf(this.lpl.lot), this.lpl.lou);
        if (!(this.lpb || this.lpl.lot == 0)) {
            this.lpc = true;
        }
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
    }
}
