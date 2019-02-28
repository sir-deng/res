package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ain;
import com.tencent.mm.protocal.c.aio;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE;
    private ain nLf = null;
    public aio nLg = null;
    public boolean nLh = true;

    public f(String str, String str2) {
        if (bi.oN(str2)) {
            this.nLh = true;
            str2 = "";
        } else {
            this.nLh = false;
        }
        a aVar = new a();
        aVar.hnT = new ain();
        aVar.hnU = new aio();
        aVar.hnS = 929;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.nLf = (ain) this.gLB.hnQ.hnY;
        this.nLf.wws = str;
        this.nLf.wwt = str2;
        x.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
    }

    public final int getType() {
        return 929;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nLg = (aio) ((b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
