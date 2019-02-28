package com.tencent.mm.plugin.qmessage;

import com.tencent.mm.f.a.mb;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.k.a;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.as;

public final class b extends c<mb> {
    public b() {
        this.xmG = mb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        mb mbVar = (mb) bVar;
        switch (mbVar.fEt.opType) {
            case 0:
                String str = mbVar.fEt.fEv;
                String str2 = mbVar.fEt.fEw;
                as.Hm();
                a Xv = com.tencent.mm.y.c.Ff().Xv(str);
                if (Xv == null || ((int) Xv.gKO) == 0) {
                    ag xVar = new x(str);
                    xVar.At();
                    xVar.dc(str2);
                    xVar.eG(4);
                    as.Hm();
                    com.tencent.mm.y.c.Ff().S(xVar);
                    com.tencent.mm.ac.b.iX(xVar.field_username);
                }
                d Ii = g.bkF().Ii(str);
                if (Ii == null || bi.oM(Ii.getUsername()).length() <= 0) {
                    Ii = new d();
                    Ii.fEo = -1;
                    Ii.ptd = 1;
                    Ii.username = str;
                    Ii.pte = 0;
                    Ii.ptf = 0;
                    if (!g.bkF().a(Ii)) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QMsgExtension", "processModQContact: insert qcontact failed");
                    }
                }
                mbVar.fEu.fqR = true;
                break;
            case 1:
                d Ii2 = g.bkF().Ii(mbVar.fEt.fEx);
                if (Ii2 != null && bi.oM(Ii2.getUsername()).length() > 0) {
                    if (Ii2.pte != ((long) mbVar.fEt.fEy) || Ii2.ptf != ((long) mbVar.fEt.fEz)) {
                        Ii2.ptd = 1;
                        Ii2.username = mbVar.fEt.fEx;
                        Ii2.pte = (long) mbVar.fEt.fEy;
                        Ii2.ptf = (long) mbVar.fEt.fEz;
                        Ii2.fEo = 56;
                        if (!g.bkF().a(Ii2.getUsername(), Ii2)) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QMsgOperationListener", "processModQContact: update qcontact failed");
                        }
                        mbVar.fEu.fqR = true;
                        break;
                    }
                    mbVar.fEu.fqR = true;
                    break;
                }
                Ii2 = new d();
                Ii2.fEo = -1;
                Ii2.ptd = 1;
                Ii2.username = mbVar.fEt.fEx;
                Ii2.pte = (long) mbVar.fEt.fEy;
                Ii2.ptf = (long) mbVar.fEt.fEz;
                if (!g.bkF().a(Ii2)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QMsgOperationListener", "processModQContact: insert qcontact failed");
                }
                mbVar.fEu.fqR = true;
                break;
                break;
            case 2:
                g.bkG();
                break;
        }
        return false;
    }
}
