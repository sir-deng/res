package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aas;
import com.tencent.mm.protocal.c.aat;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ad.b gLB;
    private e gLE;
    public String kRy;
    public String kSQ = "";

    public b(double d, double d2, String str) {
        a aVar = new a();
        aVar.hnT = new aas();
        aVar.hnU = new aat();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
        aVar.hnS = 1164;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        aas aas = (aas) this.gLB.hnQ.hnY;
        aas.latitude = d;
        aas.longitude = d2;
        aas.kSQ = str;
        as.Hm();
        aas.wqA = (String) c.Db().get(w.a.USERINFO_CARD_REDOT_BUFF_STRING_SYNC, (Object) "");
        x.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + aas.wqA);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(1164), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            aat aat = (aat) this.gLB.hnR.hnY;
            x.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + aat.kRy);
            this.kRy = aat.kRy;
            this.kSQ = aat.kSQ;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1164;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
