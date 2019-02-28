package com.tencent.mm.af;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zu;
import com.tencent.mm.protocal.c.zv;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends k implements com.tencent.mm.network.k {
    Object data;
    public b gLB;
    private e gLE;

    public r(String str, int i, Object obj) {
        a aVar = new a();
        aVar.hnT = new zu();
        aVar.hnU = new zv();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizenterpriseattr";
        this.gLB = aVar.Kf();
        zu zuVar = (zu) this.gLB.hnQ.hnY;
        zuVar.vUh = str;
        zuVar.wqk = i;
        zuVar.wql = w.cfV().equals("zh_CN") ? 2 : 1;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1343;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.NetSceneGetBizEnterpriseAttr", "do scene");
        return a(eVar, this.gLB, this);
    }
}
