package com.tencent.mm.modelstat;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acl;
import com.tencent.mm.protocal.c.acm;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private e gQm;
    final b hTp;

    public j(com.tencent.mm.bp.b bVar) {
        a aVar = new a();
        com.tencent.mm.bp.a acl = new acl();
        acl.wsb = bVar;
        aVar.hnT = acl;
        aVar.hnU = new acm();
        aVar.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
        aVar.hnS = 1126;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hTp = aVar.Kf();
    }

    public final int getType() {
        return 1126;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
        this.hop = true;
        this.gQm = eVar2;
        return a(eVar, this.hTp, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar.toString());
        this.gQm.a(i2, i3, str, this);
    }
}
