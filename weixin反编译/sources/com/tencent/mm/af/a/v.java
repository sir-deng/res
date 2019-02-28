package com.tencent.mm.af.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbl;
import com.tencent.mm.protocal.c.bbm;
import com.tencent.mm.sdk.platformtools.x;

public final class v extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;

    public v(String str, String str2, int i) {
        a aVar = new a();
        aVar.hnT = new bbl();
        aVar.hnU = new bbm();
        aVar.uri = "/cgi-bin/mmocbiz-bin/qymsgstatenotify";
        this.gLB = aVar.Kf();
        bbl bbl = (bbl) this.gLB.hnQ.hnY;
        bbl.vUh = str;
        bbl.vUb = str2;
        bbl.time_stamp = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneQyMsgStateNotify", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1361;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.NetSceneQyMsgStateNotify", "do scene");
        return a(eVar, this.gLB, this);
    }
}
