package com.tencent.mm.af.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hu;
import com.tencent.mm.protocal.c.hv;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k {
    private Object data;
    public b gLB;
    private e gLE;

    public l(String str, String str2, int i) {
        a aVar = new a();
        aVar.hnT = new hu();
        aVar.hnU = new hv();
        aVar.uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
        this.gLB = aVar.Kf();
        hu huVar = (hu) this.gLB.hnQ.hnY;
        huVar.vUh = str;
        huVar.foW = str2;
        huVar.offset = i;
        this.data = null;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1364;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
        return a(eVar, this.gLB, this);
    }
}
