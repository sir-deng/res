package com.tencent.mm.modelappbrand;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.age;
import com.tencent.mm.protocal.c.agf;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k {
    private e gQm;
    public final b hln;

    public l(int i) {
        a aVar = new a();
        aVar.hnT = new age();
        aVar.hnU = new agf();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
        this.hln = aVar.Kf();
        ((age) this.hln.hnQ.hnY).wuK = i;
    }

    public final agf Jh() {
        return (agf) this.hln.hnR.hnY;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gQm != null) {
            this.gQm.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1145;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.gQm = eVar2;
        return a(eVar, this.hln, this);
    }
}
