package com.tencent.mm.af.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bqr;
import com.tencent.mm.protocal.c.bqs;
import com.tencent.mm.protocal.c.hp;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends k implements com.tencent.mm.network.k {
    Object data;
    public b gLB;
    private e gLE;

    public w(String str, hp hpVar, Object obj) {
        a aVar = new a();
        aVar.hnT = new bqr();
        aVar.hnU = new bqs();
        aVar.uri = "/cgi-bin/mmocbiz-bin/updatebizchat";
        this.gLB = aVar.Kf();
        bqr bqr = (bqr) this.gLB.hnQ.hnY;
        bqr.vUh = str;
        bqr.wnN = hpVar;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneUpdateBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1356;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.brandservice.NetSceneUpdateBizChat", "do scene");
        return a(eVar, this.gLB, this);
    }
}
