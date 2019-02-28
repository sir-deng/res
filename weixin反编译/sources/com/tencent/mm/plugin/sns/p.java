package com.tencent.mm.plugin.sns;

import com.tencent.mm.f.a.sg;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.blz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p extends c<sg> {
    public p() {
        this.xmG = sg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 0;
        sg sgVar = (sg) bVar;
        if (sgVar instanceof sg) {
            if (sgVar.fKL.fKN instanceof u) {
                u uVar = (u) sgVar.fKL.fKN;
                int i2 = uVar.raD;
                LinkedList linkedList = uVar.raC;
                sgVar.fKM.state = i2;
                if (i2 == 2) {
                    if (linkedList != null && linkedList.size() > 0) {
                        ae.bwl().eV(7);
                    }
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            blz blz = (blz) it.next();
                            if (blz.wVU == 7) {
                                s sVar = new s();
                                u.a(sVar, blz);
                                ae.bwl().a(sVar);
                            }
                        }
                    }
                }
                if (i2 != 1) {
                    s eU = ae.bwl().eU(7);
                    sg.b bVar2 = sgVar.fKM;
                    List linkedList2 = new LinkedList();
                    if (eU.field_memberList != null) {
                        String[] split = eU.field_memberList.split(",");
                        int length = split.length;
                        while (i < length) {
                            linkedList2.add(split[i]);
                            i++;
                        }
                    }
                    bVar2.fKO = linkedList2;
                }
            }
            return true;
        }
        x.f("MicroMsg.UpdateSnsTagListListener", "mismatched event");
        return false;
    }
}
