package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adg;
import com.tencent.mm.protocal.c.adh;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    public final b hTp;
    private e ptc;

    public c() {
        a aVar = new a();
        aVar.hnT = new adg();
        aVar.hnU = new adh();
        aVar.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
        this.hTp = aVar.Kf();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetImUnreadMsgCount", "end get im unread msg count, errType: %d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ptc.a(i2, i3, str, this);
    }

    public final int getType() {
        return 630;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
        this.ptc = eVar2;
        return a(eVar, this.hTp, this);
    }
}
