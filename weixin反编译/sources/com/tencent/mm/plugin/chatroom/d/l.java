package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ben;
import com.tencent.mm.protocal.c.beo;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public l(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new ben();
        aVar.hnU = new beo();
        aVar.uri = "/cgi-bin/micromsg-bin/revokechatroomqrcode";
        this.gLB = aVar.Kf();
        ben ben = (ben) this.gLB.hnQ.hnY;
        ben.wRc = str;
        ben.wRd = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 700;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.RevokeChatRoomQRCodeRequest", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gLE.a(i2, i3, str, this);
    }
}
