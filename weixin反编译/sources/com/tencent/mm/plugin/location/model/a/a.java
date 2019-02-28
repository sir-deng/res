package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.tm;
import com.tencent.mm.protocal.c.tn;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gLE;
    private Runnable hPS;

    public a(String str) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new tm();
        aVar.hnU = new tn();
        aVar.uri = "/cgi-bin/micromsg-bin/exittrackroom";
        this.gLB = aVar.Kf();
        ((tm) this.gLB.hnQ.hnY).wiv = str;
        x.d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:" + str);
    }

    public final int getType() {
        return 491;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
        if (this.hPS != null) {
            this.hPS.run();
        }
    }
}
