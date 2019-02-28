package com.tencent.mm.bc;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.protocal.c.bhx;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    String hNc;

    public a(float f, float f2, int i, int i2, String str, String str2, int i3, int i4, String str3) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bhx();
        aVar.hnU = new bhy();
        aVar.uri = "/cgi-bin/micromsg-bin/sensewhere";
        this.gLB = aVar.Kf();
        aot aot = new aot();
        aot.wjx = str2;
        aot.wjy = i2;
        aot.vXy = f2;
        aot.vXx = f;
        aot.wjw = str;
        aot.wjv = i;
        bhx bhx = (bhx) this.gLB.hnQ.hnY;
        bhx.wfE = aot;
        bhx.wSJ = i3;
        bhx.sfa = i4;
        bhx.noL = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.hNc = ((bhy) ((b) qVar).hnR.hnY).noL;
        } else {
            x.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 752;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
