package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ft;
import com.tencent.mm.protocal.c.fu;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class s extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    private LinkedList<ak> kRD;
    public LinkedList<ak> kRE = new LinkedList();

    public s(LinkedList<ak> linkedList) {
        this.kRD = linkedList;
        a aVar = new a();
        aVar.hnT = new ft();
        aVar.hnU = new fu();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditem";
        aVar.hnS = 559;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ((ft) this.gLB.hnQ.hnY).vRU = E(linkedList);
    }

    public final int getType() {
        return 559;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            Object obj = ((fu) this.gLB.hnR.hnY).kRy;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.gLE.a(4, -1, null, this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList xn = f.xn(obj);
            if (xn != null) {
                int i4;
                if (this.kRD != null) {
                    this.kRE.addAll(this.kRD);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                as.Hm();
                long dA = c.Fc().dA(Thread.currentThread().getId());
                int i5 = 0;
                int i6 = 0;
                Iterator it = xn.iterator();
                while (true) {
                    i4 = i5;
                    if (!it.hasNext()) {
                        break;
                    }
                    CardInfo cardInfo = (CardInfo) it.next();
                    i4++;
                    if (!l.b(cardInfo)) {
                        i6++;
                        LinkedList linkedList = this.kRE;
                        if (cardInfo != null) {
                            ak akVar = new ak();
                            akVar.field_cardUserId = cardInfo.field_card_id;
                            linkedList.remove(akVar);
                        }
                    }
                    i5 = i6;
                }
                as.Hm();
                c.Fc().fT(dA);
                x.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd do transaction use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, deal CardObject %d fail of %d", Integer.valueOf(i6), Integer.valueOf(i4));
                l.axL();
                if (xn.size() > 0) {
                    i5 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(43);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(44);
                    iDKey2.SetValue((long) i5);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(45);
                    iDKey3.SetValue((long) xn.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(47);
                    iDKey4.SetValue((long) (i5 / xn.size()));
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    g.pWK.a(arrayList, true);
                }
            }
            this.gLE.a(0, 0, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gLE.a(i2, i3, str, this);
    }

    private static LinkedList<String> E(LinkedList<ak> linkedList) {
        LinkedList<String> linkedList2 = new LinkedList();
        if (linkedList == null || linkedList.size() == 0) {
            return linkedList2;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ak akVar = (ak) it.next();
            if (akVar != null) {
                linkedList2.add(akVar.field_cardUserId);
            }
        }
        return linkedList2;
    }
}
