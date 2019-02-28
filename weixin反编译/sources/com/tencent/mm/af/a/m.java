package com.tencent.mm.af.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    Object data;
    public b gLB;
    private e gLE;
    public String htd;

    public m(String str, String str2, String str3, Object obj) {
        a aVar = new a();
        aVar.hnT = new pm();
        aVar.hnU = new pn();
        aVar.uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
        this.gLB = aVar.Kf();
        pm pmVar = (pm) this.gLB.hnQ.hnY;
        pmVar.wfm = str;
        pmVar.wfo = str2;
        pmVar.wfn = str3;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1315;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.NetSceneConvertBizChat", "do scene");
        return a(eVar, this.gLB, this);
    }

    public final pn ME() {
        if (this.gLB == null || this.gLB.hnR.hnY == null) {
            return null;
        }
        return (pn) this.gLB.hnR.hnY;
    }
}
