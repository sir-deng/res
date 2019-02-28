package com.tencent.mm.openim.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.btp;
import com.tencent.mm.protocal.c.btq;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public String idC;

    public g(String str, String str2) {
        a aVar = new a();
        aVar.hnT = new btp();
        aVar.hnU = new btq();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyopenimcontact";
        this.gLB = aVar.Kf();
        this.idC = str;
        btp btp = (btp) this.gLB.hnQ.hnY;
        btp.idC = str;
        btp.xbr = str2;
        x.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "tp_username: %s, verify_ticket:%s", str, str2);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.idC);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 853;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
