package com.tencent.mm.openim.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.avo;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public com.tencent.mm.plugin.messenger.foundation.a.a.e.b idG;
    private int opType;

    public d(com.tencent.mm.plugin.messenger.foundation.a.a.e.b bVar) {
        a aVar = new a();
        aVar.hnT = new avo();
        aVar.hnU = new avp();
        aVar.uri = "/cgi-bin/micromsg-bin/openimoplog";
        this.gLB = aVar.Kf();
        this.opType = bVar.ouG;
        this.idG = bVar;
        x.i("MicroMsg.NetSceneOpenIMOPLog", "type: %d", Integer.valueOf(this.opType));
        avo avo = (avo) this.gLB.hnQ.hnY;
        avo.type = this.opType;
        avo.wKd = new com.tencent.mm.bp.b(bVar.getBuffer());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 806;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpenIMOPLog", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opType:%d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.opType));
        this.gLE.a(i2, i3, str, this);
    }
}
