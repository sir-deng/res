package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.anp;
import com.tencent.mm.protocal.c.anq;
import com.tencent.mm.sdk.platformtools.x;

public final class aa extends k implements com.tencent.mm.network.k {
    private e gLE;
    private final b hGV;
    public Object tag;

    public aa(String str) {
        a aVar = new a();
        aVar.hnT = new anp();
        aVar.hnU = new anq();
        aVar.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
        this.hGV = aVar.Kf();
        ((anp) this.hGV.hnQ.hnY).nlE = str;
    }

    public final int getType() {
        return 666;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:net end ok");
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final anq St() {
        return (anq) this.hGV.hnR.hnY;
    }
}
