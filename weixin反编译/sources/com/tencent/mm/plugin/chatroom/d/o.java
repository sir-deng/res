package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.protocal.c.brj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.m;

public final class o extends k implements com.tencent.mm.network.k {
    public String chatroomName = null;
    public int gDq = 0;
    private final b gLB;
    private e gLE = null;
    public String lfa = null;
    public String lfk = null;
    public int lfl = 0;

    public o(String str) {
        a aVar = new a();
        aVar.hnT = new bri();
        aVar.hnU = new brj();
        aVar.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
        aVar.hnS = 482;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.chatroomName = str;
        ((bri) this.gLB.hnQ.hnY).wfN = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 482;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        brj brj = (brj) this.gLB.hnR.hnY;
        x.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.lfk = brj.wGr;
        if (!bi.oN(this.lfk)) {
            as.Hm();
            com.tencent.mm.storage.q hG = c.Fo().hG(this.chatroomName);
            if (hG == null) {
                hG = new com.tencent.mm.storage.q();
            }
            hG.fI(com.tencent.mm.y.q.FY(), this.lfk);
            m.a(hG);
        }
        this.lfa = brj.wqX;
        this.gDq = brj.wqW;
        this.lfl = brj.wqY;
        this.gLE.a(i2, i3, str, this);
    }
}
