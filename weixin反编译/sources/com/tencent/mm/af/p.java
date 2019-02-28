package com.tencent.mm.af;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hm;
import com.tencent.mm.protocal.c.hn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class p extends k implements com.tencent.mm.network.k {
    private String gBJ;
    b gLB;
    private e gLE;
    private a<p> hrO;

    public interface a<T extends k> {
        void b(int i, int i2, String str, T t);
    }

    public p(String str, String str2, a<p> aVar) {
        this(str, str2);
        this.hrO = aVar;
    }

    private p(String str, String str2) {
        this.gBJ = str;
        x.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", str);
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnS = 1075;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
        aVar.hnT = new hm();
        aVar.hnU = new hn();
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        hm hmVar = (hm) this.gLB.hnQ.hnY;
        hmVar.vTX = this.gBJ;
        hmVar.vTY = new com.tencent.mm.bp.b(bi.Wj(bi.oM(str2)));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
        if (this.hrO != null) {
            this.hrO.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1075;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
