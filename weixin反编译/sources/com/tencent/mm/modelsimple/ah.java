package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdd;
import com.tencent.mm.protocal.c.bip;
import com.tencent.mm.protocal.c.biq;
import com.tencent.mm.sdk.platformtools.x;

public final class ah extends k implements com.tencent.mm.network.k {
    private e gLE;
    public final b hGV;

    public ah(int i, bdd bdd) {
        x.i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", Integer.valueOf(i), bdd.wPP, Integer.valueOf(bdd.lUo), Integer.valueOf(bdd.kzz), Integer.valueOf(bdd.wMK));
        a aVar = new a();
        aVar.hnT = new bip();
        aVar.hnU = new biq();
        aVar.uri = "/cgi-bin/micromsg-bin/setmsgremind";
        this.hGV = aVar.Kf();
        bip bip = (bip) this.hGV.hnQ.hnY;
        if (i == 0) {
            i = 1;
        }
        bip.nne = i;
        bip.wST = bdd;
    }

    public final int getType() {
        return 525;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", ((biq) this.hGV.hnR.hnY).wPP);
        } else {
            x.e("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        }
        this.gLE.a(i2, i3, str, this);
    }
}
