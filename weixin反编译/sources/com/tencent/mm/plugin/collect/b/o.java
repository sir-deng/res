package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bit;
import com.tencent.mm.protocal.c.biu;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    private bit loK;

    public o(String str) {
        a aVar = new a();
        aVar.hnT = new bit();
        aVar.hnU = new biu();
        aVar.uri = "/cgi-bin/micromsg-bin/setpushsound";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        this.loK = (bit) this.hPx.hnQ.hnY;
        this.loK.kzz = 3;
        this.loK.wSU = str;
        x.i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", Integer.valueOf(3), str);
    }

    public final int getType() {
        return 304;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSetPushSound", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
