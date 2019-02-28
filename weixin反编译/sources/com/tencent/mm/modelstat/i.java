package com.tencent.mm.modelstat;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bc;
import com.tencent.mm.protocal.c.bd;
import com.tencent.mm.protocal.c.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gQm;

    public i(int i, String str, int i2) {
        a aVar = new a();
        aVar.hnT = new bc();
        aVar.hnU = new bd();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        this.gLB = aVar.Kf();
        bc bcVar = (bc) this.gLB.hnQ.hnY;
        bi biVar = new bi();
        biVar.vNn = i;
        biVar.vNo = new com.tencent.mm.bp.b(str.getBytes());
        biVar.vNp = (long) i2;
        bcVar.vMY.add(biVar);
        x.i("MicroMsg.NetSceneAdDataReport", "init logId:%d, logStr:%s", Integer.valueOf(i), str);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bd bdVar = (bd) this.gLB.hnR.hnY;
        x.i("MicroMsg.NetSceneAdDataReport", "onGYNetEnd, errType = %d, errCode = %d, ret=%d, msg=%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bdVar.ret), bdVar.fpV);
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1295;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }
}
