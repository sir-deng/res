package com.tencent.mm.openim.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.f.g;
import com.tencent.mm.protocal.c.bhh;
import com.tencent.mm.protocal.c.bhi;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    private String idC;

    public f(String str, String str2, String str3) {
        this.idC = str;
        a aVar = new a();
        aVar.hnT = new bhh();
        aVar.hnU = new bhi();
        aVar.uri = "/cgi-bin/micromsg-bin/sendopenimverifyrequest";
        aVar.hnS = g.CTRL_INDEX;
        this.gLB = aVar.Kf();
        bhh bhh = (bhh) this.gLB.hnQ.hnY;
        bhh.idC = str;
        bhh.wSw = str2;
        bhh.vNZ = str3;
        x.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "init user:%s anti:%s", str, str3);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return g.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.idC);
        if (!(i2 == 0 && i3 == 0)) {
            x.e("MicroMsg.NetSceneSendOpenIMVerifyRequest", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.gLE.a(i2, i3, str, this);
    }
}
