package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.c.aai;
import com.tencent.mm.protocal.c.aaj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class y extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public y() {
        a aVar = new a();
        aVar.hnT = new aai();
        aVar.hnU = new aaj();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardcount";
        this.gLB = aVar.Kf();
    }

    public final int getType() {
        return 663;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            aaj aaj = (aaj) this.gLB.hnR.hnY;
            x.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + aaj.wqw + " has_share_card:" + aaj.wqx);
            if (aaj.wqw > 0) {
                l.axL();
                as.Hm();
                if (TextUtils.isEmpty((String) c.Db().get(w.a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, null))) {
                    am.avg();
                    com.tencent.mm.plugin.card.a.b.nX(1);
                }
            }
            if (aaj.wqx > 0) {
                l.axN();
                as.Hm();
                Long l = (Long) c.Db().get(w.a.USERINFO_CARD_REQUENCE_LONG_SYNC, Long.valueOf(0));
                if (l != null && l.longValue() == 0) {
                    am.avo().avy();
                }
            }
        }
        as.Hm();
        c.Db().set(282882, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        this.gLE.a(i2, i3, str, this);
    }
}
