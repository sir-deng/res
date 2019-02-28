package com.tencent.mm.openim.b;

import com.tencent.mm.ac.h;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.protocal.c.bgh;
import com.tencent.mm.protocal.c.bgi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private com.tencent.mm.ad.e gLE;
    private String idH;
    public bgg idI;
    public String idJ;

    public e(String str) {
        this.idH = str;
        a aVar = new a();
        aVar.hnT = new bgh();
        aVar.hnU = new bgi();
        aVar.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
        aVar.hnS = q.CTRL_INDEX;
        this.gLB = aVar.Kf();
        x.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", str);
        ((bgh) this.gLB.hnQ.hnY).wRY = str;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return q.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.idI = ((bgi) this.gLB.hnR.hnY).wRZ;
            h hVar = new h();
            hVar.username = this.idI.kyG;
            hVar.hni = this.idI.wbY;
            hVar.hnh = this.idI.wbZ;
            hVar.fEo = -1;
            x.d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", hVar.getUsername(), hVar.JM(), hVar.JN());
            hVar.fWZ = 3;
            hVar.bC(true);
            n.JW().a(hVar);
            this.gLE.a(i2, i3, str, this);
            return;
        }
        if (i2 == 4 && i3 == -2034) {
            this.idJ = ((bgi) this.gLB.hnR.hnY).url;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
