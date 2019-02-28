package com.tencent.mm.af.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.zq;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends k implements com.tencent.mm.network.k {
    Object data;
    public b gLB;
    private e gLE;

    public q(String str, Object obj) {
        a aVar = new a();
        aVar.hnT = new zq();
        aVar.hnU = new zr();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatmyuserinfo";
        this.gLB = aVar.Kf();
        ((zq) this.gLB.hnQ.hnY).vUh = str;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1354;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "do scene");
        return a(eVar, this.gLB, this);
    }
}
