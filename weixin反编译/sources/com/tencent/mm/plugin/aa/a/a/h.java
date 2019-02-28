package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.l;
import com.tencent.mm.protocal.c.m;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    private l ijt;
    public m iju;

    public h() {
        a aVar = new a();
        aVar.hnT = new l();
        aVar.hnU = new m();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaoperation";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        this.ijt = (l) this.hPx.hnQ.hnY;
    }

    public final int getType() {
        return 1698;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.iju = (m) ((b) qVar).hnR.hnY;
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", Integer.valueOf(this.iju.lot), this.iju.lou, Integer.valueOf(this.iju.vJW), Integer.valueOf(this.iju.vJX), Integer.valueOf(this.iju.vJY), Long.valueOf(this.iju.vJZ), Long.valueOf(this.iju.vKa), this.iju.loF, this.iju.loG);
        }
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
