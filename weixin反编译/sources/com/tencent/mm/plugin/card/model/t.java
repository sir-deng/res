package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.protocal.c.fr;
import com.tencent.mm.protocal.c.fs;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.LinkedList;

public final class t extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public LinkedList<CardInfo> kRF = new LinkedList();

    public t(LinkedList<kx> linkedList, bmz bmz, int i) {
        a aVar = new a();
        aVar.hnT = new fr();
        aVar.hnU = new fs();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
        aVar.hnS = 699;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        fr frVar = (fr) this.gLB.hnQ.hnY;
        frVar.hfI = linkedList;
        frVar.vLw = bmz;
        frVar.fHR = i;
    }

    public final int getType() {
        return 699;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            Object obj = ((fs) this.gLB.hnR.hnY).kRy;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.gLE.a(4, -1, null, this);
                return;
            }
            Collection xn = f.xn(obj);
            if (xn != null) {
                l.axL();
                this.kRF.addAll(xn);
            }
            this.gLE.a(0, 0, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gLE.a(i2, i3, str, this);
    }
}
