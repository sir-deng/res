package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abd;
import com.tencent.mm.protocal.c.abe;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    public String chatroomName;
    private final b gLB;
    private e gLE = null;
    public String lfa;
    public int lfb;
    public int lfc;
    public int status;

    public h(String str) {
        a aVar = new a();
        aVar.hnT = new abd();
        aVar.hnU = new abe();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
        aVar.hnS = 519;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.chatroomName = str;
        ((abd) this.gLB.hnQ.hnY).wfN = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 519;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        abe abe = (abe) this.gLB.hnR.hnY;
        x.d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.status = abe.kyY;
        this.lfa = abe.wqX;
        this.lfc = abe.wqY;
        this.lfa = abe.wqX;
        this.lfb = abe.wqW;
        this.gLE.a(i2, i3, str, this);
    }
}
