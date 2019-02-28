package com.tencent.mm.af.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.protocal.c.pt;
import com.tencent.mm.protocal.c.ws;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    Object data;
    public b gLB;
    private e gLE;

    public n(String str, ws wsVar, Object obj) {
        a aVar = new a();
        aVar.hnT = new ps();
        aVar.hnU = new pt();
        aVar.uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
        this.gLB = aVar.Kf();
        ps psVar = (ps) this.gLB.hnQ.hnY;
        psVar.vUh = str;
        psVar.wfx = wsVar;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1355;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
        return a(eVar, this.gLB, this);
    }

    public final pt MF() {
        if (this.gLB == null || this.gLB.hnR.hnY == null) {
            return null;
        }
        return (pt) this.gLB.hnR.hnY;
    }

    public final ps MG() {
        if (this.gLB == null || this.gLB.hnQ.hnY == null) {
            return null;
        }
        return (ps) this.gLB.hnQ.hnY;
    }
}
