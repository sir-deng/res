package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.protocal.c.abm;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public c() {
        a aVar = new a();
        aVar.hnT = new abl();
        aVar.hnU = new abm();
        aVar.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
        this.gLB = aVar.Kf();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4 = 0;
        x.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            as.Hm();
            com.tencent.mm.y.c.Db().set(209408, Long.valueOf(System.currentTimeMillis()));
            abm abm = (abm) this.gLB.hnR.hnY;
            if (!(abm == null || abm.vNz == null)) {
                LinkedList linkedList = abm.vNz;
                List arrayList = new ArrayList();
                int size = linkedList.size();
                while (i4 < size) {
                    aoh aoh = (aoh) linkedList.get(i4);
                    z zVar = new z();
                    zVar.field_labelID = aoh.wBT;
                    zVar.field_labelName = aoh.wBS;
                    zVar.field_labelPYFull = com.tencent.mm.platformtools.c.oD(aoh.wBS);
                    zVar.field_labelPYShort = com.tencent.mm.platformtools.c.oE(aoh.wBS);
                    arrayList.add(zVar);
                    i4++;
                }
                com.tencent.mm.plugin.label.e.aVC().cH(arrayList);
                com.tencent.mm.plugin.label.e.aVC().cI(com.tencent.mm.plugin.label.e.aVC().cJ(arrayList));
            }
        } else {
            x.w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 639;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
