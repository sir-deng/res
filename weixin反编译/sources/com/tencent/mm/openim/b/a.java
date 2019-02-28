package com.tencent.mm.openim.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bz;
import com.tencent.mm.protocal.c.ca;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public String idC;

    public a(String str, String str2) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bz();
        aVar.hnU = new ca();
        aVar.uri = "/cgi-bin/micromsg-bin/addopenimcontact";
        this.gLB = aVar.Kf();
        this.idC = str;
        bz bzVar = (bz) this.gLB.hnQ.hnY;
        bzVar.idC = str;
        bzVar.vNZ = str2;
        x.i("MicroMsg.FreeWifi.NetSceneAddOpenIMContact", "tp_username: %s, antispam_ticket:%s", str, str2);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FreeWifi.NetSceneAddOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.idC);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 667;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
