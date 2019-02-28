package com.tencent.mm.af;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.protocal.c.bii;
import com.tencent.mm.protocal.c.hx;

public final class x extends k implements com.tencent.mm.network.k {
    Object data;
    public b gLB;
    private e gLE;

    public x(hx hxVar, Object obj) {
        a aVar = new a();
        aVar.hnT = new bih();
        aVar.hnU = new bii();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
        this.gLB = aVar.Kf();
        bih bih = (bih) this.gLB.hnQ.hnY;
        bih.wqm = hxVar;
        bih.mask = 1;
        bih.wqk = 1;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1228;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
        return a(eVar, this.gLB, this);
    }
}
