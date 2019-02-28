package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpv;
import com.tencent.mm.protocal.c.bpw;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public String username;

    public n(String str, String str2) {
        a aVar = new a();
        this.username = str2;
        com.tencent.mm.bp.a bpv = new bpv();
        bpv.wfN = str;
        bpv.wYL = str2;
        aVar.hnT = bpv;
        aVar.hnU = new bpw();
        aVar.uri = "/cgi-bin/micromsg-bin/transferchatroomowner";
        this.gLB = aVar.Kf();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.w("MicroMsg.NetSceneTransferChatRoomOwner", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 990;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
