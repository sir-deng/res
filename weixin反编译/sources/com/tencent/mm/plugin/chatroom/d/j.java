package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajt;
import com.tencent.mm.protocal.c.aju;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class j extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE = null;

    public final int getType() {
        return 339;
    }

    public j(String str) {
        a aVar = new a();
        aVar.hnT = new ajt();
        aVar.hnU = new aju();
        aVar.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
        aVar.hnS = 339;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((ajt) this.gLB.hnQ.hnY).npV = str;
        x.d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :" + str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGrantBigChatRoom", "onGYNetEnd " + i2 + " " + i3 + "  " + str);
        if (i2 == 0 && i3 == 0) {
            as.Hm();
            int intValue = ((Integer) c.Db().get(135176, Integer.valueOf(0))).intValue();
            if (intValue - 1 >= 0) {
                as.Hm();
                c.Db().set(135176, Integer.valueOf(intValue - 1));
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
