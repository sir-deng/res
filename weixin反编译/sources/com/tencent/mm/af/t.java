package com.tencent.mm.af;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ans;
import com.tencent.mm.protocal.c.ant;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;
    public String hrP;

    public t(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new ans();
        aVar.hnU = new ant();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetbindlist";
        this.gLB = aVar.Kf();
        ans ans = (ans) this.gLB.hnQ.hnY;
        ans.wBB = str;
        ans.wBC = str2;
        this.hrP = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneKFGetBindList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 674;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.NetSceneKFGetBindList", "do scene");
        return a(eVar, this.gLB, this);
    }

    public final ant Mg() {
        if (this.gLB == null || this.gLB.hnR.hnY == null) {
            return null;
        }
        return (ant) this.gLB.hnR.hnY;
    }
}
