package com.tencent.mm.af.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acn;
import com.tencent.mm.protocal.c.aco;
import com.tencent.mm.sdk.platformtools.x;

public final class s extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;

    public s(String str) {
        a aVar = new a();
        aVar.hnT = new acn();
        aVar.hnU = new aco();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getfavbizchatlist";
        this.gLB = aVar.Kf();
        ((acn) this.gLB.hnQ.hnY).vUh = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetFavBizChatList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1367;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetFavBizChatList", "do scene");
        return a(eVar, this.gLB, this);
    }
}
