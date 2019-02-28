package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ayr;
import com.tencent.mm.protocal.c.ays;
import com.tencent.mm.sdk.platformtools.x;

public final class ag extends k implements com.tencent.mm.network.k {
    public String content;
    public String fGc;
    private final b gLB;
    private e gLE;
    public String iPT;
    public String kRQ;
    public String kRR;
    public boolean kRS;
    public String kRT;
    public String kRU;
    public String kRV;
    public String kRW;
    public int status;

    public ag(int i, String str, String str2) {
        a aVar = new a();
        aVar.hnT = new ayr();
        aVar.hnU = new ays();
        aVar.uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
        this.gLB = aVar.Kf();
        ayr ayr = (ayr) this.gLB.hnQ.hnY;
        ayr.vLy = i;
        ayr.vLz = str;
        ayr.vLA = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            ays ays = (ays) this.gLB.hnR.hnY;
            this.fGc = ays.vLD;
            this.kRQ = ays.vLE;
            this.status = ays.status;
            this.content = ays.content;
            this.kRR = ays.kRl;
            this.iPT = ays.wMh;
            this.kRS = ays.kRS;
            this.kRT = ays.wMi;
            this.kRU = ays.wMj;
            this.kRV = ays.wMk;
            this.kRW = ays.wMl;
            x.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", this.fGc, this.kRQ, Integer.valueOf(this.status), this.content, this.kRR, this.iPT, Boolean.valueOf(this.kRS));
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1171;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
