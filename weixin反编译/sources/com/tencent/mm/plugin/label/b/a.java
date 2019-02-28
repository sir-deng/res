package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.protocal.c.bo;
import com.tencent.mm.protocal.c.bp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    private LinkedList<aoh> nUk = new LinkedList();

    public a(String str) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bo();
        aVar.hnU = new bp();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.hnS = 635;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        if (!bi.oN(str)) {
            aoh aoh = new aoh();
            aoh.wBS = str;
            this.nUk.add(aoh);
        }
    }

    public a(List<String> list) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bo();
        aVar.hnU = new bp();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.hnS = 635;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                aoh aoh = new aoh();
                aoh.wBS = (String) list.get(i);
                this.nUk.add(aoh);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
        this.gLE = eVar2;
        bo boVar = (bo) this.gLB.hnQ.hnY;
        if (this.nUk == null || this.nUk.size() <= 0) {
            x.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
            eVar2.a(3, -1, "[doScene]empty contact list.", this);
            return 0;
        }
        boVar.vNz = this.nUk;
        boVar.vNy = this.nUk.size();
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        bp aVE = aVE();
        if (aVE != null) {
            LinkedList linkedList = aVE.vNz;
            List arrayList = new ArrayList();
            int size = linkedList.size();
            for (int i4 = 0; i4 < size; i4++) {
                aoh aoh = (aoh) linkedList.get(i4);
                z zVar = new z();
                zVar.field_labelID = aoh.wBT;
                zVar.field_labelName = aoh.wBS;
                zVar.field_labelPYFull = c.oD(aoh.wBS);
                zVar.field_labelPYShort = c.oE(aoh.wBS);
                zVar.field_isTemporary = false;
                arrayList.add(zVar);
            }
            com.tencent.mm.plugin.label.e.aVC().cG(arrayList);
            com.tencent.mm.plugin.label.e.aVC().cH(arrayList);
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 635;
    }

    public final bp aVE() {
        return (bp) this.gLB.hnR.hnY;
    }
}
