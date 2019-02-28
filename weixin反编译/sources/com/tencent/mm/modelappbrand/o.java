package com.tencent.mm.modelappbrand;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cdq;
import com.tencent.mm.protocal.c.cdr;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends k implements com.tencent.mm.network.k {
    private e gQm;
    private final b hln;

    public o(String str) {
        a aVar = new a();
        aVar.hnT = new cdq();
        aVar.hnU = new cdr();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
        this.hln = aVar.Kf();
        ((cdq) this.hln.hnQ.hnY).xjd = str;
    }

    public final cdr Jl() {
        if (this.hln != null) {
            return (cdr) this.hln.hnR.hnY;
        }
        return null;
    }

    public final int getType() {
        return 1198;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gQm != null) {
            this.gQm.a(i2, i3, str, this);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.gQm = eVar2;
        return a(eVar, this.hln, this);
    }
}
