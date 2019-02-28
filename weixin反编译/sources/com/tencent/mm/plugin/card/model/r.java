package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.fj;
import com.tencent.mm.protocal.c.fk;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    private int kRC = 0;

    public r(LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hnT = new fj();
        aVar.hnU = new fk();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelcarditem";
        aVar.hnS = 560;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((fj) this.gLB.hnQ.hnY).vRU = linkedList;
    }

    public final int getType() {
        return 560;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((fk) this.gLB.hnR.hnY).vRV;
            String str2 = "MicroMsg.NetSceneBatchDelCardItem";
            String str3 = "onGYNetEnd, resp list count = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(linkedList == null ? 0 : linkedList.size());
            x.i(str2, str3, objArr);
            if (linkedList == null || linkedList.size() == 0) {
                x.e("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd fail, resp list is null");
            } else {
                this.kRC = 0;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    boolean z;
                    String str4 = (String) it.next();
                    if (TextUtils.isEmpty(str4)) {
                        x.e("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem fail, id is null");
                        z = false;
                    } else {
                        c cardInfo = new CardInfo();
                        cardInfo.field_card_id = str4;
                        z = am.avh().a(cardInfo, new String[0]);
                        x.i("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem, delRet = %b", Boolean.valueOf(z));
                    }
                    if (!z) {
                        this.kRC++;
                    }
                }
                x.d("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, %d fail items", Integer.valueOf(this.kRC));
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
