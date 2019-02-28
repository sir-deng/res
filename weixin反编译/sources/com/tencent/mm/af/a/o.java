package com.tencent.mm.af.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zo;
import com.tencent.mm.protocal.c.zp;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;
    boolean hte = false;

    public o(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new zo();
        aVar.hnU = new zp();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfo";
        aVar.hnS = 1352;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        zo zoVar = (zo) this.gLB.hnQ.hnY;
        zoVar.vUb = str;
        zoVar.vUh = str2;
        this.hte = true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetBizChatInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1352;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetBizChatInfo", "do scene");
        return a(eVar, this.gLB, this);
    }
}
