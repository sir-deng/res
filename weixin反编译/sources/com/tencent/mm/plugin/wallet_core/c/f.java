package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aex;
import com.tencent.mm.protocal.c.aey;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public String sOu = "";
    public boolean sOv = false;

    public f() {
        a aVar = new a();
        aVar.hnT = new aex();
        aVar.hnU = new aey();
        aVar.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
        aVar.hnS = 2541;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public final int getType() {
        return 2541;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MircoMsg.NetSceneGetPayUserDuty", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            aey aey = (aey) ((b) qVar).hnR.hnY;
            this.sOu = aey.sOu;
            this.sOv = aey.sOv;
            x.i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s need_agree_duty %s", this.sOu, Boolean.valueOf(this.sOv));
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
