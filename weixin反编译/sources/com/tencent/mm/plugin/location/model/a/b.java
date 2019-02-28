package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.anl;
import com.tencent.mm.protocal.c.anm;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public int errCode;
    public int errType;
    public String foE;
    public final com.tencent.mm.ad.b gLB;
    private e gLE;
    private Runnable hPS;
    public String jgc;
    public String nWc = "";

    public b(String str) {
        a aVar = new a();
        aVar.hnT = new anl();
        aVar.hnU = new anm();
        aVar.uri = "/cgi-bin/micromsg-bin/jointrackroom";
        aVar.hnS = 490;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((anl) this.gLB.hnQ.hnY).wBx = str;
        x.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:" + str);
    }

    public final int getType() {
        return 490;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        anm anm;
        this.errType = i2;
        this.errCode = i3;
        this.foE = str;
        if (((com.tencent.mm.ad.b) qVar).hnR.hnY != null) {
            anm = (anm) ((com.tencent.mm.ad.b) qVar).hnR.hnY;
        } else {
            anm = null;
        }
        x.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if ((i3 == 0 || i3 >= 1000) && anm != null) {
            this.nWc = anm.wiv;
            x.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", this.nWc);
        }
        if (anm != null) {
            this.jgc = anm.vXU;
        }
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
        if (this.hPS != null) {
            this.hPS.run();
        }
    }
}
