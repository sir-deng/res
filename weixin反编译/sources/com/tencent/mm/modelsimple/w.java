package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azb;
import com.tencent.mm.protocal.c.fi;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    private azb hPy;

    public w(int i) {
        a aVar = new a();
        aVar.hnT = new azb();
        aVar.hnU = new fi();
        aVar.uri = "/cgi-bin/micromsg-bin/privacypolicychoise";
        this.hPx = aVar.Kf();
        this.hPy = (azb) this.hPx.hnQ.hnY;
        this.hPy.wME = i;
    }

    public final int getType() {
        return 268;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetScenePrivacyPolicyChoice", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
