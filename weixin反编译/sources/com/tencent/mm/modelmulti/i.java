package com.tencent.mm.modelmulti;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ayp;
import com.tencent.mm.protocal.c.ayq;
import com.tencent.mm.protocal.c.bqf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    private int hGW = 0;

    public i(int i, String str) {
        a aVar = new a();
        aVar.hnT = new ayp();
        aVar.hnU = new ayq();
        aVar.uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
        aVar.hnS = 1804;
        this.gLB = aVar.Kf();
        ayp ayp = (ayp) this.gLB.hnQ.hnY;
        ayp.wsC = i;
        ayp.wsE = str;
        if ((i & 16) > 0) {
            com.tencent.mm.ui.i.a aVar2 = new com.tencent.mm.ui.i.a();
            bqf bqf = new bqf();
            if (aVar2.zyZ == null) {
                bqf = null;
            } else if (!bi.oN(aVar2.zyZ.token)) {
                bqf.wYZ = aVar2.zyZ.token;
                bqf.wZa = aVar2.zyZ.wFv;
            }
            ayp.wMg = bqf;
        }
        this.hGW = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.gLE.a(i2, i3, str, this);
        } else {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1804;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
